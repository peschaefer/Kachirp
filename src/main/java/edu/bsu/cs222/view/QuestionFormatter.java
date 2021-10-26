package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Question;

public class QuestionFormatter {
    public String formatQuestion(Question question){
        StringBuilder formattedQuestion = new StringBuilder();
        formattedQuestion.append("\n");
        formattedQuestion.append(question.getQuestionText()).append("\n");
        for(int index = 0;index < 4; index++) {
            formattedQuestion.append(index+1).append(". ").append(question.getAnswers()[index]).append("\n");
        }
        return formattedQuestion.toString();
    }
}
