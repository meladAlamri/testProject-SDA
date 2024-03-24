package Exercises;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ecommercePlayground.Register;

public class Task01FluentPOMTest extends Tests{
    /**
     * go to url : <a href="https://ecommerce-playground.lambdatest.io/index.php?route=account/register">ecommerce-playground</a>
     * register account test with fluent page object approach
     */

    private final String username = "poco" + System.currentTimeMillis() + "@gmail.com";
    private final String password = "Poco" + System.currentTimeMillis();

    private final String firstname = "Mega";
    private final String lastName = "Poco";

    private final String phone = "9665"+System.currentTimeMillis()+"\b\b\b\b\b";

    @Test
    public void register() {

        //register account test with fluent page object approach
        String massage = new Register(driver, bot, logger)
                .goTo() // go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
                .register(firstname,lastName,username,phone,password) //  register account test
                .readMessage(); // read the successful message

        Assert.assertEquals(massage,"Your Account Has Been Created!");



    }

}
