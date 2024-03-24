package pages.ecommercePlayground;

import engine.ActionBot;
import io.qameta.allure.Step;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends Pages {


    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By Label = By.tagName("h1");
    private final By firstNameInput = By.name("firstname");
    private final By lastNameInput = By.name("lastname");
    private final By emailInput = By.id("input-email");
    private final By phoneInput = By.id("input-telephone");
    private final By passwordInput = By.id("input-password");
    private final By rePasswordInput = By.id("input-confirm");
    private final By checkBox = By.id("input-agree");
    private final By submitButton = By.xpath("//input[@type ='submit']");

    public Register(WebDriver driver, ActionBot bot, Logger logger) {
        super(driver, bot, logger );
    }

    @Step("Navigate to the Poco registration page")
    public Register goTo() {
        logger.info("Navigate to the Poco registration page");
        bot.navigate(url);
        return this;
    }

    @Step("Fill out the registration form")
    public Register register(CharSequence firstname, CharSequence lastName,
                             CharSequence username, CharSequence phone, CharSequence password) {
        logger.info("Fill out the registration form");
        bot.type(firstNameInput, firstname);
        bot.type(lastNameInput, lastName);
        bot.type(emailInput, username);
        bot.type(phoneInput, phone);
        bot.type(passwordInput, password);
        bot.type(rePasswordInput, password);
        bot.click(checkBox);
        bot.click(submitButton);
        return this;
    }

    @Step("Reading the welcome message")
    public String readMessage() {
        logger.info("Reading the welcome message");
        return bot.getText(Label);
    }
}