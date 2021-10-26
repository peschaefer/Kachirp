package edu.bsu.cs222.model;

import com.jayway.jsonpath.JsonPath;

import java.util.ArrayList;

public class TriviaParser {
    ArrayList<Question> questionArrayList = new ArrayList<>();

    public String parseForQuestionText(String triviaData,int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].question");
    }

    public String parseForCorrectAnswer(String triviaData, int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].correctAnswer");
    }

    public String[] parseForIncorrectAnswers(String triviaData, int questionIndex) {
        String incorrectAnswer1 = JsonPath.read(triviaData,"$.["+ questionIndex +"].incorrectAnswers[0]").toString();
        String incorrectAnswer2 = JsonPath.read(triviaData,"$.["+ questionIndex +"].incorrectAnswers[1]").toString();
        String incorrectAnswer3 = JsonPath.read(triviaData,"$.["+ questionIndex +"].incorrectAnswers[2]").toString();
        return new String[]{incorrectAnswer1,incorrectAnswer2,incorrectAnswer3};
    }

    public void addQuestions(String triviaData, int numberOfQuestions) {
        for(int questionIndex=0; questionIndex < numberOfQuestions; questionIndex++){
            String questionText = parseForQuestionText(triviaData, questionIndex);
            String correctAnswer = parseForCorrectAnswer(triviaData, questionIndex);
            String[] incorrectAnswers = parseForIncorrectAnswers(triviaData, questionIndex);
            Question question = new Question(questionText, correctAnswer, incorrectAnswers);
            questionArrayList.add(question);
        }
    }

    public ArrayList<Question> getQuestionArrayList(){
        return questionArrayList;
    }

}