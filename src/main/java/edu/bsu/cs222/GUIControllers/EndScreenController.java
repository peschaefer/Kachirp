package edu.bsu.cs222.GUIControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class EndScreenController {

    public Label percentCorrectLabel;
    public Main main;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setScoreLabel(int score){
        percentCorrectLabel.setText(String.valueOf(score));
    }

    public void returnToMainMenu(ActionEvent event) {
        main.switchToMainMenu(event);
    }
}