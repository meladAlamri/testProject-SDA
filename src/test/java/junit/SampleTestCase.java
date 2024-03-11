package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Launch Browser
 * <br>Navigate to the contact list page <a href="https://thinking-tester-contact-list.herokuapp.com"></a>
 * <br>There should be a user which logged in to the system
 * <br>Click on Add a New contact button
 * <br>Fill the fields		Create the inputs using Java.Faker
 * <br>Click on submit button
 * */
public class SampleTestCase {

    WebDriver driver;
    @Test
    public void contactListApp(){

        By userName = By.id("email");
        By password = By.id("password");
        By loginButton = By.id("submit");
        driver.findElement(userName).sendKeys("test2@fake.com");
        driver.findElement(password).sendKeys("myNewPassword");
        driver.findElement(loginButton).click();

        By addNewContactButton = null;
        By fillOne = null;
        By fillTwo = null;
        By submintButton = null;
        driver.findElement(addNewContactButton).click();
        driver.findElement(fillOne).sendKeys("");
        driver.findElement(fillTwo).sendKeys("");
        driver.findElement(submintButton).click();


    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://thinking-tester-contact-list.herokuapp.com");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
