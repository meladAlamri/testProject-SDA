package pages.magentoSoftware;

import engine.ActionBot;
import engine.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register extends Pages {

    private final String url = PropertiesReader.props.getProperty("baseUrlSoft")+"customer/account/create/";
    private final By Label = By.className("message-success");
    private final By firstNameInput = By.id("firstname");
    private final By lastNameInput = By.id("lastname");
    private final By emailInput = By.id("email_address");
    private final By passwordInput = By.id("password");
    private final By rePasswordInput = By.id("password-confirmation");

    public Register(WebDriver driver, ActionBot bot) {
        super(driver, bot);
    }

    @Step("Navigate to the Luma registration page")
    public Register goTo() {
        bot.navigate(url);
        return this;
    }
    @Step("Fill out the registration form")
    public Register register(CharSequence firstname, CharSequence lastName, CharSequence usernameAccount, CharSequence passwordAccount){
        bot.type(firstNameInput, firstname);
        bot.type(lastNameInput, lastName);
        bot.type(emailInput, usernameAccount);
        bot.type(passwordInput, passwordAccount);
        bot.type(rePasswordInput, passwordAccount);
        driver.findElement(rePasswordInput).submit();

        return this;
    }

    @Step("Reading a popped-up message")
    public String readMessage(){
        return bot.getText(Label);
    }
}