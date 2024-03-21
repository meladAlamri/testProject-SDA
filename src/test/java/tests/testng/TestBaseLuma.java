package tests.testng;

import engine.ActionBot;
import engine.CustomListener;
import engine.PropertiesReader;
import org.json.simple.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import java.time.Duration;

public class TestBaseLuma extends Tests{

    @BeforeMethod
    public void initialData() {
        dataInfo = (JSONObject) testData.get("LumaDomeLoginTestData");
    }

    @BeforeMethod
    public void beforeEach(@Optional("Chrome") String option) {
        option = PropertiesReader.props.getProperty("targetBrowser");
        logger.info("Opening " + option + " Browser");
        switch (option) {
            case "Chrome" -> driver = new ChromeDriver();
            case "Edge" -> driver = new EdgeDriver();
            case "Firefox" -> driver = new FirefoxDriver();
        }

        driver = new EventFiringDecorator<>(new CustomListener()).decorate(driver);
        driver.manage().window().maximize();

        logger.info("Configuring 15 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        bot = new ActionBot(driver, wait, logger);

    }
}
