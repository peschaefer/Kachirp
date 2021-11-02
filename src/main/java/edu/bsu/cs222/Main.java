package edu.bsu.cs222;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        QuestionBankCreator creator = new QuestionBankCreator();
        //QuestionBankWriter writer = new QuestionBankWriter();
        QuestionBankReader reader = new QuestionBankReader();

        //writer.writeNewQuestionBank(creator.createCustomQuestions(),"testBank");
        System.out.println(reader.readQuestionBank("src/test/resources/questionBankTest.json"));


//        Console game = new Console();
//        game.runConsole();
    }
}