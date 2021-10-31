package edu.bsu.cs222;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        CustomQuestionCreator creator = new CustomQuestionCreator();
        System.out.println(creator.createCustomQuestions());
//        Console game = new Console();
//        game.runConsole();
    }
}