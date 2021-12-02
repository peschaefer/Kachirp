package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.ArrayList;

public class GameController{

    public Label questionTextLabel;
    public Button option1;
    public Button option2;
    public Button option3;
    public Button option4;
    public Label answerResponse;
    public int answerChoice;
    public int currentQuestionIndex = 0;
    public boolean pointsAllowed;
    public Question question;
    public ArrayList<Question> questionArrayList = new ArrayList<>();
    public boolean[] responseArray;
    Main main;

    public void setMain(Main main){
        this.main = main;
    }

    public void setQuestionArrayList(ArrayList<Question> questionArrayList){
        this.questionArrayList = questionArrayList;
         responseArray = new boolean[questionArrayList.size()];
        setQuestionProperties();
    }

    public void setQuestionProperties(){
        questionTextLabel.setText(questionArrayList.get(currentQuestionIndex).getQuestionText());
        option1.setText(questionArrayList.get(currentQuestionIndex).getAnswers()[0]);
        option2.setText(questionArrayList.get(currentQuestionIndex).getAnswers()[1]);
        option3.setText(questionArrayList.get(currentQuestionIndex).getAnswers()[2]);
        option4.setText(questionArrayList.get(currentQuestionIndex).getAnswers()[3]);
    }

    public void onButtonPress(javafx.event.ActionEvent event){
        if(checkAnswer()) {
            currentQuestionIndex++;
            if (currentQuestionIndex == questionArrayList.size()) {
                main.switchToEndScreen(event, getScore());
            } else {
                setQuestionProperties();
            }
        }
    }

    private int getScore() {
        int score = 0;
        for(boolean correct : responseArray){
            if(correct){
                score++;
            }
        }
        return score;
    }

    public Boolean checkAnswer(){
        int correctAnswerIndex = questionArrayList.get(currentQuestionIndex).getCorrectAnswerIndex()+1;
        if( correctAnswerIndex == answerChoice){
            answerResponse.setText("Correct!");
            responseArray[currentQuestionIndex] = true;
            //incrementScore();
            setCorrectAnswerColorToDefault(correctAnswerIndex);
            pointsAllowed = true;
            return true;
        }
        else{
            answerResponse.setText("Incorrect!");
            responseArray[currentQuestionIndex] = false;
            changeCorrectAnswerColor(correctAnswerIndex);
            pointsAllowed = false;
            return false;
        }
    }

    public void changeCorrectAnswerColor(int correctAnswerIndex) {
        String correctAnswerColor = "-fx-background-color: #45f3d0";
        switch (correctAnswerIndex) {
            case 1 -> option1.setStyle(correctAnswerColor);
            case 2 -> option2.setStyle(correctAnswerColor);
            case 3 -> option3.setStyle(correctAnswerColor);
            default -> option4.setStyle(correctAnswerColor);
        }
    }

    public void setCorrectAnswerColorToDefault(int correctAnswerIndex){
        String defaultColor = "-fx-background-color: #ba0c2f";
        switch (correctAnswerIndex) {
            case 1 -> option1.setStyle(defaultColor);
            case 2 -> option2.setStyle(defaultColor);
            case 3 -> option3.setStyle(defaultColor);
            default -> option4.setStyle(defaultColor);
        }
        option1.setStyle(defaultColor);
        option2.setStyle(defaultColor);
        option3.setStyle(defaultColor);
        option4.setStyle(defaultColor);
    }

    public void setAnswerChoice1(javafx.event.ActionEvent event){
        answerChoice = 1;
        onButtonPress(event);
    }
    public void setAnswerChoice2(javafx.event.ActionEvent event){
        answerChoice = 2;
        onButtonPress(event);
    }
    public void setAnswerChoice3(javafx.event.ActionEvent event){
        answerChoice = 3;
        onButtonPress(event);
    }
    public void setAnswerChoice4(javafx.event.ActionEvent event){
        answerChoice = 4;
        onButtonPress(event);
    }
}
