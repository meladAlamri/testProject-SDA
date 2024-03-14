package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

/**
 * Use Google Chrome
 * Navigate to <a href="https://www.google.com/">Google.com</a>
 * Search for "Selenium"
 * Check that results stats is not empty
 * Change to using Firefox
 */
public class SynchonzitionTest {

    WebDriver driver;
    @Test
    public void chromeTest(){
       driver = new ChromeDriver();
       driver.navigate().to("https://www.google.com.sa/");
        By idSearch = By.id("APjFqb");
        By ResultText = By.id("result-stats");
        driver.findElement(idSearch).sendKeys("Selenium" + Keys.RETURN);
        String textLabel = driver.findElement(ResultText).getText();
        Assertions.assertFalse(textLabel.isEmpty());

    }

    @Test
    public void fireFoxTest(){
        driver = new FirefoxDriver();
        driver.navigate().to("https://www.google.com.sa/");
        By idSearch = By.id("APjFqb");
        By ResultText = By.id("result-stats");
        driver.findElement(idSearch).sendKeys("Selenium"+ Keys.RETURN);
        //Thread.sleep(5000);
        // Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(d -> driver.findElement(ResultText).isDisplayed());
        // wait.until(d -> ! (driver.findElement(ResultText).getText().isEmpty()));
        Wait<WebDriver> wait =
                new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(NoSuchElementException.class);

        wait.until(
                d -> {
                    driver.findElement(ResultText).getText();
                    return true;
                });
        boolean textLabel = driver.findElement(ResultText).getText().isEmpty();

        Assertions.assertFalse(textLabel);

    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
