package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Question {
    private final String questionText;
    private final String[] answers;
    private final int correctAnswerIndex;

    public Question(String questionText,String correctAnswer,String[] incorrectAnswers) {
        this.questionText = questionText;
        correctAnswer = correctAnswer.replaceAll( "([ ])", "");
        this.answers = new String[]{correctAnswer,incorrectAnswers[0],incorrectAnswers[1],incorrectAnswers[2]};
        correctAnswerIndex = randomizeAnswerChoices(answers,0);
    }

    public Question(String questionText,String[] answers, int correctAnswerIndex){
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerIndex = randomizeAnswerChoices(answers,correctAnswerIndex);
    }

    private int randomizeAnswerChoices(String[] answers, int correctAnswerIndex){
        String correctAnswer = answers[correctAnswerIndex];
        ArrayList<String> answersArrayList = new ArrayList<>(Arrays.asList(answers));
        Collections.shuffle(answersArrayList);
        correctAnswerIndex = answersArrayList.indexOf(correctAnswer);
        answersArrayList.toArray(answers);

        return correctAnswerIndex;
    }

    public int getCorrectAnswerIndex(){
        return correctAnswerIndex;
    }

    public String getCorrectAnswer(){
        return answers[correctAnswerIndex];
    }

    public String[] getAnswers() {
        return answers;
    }

    public String getQuestionText() {
        return questionText;
    }

}