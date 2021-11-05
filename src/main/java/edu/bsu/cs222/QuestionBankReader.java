package edu.bsu.cs222;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuestionBankReader {

    public String readQuestionBank(String questionBankName) throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/main/java/QuestionBanks/" + questionBankName + ".json")));
    }
}
