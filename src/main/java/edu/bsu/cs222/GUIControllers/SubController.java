package edu.bsu.cs222.GUIControllers;

import javafx.event.ActionEvent;

abstract class SubController {
    protected Main main;

    public void returnToMain(ActionEvent event){
        main.switchToMainMenu(event);
    }

    public void setMain(Main main){
        this.main = main;
    }

}
