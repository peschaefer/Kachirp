package edu.bsu.cs222.GUIControllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class EndScreenController extends SubController{

    public Label percentCorrectLabel;

    public void setScoreLabel(int score,int totalQuestions){
        percentCorrectLabel.setText(score + " out of " + totalQuestions);
    }

}