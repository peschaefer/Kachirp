package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
import edu.bsu.cs222.QuestionBankWriter;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class QuestionCreatorController {

    public TextField questionBankName;
    public TextField questionTextField;
    public TextField correctAnswerField;
    public TextField incorrectField1;
    public TextField incorrectField2;
    public TextField incorrectField3;

    QuestionBankWriter writer = new QuestionBankWriter();

    Main main;
    //QuestionBankCreator creator = new QuestionBankCreator();
    ArrayList<Question> currentQuestionList= new ArrayList<>();

    public void setMain(Main main) {
        this.main = main;
    }

//    public void checkForOverwrite(ActionEvent event) {
//        System.out.println(creator.bankPresent(questionBankName.getText() + ".json"));
//    }


    public void addQuestion() {
        String questionText = questionTextField.getText();
        String correctAnswer = correctAnswerField.getText();
        String[] incorrectAnswers = new String[]{incorrectField1.getText(),incorrectField2.getText(),incorrectField3.getText()};
        Question question = new Question(questionText,correctAnswer,incorrectAnswers);
        currentQuestionList.add(question);
        clearTextFields();
    }

    public void submitBank(ActionEvent event) throws IOException {
        writer.writeNewQuestionBank(currentQuestionList,questionBankName.getText() + ".json");
        main.switchToMainMenu(event);
    }

    private void clearTextFields(){
        questionTextField.clear();
        correctAnswerField.clear();
        incorrectField1.clear();
        incorrectField2.clear();
        incorrectField3.clear();
    }
}
