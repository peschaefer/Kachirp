package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class QuestionBankReaderTest {
    QuestionBankReader reader = new QuestionBankReader();

    @Test
    public void testForReadingQuestionBank() throws IOException {
        String triviaData = reader.readQuestionBank("src/test/resources/questionBankTest.json");
        TriviaParser parser = new TriviaParser();
        String questionText = parser.parseForQuestionText(triviaData,0);
        Assertions.assertEquals(questionText,"whats 9 + 10");
    }
}
