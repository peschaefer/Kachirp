package edu.bsu.cs222;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionBankCreator {

    private final UserInput userInput = new UserInput();
    private final QuestionBankWriter writer = new QuestionBankWriter();


    public void createCustomQuestions() throws IOException {
        ArrayList<Question> questions = new ArrayList<>();
        String questionBankName = userInput.getInput("What would you like to name this question bank?");

        questionBankName = checkQuestionBank(questionBankName);


        while(true){
            String questionText = userInput.getInput("Please enter your question or nothing to quit");

            if(questionText.isEmpty() || questionText.equalsIgnoreCase("nothing")){
                break;
            }

            String correctAnswer = userInput.getInput("Please enter the correct answer");

            System.out.println("Please enter three incorrect answers separated by commas");

            while(true) {
                try {

                    String incorrectAnswersString = userInput.getInput();
                    String[] incorrectAnswersArray = incorrectAnswersString.split(",");

                    Question question = new Question(questionText, correctAnswer, incorrectAnswersArray);

                    questions.add(question);

                    break;
                } catch (ArrayIndexOutOfBoundsException ignored){
                    System.err.println("THREE. Incorrect. Answers. Separated. By. COMMAS.");
                }
            }
        }
        writer.writeNewQuestionBank(questions, questionBankName);
    }

    private String checkQuestionBank(String questionBankChoice) {
        String[] pathNames = new File("src/main/java/QuestionBanks").list();

        questionBankChoice = questionBankChoice + ".json";

        assert pathNames != null;

            if (Arrays.asList(pathNames).contains(questionBankChoice)) {
                if(overwriteBank()){
                    return questionBankChoice;
                }
                else{
                    questionBankChoice = userInput.getInput("What would you like to name this bank?");
                    return checkQuestionBank(questionBankChoice);
                }
            }
            else {
                return questionBankChoice;
            }
    }

    private Boolean overwriteBank(){
        String choice = userInput.getInput("This bank already exists. Would you like to overwrite it? (yes or no)");
        while(true) {
            if (choice.equalsIgnoreCase("yes")) {
                return true;
            } else if (choice.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.err.println("That looks suspiciously like something besides yes or no.");
                choice = userInput.getInput();
            }
        }
    }

    public void overWriteBank2(String questionBankChoice){
        String[] pathNames = new File("src/main/java/QuestionBanks").list();

        assert pathNames != null;
        System.out.println((Arrays.asList(pathNames).contains(questionBankChoice)));
    }
}