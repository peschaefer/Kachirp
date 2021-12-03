package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
import edu.bsu.cs222.QuestionBankCreator;
import edu.bsu.cs222.QuestionBankWriter;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
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
    public Button submitQuestionButton;
    public Button saveBankButton;
    public DialogPane overwriteDialogBox;
    public QuestionBankCreator creator = new QuestionBankCreator();

    QuestionBankWriter writer = new QuestionBankWriter();

    Main main;
    ArrayList<Question> currentQuestionList= new ArrayList<>();

    public void setMain(Main main) {
        this.main = main;
    }

    public boolean checkForOverwrite() {
        if(creator.bankPresent(questionBankName.getText() + ".json")) {
            setElementsDisableProperty(true);
            saveBankButton.setDisable(true);
            submitQuestionButton.setDisable(true);
            return true;
        }
        return false;
    }

    public void allowRename(){
        setElementsDisableProperty(false);
    }

    public void addQuestion() {
        String questionText = questionTextField.getText();
        String correctAnswer = correctAnswerField.getText();
        String[] incorrectAnswers = new String[]{incorrectField1.getText(),incorrectField2.getText(),incorrectField3.getText()};
        Question question = new Question(questionText,correctAnswer,incorrectAnswers);
        currentQuestionList.add(question);
        clearTextFields();
        enableSubmitQuestionButton();
        enableSaveBankButton();
    }

    public void submitBank(ActionEvent event) throws IOException {
        if(checkForOverwrite()){
            return;
        }
        writer.writeNewQuestionBank(currentQuestionList,questionBankName.getText() + ".json");
        main.switchToMainMenu(event);
    }

    public void submitOverwrittenBank(ActionEvent event) throws IOException {
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

    public void enableSubmitQuestionButton() {
        String[] textFieldText = new String[]{questionTextField.getText(), correctAnswerField.getText(),
                incorrectField1.getText(),incorrectField2.getText(),incorrectField3.getText()};
        for(String text : textFieldText){
            if(text.isEmpty()){
                submitQuestionButton.setDisable(true);
                return;
            }
        }
        submitQuestionButton.setDisable(false);
    }

    public void enableSaveBankButton() {
        if(questionBankName.getText().isEmpty() || currentQuestionList.isEmpty()){
            saveBankButton.setDisable(true);
            return;
        }
        saveBankButton.setDisable(false);
    }

    public void setElementsDisableProperty(boolean value){
        overwriteDialogBox.setVisible(value);
        questionBankName.setDisable(value);
        questionTextField.setDisable(value);
        correctAnswerField.setDisable(value);
        incorrectField1.setDisable(value);
        incorrectField2.setDisable(value);
        incorrectField3.setDisable(value);
    }
}
