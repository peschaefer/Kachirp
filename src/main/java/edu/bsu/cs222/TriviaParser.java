package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;

public class TriviaParser {
    public String parseForQuestionText(String triviaData) {
        String questionText = JsonPath.read(triviaData,"$.[0].question");
        return questionText;
    }
}
