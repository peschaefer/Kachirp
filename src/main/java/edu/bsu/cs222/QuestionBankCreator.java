package edu.bsu.cs222;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionBankCreator {

    UserInput userInput = new UserInput();
    QuestionBankWriter writer = new QuestionBankWriter();


    public void createCustomQuestions() throws IOException {
        ArrayList<Question> questions = new ArrayList<>();
        String questionBankName = userInput.getInput("What would you like to name this question bank?");


        while(true){
            String questionText = userInput.getInput("Please enter your question or nothing to quit");

            if(questionText.isEmpty() || questionText.equalsIgnoreCase("nothing")){
                break;
            }

            String correctAnswer = userInput.getInput("Please enter the correct answer");
            String incorrectAnswersString = userInput.getInput("Please enter three incorrect answers separated by commas");
            String[] incorrectAnswersArray = incorrectAnswersString.split(",");

            Question question = new Question(questionText,correctAnswer,incorrectAnswersArray);

            questions.add(question);

        }
        writer.writeNewQuestionBank(questions, questionBankName);
    }


}
