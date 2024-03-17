package Exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestNGAssignment4 extends Tests {
    /**
     * Open the site: <a href="http://opencart.abstracta.us/index.php?route=account/login">open cart</a> (done)
     * <br>Login with those credentials (done)
     * <br>Email: clarusway@gmail.com (done)
     * <br>Password: 123456789 (done)
     * <br>Using the Search function do it with Data Provider for Mac, iPad and Samsung. (done)
     */
    @Test(dataProvider = "data-provider", dataProviderClass = DataProviderClass.class)
    public void Assignment4(String searchQuery) {

        //Open the site: http://opencart.abstracta.us/index.php?route=account/login
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");

        // Login with that credentials
        // Email: clarusway@gmail.com
        By emailLocator = By.id("input-email");
        bot.type(emailLocator, "clarusway@gmail.com");

        // Password: 123456789
        By passwordLocator = By.id("input-password");
        bot.type(passwordLocator, "123456789");

        By loginLocator = By.xpath("//input[contains(@class ,'btn-primar')]");
        bot.click(loginLocator);

        // Using the Search function does it with Data Provider for Mac, iPad and Samsung.

        By searchLocator = By.name("search");
        bot.type(searchLocator, searchQuery + Keys.RETURN);

        By resultLabelLocator = By.className("control-label");
        Assert.assertTrue(driver.findElement(resultLabelLocator).isDisplayed(), "result Label is not displayed");


    }
}
