package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;

public class QuestionBankParser extends Parser{

    @Override
    public String parseForQuestionText(String triviaData, int questionIndex) {
        return JsonPath.read(triviaData, "$.[" + questionIndex + "].questionText");
    }

    public String[] parseForAnswers(String triviaData, int questionIndex) {
        String[] answers = new String[4];
        for(int x = 0; x < 4; x++){
            String answer = JsonPath.read(triviaData,"$.[" + questionIndex + "].answers[" + x + "]");
            answers[x] = answer;
        }
        return answers;
    }

    public void addQuestions(String triviaData) {
        questionArrayList.clear();
        int questionIndex = 0;
        while(true){
            try{
                String questionText = parseForQuestionText(triviaData, questionIndex);
                int correctAnswerIndex = parseForCorrectAnswerIndex(triviaData, questionIndex);
                String[] answers = parseForAnswers(triviaData, questionIndex);
                Question question = new Question(questionText,answers,correctAnswerIndex);
                questionArrayList.add(question);
                questionIndex++;
            }catch(Exception e){
                break;
            }
        }
    }

    public int parseForCorrectAnswerIndex(String triviaData, int questionIndex) {
        return JsonPath.read(triviaData,"$.[" + questionIndex + "].correctAnswerIndex");
    }
}
