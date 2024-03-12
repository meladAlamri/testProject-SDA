package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class JunitAssignment4 extends JunitTestBase{


    /**
     * ( This task should be managed with keyboard actions )
     * go to <a href="https://www.google.com/">Google</a>(done)
     * <br>search for "Scroll Methods" by using an Actions object(done)
     * <br>Instead of locating the searchbar and sending the "Scroll Methods";(done)
     * <br>I want you to use the actions and while holding the SHIFT key type "s" and then continue to type "croll"(done)
     * <br>then click space and again make the "m" capital and continue typing "ethods"(done)
     * <br>then click enter.(done)
     * */

    @Test
    public void junitAssignment4(){

        // go to https://www.google.com/
        bot.navigate("https://www.google.com/");

        // search for "Scroll Methods" by using an Actions object
        new Actions(driver)
                .scrollToElement(driver.findElement(By.id("APjFqb")))
                .click(driver.findElement(By.id("APjFqb")))
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("croll")
                .keyDown(Keys.SPACE)
                .keyUp(Keys.SPACE)
                .keyDown(Keys.SHIFT)
                .sendKeys("m")
                .keyUp(Keys.SHIFT)
                .sendKeys("ethods")
                .sendKeys(Keys.ENTER)
                .perform();
        By ResultText = By.id("result-stats");
        wait.until(
                d -> {
                    driver.findElement(ResultText).getText();
                    return true;
                });
        Assertions.assertNotEquals("",driver.findElement(ResultText).getText());


    }

}
