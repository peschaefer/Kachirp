package edu.bsu.cs222;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {
    private int correctResponses = 0;
    private final UserInput userInput = new UserInput();
    private final TriviaAPIConnector connector = new TriviaAPIConnector();
    private final URLBuilder urlBuilder = new URLBuilder();
    private final QuestionBankCreator creator = new QuestionBankCreator();
    private final QuestionBankReader reader = new QuestionBankReader();
    private final ConnectionErrorHandler errorHandler = new ConnectionErrorHandler();
    private final Menu menu = new Menu();

    public void runApplication() throws IOException {

        menu.displayHeader();

        while(true){
            menu.displayMainMenu();
            String modeSelection = userInput.getInput();

            switch (modeSelection) {
                case "1" -> playVanillaGame();
                case "2" -> playCustomGame();
                case "3" -> creator.createCustomQuestions();
                case "4" -> {
                    System.out.println("Thanks for playing :D");
                    System.exit(0);
                }
                default -> System.err.println("You are on thin ice. Read the menu next time.");
            }
        }
    }


    private void displayQuestionInformation (Question question){
        QuestionFormatter formatter = new QuestionFormatter();
        System.out.println(formatter.formatQuestion(question));
    }

    private void checkAnswer ( int userAnswer, Question currentQuestion){
        userAnswer -= 1;
        int correctAnswerIndex = currentQuestion.getCorrectAnswerIndex();
        if (userAnswer == correctAnswerIndex) {
            System.out.println("\nGood Job! You got it right!\n");
            correctResponses+=1;

        } else {
            menu.displayIncorrectAnswerMessage(currentQuestion);
        }
    }

    private void displayPointTotal(){
        System.out.printf("Point Total: %d\n%s\n",correctResponses,"-".repeat(21));
    }

    private void playVanillaGame() throws IOException {
        TriviaAPIParser parser = new TriviaAPIParser();
        int numberOfQuestions = selectNumberOfQuestions();
        menu.displayCategoriesMenu();

        String urlDestination = urlBuilder.buildURL(userInput.getCategories(), numberOfQuestions);

        String triviaData = connector.connectToApi(urlDestination);
        errorHandler.checkForValidConnection(triviaData);
        parser.addQuestions(triviaData);
        ArrayList<Question> questionArrayList = parser.getQuestionArrayList();

        askQuestions(numberOfQuestions,questionArrayList);
    }

    private int selectNumberOfQuestions(){
        while(true) {
            try {
                return Integer.parseInt(userInput.getInput("Enter the number of questions you would like:"));
            }catch(NumberFormatException e){
                System.err.println("Does that look like a number?");
            }
        }
    }

    public void playCustomGame() throws IOException {
        QuestionBankParser parser = new QuestionBankParser();

        String bankFilePath = selectQuestionBank();

        parser.addQuestions(reader.readQuestionBank(bankFilePath));
        ArrayList<Question> questionArrayList = parser.getQuestionArrayList();

        System.out.println();

        askQuestions(parser.getNumberOfQuestions(),questionArrayList);
    }

    private String selectQuestionBank(){
        System.out.println("Here are the existing question banks:\n");
        menu.printQuestionBanks();

        String[] pathNames = new File("src/main/java/QuestionBanks").list();

        assert pathNames != null;
        String questionBankChoice = userInput.getInput("\nEnter the name of the bank you would like to play with.\n") + ".json";
        while(true) {
            if (Arrays.asList(pathNames).contains(questionBankChoice)) {
                return reader.buildFilePath(questionBankChoice);
            } else {
                System.err.println("Error 404: Question Bank Not Found! Did you even read the list?");
                questionBankChoice = userInput.getInput("Try again.") + ".json";
            }
        }
    }

    private void askQuestions(int numberOfQuestions, ArrayList<Question> questionArrayList) {
        int questionIndex = 0;
        while (questionIndex < numberOfQuestions) {
            int userAnswer;
            displayQuestionInformation(questionArrayList.get(questionIndex));
            try {
                userAnswer = Integer.parseInt(userInput.getInput());
            } catch (NumberFormatException e) {
                System.out.println("\nThat is not a valid response.\n");
                continue;
            }
            if(userAnswer > 4 || userAnswer < 1){
                System.out.println("\nPlease enter a number between 1 and 4.\n");
                continue;
            }
            checkAnswer(userAnswer, questionArrayList.get(questionIndex));
            questionIndex++;
        }
        displayPointTotal();
    }
}
