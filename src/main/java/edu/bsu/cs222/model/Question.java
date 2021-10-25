package edu.bsu.cs222.model;

import java.util.Random;

public class Question {
    String questionText;
    String[] answers = new String[4];
    int correctAnswerIndex;
    Random random = new Random();

    public Question(String questionText,String correctAnswer,String[] incorrectAnswers) {
        this.questionText = questionText;

        correctAnswerIndex = randomizeAnswerChoices(correctAnswer,incorrectAnswers[0],incorrectAnswers[1],incorrectAnswers[2]);
    }

    private int randomizeAnswerChoices(String correct, String incorrect1,String incorrect2,String incorrect3) {
        int answerNumber = random.nextInt(4);
        answers[answerNumber] = correct;
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
    public int getCorrectAnswerIndex(){
        return correctAnswerIndex;
    }

    public String[] getAnswers() {
        return answers;
    }
    public String getQuestionText() {
        return questionText;
    }

}