package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class FileUploadTest extends Tests {
    /**
     * Breakout Activity: 20 minute
     * <br>navigate to <a href="https://the-internet.herokuapp.com/upload">Upload Test</a>
     * <br>uploading any file from your machine (make it small please)
     * <br>checking to see that the file was successfully uploaded
     * --------------------------------------------------------------
     * <br>breakout task (15)
     * <br>write some logs in that 'FileUploadTest'
     * <br>Steps to implement logging:
     * <br>add the pom.xml dependency (done)
     * <br>create the sample properties file (done)
     * <br>create the logger configuration in your base test class (done)
     * <br>use the logger object in your test class (done)
     */

    @Test
    public void fileUpload() {

        bot.navigate("https://the-internet.herokuapp.com/upload");
        By inputFileUploadLocator = By.id("file-upload");
        String uploadingFilePath = "C:\\Users\\dinai\\IdeaProjects\\testProject\\src\\test\\java\\testPackage\\xpath-css selector";

        logger.info("Uploading file: " + uploadingFilePath);
        driver.findElement(inputFileUploadLocator)
                .sendKeys(uploadingFilePath);
        driver.findElement(inputFileUploadLocator).submit();

        By massageUpload = By.tagName("h3");
        logger.info("Confining that the file has been upload successfully");
        String massage = driver.findElement(massageUpload).getText();
        Assertions.assertEquals("File Uploaded!", massage);

    }

}
