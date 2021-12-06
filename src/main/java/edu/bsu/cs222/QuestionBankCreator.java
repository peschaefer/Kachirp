package edu.bsu.cs222;

import edu.bsu.cs222.ConsoleExclusives.UserInput;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class QuestionBankCreator {

    private final UserInput userInput = new UserInput();
    private final QuestionBankWriter writer = new QuestionBankWriter();

    public void createCustomQuestions() throws IOException {
        ArrayList<Question> questions = new ArrayList<>();
        String questionBankName = getQuestionBankName();
        questionBankName = checkQuestionBank(questionBankName);
        while(true){
            String questionText = userInput.getInput("Please enter your question or nothing to quit");
            if(questionText.isEmpty() || questionText.equalsIgnoreCase("nothing")){
                break;
            }
            String correctAnswer = userInput.getInput("Please enter the correct answer");
            String[] incorrectAnswersArray = getIncorrectAnswers();
            Question question = new Question(questionText, correctAnswer, incorrectAnswersArray);
            questions.add(question);
        }
        writer.writeNewQuestionBank(questions, questionBankName);
    }

    private String[] getIncorrectAnswers() {
        System.out.println("Please enter three incorrect answers separated by commas");
        while(true) {
            try {
                String incorrectAnswersString = userInput.getInput();
                String[] incorrectAnswersArray = incorrectAnswersString.split(",");
                if(incorrectAnswersArray.length != 3){
                    throw new Exception();
                }
                return incorrectAnswersArray;
            } catch (Exception e){
                System.err.println("THREE. Incorrect. Answers. Separated. By. COMMAS.");
            }
        }
    }

    private String getQuestionBankName() {
        String questionBankName = userInput.getInput("What would you like to name this question bank?");
        String regex = "^[a-zA-Z0-9]*$";
        while (true){
            if (!questionBankName.matches(regex) || questionBankName.isEmpty()) {
                System.err.println("The bank's name must be within alphanumerical bounds mate.");
                questionBankName = userInput.getInput("Try again");
            }
            else {
                break;
            }
        }
        return questionBankName;
    }

    private String checkQuestionBank(String questionBankChoice) {
        questionBankChoice = questionBankChoice + ".json";

            if (bankPresent(questionBankChoice)) {
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

    public Boolean bankPresent(String questionBankChoice){
        String[] pathNames = new File("src/main/java/questionBanks").list();

        assert pathNames != null;
        return (Arrays.asList(pathNames).contains(questionBankChoice));
    }
}