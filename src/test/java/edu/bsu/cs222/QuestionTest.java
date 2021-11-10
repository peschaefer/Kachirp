package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    String[] incorrectAnswers = new String[]{"Red","Green","Blue"};
    String[] testAnswers = new String []{"Will","Peyton","Dawson","Will II"};
    @Test
    public void correctAnswerResponseTest() {
        Question testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        int index = testQuestion.getCorrectAnswerIndex();
        Assertions.assertEquals("Blue", testQuestion.getAnswers()[index]);
    }

    @Test
    public void incorrectAnswerResponseTest(){
        Question testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        int index = testQuestion.getCorrectAnswerIndex();
        Assertions.assertNotEquals("Red", testQuestion.getAnswers()[index]);
    }

    @Test
    public void questionTextTest(){
        Question testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        Assertions.assertEquals("What is the color of the sky?",testQuestion.getQuestionText());
    }

}
