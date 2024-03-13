package tests.testng;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class BasicGoogleTest extends Tests{

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
    public  void quickGoogleSearch(String searchQuery){
        bot.navigate("https://www.google.com/");
        By searchInput = By.id("APjFqb");
        bot.type(searchInput, testData.get("searchQuery").toString()+ Keys.RETURN);
        //bot.type(searchInput,"Selenium WebDriver"+ Keys.RETURN);
        //bot.type(searchInput,searchQuery+ Keys.RETURN);
        By resultSearchLabel = By.id("result-stats");
        wait.until(
                d -> {
                    driver.findElement(resultSearchLabel).getText();
                    return true;
                });
        //assert !("".equals(driver.findElement(resultSearchLabel).getText())) : "Exacted : result stats is not empty using testng";
        Assert.assertNotEquals("",driver.findElement(resultSearchLabel).getText());

    }

    @Test(dependsOnMethods = {"quickGoogleSearch"})
    public  void logoGoogleExist(){
        bot.navigate("https://www.google.com/");
        By googleImgLoge = By.cssSelector("img[alt='Google']");
        //Assert.assertTrue(driver.findElement(googleImgLoge).isDisplayed());
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(driver.findElement(googleImgLoge).isDisplayed(),"First field");
        softAssert.assertTrue(driver.findElement(googleImgLoge).isDisplayed(), "Second field");
        softAssert.assertFalse(driver.findElement(googleImgLoge).isDisplayed(), "Tried field");
        softAssert.assertAll();

    }

}
