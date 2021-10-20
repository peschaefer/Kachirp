package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
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
    public void getQuestion1Text(){
        String questionText = parser.parseForQuestionText(triviaData,0);
        Assertions.assertEquals("What is the capital of Iran?",questionText);
    }

    @Test
    public void getQuestion2Text(){
        String questionText = parser.parseForQuestionText(triviaData,1);
        Assertions.assertEquals("Who had a number 1 record in 1963 with Sweets For My Sweet?",questionText);
    }

    @Test
    public void getQuestion1CorrectAnswer(){
        String correctAnswer = parser.parseForCorrectAnswer(triviaData);
        Assertions.assertEquals("Tehran",correctAnswer);
    }
}
