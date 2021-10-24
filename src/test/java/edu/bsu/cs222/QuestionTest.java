package edu.bsu.cs222;

import model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionTest {
    @Test
    public void testForCorrectAnswerResponse() {
        Question testQuestion = new Question("What is the color of the sky?",
            "Blue",
            "Red",
            "Green",
            "Brown");
        int index = testQuestion.getCorrectAnswerIndex();
        //System.out.println(index);
        Assertions.assertEquals("Blue", testQuestion.getAnswers()[index]);
    }

    @Test
    public void testForIncorrectAnswerResponse(){
        Question testQuestion = new Question("What is the color of the sky?",
                "Blue",
                "Red",
                "Green",
                "Brown");
        int index = testQuestion.getCorrectAnswerIndex();
        //System.out.println(index);
        Assertions.assertNotEquals("Red", testQuestion.getAnswers()[index]);
    }

    @Test
    public void testForQuestionText(){
        Question testQuestion = new Question("What is the color of the sky?",
                "Blue" ,
                "Red" ,
                "Green" ,
                "Brown");
        Assertions.assertEquals("What is the color of the sky?",testQuestion.getQuestionText());
    }
}
