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

    public TriviaParserTest() throws IOException {
    }

    @Test
    public void getQuestion1Text(){
        TriviaParser parser = new TriviaParser();
        String questionText = parser.parseForQuestionText(triviaData);
        Assertions.assertEquals("What is the capital of Iran?",questionText);
    }
}
