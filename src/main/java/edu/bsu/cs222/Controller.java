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

    public void runApplication() throws IOException {

        displayHeader();

        while(true){
            displayMenu();
            String modeSelection = userInput.getInput();

            switch (modeSelection) {
                case "1" -> playVanillaGame();
                case "2" -> creator.createCustomQuestions();
                case "3" -> playCustomGame();
                case "4" -> {
                    System.out.println("Thanks for playing :D");
                    System.exit(0);
                }
                default -> System.out.println("Nope");
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
            System.out.println("\nYou are a failure, and you should feel bad.");
            System.out.printf("The answer was: %s\n\n",currentQuestion.getCorrectAnswer());
        }
    }

    private void displayPointTotal(){
        System.out.printf("Point Total: %d\n%s\n",correctResponses,"-".repeat(21));
    }

    private void displayMenu(){
        System.out.println(
        """
        Please select an option.
        
        1) Play vanilla game!
        2) Create your own question bank!
        3) Play with custom questions!
        4) Exit the application.
        """);
    }

    private void displayHeader(){
        System.out.println(
        """
        Welcome to Kachirp!
        ---------------------
        """);
    }

    private void displayCategories(){
        System.out.println("""
        The following are categories that you can choose to receive questions from:
        Food and Drink
        Geography
        General Knowledge
        History
        Art and Literature
        Movies
        Music
        Science
        Society and Culture
        Sport and Leisure
        (Selecting none will provide a random question bank)
        """);
    }

    private void playVanillaGame() throws IOException {
        TriviaAPIParser parser = new TriviaAPIParser();
        int numberOfQuestions = selectNumberOfQuestions();
        displayCategories();

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

        askQuestions(parser.getNumberOfQuestions(),questionArrayList);
    }

    private String selectQuestionBank(){
        System.out.println("Here are the existing question banks:");
        printQuestionBanks();

        File testFile = new File("src/main/java/QuestionBanks");
        String[] pathNames = testFile.list();

        assert pathNames != null;
        String questionBankChoice = userInput.getInput("Enter the name of the bank you would like to play with.");
        while(true) {
            if (Arrays.asList(pathNames).contains(questionBankChoice)) {
                return reader.buildFilePath(questionBankChoice);
            } else {
                System.err.println("Error 404: Question Bank Not Found! Did you even read the list?");
                questionBankChoice = userInput.getInput("Try again.");
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

    private void printQuestionBanks() {
        File testFile = new File("src/main/java/QuestionBanks");
        String[] pathNames = testFile.list();
        assert pathNames != null;
        for(String path : pathNames){
            System.out.println(path.substring(0,path.length()-5));
        }
    }
}