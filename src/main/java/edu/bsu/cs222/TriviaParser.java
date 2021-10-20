package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;

public class TriviaParser {
    public String parseForQuestionText(String triviaData,int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].question");
    }

    public String parseForCorrectAnswer(String triviaData, int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].correctAnswer");
    }

    public String[] parseForIncorrectAnswers(String triviaData) {
        String incorrectAnswer1 = JsonPath.read(triviaData,"$.[0].incorrectAnswers[0]").toString();
        String incorrectAnswer2 = JsonPath.read(triviaData,"$.[0].incorrectAnswers[1]").toString();
        String incorrectAnswer3 = JsonPath.read(triviaData,"$.[0].incorrectAnswers[2]").toString();
        return new String[]{incorrectAnswer1,incorrectAnswer2,incorrectAnswer3};
    }
}