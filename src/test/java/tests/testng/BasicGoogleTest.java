package tests.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;



public class BasicGoogleTest extends Tests{

    /**
     * Breakout task: 40 minutes
     * 1. recreate the base test class for junit with testng (done)
     * 2. copy the actionsBot to your project under `src/main/java/engine` (done)
     * 3. create a new tests.testng (done)
     * 4. create a new class (done)
     * 5. do a quick google search and assert that result stats is not empty using testng (done)
     */

    @Test
    public  void quickGoogleSearch(){
        bot.navigate("https://www.google.com/");
        By searchInput = By.id("APjFqb");
        bot.type(searchInput,"Selenium WebDriver"+ Keys.RETURN);
        By resultSearchLabel = By.id("result-stats");
        assert !("".equals(driver.findElement(resultSearchLabel).getText())) : "Exacted : result stats is not empty using testng";


    }

}
