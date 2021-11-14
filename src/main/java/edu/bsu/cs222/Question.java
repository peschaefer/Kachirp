package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Question {
    private final String questionText;
    private String[] answers = new String[4];
    private final int correctAnswerIndex;
    private final Random random = new Random();

    public Question(String questionText,String correctAnswer,String[] incorrectAnswers) {
        this.questionText = questionText;
        correctAnswerIndex = randomizeAnswerChoices(correctAnswer,incorrectAnswers[0],incorrectAnswers[1],incorrectAnswers[2]);
    }

    public Question(String questionText,String[] answers, int correctAnswerIndex){
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswerIndex = randomizeAnswerChoices(answers,correctAnswerIndex);
    }

    private int randomizeAnswerChoices(String correctAnswer, String incorrect1,String incorrect2,String incorrect3) {
        int answerNumber = random.nextInt(4);
        answers[answerNumber] = correctAnswer;
        switch (answerNumber) {
            case 0 -> {
                answers[1] = incorrect1;
                answers[2] = incorrect2;
                answers[3] = incorrect3;
            }
            case 1 -> {
                answers[0] = incorrect1;
                answers[2] = incorrect2;
                answers[3] = incorrect3;
            }
            case 2 -> {
                answers[0] = incorrect1;
                answers[1] = incorrect2;
                answers[3] = incorrect3;
            }
            default -> {
                answers[0] = incorrect1;
                answers[1] = incorrect2;
                answers[2] = incorrect3;
            }
        }
        return answerNumber;
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
