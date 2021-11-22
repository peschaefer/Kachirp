package edu.bsu.cs222;

import edu.bsu.cs222.URLBuilder;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

import java.util.ArrayList;
import java.util.Locale;

public class CategoryController {
    ArrayList<String> guiCategorySelections = new ArrayList<>();

    ArrayList<CheckBox> checkBoxes = new ArrayList<>();

    URLBuilder builder = new URLBuilder();

    @FXML
    private Slider questionNumberSlider;
    @FXML
    private Label questionNumberLabel;
    @FXML
    private TextArea tempTextArea;
    @FXML
    private CheckBox foodAndDrinkBox;
    @FXML
    private CheckBox geographyBox;
    @FXML
    private CheckBox generalKnowledgeBox;
    @FXML
    private CheckBox historyBox;
    @FXML
    private CheckBox artAndLiteratureBox;
    @FXML
    private CheckBox scienceBox;
    @FXML
    private CheckBox societyAndCultureBox;
    @FXML
    private CheckBox sportsAndLeisureBox;
    @FXML
    private CheckBox musicBox;
    @FXML
    private CheckBox moviesBox;

    private void populateCheckboxArrayList(){
        //Send a GET request to the FXML document for all fxid's (later)
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
                guiCategorySelections.add(box.getText().toLowerCase(Locale.ROOT));
            }
        }
        checkBoxes.clear();
        //tempTextArea.setText(guiCategorySelections.toString());
        return guiCategorySelections;
    }

    public void setNumberLabel() {
        int numberOfQuestions = (int)Math.ceil(questionNumberSlider.getValue());
        questionNumberLabel.setText(String.valueOf(numberOfQuestions));
    }

    public void setUpURL(){
        populateCheckboxArrayList();
        int numberOfQuestions = (int)Math.ceil(questionNumberSlider.getValue());
        ArrayList<String> categoryChoices = populateCategoryArrayList();
        tempTextArea.setText(builder.buildURL(categoryChoices,numberOfQuestions));
    }


}
