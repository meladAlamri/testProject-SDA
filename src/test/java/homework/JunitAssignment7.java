package homework;

import com.google.common.io.Files;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class JunitAssignment7 extends JunitTestBase{

    /**
     * Go to <a href="https://www.amazon.com/">Amazon</a>(done)
     * <br>Take Full Page Screenshot.(done)
     * <br>Take any specific WebElement ScreenShot(done)
     * */

    @Test
    public void junitAssignment7() throws IOException {

        // Go to amazon.com
        bot.navigate("https://www.amazon.com");
        // Take Full Page Screenshot.
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot, new File("target/FullScreenshot_"+System.currentTimeMillis()+".png"));
        // Take any specific WebElement ScreenShot
        By specificElementImage = By.xpath("//button[@type='submit']");
        File ElementScreenshot = driver.findElement(specificElementImage).getScreenshotAs(OutputType.FILE);
        Files.copy(ElementScreenshot, new File("target/SpecificElementScreenshot_"+System.currentTimeMillis()+".png"));


    }
}
