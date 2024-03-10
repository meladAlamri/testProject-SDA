package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TaskTwo {
    // Task 1
    @Test
    // Create main method
    public void mainMethod(){
        //Create chrome driver
        WebDriver driver = new ChromeDriver();
        //Open google home page: https://www.google.com
        driver.get("https://www.google.com");
        //Print Title on page
        System.out.println(driver.getTitle());
        //Print Current URL on page
        System.out.println(driver.getCurrentUrl());
        //Close/Quit the browser
        driver.quit();

    }
    // Task 2
    // Differences between get() method and navigate to() method?
    /**
     * get() is a simpler method to navigate to a URL and waits for the page to load,
     * while navigate().to() provides more control and additional navigation options
     * but may not wait for the page to fully load.*/

    //Task 3
    @Test
    public void task3(){

        //Invoke Chrome Driver
        WebDriver driver = new ChromeDriver();
        //Navigate to Facebook homepage URL: https://www.facebook.com/
        driver.navigate().to("https://www.facebook.com/");
        // Verify expected URL equals to the actual URL
        var expectedUrl = "https://www.facebook.com/";
        var actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(expectedUrl,actualUrl);
        // Verify pagesource of Facebook contains "Facebook"
        var pageSource = driver.getPageSource().contains("Facebook");

        Assertions.assertEquals("Facebook",pageSource);

        driver.quit();

    }

    // Task 4
    @Test
    public void task4(){
        WebDriver driver = new ChromeDriver();
        //Navigate to website  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        //Under the Examples
        //Click on Locators - Find By Playground Test Page
        By click1 = By.id("findbytest");
        driver.findElement(click1).click();
        //Print the URL
        var fUrl = driver.getCurrentUrl();
        System.out.println(fUrl);
        //Navigate back
        driver.navigate().back();
        //Print the URL
        var sUrl = driver.getCurrentUrl();
        System.out.println(sUrl);
        //Click on WebDriver Example Page
        By click2 = By.id("webdriverexamplepage");
        driver.findElement(click2).click();
        //Print the URL
        var tUrl = driver.getCurrentUrl();
        System.out.println(tUrl);
        //Enter value 🡪 20 and Enter to "Enter Some Numbers inputBox"
        By textInput = By.name("number-entry");
        driver.findElement(textInput).sendKeys("20");
        By click3 = By.id("submit-to-server");
        driver.findElement(click3).click();
        //And then verify ‘two, zero’ message is displayed on page
        By message = By.id("message");
        var textValue = driver.findElement(message).getText();
        Assertions.assertEquals("two, zero",textValue);
        //Close driver.
        driver.quit();


    }
}
