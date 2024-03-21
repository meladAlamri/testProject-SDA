package pages.magentoSoftware;

import engine.ActionBot;
import engine.PropertiesReader;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Pages {


    private final String url = PropertiesReader.props.getProperty("baseUrlSoft")+"customer/account/login/";
    private final By usernameTextArea = By.id("email");
    private final By passwordTextArea = By.id("pass");
    private final By titleLabel = By.className("current");

    public Login(WebDriver driver, ActionBot bot) {
        super(driver, bot);
    }


    @Step("Navigate to the Luna login page")
    public Login goTo() {
        bot.navigate(url);
        return this;
    }

    @Step("Login to the Luma")
    public Login login(String username, String password) {
        bot.type(usernameTextArea, username);
        bot.type(passwordTextArea, password);
        driver.findElement(usernameTextArea).submit();
        return this;
    }

    @Step("Reading a current navigation title")
    public String readTitle(){
        return bot.getText(titleLabel);
    }
}
