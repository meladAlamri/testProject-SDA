package tests.testng;

import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.sauceDemo.Inventory;
import pages.sauceDemo.Login;

public class SauceDomeLoginTests extends Tests {
    /**
     * Breakout task: 40 minute
     * - login page object model class
     * - one test method that uses this class
     * - optional: read data from json file
     * - optional: create two more test methods
     */

    @Test(testName = "Successful Login Test", description = "Given I am on the login page, When I input valid")
    public void successLoginTest() {
        Login loginPage = new Login(driver, bot);
        loginPage.goTo();
        JSONObject dataInfo = (JSONObject) testData.get("SauceDomeLoginTestData");
        dataInfo =(JSONObject) dataInfo.get("case1");
        loginPage.login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString());
        Inventory inventoryPage = new Inventory(driver, bot);
        Assert.assertEquals(inventoryPage.readHeader(), "Products");

    }
    @Test(testName = "locked Out User Login Test", description = "Given I am on the login page, When I input lock out")
    public void lockedOutUserLoginTest() {
        Login loginPage = new Login(driver, bot);
        loginPage.goTo();
        JSONObject dataInfo = (JSONObject) testData.get("SauceDomeLoginTestData");
        dataInfo =(JSONObject) dataInfo.get("case2");
        loginPage.login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString());

        By errMassage = By.tagName("h3");
        Assert.assertTrue(driver.findElement(errMassage).isDisplayed());

    }

    @Test(testName = "problem User Login Test", description = "Given I am on the login page, When I input problematic ")
    public void problemUserLoginTest() {
        Login loginPage = new Login(driver, bot);
        loginPage.goTo();
        JSONObject dataInfo = (JSONObject) testData.get("SauceDomeLoginTestData");
        dataInfo =(JSONObject) dataInfo.get("case3");
        loginPage.login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString());
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/v1/inventory.html");

    }
}
