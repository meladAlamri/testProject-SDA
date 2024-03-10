package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * Navigate to <a href="https://www.w3schools.com/html/html_tables.asp">w3schools tables</a>
 * <br>check that the Contact for "Alfreds Futterkiste" company is "Maria Anders"
 * <br>check that the Contact for "Island Trading" company is "Helen Bennett"
 */
public class locaterRelative {

    WebDriver driver;
    @Test
    public void findAlfreds(){
        var name = find("Alfreds Futterkiste",2);
        Assertions.assertEquals("Maria Anders",name);

    }
    @Test
    public void findIslreds(){
        var name = find("Island Trading",2);
        Assertions.assertEquals("Helen Bennett",name);

    }

    private String find(String name , int index){
        By Isl = By.xpath("//tr[contains(.,'"+name+"')]/td["+index+"]");
        return driver.findElement(Isl).getText();
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
