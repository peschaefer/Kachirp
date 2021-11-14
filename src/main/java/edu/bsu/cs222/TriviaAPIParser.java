package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;

public class TriviaAPIParser extends Parser{

    public String parseForQuestionText(String triviaData,int questionIndex) {
        return JsonPath.read(triviaData, "$.[" + questionIndex + "].question");
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

    public void addQuestions(String triviaData) {
        questionArrayList.clear();
        int questionIndex = 0;
        while(true){
            try{
                String questionText = parseForQuestionText(triviaData, questionIndex);
                String correctAnswer = parseForCorrectAnswer(triviaData, questionIndex);
                String[] incorrectAnswers = parseForIncorrectAnswers(triviaData, questionIndex);
                Question question = new Question(questionText, correctAnswer, incorrectAnswers);
                questionArrayList.add(question);
                questionIndex++;
            }catch(Exception e){
                break;
            }
        }
    }

}