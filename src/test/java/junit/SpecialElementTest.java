package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SpecialElementTest {
    WebDriver driver;
/**
 * initialize the browser in maximized mode (using options)
 * navigate to <a href="https://www.selenium.dev/selenium/web/web-form.html">web form test page</a>
 * check the box and validate that it is checked
 * select the radio and validate that it is selected
 * choose an item (by value) from the select dropdown menu and validate that it is selected (by text)
 * */

    @Test
    public void checkBoxTest(){

        By checkBox2 = By.cssSelector("#my-check-2");

        driver.findElement(checkBox2).click();
        boolean isChecked = driver.findElement(checkBox2).isSelected();
        Assertions.assertTrue(isChecked);

    }
    @Test
    public void uncheckBoxTest(){

        By checkBox2 = By.cssSelector("#my-check-2");

        driver.findElement(checkBox2).click();
        driver.findElement(checkBox2).click();
        boolean isChecked = driver.findElement(checkBox2).isSelected();
        Assertions.assertFalse(isChecked);

    }
    @Test
    public void radioTest(){
        By radioButton = By.cssSelector("#my-radio-2");

        driver.findElement(radioButton).click();
        boolean isChecked = driver.findElement(radioButton).isSelected();
        Assertions.assertTrue(isChecked);

    }

    @Test
    public void selectFromDropDown(){
        By selectElement = By.name("my-select");
        Select select = new Select( driver.findElement(selectElement));
        select.selectByValue("2");
        String selectText = select.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("Two", selectText);
    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        //chromeOptions.addArguments("");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

    }

    @AfterEach
    public void afterEach(){
        driver.quit();

    }
}
