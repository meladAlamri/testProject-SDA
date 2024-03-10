package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Task3 {
    WebDriver driver;

    @Test
    public void selectFromDropDownByList(){
        By selectElement = By.id("dropdown");
        Select select = new Select( driver.findElement(selectElement));
        List < WebElement> allOptions = select.getOptions();
        System.out.println("The size of select manu: "+allOptions.size());
        String selectText = allOptions.get(2).getText();
        Assertions.assertEquals("Option 2", selectText);
    }
    @Test
    public void selectFromDropDownByValue(){
        By selectElement = By.id("dropdown");
        Select select = new Select( driver.findElement(selectElement));
        select.selectByValue("2");
        boolean isChecked = select.getFirstSelectedOption().isSelected();
        String selectText2 = select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertTrue(isChecked);

    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
