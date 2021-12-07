package edu.bsu.cs222.ConsoleExclusives;

import edu.bsu.cs222.IncorrectMessageGetter;
import edu.bsu.cs222.Question;
import edu.bsu.cs222.QuestionFormatter;

import java.io.File;

public class ConsoleDisplay {

    public void displayMainMenu(){
        System.out.println("""
        Please select an option.
                
        1) Play vanilla game!
        2) Play with custom questions!
        3) Create your own question bank!
        4) Exit the application.
        """);
    }

    public void displayHeader(){
        System.out.println(
        """
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
        (Selecting no categories will provide a random question bank)
        """);
    }
    public void printQuestionBanks() {
        File testFile = new File("src/main/java/questionBanks");
        String[] pathNames = testFile.list();
        assert pathNames != null;
        for(String path : pathNames){
            System.out.println(path.substring(0,path.length()-5));
        }
    }

    public void displayIncorrectAnswerMessage(Question currentQuestion) {
        IncorrectMessageGetter getter = new IncorrectMessageGetter();
        String response = getter.getIncorrectAnswerMessage();
        System.err.println("\n" + response);
        System.out.printf("The answer was: %s\n\n",currentQuestion.getCorrectAnswer());

    }

    public void displayPointTotal(int correctResponses, int numberOfQuestions){
        double score = (double)correctResponses/(double)numberOfQuestions*100;
        System.out.printf("Point Total: %d\n%s\n",correctResponses,"-".repeat(21));
        System.out.printf("Percentage: %.0f%%\n%s\n\n",score,"-".repeat(21));
    }

    public void displayQuestionInformation (Question question){
        QuestionFormatter formatter = new QuestionFormatter();
        System.out.println(formatter.formatQuestion(question));
    }
}
