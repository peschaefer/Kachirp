package edu.bsu.cs222.ConsoleExclusives;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class UserInput {

    private final String[] categoryArray = new String[]{"food and drink","geography","general knowledge","history",
            "art and literature","movies","music","science","society and culture","sport and leisure"};

    public String getInput(String message){
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String getInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public ArrayList<String> getUserCategoryChoices(){
        ArrayList<String> categoryArrayList = new ArrayList<>(Arrays.asList(categoryArray));
        ArrayList<String> userCategoryChoices = new ArrayList<>();

        while(true) {
            System.out.println("Please choose a category or hit enter to quit");
            String categoryChoice = getInput().toLowerCase(Locale.ROOT);
            if(categoryChoice.equals("") && userCategoryChoices.isEmpty()){
                break;
            }
            else if(categoryChoice.equals("") || categoryChoice.equalsIgnoreCase("nothing")){
                break;
            }
            else if(categoryArrayList.contains(categoryChoice)){
                if(userCategoryChoices.isEmpty()){
                    userCategoryChoices.add(categoryChoice);
                }
                categoryArrayList.remove(categoryChoice);
            }
            else{
                if (Arrays.asList(categoryArray).contains(categoryChoice)) {
                    System.out.println("You already chose that category!");
                }
                else {
                    System.out.println("That category does not exist.");
                }
            }
        }
        return userCategoryChoices;
    }
}