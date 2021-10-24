package edu.bsu.cs222;

import model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    String[] incorrectAnswers = new String[]{"Red","Green","Blue"};
    @Test
    public void testForCorrectAnswerResponse() {
        Question testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        int index = testQuestion.getCorrectAnswerIndex();
        //System.out.println(index);
        Assertions.assertEquals("Blue", testQuestion.getAnswers()[index]);
    }

    @Test
    public void testForIncorrectAnswerResponse(){
        Question testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        int index = testQuestion.getCorrectAnswerIndex();
        //System.out.println(index);
        Assertions.assertNotEquals("Red", testQuestion.getAnswers()[index]);
    }

    @Test
    public void testForQuestionText(){
        Question testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        Assertions.assertEquals("What is the color of the sky?",testQuestion.getQuestionText());
    }
}
