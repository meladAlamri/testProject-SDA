package tests.testng;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    @Test(testName = "A successful login")
    public void successLoginTest() {
       loginCase(1);
    }
    @Test(testName = "A filed login password")
    public void filedLoginPasswordTest() {
        loginCase(2);
    }
    @Test(testName = "A filed login username")
    public void filedLoginUserNameTest() {
        loginCase(3);
    }

    private void loginCase(int index) {
        dataInfo = (JSONObject) dataInfo.get("case"+index);
        String actionText = new Login(driver, bot)
                .goTo()
                .login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString())
                .readMassage();
        Assert.assertEquals(actionText, dataInfo.get("massage"));
    }

    @BeforeMethod
    public void initialData(){
        dataInfo = (JSONObject) testData.get("PracticeDomeLoginTestData");
    }

}
