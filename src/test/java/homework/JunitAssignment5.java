package homework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class JunitAssignment5 extends JunitTestBase{

    /**
     * Go to URL: <a href="http://facebook.com">faceBook</a>
     * <br>getCookies,
     * <br>addCookie,
     * <br>deleteCookieNamed,
     * <br>deleteAllCookies
     **/
    @Test
    public void junitAssignment5(){
        //Go to URL: http://facebook.com
        bot.navigate("http://facebook.com");

        //getCookies,
        var cookies = driver.manage().getCookies();
        System.out.println("Cookies list");
        cookies.forEach(System.out::println);
        System.out.println("------------------------------------");
        // addCookie,
        driver.manage().addCookie(new Cookie(
                "fruit","apple"));
        cookies = driver.manage().getCookies();

        System.out.println("Cookies list after add");
        cookies.forEach(System.out::println);
        System.out.println("------------------------------------");

        // deleteCookieNamed,
        driver.manage().deleteCookieNamed("fruit");
        cookies = driver.manage().getCookies();
        System.out.println("Cookies list after delete one cook by name");
        cookies.forEach(System.out::println);
        System.out.println("------------------------------------");

        // deleteAllCookies
        driver.manage().deleteAllCookies();
        cookies = driver.manage().getCookies();
        System.out.println("Cookies list after delete all");
        cookies.forEach(System.out::println);
        System.out.println("------------------------------------");

    }
}
