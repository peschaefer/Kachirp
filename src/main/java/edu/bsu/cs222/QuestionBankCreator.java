package edu.bsu.cs222;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionBankCreator {

    UserInput userInput = new UserInput();
    QuestionBankWriter writer = new QuestionBankWriter();


    public void createCustomQuestions() throws IOException {
        ArrayList<Question> questions = new ArrayList<>();
        System.out.println("What would you like to name this question bank?");
        String questionBankName = userInput.getInput();


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
        writer.writeNewQuestionBank(questions, questionBankName);
    }
}
