package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class GameController{

    public Label questionTextLabel;
    public Button option1;
    public Button option2;
    public Button option3;
    public Button option4;
    public Label answerResponse;
    public int answerChoice;
    public int currentQuestionIndex = 0;
    public int score = 0;
    public Question question;
    public ArrayList<Question> questionArrayList = new ArrayList<>();
    Main main;

    public void setMain(Main main){
        this.main = main;
    }

    public void setQuestionArrayList(ArrayList<Question> questionArrayList){
        this.questionArrayList = questionArrayList;
        setQuestionProperties();
    }

    public void setQuestionProperties(){
        questionTextLabel.setText(questionArrayList.get(currentQuestionIndex).getQuestionText());
        option1.setText(questionArrayList.get(currentQuestionIndex).getAnswers()[0]);
        option2.setText(questionArrayList.get(currentQuestionIndex).getAnswers()[1]);
        option3.setText(questionArrayList.get(currentQuestionIndex).getAnswers()[2]);
        option4.setText(questionArrayList.get(currentQuestionIndex).getAnswers()[3]);
    }

    public void onButtonPress(javafx.event.ActionEvent event) throws InterruptedException {
        checkAnswer();
        currentQuestionIndex++;
        if(currentQuestionIndex == questionArrayList.size()){
            main.switchToEndScreen(event,score);
        }
        else{
            setQuestionProperties();
        }
    }

    public void checkAnswer() throws InterruptedException {
        int correctAnswerIndex = questionArrayList.get(currentQuestionIndex).getCorrectAnswerIndex()+1;
        if( correctAnswerIndex == answerChoice){
            answerResponse.setText("Correct!");
            score++;
        }
        else{
            changeCorrectAnswerColor(correctAnswerIndex);
            //Thread.sleep(1000);
            //setAllOptionsToDefaultColor();
            answerResponse.setText("Wrong!");
        }
    }

    public void changeCorrectAnswerColor(int correctAnswerIndex) throws InterruptedException {
        String correctAnswerColor = "-fx-background-color: #45f3d0";
        if(correctAnswerIndex == 1){
            option1.setStyle(correctAnswerColor);
        }
        else if(correctAnswerIndex == 2){
            option2.setStyle(correctAnswerColor);
        }
        else if (correctAnswerIndex == 3){
            option3.setStyle(correctAnswerColor);
        }
        else{
            option4.setStyle(correctAnswerColor);
        }
        //Thread.sleep(1000);
        //TimeUnit.SECONDS.sleep(1);
        //setAllOptionsToDefaultColor();
    }

    public void setAllOptionsToDefaultColor(){
        String defaultColor = "-fx-background-color: #ba0c2f";
        option1.setStyle(defaultColor);
        option2.setStyle(defaultColor);
        option3.setStyle(defaultColor);
        option4.setStyle(defaultColor);
    }

    public void setAnswerChoice1(javafx.event.ActionEvent event) throws InterruptedException {
        answerChoice = 1;
        onButtonPress(event);
    }
    public void setAnswerChoice2(javafx.event.ActionEvent event) throws InterruptedException {
        answerChoice = 2;
        onButtonPress(event);
    }
    public void setAnswerChoice3(javafx.event.ActionEvent event) throws InterruptedException {
        answerChoice = 3;
        onButtonPress(event);
    }
    public void setAnswerChoice4(javafx.event.ActionEvent event) throws InterruptedException {
        answerChoice = 4;
        onButtonPress(event);
    }
}
