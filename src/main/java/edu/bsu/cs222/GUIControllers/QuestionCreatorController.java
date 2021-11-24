package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.QuestionBankCreator;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class QuestionCreatorController {

    public TextField questionBankName;

    Main main;
    QuestionBankCreator creator = new QuestionBankCreator();

    public void setMain(Main main) {
        this.main = main;
    }

    public void checkForOverwrite(ActionEvent event) {
        creator.overWriteBank2(questionBankName.getText());
    }
}
