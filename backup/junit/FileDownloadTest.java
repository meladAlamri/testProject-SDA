package junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileDownloadTest extends Tests{
    static Path path = Path.of(System.getProperty("user.home") + "/Downloads/importData.CSV");
    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        By username = By.name("username");
        By password = By.name("password");
        By login = By.tagName("button");

        bot.type(username,"Admin");
        bot.type(password,"admin123");
        bot.click(login);

        By pinButton = By.xpath("(//span[contains(@class,'oxd-text')])[2]");
        bot.click(pinButton);

        By configure = By.xpath("//span[contains(@class,'oxd-topbar-body-nav-tab-item')]");
        By dataImport = By.xpath("(//a[contains(@class,'oxd-topbar-body-nav-tab-link')])[3]");
        bot.click(configure);
        bot.click(dataImport);


        By downloadCSV = By.xpath("//a[contains(@class,'download-link')]");
        bot.click(downloadCSV);

        Thread.sleep(5000);
        Assertions.assertTrue(Files.exists(path));

    }
    @AfterAll
    public static void afterAll() throws IOException {
        Files.delete(path);
    }
}
