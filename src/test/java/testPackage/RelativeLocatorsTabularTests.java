package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Navigate to <a href="https://www.w3schools.com/html/html_tables.asp">w3schools tables</a>
 * check that the Contact for "Alfreds Futterkiste" company is "Maria Anders"
 * check that the Contact for "Island Trading" company is "Helen Bennett"
 */
public class RelativeLocatorsTabularTests {
    WebDriver driver;

    @Test
    public void checkContactNameForTargetCompany(){
        Assertions.assertEquals("Maria Anders", getContactName("Alfreds Futterkiste"));
    }

    @Test
    public void checkContactNameForTargetCompany2(){
        Assertions.assertEquals("Helen Bennett", getContactName("Island Trading"));
    }

    private String getContactName(String targetCompany){
        By contactNameForTargetCompany = By.xpath("//tr[contains(.,'"+targetCompany+"')]/td[2]");
        return driver.findElement(contactNameForTargetCompany).getText();
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}