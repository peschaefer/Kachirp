package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameController {

    public Label questionTextLabel;
    public Button option1;
    public Button option2;
    public Button option3;
    public Button option4;
    public Label answerResponse;
    public int answerChoice;
    public int currentQuestionIndex = 0;
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

    public void titleWIP(javafx.event.ActionEvent event){
        checkAnswer();
        currentQuestionIndex++;
        if(currentQuestionIndex == questionArrayList.size()){
            main.switchToMainMenu(event);
        }
        else{
            setQuestionProperties();
        }
    }

    public void checkAnswer(){
        if(questionArrayList.get(currentQuestionIndex).getCorrectAnswerIndex()+1 == answerChoice){
            answerResponse.setText("Correct!");
        }
        else{
            answerResponse.setText("Wrong!");
        }
    }

    public void setAnswerChoice1(javafx.event.ActionEvent event) {
        answerChoice = 1;
        titleWIP(event);
    }
    public void setAnswerChoice2(javafx.event.ActionEvent event) {
        answerChoice = 2;
        titleWIP(event);
    }
    public void setAnswerChoice3(javafx.event.ActionEvent event) {
        answerChoice = 3;
        titleWIP(event);
    }
    public void setAnswerChoice4(javafx.event.ActionEvent event) {
        answerChoice = 4;
        titleWIP(event);
    }
}
