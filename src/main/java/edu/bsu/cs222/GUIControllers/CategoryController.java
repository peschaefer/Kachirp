package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CategoryController {
    public DialogPane errorDialogPane;
    public Button menuButton;
    public Button playButton;
    TriviaAPIParser parser = new TriviaAPIParser();
    TriviaAPIConnector connector = new TriviaAPIConnector();
    ArrayList<String> guiCategorySelections = new ArrayList<>();
    ArrayList<CheckBox> checkBoxes = new ArrayList<>();
    URLBuilder builder = new URLBuilder();
    Main main;
    private int numberOfQuestions = 1;
    @FXML
    private Slider questionNumberSlider;
    @FXML
    private Label questionNumberLabel;
    @FXML
    private CheckBox foodAndDrinkBox,geographyBox,generalKnowledgeBox,historyBox,artAndLiteratureBox
            ,musicBox,moviesBox,sportsAndLeisureBox,societyAndCultureBox,scienceBox;

    public void setMain(Main main){
        this.main = main;
    }

    private void populateCheckboxArrayList(){
        //Send a GET request to the FXML document for all fx id's (later)
        checkBoxes.add(foodAndDrinkBox);
        checkBoxes.add(geographyBox);
        checkBoxes.add(generalKnowledgeBox);
        checkBoxes.add(historyBox);
        checkBoxes.add(artAndLiteratureBox);
        checkBoxes.add(scienceBox);
        checkBoxes.add(societyAndCultureBox);
        checkBoxes.add(sportsAndLeisureBox);
        checkBoxes.add(musicBox);
        checkBoxes.add(moviesBox);
    }


    public ArrayList<String> populateCategoryArrayList(){
        guiCategorySelections.clear();
        for (CheckBox box:checkBoxes) {
            if(box.isSelected()){
                guiCategorySelections.add(box.getAccessibleText());
            }
        }
        checkBoxes.clear();
        return guiCategorySelections;
    }

    public void onMouseRelease(){
        setNumberLabel();
        changeToOpenHandCursor();
    }

    public void setNumberLabel() {
        numberOfQuestions = (int)Math.ceil(questionNumberSlider.getValue());
        questionNumberLabel.setText("# Of Questions: " + numberOfQuestions);
    }

    public void returnToMain(ActionEvent event) {
            main.switchToMainMenu(event);
    }

    public void startGame(ActionEvent event){
        checkForValidConnection();
        populateCheckboxArrayList();
        ArrayList<String> categoryChoices = populateCategoryArrayList();
        try {
            String url = builder.buildURL(categoryChoices, numberOfQuestions);
            String apiData = connector.connectToApi(url);
            parser.addQuestions(apiData);
            ArrayList<Question> questionArrayList = parser.getQuestionArrayList();
            main.switchToQuestionPrompt(event, questionArrayList);
        } catch (Exception ignored){}
    }

    private void checkForValidConnection() {
        disableButtons();
        ConnectionErrorHandler handler = new ConnectionErrorHandler();
        if(handler.checkForConnectionError()){
            errorDialogPane.setVisible(true);
        }
    }

    private void disableButtons() {
        menuButton.setDisable(true);
        playButton.setDisable(true);
        questionNumberSlider.setDisable(true);
        historyBox.setDisable(true);
        foodAndDrinkBox.setDisable(true);
        artAndLiteratureBox.setDisable(true);
        generalKnowledgeBox.setDisable(true);
        geographyBox.setDisable(true);
        societyAndCultureBox.setDisable(true);
        moviesBox.setDisable(true);
    }

    public void changeToClosedHandCursor() {
        questionNumberSlider.setCursor(Cursor.CLOSED_HAND);
    }

    public void changeToOpenHandCursor() {
        questionNumberSlider.setCursor(Cursor.OPEN_HAND);
    }
}