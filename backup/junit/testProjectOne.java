package junit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testProjectOne {
    @Test
    public void test1(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com.sa/");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
