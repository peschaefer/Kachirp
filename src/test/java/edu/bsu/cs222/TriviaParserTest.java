package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class TriviaParserTest {

    InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
    String triviaData = JsonPath.read(testDataStream,"$..*").toString();
    TriviaParser parser = new TriviaParser();

    public TriviaParserTest() throws IOException {
    }

    @Test
    public void getQuestion1TextTest(){
        String questionText = parser.parseForQuestionText(triviaData,0);
        Assertions.assertEquals("What is the capital of Iran?",questionText);
    }

    @Test
    public void getQuestion2TextTest(){
        String questionText = parser.parseForQuestionText(triviaData,1);
        Assertions.assertEquals("Who had a number 1 record in 1963 with Sweets For My Sweet?",questionText);
    }

    @Test
    public void getQuestion1CorrectAnswerTest(){
        String correctAnswer = parser.parseForCorrectAnswer(triviaData,0);
        Assertions.assertEquals("Tehran",correctAnswer);
    }

    @Test
    public void getQuestion2CorrectAnswerTest(){
        String correctAnswer = parser.parseForCorrectAnswer(triviaData,1);
        Assertions.assertEquals("The Searchers\u00a0",correctAnswer);
    }

    @Test
    public void getQuestion1IncorrectAnswer1Test(){
        String[] incorrectAnswers = parser.parseForIncorrectAnswers(triviaData,0);
        Assertions.assertEquals("Isfahan",incorrectAnswers[0]);
    }

    @Test
    public void getQuestion1IncorrectAnswer2Test(){
        String[] incorrectAnswers = parser.parseForIncorrectAnswers(triviaData,1);
        Assertions.assertEquals("The Lookers",incorrectAnswers[0]);
    }

    @Test
    public void addQuestionsTest1(){
        parser.addQuestions(triviaData, 5);
        Assertions.assertEquals("What is the capital of Iran?",parser.getQuestionArrayList().get(0).getQuestionText());
    }

    @Test
    public void addQuestionsTest2(){
        parser.addQuestions(triviaData, 5);
        Assertions.assertEquals("What is the second largest bone in the foot?",parser.getQuestionArrayList().get(4).getQuestionText());
    }
}