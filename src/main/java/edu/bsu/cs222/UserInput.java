package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class UserInput {
    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getCategories(){
        String[] categoryArray = new String[]{"food and drink","geography","general knowledge","history",
                "art and literature","movies","music","science","society and culture","sport and leisure"};
        ArrayList<String> categoryArrayList = new ArrayList<>(Arrays.asList(categoryArray));
        StringBuilder categoryString = new StringBuilder();
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
        int numberOfCategories = 0;
        while(true) {
            System.out.println("Please choose a category or nothing to quit");
            String categoryChoice = getInput().toLowerCase(Locale.ROOT);
            if(categoryChoice.equals("") && numberOfCategories == 0){
                return "";
            }
            else if(categoryChoice.equals("")){
                return categoryString.toString();
            }
            else if(categoryArrayList.contains(categoryChoice)){
                if(numberOfCategories==0){
                    categoryString.append(categoryChoice);
                }else {
                    categoryString.append(",").append(categoryChoice);
                }
                numberOfCategories++;
                categoryArrayList.remove(categoryChoice);
            }else if(!categoryArrayList.contains(categoryChoice)) {
                if (Arrays.asList(categoryArray).contains(categoryChoice)) {
                    System.out.println("You already chose that category!");
                } else {
                    System.out.println("That category does not exist.");
                }
            }
        }
    }
}