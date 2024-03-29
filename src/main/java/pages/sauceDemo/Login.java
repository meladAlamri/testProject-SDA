package pages.sauceDemo;

import engine.ActionBot;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private final WebDriver driver;

    private final ActionBot bot;

    private final String url = "https://www.saucedemo.com/v1/index.html";
    private final By usernameTextArea = By.id("user-name");
    private final By passwordTextArea = By.id("password");
    private final By loginButton = By.id("login-button");

    public Login(WebDriver driver, ActionBot bot) {
        this.driver = driver;
        this.bot = bot;
    }

    @Step("Navigate to the SauceDemo login page")
    public void goTo() {
        bot.navigate(url);
    }

    @Step("Login to the SauceDemo")
    public void login(String username, String password) {
        bot.type(usernameTextArea, username);
        bot.type(passwordTextArea, password);
        bot.click(loginButton);
    }
}
