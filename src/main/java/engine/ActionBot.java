package engine;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class ActionBot {
    private final WebDriver driver;

    private final Logger logger;

    private final Wait<WebDriver> wait;

    public ActionBot(WebDriver driver, Wait<WebDriver> wait, Logger logger) {
        this.driver = driver;
        this.wait = wait;
        this.logger = logger;

    }

    public void navigate(String url) {
        logger.info("Navigate to: " + url);
        driver.navigate().to(url);
    }

    public void type(By locator, CharSequence text) {
        logger.info("Typing: " + text + " info: " + locator);
        wait.until(f -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }

    public void click(By locator) {
        logger.info("Clicking: " + locator);
        wait.until(f -> {
            try {
                logger.debug("Using Selenium click");
                driver.findElement(locator).click();
            } catch (ElementClickInterceptedException exception) {
                logger.debug("Using JavaScript click");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(locator));
            }
            return true;

        });
    }
}
