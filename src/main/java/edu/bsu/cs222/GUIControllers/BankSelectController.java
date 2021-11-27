package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
import edu.bsu.cs222.QuestionBankParser;
import edu.bsu.cs222.QuestionBankReader;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.ArrayList;

public class BankSelectController {

    @FXML
    private ComboBox<String> bankComboBox;

    Main main;
    QuestionBankReader reader = new QuestionBankReader();
    QuestionBankParser parser = new QuestionBankParser();
    String[] questionBanks = reader.getQuestionBankList();


    public void setBankComboBox(){
        bankComboBox.setItems(FXCollections.observableArrayList(questionBanks));
    }

    public void setMain(Main main){
        this.main = main;
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
}
