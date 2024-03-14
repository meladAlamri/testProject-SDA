package homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class JunitAssignment3 extends JunitTestBase{
    /**
     * Go to URL: <a href="http://demo.guru99.com/test/drag_drop.html">guru99</a>(done)
     *<br> Drag and drop the BANK button to the Account section in DEBIT SIDE(done)
     *<br> Drag and drop the SALES button to the Account section in CREDIT SIDE(done)
     *<br> Drag and drop the 5000 button to the Amount section in DEBIT SIDE(done)
     *<br> Drag and drop the second 5000 button to the Amount section in CREDIT SIDE(done)
     *<br> Verify the visibility of Perfect text.(done)
     * */

    @Test
    public void junitAssignment3(){

//      Go to URL: http://demo.guru99.com/test/drag_drop.html
        bot.navigate("http://demo.guru99.com/test/drag_drop.html");
//      Drag and drop the BANK button to the Account section in DEBIT SIDE
        By bankButtonLocator = By.xpath("//a[contains(.,'BANK')]");
        By accountSectionDebitLocator = By.id("bank");
        dragAndDrop(bankButtonLocator,accountSectionDebitLocator);
//      Drag and drop the SALES button to the Account section in CREDIT SIDE
        By salesButtonLocator = By.xpath("//a[contains(.,'SALES')]");
        By accountSectionCreditLocator = By.id("loan");
        dragAndDrop(salesButtonLocator,accountSectionCreditLocator);
//      Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        By the5000ButtonLocator = By.xpath("(//li[@id ='fourth'])[1]");
        By theAmountSectionDebitLocator = By.id("amt7");
        dragAndDrop(the5000ButtonLocator,theAmountSectionDebitLocator);
//      Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        By theSecond5000ButtonLocator = By.xpath("(//li[@id ='fourth'])[2]");
        By theAmountSectionCreditLocator =By.id("amt8");
        dragAndDrop(theSecond5000ButtonLocator,theAmountSectionCreditLocator);
//      Verify the visibility of Perfect text.
        By textLocator = By.xpath("(//a[contains(@class,'button-green')])[1]");
        Assertions.assertEquals("Perfect!",driver.findElement(textLocator).getText());

    }

    private void dragAndDrop(By draggable, By droppable){
        new Actions(driver)
                .dragAndDrop( driver.findElement(draggable) ,driver.findElement(droppable) )
                .perform();
    }
}
