package tests.testng;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.expandTesting.Login;

public class FluentPanPatternPanTests extends Tests {
    /**
     * breakout task: 40 minutes
     * - implement fluent POM design, using abstract page class
     * - add a new failed login test
     * - read data from json
     * - generate single allure html file
     */

    @Test
    public void successLoginTest() {
       loginCase(1);
    }
    @Test
    public void filedLoginPasswordTest() {
        loginCase(2);
    }
    @Test
    public void filedLoginUserNameTest() {
        loginCase(3);
    }

    private void loginCase(int index) {
        JSONObject dataInfo = (JSONObject) testData.get("PracticeDomeLoginTestData");
        dataInfo = (JSONObject) dataInfo.get("case"+index);
        String actionText = new Login(driver, bot)
                .goTo()
                .login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString())
                .readMassage();
        Assert.assertEquals(actionText, dataInfo.get("massage"));
    }
}
