package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.magentoSoftware.TheCart;
import pages.magentoSoftware.Login;
import pages.magentoSoftware.Register;

public class LumaDomeLoginTests extends TestBaseLuma {
    /**
     * Breakout task: 50 minutes
     * Create the following Test Cases:
     * 1. Register to Luma: <a href="https://magento.softwaretestingboard.com/">Luma Demo Shopping</a> and assert that you are successful
     * 2. Login to Luma (depends on successful registration) and assert that you are successful
     * Extra:
     * Create the following Test Scenario: // We'll work on it tomorrow, so start now for an early lead
     * 1. Login to Luma
     * 2. Navigate to "Men>Tops>Jackets"
     * 3. Add to cart the following item: Typhon Performance Fleece-lined Jacket, Large, Green
     * 4. Navigate to your cart
     * 5. Assert the item name, size, and color
     */
    private final String usernameAccount = "luma" + System.currentTimeMillis() + "@gmail.com";
    private final String passwordAccount = "Luma" + System.currentTimeMillis();

    private final String firstname = "Luma";
    private final String lastName = "Luna";

    @Test(testName = "A success register test" ,description = "Current account for test user")
    public void registerSuccess() {

        String massage = new Register(driver, bot)
                .goTo()
                .register(firstname, lastName, usernameAccount, passwordAccount)
                .readMessage();
        Assert.assertEquals(massage, dataInfo.get("massage"));

    }

    @Test(dependsOnMethods = "registerSuccess", testName = "A successful login", description = "Trying the user account and ensure it login")
    //@Test
    public void loginSuccess() {
        String title = new Login(driver, bot).goTo().
                login(usernameAccount, passwordAccount)
                .readTitle();
        Assert.assertEquals(title, dataInfo.get("title"));
    }

    @Test(dependsOnMethods = "loginSuccess", testName = "Add to the cart", description = "Login and add item to cart")
    //@Test
    public void addToCart() {
        new Login(driver, bot)
                .goTo().
                login(usernameAccount, passwordAccount)
                .readTitle();
        String[] asserts = new TheCart(driver, bot)
                .goTo()
                .addToCar();


        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(asserts[0], "You added Typhon Performance Fleece-lined Jacket to your shopping cart.");
        softAssert.assertEquals(asserts[1], "Typhon Performance Fleece-lined Jacket");
        softAssert.assertEquals(asserts[2], "L");
        softAssert.assertEquals(asserts[3], "Green");
        softAssert.assertAll();

    }

    @Test(dependsOnMethods = "addToCart", testName = "Delete cart item", description = "delete an item from the cart")
    public void deleteCartItem() {
        new Login(driver, bot)
                .goTo()
                .login(usernameAccount, passwordAccount)
                .readTitle();
        String deleteItem = new TheCart(driver, bot).deleteItem();
        Assert.assertEquals(deleteItem, dataInfo.get("deleteMassage"));

    }


}
