package pages.expandTesting;

import engine.ActionBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class secure extends Pages{

    private final String url = "https://practice.expandtesting.com/secure";
    private final By Label = By.id("flash");

    public secure(WebDriver driver, ActionBot bot) {
        super(driver, bot);
    }

    @Step("Navigate to the Practice Demo secure page")
    public void goTo(){
        bot.navigate(url);
    }

    @Step("Reading page massage")
    public String readMassage(){
        return bot.getText(Label);
    }
}