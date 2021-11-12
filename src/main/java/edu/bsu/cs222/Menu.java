package edu.bsu.cs222;

import java.io.File;
import java.util.Random;

public class Menu {
    public void displayMainMenu(){
        System.out.println("""
        Please select an option.
                
        1) Play vanilla game!
        2) Create your own question bank!
        3) Play with custom questions!
        4) Exit the application.
        """);
    }

    public void displayHeader(){
        System.out.println("""
        Welcome to Kachirp!
        ---------------------
        """);
    }

    public void displayCategoriesMenu(){
        System.out.println("""
        The following are categories that you can choose to receive questions from:
        Food and Drink
        Geography
        General Knowledge
        History
        Art and Literature
        Movies
        Music
        Science
        Society and Culture
        Sport and Leisure
        (Selecting none will provide a random question bank)
        """);
    }
    public void printQuestionBanks() {
        File testFile = new File("src/main/java/QuestionBanks");
        String[] pathNames = testFile.list();
        assert pathNames != null;
        for(String path : pathNames){
            System.out.println(path.substring(0,path.length()-5));
        }
    }

    public void displayIncorrectAnswerMessage(Question currentQuestion) {
        String[] incorrectAnswerResponses = new String[]{
        "You are a failure, you should feel bad.",
        "You're joking right?",
        "We're all laughing at you by the way.",
        "Should we give you an easier question next time?",
        "Trivia isn't for everybody.",
        "Disappointing.",
        "Maybe think next time before choosing an answer.",};
        Random random = new Random();
        System.out.println(incorrectAnswerResponses[random.nextInt(incorrectAnswerResponses.length)]);
        System.out.printf("The answer was: %s\n\n",currentQuestion.getCorrectAnswer());
    }
}