package testPackage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

/**
 * Breakout task: 15 minutes
 * Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
 * print the total number of cookies
 * add a new "fruit=apple" cookie
 * edit the "protein" cookie to have the value "meat"
 * delete the "veggie" cookie
 * print all cookies
 * delete all cookies
 */
public class CookiesTest extends Tests{
    @Test
    public void cookies(){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

        var cookies = driver.manage().getCookies();

        System.out.println(cookies.size());
        /*cookies.forEach(cookie -> {
            System.out.println(cookie);
        });*/
        cookies.forEach(System.out::println);

        driver.manage().addCookie(new Cookie(
                "fruit","apple"));


        driver.manage().addCookie(new Cookie(
                "protein","meat"));//cookies name mast be unique add with tha same name would replace the old one

        driver.manage().deleteCookieNamed("vegetable");
        cookies = driver.manage().getCookies();

        System.out.println("Update list of cookies");
        cookies.forEach(System.out::println);

        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();

        Assertions.assertEquals(0,cookies.size());

    }
}
