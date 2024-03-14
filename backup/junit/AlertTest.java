package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTest {
    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://the-internet.herokuapp.com/javascript_alerts">Alerts</a>
     * click on "Click for JS Confirm"
     * Press OK
     * Check that "You clicked: Ok" is displayed
     */
    WebDriver driver;
    Wait<WebDriver> wait;
    @Test
    public void alertTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        By buttonLocater = By.cssSelector("button[onclick='jsConfirm()']") ;
        By textLocater = By.id("result");
        driver.findElement(buttonLocater).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //Press the OK button
        alert.accept();

        //Store the alert text in a variable
        String text = driver.findElement(textLocater).getText();
        Assertions.assertEquals("You clicked: Ok",text);


    }



    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
       // driver.navigate().to("https://demoqa.com/select-menu");//change
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
