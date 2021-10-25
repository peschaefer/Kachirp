package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Question;
import edu.bsu.cs222.model.TriviaAPIConnector;
import edu.bsu.cs222.model.TriviaParser;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        UserInput userInput = new UserInput();
        TriviaParser parser = new TriviaParser();
        TriviaAPIConnector connector = new TriviaAPIConnector();

        String triviaData = connector.connectToApi("https://api.trivia.willfry.co.uk/questions?limit=5");
        checkForValidConnection(triviaData);
        parser.addQuestions(triviaData, 5);
        ArrayList<Question> questionArrayList = parser.getQuestionArrayList();

        int questionIndex = 0;
        while(questionIndex < 5) {
            int userAnswer;
            displayQuestionInformation(questionArrayList.get(questionIndex));
            try{
                userAnswer = Integer.parseInt(userInput.getInput());
            }catch(NumberFormatException e){
                System.out.println("\nThat is not a valid response.\n");
                continue;
            }
            checkAnswer(userAnswer,questionArrayList.get(questionIndex).getCorrectAnswerIndex());
            questionIndex++;
        }
    }

    private static void checkForValidConnection(String triviaData) {
        if (triviaData.isEmpty()){
            System.err.println("A network error has occurred");
            System.exit(0);
        }
    }

    private static void displayQuestionInformation(Question question){
        System.out.println(question.getQuestionText()+"\n");
        for(int index = 0;index < 4; index++) {
            System.out.println(index + 1 + ". " + question.getAnswers()[index]);
        }
        System.out.println();
    }
    private static void checkAnswer(int userAnswer, int correctAnswerIndex){
        //Since the index is numbered 0-3 and the user input is 1-4, it must be decremented to check correctness
        userAnswer -= 1;
        if(userAnswer == correctAnswerIndex){
            System.out.println("\nGood Job! You got it right!\n");
        }
        else{
            System.out.println("\nYou are a failure, and you should feel bad.\n");
        }
    }
}
