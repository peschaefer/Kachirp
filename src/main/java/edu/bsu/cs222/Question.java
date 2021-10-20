package edu.bsu.cs222;

public class Question {
    String questionText;
    String correctAnswer;
    String incorrectAnswer1;
    String incorrectAnswer2;
    String incorrectAnswer3;

    public Question(String questionText,String correctAnswer,String incorrectAnswer1,String incorrectAnswer2, String incorrectAnswer3) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswer1 = incorrectAnswer1;
        this.incorrectAnswer2 = incorrectAnswer2;
        this.incorrectAnswer3 = incorrectAnswer3;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String[] getIncorrectAnswers() {
        return new String[]{incorrectAnswer1,incorrectAnswer2,incorrectAnswer3};
    }
}
