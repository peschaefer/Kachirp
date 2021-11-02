package edu.bsu.cs222;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class URLBuilderTest {

    @Test
    public void buildUrlRandomCategoriesTest(){
        URLBuilder urlBuilder = new URLBuilder();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=&limit=5",urlBuilder.buildURL("",5));
    }

    @Test
    public void buildUrlWithScienceTest(){
        URLBuilder urlBuilder = new URLBuilder();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=science&limit=5",urlBuilder.buildURL("science",5));
    }

    @Test
    public void buildUrlWithScienceAndMoviesTest(){
        URLBuilder urlBuilder = new URLBuilder();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=science,movies&limit=5",urlBuilder.buildURL("science,movies",5));
    }

    @Test
    public void buildUrlWithFoodAndDrinkTest(){
        URLBuilder urlBuilder = new URLBuilder();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=food_and_drink&limit=5",urlBuilder.buildURL("food and drink",5));
    }

}
