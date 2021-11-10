package edu.bsu.cs222;

import java.util.ArrayList;

public class URLBuilder {
    public String buildURL(ArrayList<String> userCategoryChoices, int numberOfQuestions) {

        StringBuilder categoryStringBuilder = new StringBuilder();

        for (String category : userCategoryChoices) {
            categoryStringBuilder.append(category).append(",");
        }

        String categoryString = categoryStringBuilder.toString();
        if (!userCategoryChoices.isEmpty()) {
            categoryString = categoryString.substring(0, categoryString.length() - 1).replace(" ", "_");
        }

        return "https://api.trivia.willfry.co.uk/questions?categories="+ categoryString +"&limit="+numberOfQuestions;
    }
}
