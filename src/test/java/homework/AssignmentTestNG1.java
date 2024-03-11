package homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssignmentTestNG1 extends Tests{
/**
 * Go to URL: <a href="https://api.jquery.com/dblclick/">api.jquery</a> (done)
 * <br> Double click on the blue square at the bottom of the page and then write the changed color.(done)
 * <br> Go top of the page and sendKeys "Thanks to JavascriptExecutor" (done)
 * <br> Go to the bottom of the page and click the book, name"jQuery in Action" (done)
 * */
    @Test
    public void assignmentTestNG1(){

        //Go to URL: https://api.jquery.com/dblclick/
        bot.navigate("https://api.jquery.com/dblclick/");

        //Double click on the blue square at the bottom of the page and then write the changed color.
        By frameLocater = By.tagName("iframe");
        WebElement iframe = driver.findElement(frameLocater);
        driver.switchTo().frame(iframe);
        By blueSquareButtonLocater = By.tagName("div");
        System.out.println("The old color is " + driver.findElement(blueSquareButtonLocater).getCssValue("background-color"));
        new Actions(driver)
                .doubleClick(driver.findElement(blueSquareButtonLocater))
                .perform();
        System.out.println("The color change to " + driver.findElement(blueSquareButtonLocater).getCssValue("background-color"));
        driver.switchTo().defaultContent();

        //Go top of the page and sendKeys "Thanks to JavascriptExecutor"
        By searchInputBoxLocater = By.name("s");
        bot.type(searchInputBoxLocater,"Thanks to JavascriptExecutor" + Keys.RETURN);

        //Go to the bottom of the page and click the book, name"jQuery in Action"
        By bookLecater = By.xpath("//img[contains(@alt,'jQuery in Action')]");
        bot.click(bookLecater);
        Assert.assertEquals("https://www.manning.com/books/jquery-in-action-third-edition",driver.getCurrentUrl());


    }
}
