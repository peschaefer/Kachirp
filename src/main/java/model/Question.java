package model;

import java.util.Random;

public class Question {
    String questionText;
    //String correctAnswer;
    String[] answers = new String[4];
    int correctAnswerIndex;
    Random random = new Random();

    public Question(String questionText,String correctAnswer,String incorrectAnswer1,String incorrectAnswer2, String incorrectAnswer3) {
        this.questionText = questionText;
//        this.correctAnswer = correctAnswer;
//        this.incorrectAnswer1 = incorrectAnswer1;
//        this.incorrectAnswer2 = incorrectAnswer2;
//        this.incorrectAnswer3 = incorrectAnswer3;
        correctAnswerIndex = randomizeAnswerChoices(correctAnswer,incorrectAnswer1,incorrectAnswer2,incorrectAnswer3);
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
//
//    public String getCorrectAnswer() {
//        return correctAnswer;
//    }
//
//    public String[] getIncorrectAnswers() {
//        return new String[]{incorrectAnswer1,incorrectAnswer2,incorrectAnswer3};
//    }
}
