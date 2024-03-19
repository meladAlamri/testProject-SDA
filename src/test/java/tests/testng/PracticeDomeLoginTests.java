package tests.testng;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.expandTesting.secure;
import pages.expandTesting.Login;

public class PracticeDomeLoginTests extends Tests {
    /**
     * Breakout task: 30 minute
     * <br>- login by applying POM pattern -> <a href="https://practice.expandtesting.com/login">practice</a>
     * <br>- generate working allure report
     * <br>- optional: read data from json file
     */

    @Test(testName = "Successful Login Test", description = "Given I am on the login page, When I input valid")
    public void successLoginTest() {
        Login login = new Login(driver, bot);
        login.goTo();
        JSONObject dataInfo = (JSONObject) testData.get("PracticeDomeLoginTestData");
        dataInfo =(JSONObject) dataInfo.get("case1");
        login.login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString());
        secure inventoryPage = new secure(driver, bot);
        Assert.assertEquals(inventoryPage.readMassage(), "You logged into a secure area!");

    }

}
