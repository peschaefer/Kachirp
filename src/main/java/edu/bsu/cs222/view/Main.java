package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Question;
import edu.bsu.cs222.model.TriviaAPIConnector;
import edu.bsu.cs222.model.TriviaParser;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        TriviaParser parser = new TriviaParser();
        TriviaAPIConnector connector = new TriviaAPIConnector();
        String triviaData = connector.connectToApi("https://api.trivia.willfry.co.uk/questions?limit=5");
        parser.addQuestions(triviaData, 5);
        ArrayList<Question> questionArrayList = parser.getQuestionArrayList();
        for(int questionIndex = 0; questionIndex < 5; questionIndex++) {
            displayQuestionInformation(questionArrayList.get(questionIndex));
        }
    }

    private static void displayQuestionInformation(Question question){
        System.out.println(question.getQuestionText()+"\n");
        for(int index = 0;index < 4; index++) {
            System.out.println(question.getAnswers()[index]);
        }
        System.out.println();
    }
}
