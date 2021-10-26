package edu.bsu.cs222.view;

import edu.bsu.cs222.model.Question;
import edu.bsu.cs222.model.TriviaAPIConnector;
import edu.bsu.cs222.model.TriviaParser;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        Console game = new Console();
        game.runConsole();
    }
}
