package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.Collections;

abstract class Parser {
    ArrayList<Question> questionArrayList = new ArrayList<>();

    public abstract String parseForQuestionText(String triviaData,int questionIndex);

    public abstract void addQuestions(String triviaData);

    public int getNumberOfQuestions(){
        return questionArrayList.size();
    }

    public ArrayList<Question> getQuestionArrayList(){
        Collections.shuffle(questionArrayList);
        return questionArrayList;
    }
}
