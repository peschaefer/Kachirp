package edu.bsu.cs222;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class QuestionBankReader {

    public String readQuestionBank(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    public String buildFilePath(String questionBankName){
        return String.format("src/main/java/questionBanks/%s.json",questionBankName);
    }

    public String[] getQuestionBankList(){
        String[] questionBankList = new File("src/main/java/questionBanks").list();
        assert questionBankList != null;
        int i = 0;
        for(String bankName : questionBankList){
            questionBankList[i] = bankName.substring(0,bankName.length()-5);
            i++;
        }
        return questionBankList;
    }
}
