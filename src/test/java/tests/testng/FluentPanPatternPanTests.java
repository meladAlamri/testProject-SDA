package tests.testng;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.expandTesting.Login;

public class FluentPanPatternPanTests extends Tests{
    /**
     * breakout task: 40 minutes
     * - implement fluent POM design, using abstract page class
     * - add a new failed login test
     * - read data from json
     * - generate single allure html file
     */

    @Test
    public void successLoginTest(){
        JSONObject dataInfo = (JSONObject) testData.get("PracticeDomeLoginTestData");
        dataInfo =(JSONObject) dataInfo.get("case1");
        String actionText = new Login(driver,bot)
                .goTo()
                .login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString())
                .readMassage();
        Assert.assertEquals(actionText,dataInfo.get("massage"));
    }
    @Test
    public void filedLoginPasswordTest(){
        JSONObject dataInfo = (JSONObject) testData.get("PracticeDomeLoginTestData");
        dataInfo =(JSONObject) dataInfo.get("case2");
        String actionText = new Login(driver,bot)
                .goTo()
                .login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString())
                .readMassage();
        Assert.assertEquals(actionText,dataInfo.get("massage"));
    }
    @Test
    public void filedLoginUserNameTest(){
        JSONObject dataInfo = (JSONObject) testData.get("PracticeDomeLoginTestData");
        dataInfo =(JSONObject) dataInfo.get("case3");
        String actionText = new Login(driver,bot)
                .goTo()
                .login(dataInfo.get("Username").toString(), dataInfo.get("Password").toString())
                .readMassage();
        Assert.assertEquals(actionText,dataInfo.get("massage"));
    }
}
