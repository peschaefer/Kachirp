package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionFormatterTest {
    String[] incorrectAnswers = new String[]{"Blue","Blue","Blue"};
    @Test
    public void formatQuestionTest(){
        QuestionFormatter formatter = new QuestionFormatter();
        Question testQuestion = new Question("What is the color of the sky?", "Blue", incorrectAnswers);
        Assertions.assertEquals("""
                What is the color of the sky?
                1. Blue
                2. Blue
                3. Blue
                4. Blue
                """,formatter.formatQuestion(testQuestion));
        //testQuestion has all the same answers since the Question constructor randomizes the order of the answers.
    }
}
