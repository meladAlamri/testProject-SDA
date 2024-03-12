package homework;

import engine.ActionBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestNGTestBase {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;

    protected ActionBot bot;

    //   = LogManager.getLogger(Tests.class.getName());
    @BeforeClass
    public static void beforeAll() {
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(TestNGTestBase.class.getName());
    }


    @BeforeMethod
    public void beforeEach() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        logger.info("Opening Chrome Browser");
        driver = new ChromeDriver(chromeOptions);

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        bot = new ActionBot(driver, wait, logger);

    }

    @AfterMethod
    public void afterEach() {
        logger.info("Quitting Browser");
        driver.quit();
    }
}
