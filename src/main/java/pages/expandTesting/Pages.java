package pages.expandTesting;

import engine.ActionBot;
import org.openqa.selenium.WebDriver;

public abstract class Pages {
    final WebDriver driver;

     final ActionBot bot;

    public Pages(WebDriver driver, ActionBot bot){
        this.driver = driver;
        this.bot = bot;
    }
}
