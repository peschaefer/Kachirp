package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;

import java.util.ArrayList;

public class TriviaParser {
    ArrayList<Question> questionArrayList = new ArrayList<>();

    public String parseForQuestionText(String triviaData,int questionIndex) {
        try {
            return JsonPath.read(triviaData, "$.[" + questionIndex + "].question");
        } catch(PathNotFoundException e){
            return JsonPath.read(triviaData, "$.[" + questionIndex + "].questionText");
        }
    }

    public String parseForCorrectAnswer(String triviaData, int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].correctAnswer");
    }

    public String[] parseForIncorrectAnswers(String triviaData, int questionIndex) {
        String[] incorrectAnswers = new String[3];
        for(int x = 0; x < 3; x++){
            String incorrectAnswer = JsonPath.read(triviaData,"$.[" + questionIndex + "].incorrectAnswers[" + x + "]");
            incorrectAnswers[x] = incorrectAnswer;
        }
        return incorrectAnswers;
    }

    public String[] parseForAnswers(String triviaData, int questionIndex) {
        String[] answers = new String[4];
        for(int x = 0; x < 4; x++){
            String answer = JsonPath.read(triviaData,"$.[" + questionIndex + "].answers[" + x + "]");
            answers[x] = answer;
        }
        return answers;
    }

    public int parseForCorrectAnswerIndex(String triviaData, int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].correctAnswerIndex");
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

    public void addCustomQuestions(String triviaData, int numberOfQuestions) {
        for(int questionIndex=0; questionIndex < numberOfQuestions; questionIndex++){
            String questionText = parseForQuestionText(triviaData, questionIndex);
            int correctAnswerIndex = parseForCorrectAnswerIndex(triviaData, questionIndex);
            String[] answers = parseForAnswers(triviaData, questionIndex);
            Question question = new Question(questionText,answers,correctAnswerIndex);
            questionArrayList.add(question);
        }
    }

    public ArrayList<Question> getQuestionArrayList(){
        return questionArrayList;
    }

}