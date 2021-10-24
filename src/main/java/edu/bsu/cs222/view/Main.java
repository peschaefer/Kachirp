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
        parser.addQuestions(triviaData, 5);
        ArrayList<Question> questionArrayList = parser.getQuestionArrayList();

        for(int questionIndex = 0; questionIndex < 5; questionIndex++) {
            displayQuestionInformation(questionArrayList.get(questionIndex));
            int userAnswer = Integer.parseInt(userInput.getInput());
            if (userAnswer-1 == questionArrayList.get(questionIndex).getCorrectAnswerIndex()){
                System.out.println("\nGood Job! You got it right!\n");
            }
            else{
                System.out.println("\nYou are a failure, and you should feel bad.\n");
            }
        }
    }

    private static void displayQuestionInformation(Question question){
        System.out.println(question.getQuestionText()+"\n");
        for(int index = 0;index < 4; index++) {
            System.out.println(index+1+ ". " + question.getAnswers()[index]);
        }
        System.out.println();
    }
}
