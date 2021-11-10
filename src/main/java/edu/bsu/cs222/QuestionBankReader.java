package edu.bsu.cs222;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuestionBankReader {

    public String readQuestionBank(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String buildFilePath(String questionBankName){
        return String.format("src/main/java/QuestionBanks/%s.json",questionBankName);
    }
}
