package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class QuestionBankParserTest {
    InputStream testBankDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("questionBankTest.json");
    String triviaBankData = JsonPath.read(testBankDataStream,"$..*").toString();
    QuestionBankParser parser = new QuestionBankParser();

    public QuestionBankParserTest() throws IOException {
    }

    @Test
    public void getAnswersTest1(){
        String[] answers = parser.parseForAnswers(triviaBankData,0);
        Assertions.assertEquals("19", answers[0]);
    }

    @Test
    public void getCorrectAnswerIndexTest1(){
        int correctAnswerIndex = parser.parseForCorrectAnswerIndex(triviaBankData,0);
        Assertions.assertEquals(1, correctAnswerIndex);
    }

    @Test
    public void getQuestionTextTest3(){
        String questionText = parser.parseForQuestionText(triviaBankData,0);
        Assertions.assertEquals("whats 9 + 10", questionText);
    }
}
