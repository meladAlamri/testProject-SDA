package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IframeTest {
    /**
     * <a href="https://www.selenium.dev/selenium/web/click_frames.html">iframe</a>
     * assert the value of the h1 element
     * */
    WebDriver driver;
    WebDriverWait wait;
    @Test
    public void iframeTest(){
        driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");

        By frameLocater = By.xpath("//frame[@name='source']");
        By hLocater = By.tagName("h1");

        //Store the web element
        WebElement iframe = driver.findElement(frameLocater);

        //Switch to the frame
        driver.switchTo().frame(iframe);

        //Now we can get text
        String text = driver.findElement(hLocater).getText();
        driver.switchTo().defaultContent();

        Assertions.assertEquals("Testing Clicks",text);

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
