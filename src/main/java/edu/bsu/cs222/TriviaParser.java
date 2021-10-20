package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;

public class TriviaParser {
    public String parseForQuestionText(String triviaData,int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].question");
    }

    public String parseForCorrectAnswer(String triviaData, int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].correctAnswer");
    }
}
