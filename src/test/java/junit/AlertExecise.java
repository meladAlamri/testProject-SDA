package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertExecise extends Tests {
    /**
     * Go to URL: <a href="http://demo.automationtesting.in/Alerts.html">demo</a>
     * <br>Click "Alert with OK" and click 'click the button to display an alert box:’
     * <br>Accept Alert(I am an alert box!) and print alert on console.
     * <br>Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
     * <br>Cancel Alert (Press a Button !)
     * <br>Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
     * <br>And then sendKeys «Bootcamp» (Please enter your name)
     * <br>Finally print on console this message "Hello Bootcamp How are you today" assertion these message.
     */

    @Test
    public void alertTest() {
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

        By alertOkLocater = By.cssSelector("button[onclick='alertbox()']");
        By alertOkCanceLinkeLocter = By.xpath("(//a[@class='analystic'])[2]");
        By alertOkCancelLocter = By.cssSelector("button[onclick='confirmbox()']");
        By alertTextBoxLinklLocter = By.xpath("(//a[@class='analystic'])[3]");
        By alertTexBox = By.cssSelector("button[onclick='promptbox()']");
        By massageOkCancel = By.id("demo");
        By massageTexBox = By.id("demo1");

        //---------------------------------------------------------
        driver.findElement(alertOkLocater).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String alertMassage = alert.getText();
        alert.accept();
        System.out.println(alertMassage);
        //---------------------------------------------------------
        driver.findElement(alertOkCanceLinkeLocter).click();
        driver.findElement(alertOkCancelLocter).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alertMassage = alert.getText();
        System.out.println(alertMassage);

        alert.dismiss();
        alertMassage = driver.findElement(massageOkCancel).getText();
        System.out.println(alertMassage);
        //---------------------------------------------------------
        driver.findElement(alertTextBoxLinklLocter).click();
        driver.findElement(alertTexBox).click();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("Melad");
        alert.accept();
        alertMassage = driver.findElement(massageTexBox).getText();
        System.out.println(alertMassage);
        Assertions.assertEquals("Hello Melad How are you today", alertMassage);


    }

}
