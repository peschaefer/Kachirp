package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionTest {

    @Test
    public void testForCorrectAnswerResponse(){
        Question testQuestion = new Question("What is the color of the sky?",
                "Blue" ,
                "Red" ,
                "Green" ,
                "Brown");
        Assertions.assertEquals("Blue",testQuestion.getCorrectAnswer());
    }

    @Test
    public void testForIncorrectAnswerResponse(){
        Question testQuestion = new Question("What is the color of the sky?",
                "Blue" ,
                "Red" ,
                "Green" ,
                "Brown");
        Assertions.assertEquals("Red",testQuestion.getIncorrectAnswers()[0]);
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
