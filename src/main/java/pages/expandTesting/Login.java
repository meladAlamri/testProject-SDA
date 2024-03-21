package pages.expandTesting;

import engine.ActionBot;
import engine.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Pages{


    private final String url = PropertiesReader.props.getProperty("baseUrl")+"login";
    private final By usernameTextArea = By.id("username");
    private final By passwordTextArea = By.id("password");
    private final By loginButton = By.xpath("//button[contains(@class,'btn-primary')]");

    public Login(WebDriver driver, ActionBot bot) {
        super(driver, bot);
    }


    @Step("Navigate to the practice login page")
    public Login goTo() {
        bot.navigate(url);
        return this;
    }

    @Step("Login to the practice")
    public secure login(String username, String password) {
        bot.type(usernameTextArea, username);
        bot.type(passwordTextArea, password);
        bot.click(loginButton);

        return new secure(driver,bot);
    }
}
