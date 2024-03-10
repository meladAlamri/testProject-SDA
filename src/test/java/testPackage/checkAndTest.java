package testPackage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkAndTest {
    /**
     * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     * login as standard_user
     * assert that there are 6 items on the products list page
     * add the first and last items to the cart
     * navigate to the cart and check that both items are listed
     */
    WebDriver driver;

    @Test
    public void checkItemsNumbers(){
        login("standard_user","secret_sauce");
        By listSize = By.className("inventory_item");
        int size = driver.findElements(listSize).size();
        Assertions.assertEquals(6,size);
    }
    @Test
    public void checkFirstTime(){
        login("standard_user","secret_sauce");
        addItems(1);
        addItems(6);
        Assertions.assertEquals("Sauce Labs Backpack",CheakItems(1));
    }
    @Test
    public void checkLastItem(){
        login("standard_user","secret_sauce");
        addItems(1);
        addItems(6);
        Assertions.assertEquals("Test.allTheThings() T-Shirt (Red)",CheakItems(2));

    }

    private void addItems(int numberItem){

        By itemAdd = By.xpath("(//button[contains(@class,'btn_inventory')])["+numberItem+"]");
        driver.findElement(itemAdd).click();


    }



    private String CheakItems(int numberItem){
        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        By itemAdd = By.xpath("(//div[contains(@class,'inventory_item_name')])["+numberItem+"]");
        return driver.findElement(itemAdd).getText();

    }
    private void login(String username, String password){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
