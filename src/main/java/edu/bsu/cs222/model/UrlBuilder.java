package edu.bsu.cs222.model;

public class UrlBuilder {
    public String BuildUrl(String categories, int numberOfQuestions){
        if(categories.isEmpty()){
            return "https://api.trivia.willfry.co.uk/questions?limit="+numberOfQuestions;
        }
        return "";
    }

}