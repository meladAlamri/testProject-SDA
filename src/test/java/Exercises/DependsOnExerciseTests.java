package Exercises;

import org.testng.annotations.Test;
import tests.testng.Tests;

public class DependsOnExerciseTests extends Tests {
     /**
      * Create tests that depend on each other
      * Create beforeClass and set up settings.
      * By creating interdependent tests;
      * First go to Facebook.
      * Then go to Google depending on Facebook,
      * Then go to Amazon depending on Google
      * Close the driver.
     */

     @Test
     public void dependsOnFacebookTest(){
         //First go to Facebook.
         bot.navigate("https://www.facebook.com/");
     }
    @Test(dependsOnMethods = "dependsOnFacebookTest")

    public void dependsOnGoogleTest(){
        //Then go to Google depending on Facebook
        bot.navigate("https://www.google.com.sa/");
    }
    @Test(dependsOnMethods = "dependsOnGoogleTest")
    public void dependsOnAmazonTest(){
         //Then go to Amazon depending on Google
        bot.navigate("https://www.amazon.com/");

    }
}
