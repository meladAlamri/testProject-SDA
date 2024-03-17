package Exercises;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssignment3 extends Tests {
    /**
     * go to "<a href="https://practicetestautomation.com/practice-test-login/">practice test automation</a>" (done)
     * <br>enter username - "student" (done)
     * <br>enter password - "incorrectPassword" (done)
     * <br>and login (done)
     * <br>SOFT ASSERT the error message shown (done)
     * <br>SOFT ASSERT the error message is "Your password is invalid!" (done)
     */

    @Test
    public void Assignment3() {
//        go to "https://practicetestautomation.com/practice-test-login/"
        bot.navigate("https://practicetestautomation.com/practice-test-login/");

//        enter username - "student"
        By userNameLocator = By.id("username");
        bot.type(userNameLocator, "student");

//        enter password - "incorrectPassword"
        By passwordLocator = By.id("password");
        bot.type(passwordLocator, "incorrectPassword");

//        and login
        By loginButtonLocator = By.id("submit");
        bot.click(loginButtonLocator);


//        SOFT ASSERT the error message shown
//        SOFT ASSERT the error message is "Your password is invalid!"
        By massageLocator = By.id("error");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.findElement(massageLocator).isDisplayed(), "Error message is not displayed!");
        softAssert.assertEquals(driver.findElement(massageLocator).getText(), "Your password is invalid!","Your password is valid!");
        softAssert.assertAll();

    }


}
