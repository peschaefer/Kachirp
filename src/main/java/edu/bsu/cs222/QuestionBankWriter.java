package edu.bsu.cs222;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuestionBankWriter {
    public void writeNewQuestionBank(ArrayList<Question> questions, String questionBankName) throws IOException {

        File outputFile = new File("src/main/java/QuestionBanks/"+questionBankName+".json");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(questions);

        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(json);

        writer.close();
    }
}
