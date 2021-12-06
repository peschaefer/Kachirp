package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class QuestionBankReaderTest {
    private final QuestionBankReader reader = new QuestionBankReader();

    @Test
    public void readQuestionBankTest() throws IOException {
        String triviaData = reader.readQuestionBank("src/test/resources/questionBankTest.json");
        QuestionBankParser parser = new QuestionBankParser();
        String questionText = parser.parseForQuestionText(triviaData,0);
        Assertions.assertEquals(questionText,"whats 9 + 10");
    }

    @Test
    public void buildFilePathTest(){
        Assertions.assertEquals("src/main/java/questionBanks/testFileName.json",reader.buildFilePath("testFileName"));
    }
}
