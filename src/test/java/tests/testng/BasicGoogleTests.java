package tests.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.atomic.AtomicReference;

public class BasicGoogleTests extends Tests{

    /**
     * Breakout task: 40 minutes
     * 1. recreate the base test class for junit with testng (done)
     * 2. copy the actionsBot to your project under `src/main/java/engine` (done)
     * 3. create a new tests.testng (done)
     * 4. create a new class (done)
     * 5. do a quick google search and assert that result stats is not empty using testng (done)
     */
    @Parameters("search-query")
    @Test

    public  void quickGoogleSearch(@Optional("Selenium WebDriver") String searchQuery){
        bot.navigate("https://www.google.com/");
        By searchInput = By.id("APjFqb");
        //bot.type(searchInput, testData.get("searchQuery").toString()+ Keys.RETURN);
        //bot.type(searchInput,"Selenium WebDriver"+ Keys.RETURN);
        bot.type(searchInput,searchQuery+ Keys.RETURN);
        By resultStatsLabel = By.id("result-stats");

        AtomicReference<String> actualText = new AtomicReference<>("");
        wait.until(f -> {
            actualText.set(driver.findElement(resultStatsLabel).getText());
            return true;
        });
        Assert.assertNotEquals(actualText, "");


    }

    @Test(testName = "Check Google Logo Exists", description = "Given I am on the Google homepage, Then the Google logo should be displayed")
    public  void logoGoogleExist(){
        bot.navigate("https://www.google.com/");
        By googleImgLoge = By.cssSelector("img[alt='Google']");
        //Assert.assertTrue(driver.findElement(googleImgLoge).isDisplayed());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(googleImgLoge).isDisplayed(),"First field");
        softAssert.assertTrue(driver.findElement(googleImgLoge).isDisplayed(), "Second field");
        softAssert.assertTrue(driver.findElement(googleImgLoge).isDisplayed(), "Tried field");
        softAssert.assertAll();

    }

}
