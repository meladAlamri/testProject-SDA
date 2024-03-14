package junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DemoqaSelectTest {
    WebDriver driver;
    /**
     *    <a href="https://demoqa.com/select-menu">Demoqa</a>
     *    Get all the options of the dropdown from 'Old style select menu'
     *    Options size
     *    Print all test
     *    Verify the dropdown has option "Black"
     *    Print FirstSelectedOptionTest
     *    Select option "Yellow"
     *    */
    @Test
    public void selectAll(){

        By dropdownLocate = By.id("oldSelectMenu");
        Select select = new Select( driver.findElement(dropdownLocate));
        List<WebElement> allOptions = select.getOptions();

        //-----------------------------------------------------
        System.out.println("The size of select manu: "+ allOptions.size());
        //-----------------------------------------------------
        System.out.println("All options");
        //allOptions.forEach(System.out::println); // try it later
        for (WebElement op :allOptions){
            System.out.println(op.getText());
        }
        //-----------------------------------------------------
        boolean isElementExist = allOptions.stream().anyMatch( op  ->  op.getText().equals("Black"));
        System.out.println("Has the dropdown has option Black? " + isElementExist);
        //-----------------------------------------------------
        System.out.println(allOptions.getFirst().getText());

        //------------------------------------------------------
        select.selectByVisibleText("Yellow");
        boolean isChecked = select.getFirstSelectedOption().isSelected();
        Assertions.assertTrue(isChecked);
        System.out.println(select.getFirstSelectedOption().getText());

    }

    @BeforeEach
    public void beforeEach(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://demoqa.com/select-menu");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
