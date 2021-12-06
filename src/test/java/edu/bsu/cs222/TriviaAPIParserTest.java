package edu.bsu.cs222;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class TriviaAPIParserTest {

    private final InputStream testDataStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("test.json");
    private final String triviaData = JsonPath.read(testDataStream,"$..*").toString();
    private final TriviaAPIParser parser = new TriviaAPIParser();

    public TriviaAPIParserTest() throws IOException {
    }

    @Test
    public void getQuestion1TextTest(){
        String questionText = parser.parseForQuestionText(triviaData,0);
        Assertions.assertEquals("What is the capital of Iran?",questionText);
    }

    @Test
    public void getQuestion2TextTest(){
        String questionText = parser.parseForQuestionText(triviaData,1);
        Assertions.assertEquals("Who had a number 1 record in 1963 with Sweets For My Sweet?",questionText);
    }

    @Test
    public void getQuestion1CorrectAnswerTest(){
        String correctAnswer = parser.parseForCorrectAnswer(triviaData,0);
        Assertions.assertEquals("Tehran",correctAnswer);
    }

    @Test
    public void getQuestion2CorrectAnswerTest(){
        String correctAnswer = parser.parseForCorrectAnswer(triviaData,1);
        Assertions.assertEquals("The Searchers\u00a0",correctAnswer);
    }

    @Test
    public void getQuestion1IncorrectAnswer1Test(){
        String[] incorrectAnswers = parser.parseForIncorrectAnswers(triviaData,0);
        Assertions.assertEquals("Isfahan",incorrectAnswers[0]);
    }

    @Test
    public void getQuestion1IncorrectAnswer2Test(){
        String[] incorrectAnswers = parser.parseForIncorrectAnswers(triviaData,1);
        Assertions.assertEquals("The Lookers",incorrectAnswers[0]);
    }

    @Test
    public void addQuestionsTest1(){
        parser.addQuestions(triviaData);
        ArrayList<Question> questionsArrayList;
        questionsArrayList = parser.getQuestionArrayList();
        for(int x = 0; x<5;x++){
            if("What is the capital of Iran?".equals(questionsArrayList.get(x).getQuestionText())){
                Assertions.assertTrue(true);
                return;
            }
        }
        Assertions.fail();
    }

    @Test
    public void addQuestionsTest2(){
        parser.addQuestions(triviaData);
        ArrayList<Question> questionsArrayList;
        questionsArrayList = parser.getQuestionArrayList();
        for(int x = 0; x<5;x++){
            if("What is the second largest bone in the foot?".equals(questionsArrayList.get(x).getQuestionText())){
                Assertions.assertTrue(true);
                return;
            }
        }
        Assertions.fail();
    }

    //addQuestionsTest1 and addQuestionTest2 are written this way because the order of the questions is randomized.
    //This means, all places need to be checked before we can determine if it failed

}