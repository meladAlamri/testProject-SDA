package tests.testng;

import engine.ActionBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Tests {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;

    protected ActionBot bot;

    protected static JSONObject testData;

    @BeforeClass
    public static void beforeAll() throws IOException, ParseException {
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(Tests.class.getName());
        testData = (JSONObject) new JSONParser().parse(new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8));
    }


    @Parameters("option")
    @BeforeMethod
    public void beforeEach(@Optional("Chrome") String option) {
        logger.info("Opening " + option + " Browser");
        switch (option) {
            case "Chrome" -> driver = new ChromeDriver();
            case "Edge" -> driver = new EdgeDriver();
            case "Firefox" -> driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();

        logger.info("Configuring 5 second explicit wait");
        wait = new

                WebDriverWait(driver, Duration.ofSeconds(5));
        bot = new

                ActionBot(driver, wait, logger);

    }

    @AfterMethod
    public void afterEach() {
        logger.info("Quitting Browser");
        driver.quit();
    }
}
