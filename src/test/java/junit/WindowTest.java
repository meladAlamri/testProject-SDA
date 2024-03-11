package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class WindowTest extends Tests {

    @Test
    public void windowTest(){
        driver.navigate().to("https://www.selenium.dev/");
        var originWindowHazel = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> handles = driver.getWindowHandles();
        handles.remove(originWindowHazel);
        String newWindowHandle =(String) handles.toArray()[0];



        driver.switchTo().window(originWindowHazel);
        driver.switchTo().window(newWindowHandle);
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");

        driver.switchTo().newWindow(WindowType.WINDOW);
        handles = driver.getWindowHandles();
        handles.remove(originWindowHazel);
        handles.remove(newWindowHandle);
        String thirdWindowHandle =(String) handles.toArray()[0];

        driver.switchTo().window(originWindowHazel);
        driver.switchTo().window(thirdWindowHandle);
        driver.switchTo().window(newWindowHandle);


        driver.switchTo().window(originWindowHazel);
        Assertions.assertEquals("https://www.selenium.dev/",driver.getCurrentUrl());
    }
}
