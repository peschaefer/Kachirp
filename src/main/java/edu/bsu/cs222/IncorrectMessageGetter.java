package edu.bsu.cs222;

import java.util.Random;

public class IncorrectMessageGetter {
    private final String[] incorrectAnswerResponses = new String[]{
            "You are a failure, you should feel bad.",
            "You're joking right?",
            "We're all laughing at you by the way.",
            "Should we give you an easier question next time?",
            "Trivia isn't for everybody.",
            "Disappointing.",
            "Maybe think next time before choosing an answer.",};
    private final Random random = new Random();

    public String getIncorrectAnswerMessage(){
        return incorrectAnswerResponses[random.nextInt(incorrectAnswerResponses.length)];
    }
}
