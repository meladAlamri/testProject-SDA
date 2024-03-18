package Exercises;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssignment5 extends Tests{

    /**
     * Go to URL: <a href="http://crossbrowsertesting.github.io/">cross browser</a>
     * <br>Click to To-Do App
     * <br>Checking Box to do-4 and Checking Box to do-5
     * <br>If both clicks worked, then the following List should be have length 2.
     * <br>Assert that this is correct
     * <br>Assert that the to do we added is present in the list
     * <br>Archiving old todos
     * <br>If our archive link worked, then the following list should have length 4.
     * <br>Assert that this is true as well
     * <br>Doing Cross Browser Testing.
     *     */

    @Test
    public void Assignment5(){
        //Go to URL: http://crossbrowsertesting.github.io/
        bot.navigate("http://crossbrowsertesting.github.io/");

        //Click to To-Do App
        By toDoLinkLocator = By.xpath("//a[@href='todo-app.html']");
        bot.click(toDoLinkLocator);

        //Checking Box to do-4 and Checking Box to do-5
        By do4Locator = By.name("todo-4");
        bot.click(do4Locator);
        By do5Locator = By.name("todo-5");
        bot.click(do5Locator);

        //If both clicks worked, then the following List should be have length 2.
        //Assert that this is correct
        By doneTrueListLocator = By.className("done-true");
        Assert.assertEquals(driver.findElements(doneTrueListLocator).size(),2);

        //Assert that the to do we added is present in the list
        By textInputLocator = By.id("todotext");
        By addButtonLocator = By.id("addbutton");
        bot.type(textInputLocator,"we added is present in the list");
        bot.click(addButtonLocator);
        By checkText = By.xpath("//span[text()='we added is present in the list']");
        Assert.assertTrue(driver.findElement(checkText).isDisplayed());

        //Archiving old todos
        By archiveButtonLocator = By.tagName("a");
        bot.click(archiveButtonLocator);

        //If our archive link worked, then the following list should have length 4.
        //Assert that this is true as well
        By doneFalseListLocator = By.className("done-false");
        Assert.assertEquals(driver.findElements(doneFalseListLocator).size(),4);

        //Doing Cross Browser Testing.
        /** check assignment5XML.xml */
    }
}
