package engine;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * -- Breakout task: 40 minutes
 * implement and use any one of the listeners we discussed (testng listener, webdriver listener)
 * and optionally implement the allure @step annotation to your actions bot class
 * -> use the rest of the 40 minutes to make sure that your project is fixed and following us with everything we do*/

public class CustomListener implements ITestListener, WebDriverListener {

    public void onTestFailure(ITestResult result) {
        // not implemented
        System.out.println(result.getInstanceName() + "." + result.getName() + " Failed");


    }

    public void onTestSuccess(ITestResult result) {
        // not implemented
        System.out.println(result.getInstanceName() + "." + result.getName() + " Success");
    }

    public void afterGetText(WebElement element, String result) {
        Allure.attachment("data.txt", "This is the file content.");
        try (InputStream is = Files.newInputStream(element.getScreenshotAs(OutputType.FILE).toPath())) {
            Allure.attachment("image.png", is);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}