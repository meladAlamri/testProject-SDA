package testPackage;

import com.google.common.io.Files;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ActionTests extends Tests {


    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://the-internet.herokuapp.com/javascript_alerts">Alerts</a>
     * click on "Click for JS Confirm"
     * Press OK
     * Check that "You clicked: Ok" is displayed
     */

    @Test
    public void alertTest() {
        driver.navigate().to("https://demo.automationtesting.in/Alerts.html");
        By button = By.cssSelector("button[onclick='alertbox()']");
        driver.findElement(button).click();

        //Wait for the alert to be displayed and store it in a variable
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        //Store the alert text in a variable
        String text = alert.getText();

        //Press the OK button
        alert.accept();
        Assertions.assertEquals("I am an alert box!", text);
    }

    @Test
    public void basicAuthTest() {
        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        By message = By.tagName("p");
        var actualMessage = driver.findElement(message).getText();
        Assertions.assertEquals("Congratulations! You must have the proper credentials.", actualMessage);
    }

    @Test
    public void iFrame() {
        driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");
        WebElement iframe = driver.findElement(By.xpath("//frame[@name='source']"));
        driver.switchTo().frame(iframe);
        var headerText = driver.findElement(By.tagName("h1")).getText();
        driver.switchTo().defaultContent();
        Assertions.assertEquals("Testing Clicks", headerText);
    }

    /**
     * Breakout task: 20 minutes
     * <br>navigate to <a href="https://www.selenium.dev/selenium/web/droppableItems.html">DroppableItems</a>
     * <br>drag the draggable, onto the droppable
     * <br>check that the text now shows "Dropped!"
     */
    @Test
    public void dragDropTest() {

        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");
        By dragLocater = By.id("draggable");
        By dropLocater = By.id("droppable");
        new Actions(driver)
                .dragAndDrop(driver.findElement(dragLocater)
                        , driver.findElement(dropLocater))
                .perform();
        String dropText = driver.findElement(dropLocater).getText();
        Assertions.assertEquals("Dropped!", dropText);
    }

    /**
     * Breakout task: 20 minutes
     * <br>navigate to: <a href="https://rangeslider.js.org/">Ranges</a>
     * <br>scroll to the right until you reach 700
     * <br>assert that the number says 700
     */
    @Test
    public void scrollTest() {
        driver.navigate().to(" https://rangeslider.js.org/");


        wait.until(f -> {
            new Actions(driver)
                    .dragAndDropBy(driver.findElement(By.className("rangeslider__handle"))
                            , 10, 0)
                    .perform();
            return driver.findElement(By.id("js-output")).getText().equals("700");
        });
        String text = driver.findElement(By.id("js-output")).getText();
        Assertions.assertEquals("700", text);
    }

    @Test
    public void javascriptExecutorTest() throws IOException {
        driver.navigate().to("https://www.selenium.dev/");
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1000);");

        By browserStackImage = By.xpath("//img[@alt='BrowserStack']");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        new Actions(driver).scrollToElement(driver.findElement(browserStackImage)).perform();
//        driver.findElement(browserStackImage).click();

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(browserStackImage));
        Files.copy(screenshot, new File("target/screenshot_"+System.currentTimeMillis()+".png"));
        File ElementScreenshot = driver.findElement(browserStackImage).getScreenshotAs(OutputType.FILE);
        bot.click(browserStackImage);
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(browserStackImage));
        Files.copy(ElementScreenshot, new File("target/ElementScreenshot_"+System.currentTimeMillis()+".png"));

    }



}