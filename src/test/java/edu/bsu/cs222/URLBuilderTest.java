package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class URLBuilderTest {

    private final ArrayList<String> categories = new ArrayList<>();

    @Test
    public void buildUrlRandomCategoriesTest(){
        URLBuilder urlBuilder = new URLBuilder();
        categories.clear();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=&limit=5",urlBuilder.buildURL(categories,5));
    }

    @Test
    public void buildUrlWithScienceTest(){
        URLBuilder urlBuilder = new URLBuilder();
        categories.clear();
        categories.add("science");
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=science&limit=5",urlBuilder.buildURL(categories,5));
    }

    @Test
    public void buildUrlWithScienceAndMoviesTest(){
        URLBuilder urlBuilder = new URLBuilder();
        categories.clear();
        categories.add("science");
        categories.add("movies");
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=science,movies&limit=5",urlBuilder.buildURL(categories,5));
    }

    @Test
    public void buildUrlWithFoodAndDrinkTest(){
        URLBuilder urlBuilder = new URLBuilder();
        categories.clear();
        categories.add("food and drink");
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=food_and_drink&limit=5",urlBuilder.buildURL(categories,5));
    }

}
