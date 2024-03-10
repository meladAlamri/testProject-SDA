package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTask {
    WebDriver driver;

    /**
     * //Task 1:
     * <br> Go to URL: <a href="https://demoqa.com/radio-button">Demoqa</a>
     * <br> Verify whether all 3 options given to the question can be selected.
     * <br> When each option is selected, print the following texts on the console.
     */
    @Test
    public void selectedOption() {
        driver.navigate().to("https://demoqa.com/radio-button");
        By option1 = By.id("yesRadio");
        By option2 = By.id("impressiveRadio");
        By option3 = By.id("noRadio");
        By massage = By.className("text-success");

        String assertMassage ="";

        assertMassage = clickRider(option1,massage,assertMassage);
        assertMassage = clickRider(option2,massage,assertMassage);
        assertMassage = clickRider(option3,massage,assertMassage);



    }

    /**
     * //Task 2:
     * <br>* navigate to this url <a href="https://www.saucedemo.com/v1/inventory.html">Saucedemo</a>
     * <br>* add the first item you find to your cart
     * <br>* open your cart*
     * <br>* assert that the item name is correct inside the cart
     */
    @Test
    public void nameCorrect() {
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
        By item = By.xpath("(//button[contains(@class,'btn_inventory')])[1]");
        driver.findElement(item).click();
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        By itemLabel = By.xpath("(//div[contains(@class,'inventory_item_name')])[1]");
        var itemText = driver.findElement(itemLabel).getText();
        Assertions.assertEquals("Sauce Labs Backpack", itemText);
    }

    private String clickRider(By option, By massage, String assetMassage){
        WebElement radioBtn1 = driver.findElement(option);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioBtn1);
        String currentMassage = driver.findElement(massage).getText();
        if (!(currentMassage.equals(assetMassage))){

            System.out.println("The following text is " + currentMassage );
        }
        else {
            System.out.println("This option could not select"  );
        }
        return currentMassage;
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @AfterEach
    public void afterEach() {
        driver.quit();
    }

}
