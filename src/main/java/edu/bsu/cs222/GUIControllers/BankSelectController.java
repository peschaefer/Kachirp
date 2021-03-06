package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
import edu.bsu.cs222.QuestionBankParser;
import edu.bsu.cs222.QuestionBankReader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class BankSelectController extends SubController{

    public Button submitButton;
    public ComboBox<String> bankComboBox;


    QuestionBankReader reader = new QuestionBankReader();
    QuestionBankParser parser = new QuestionBankParser();
    String[] questionBanks = reader.getQuestionBankList();


    public void setBankComboBox(){
        bankComboBox.setItems(FXCollections.observableArrayList(questionBanks));
    }

    public void chooseBank(ActionEvent event){
        try {
            String filePath = reader.buildFilePath(bankComboBox.getValue());
            String bankData = reader.readQuestionBank(filePath);
            parser.addQuestions(bankData);
            ArrayList<Question> questionArrayList = parser.getQuestionArrayList();
            main.switchToQuestionPrompt(event, questionArrayList);
        } catch (Exception ignored){}
    }

    public void enableSubmitButton() {
        if(bankComboBox.getValue() == null){
            submitButton.setDisable(true);
            return;
        }
        submitButton.setDisable(false);
    }
}
