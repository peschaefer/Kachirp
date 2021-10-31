package edu.bsu.cs222;

import java.util.ArrayList;

public class CustomQuestionCreator {

    UserInput userInput = new UserInput();

    public ArrayList<Question> createCustomQuestions(){
        ArrayList<Question> questions = new ArrayList<>();

        while(true){
            System.out.println("Please enter your question or nothing to quit");
            String questionText = userInput.getInput();

            if(questionText.isEmpty() || questionText.equalsIgnoreCase("nothing")){
                break;
            }

            System.out.println("Please enter the correct answer");
            String correctAnswer = userInput.getInput();
            System.out.println("Please enter three incorrect answers separated by commas");
            String incorrectAnswersString = userInput.getInput();
            String[] incorrectAnswersArray = incorrectAnswersString.split(",");

            Question question = new Question(questionText,correctAnswer,incorrectAnswersArray);

            questions.add(question);

        }
        return questions;
    }
}
