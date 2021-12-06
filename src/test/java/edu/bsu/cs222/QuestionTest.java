package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class QuestionTest {
    private final String[] incorrectAnswers = new String[]{"Red","Green","Purple"};
    private Question testQuestion;

    @Test
    public void correctAnswerResponseTest() {
        testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        int index = testQuestion.getCorrectAnswerIndex();
        System.out.println(Arrays.toString(testQuestion.getAnswers()));
        Assertions.assertEquals("Blue", testQuestion.getAnswers()[index]);
    }

    @Test
    public void incorrectAnswerResponseTest(){
        testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        int index = testQuestion.getCorrectAnswerIndex();
        Assertions.assertNotEquals("Red", testQuestion.getAnswers()[index]);
    }

    @Test
    public void questionTextTest(){
        testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        Assertions.assertEquals("What is the color of the sky?",testQuestion.getQuestionText());
    }

}
