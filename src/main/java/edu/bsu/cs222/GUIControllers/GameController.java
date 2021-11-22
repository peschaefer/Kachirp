package edu.bsu.cs222.GUIControllers;

import edu.bsu.cs222.Question;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameController {

    public Label questionTextLabel;
    public Button option1;
    public Button option2;
    public Button option3;
    public Button option4;
    public Label answerResponse;
    public int answerChoice;
    public Question question;

    public void setQuestionText(){
        questionTextLabel.setText(question.getQuestionText());
    }

    public void setQuestion(Question question){
        this.question = question;
    }

    public void setAnswerChoices(String[] answers){
        option1.setText(answers[0]);
        option2.setText(answers[1]);
        option3.setText(answers[2]);
        option4.setText(answers[3]);
    }

    public void checkAnswer(int answerChoice){
        if(question.getCorrectAnswerIndex()+1 == answerChoice){
            answerResponse.setText("Correct!");
        }
        else{
            answerResponse.setText("Wrong!");
        }
    }

    public void setAnswerChoice1() {
        answerChoice = 1;
        checkAnswer(1);
    }
    public void setAnswerChoice2() {
        answerChoice = 1;
        checkAnswer(2);
    }
    public void setAnswerChoice3() {
        answerChoice = 1;
        checkAnswer(3);
    }
    public void setAnswerChoice4() {
        answerChoice = 1;
        checkAnswer(4);
    }
}
