package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class JunitAssignment2 extends JunitTestBase {
    /**
     * Go to URL: <a href="https://the-internet.herokuapp.com/windows">The internet herokuApp</a> (done)
     * <br> Verify the text: “Opening a new window” (done)
     * <br> Verify the title of the page is “The Internet” (done)
     * <br> Click on the “Click Here” button (done)
     * <br> Verify the new window title is “New Window” (done)
     * <br> Go back to the previous window and then verify the title: “The Internet” (done)
     */

    @Test
    public void junitAssignment2() {
        //Go to URL: https://the-internet.herokuapp.com/windows
        bot.navigate("https://the-internet.herokuapp.com/windows");
        var originWindowHazel = driver.getWindowHandle();

        //Verify the text: “Opening a new window”
        By textWindowLocator = By.tagName("h3");
        String textWindow = driver.findElement(textWindowLocator).getText();
        System.out.println("The text is: " + textWindow);
        Assertions.assertEquals("Opening a new window", textWindow);

        //Verify the title of the page is “The Internet”
        String currentTitle = driver.getTitle();
        System.out.println("The title now is: " + currentTitle);
        Assertions.assertEquals("The Internet", currentTitle);

        //Click on the “Click Here” button
        By clickHereButtonLocator = By.xpath("//a[@href='/windows/new']");
        bot.click(clickHereButtonLocator);

        //Verify the new window title is “New Window”
        Set<String> handles = driver.getWindowHandles();
        handles.remove(originWindowHazel);
        String newWindowHandle = (String) handles.toArray()[0];
        driver.switchTo().window(newWindowHandle);
        currentTitle = driver.getTitle();
        System.out.println("The title now is: " + currentTitle);
        Assertions.assertEquals("New Window",currentTitle);

        //Go back to the previous window and then verify the title: “The Internet
        driver.switchTo().window(originWindowHazel);
        currentTitle = driver.getTitle();
        System.out.println("The title now is: " + currentTitle);
        Assertions.assertEquals("The Internet", currentTitle);


    }
}
