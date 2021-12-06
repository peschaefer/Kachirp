package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class QuestionBankParserTest {
    private final InputStream testBankDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("questionBankTest.json");
    private final String triviaBankData = JsonPath.read(testBankDataStream,"$..*").toString();
    private final QuestionBankParser parser = new QuestionBankParser();

    public QuestionBankParserTest() throws IOException {
    }

    @Test
    public void getAnswersTest(){
        String[] answers = parser.parseForAnswers(triviaBankData,0);
        Assertions.assertEquals("19", answers[0]);
    }

    @Test
    public void getCorrectAnswerIndexTest(){
        int correctAnswerIndex = parser.parseForCorrectAnswerIndex(triviaBankData,0);
        Assertions.assertEquals(1, correctAnswerIndex);
    }

    @Test
    public void getQuestionTextTest(){
        String questionText = parser.parseForQuestionText(triviaBankData,0);
        Assertions.assertEquals("whats 9 + 10", questionText);
    }
}
