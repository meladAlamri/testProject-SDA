package pages.ecommercePlayground;

import engine.ActionBot;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class Pages {
    final WebDriver driver;

    final ActionBot bot;

    final Logger logger;

    public Pages(WebDriver driver, ActionBot bot, Logger logger) {
        this.driver = driver;
        this.bot = bot;
        this.logger = logger;
    }
}
