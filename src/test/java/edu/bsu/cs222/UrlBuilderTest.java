package edu.bsu.cs222;

import edu.bsu.cs222.model.UrlBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UrlBuilderTest {

    @Test
    public void buildUrlRandomCategoriesTest(){
        UrlBuilder urlBuilder = new UrlBuilder();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?limit=5",urlBuilder.BuildUrl("",5));
    }

    @Test
    public void buildUrlWithScienceTest(){
        UrlBuilder urlBuilder = new UrlBuilder();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=science&limit=5",urlBuilder.BuildUrl("science",5));
    }

    @Test
    public void buildUrlWithScienceAndMoviesTest(){
        UrlBuilder urlBuilder = new UrlBuilder();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=science,movies&limit=5",urlBuilder.BuildUrl("science,movies",5));
    }

    @Test
    public void buildUrlWithFoodAndDrinkTest(){
        UrlBuilder urlBuilder = new UrlBuilder();
        Assertions.assertEquals("https://api.trivia.willfry.co.uk/questions?categories=food_and_drink&limit=5",urlBuilder.BuildUrl("food and drink",5));
    }

}
