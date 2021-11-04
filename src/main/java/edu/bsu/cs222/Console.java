package edu.bsu.cs222;

import java.io.IOException;
import java.util.ArrayList;

public class Console {
    int correctResponses = 0;
    UserInput userInput = new UserInput();
    TriviaParser parser = new TriviaParser();
    TriviaAPIConnector connector = new TriviaAPIConnector();
    //Timer timer = new Timer();
    URLBuilder urlBuilder = new URLBuilder();
    QuestionBankCreator creator = new QuestionBankCreator();

    public void runConsole() throws IOException {

        displayMenu();
        String modeSelection = userInput.getInput();

        switch (modeSelection) {
            case "1" -> playVanillaGame();
            case "2" -> creator.createCustomQuestions();
            case "3" -> playCustomGame();
            default -> System.out.println("Nope");
        }
    }
    //remove from console
    private void checkForValidConnection (String triviaData){
        if (triviaData.isEmpty()) {
            System.err.println("A network error has occurred");
            System.exit(0);
        }
    }

    private void displayQuestionInformation (Question question){
        QuestionFormatter formatter = new QuestionFormatter();
        System.out.println(formatter.formatQuestion(question));
    }

    //remove from console
    private void checkAnswer ( int userAnswer, int correctAnswerIndex){
        //Since the index is numbered 0-3 and the user input is 1-4, it must be decremented to check correctness
        userAnswer -= 1;
        if (userAnswer == correctAnswerIndex) {
            System.out.println("\nGood Job! You got it right!\n");
            correctResponses+=1;

        } else {
            System.out.println("\nYou are a failure, and you should feel bad.\n");
        }
    }

    private void displayPointTotal(){
        System.out.println("Point Total: " + correctResponses);
    }

    private void displayMenu(){
        System.out.println(
        """
        Welcome to Kachirp!
        ---------------------
        Select an option to begin.
        
        1) Play vanilla game!
        2) Create your own question bank!
        3) Play with custom questions!
        """);
    }

    private void playVanillaGame() throws IOException {
        System.out.println("Start by entering the number of questions you would like:");
        int numberOfQuestions = Integer.parseInt(userInput.getInput());
        String urlDestination = urlBuilder.buildURL(userInput.getCategories(), numberOfQuestions);

        String triviaData = connector.connectToApi(urlDestination);
        checkForValidConnection(triviaData);
        parser.addQuestions(triviaData, numberOfQuestions);
        ArrayList<Question> questionArrayList = parser.getQuestionArrayList();

        //extrapolate into a method?
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
            checkAnswer(userAnswer, questionArrayList.get(questionIndex).getCorrectAnswerIndex());
            questionIndex++;
        }
        displayPointTotal();
    }

    public void playCustomGame(){
        //First, it will print out a list of all the question banks.
        //Second, it will have the user select one question bank.
        //Third, it will build questions from the bank.
        //Lastly, it will run the game with the user's questions.
    }
}
