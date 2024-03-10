package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.File;
import java.util.Set;
import java.util.jar.JarException;

public class WindowTests extends Tests{
    @Test
    public void windowTest(){
        driver.navigate().to("https://www.selenium.dev/");
        //((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
        By browsStackImage = By.xpath("//img[@alt='BrowserStack]");
        // ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",driver.findElement(browsStackImage));
        //((JavascriptExecutor)driver).executeScript("arguments[0].click();",driver.findElement(browsStackImage));
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        new Actions(driver).scrollToElement(driver.findElement(browsStackImage)).perform();
        driver.findElement(browsStackImage).click();

        var originalWindowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String > handles = driver.getWindowHandles();
        handles.remove(originalWindowHandle);
        String newWindowHandle = (String) handles.toArray()[0];

        driver.switchTo().window(originalWindowHandle);
        driver.switchTo().window(newWindowHandle);

        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        driver.navigate().back();
        driver.navigate().forward();

        driver.switchTo().newWindow(WindowType.WINDOW);

        handles = driver.getWindowHandles();
        handles.remove(originalWindowHandle);
        handles.remove(newWindowHandle);
        String thirdWindowHandle = (String) handles.toArray()[0];

        driver.switchTo().window(originalWindowHandle);
        driver.switchTo().window(thirdWindowHandle);
        driver.switchTo().window(newWindowHandle);
        driver.switchTo().window(originalWindowHandle);

        Assertions.assertEquals("https://www.selenium.dev/", driver.getCurrentUrl());
    }
}