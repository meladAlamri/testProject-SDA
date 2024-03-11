package junit;

public class JsonFileReaderTests extends Tests{
/*    static JSONObject testData;

    @BeforeAll
    public static void beforeAll() throws IOException, ParseException {
        testData =  (JSONObject) new JSONParser().parse( new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8) );
    }

    @Test
    public void jsonDataTest(){
        String searchQuery = (String) testData.get("searchQuery");

        driver.get("https://www.google.com/");
        driver.findElement(By.id("APjFqb")).sendKeys(searchQuery + Keys.RETURN);

        By resultStats = By.id("result-stats");
        wait.until(d -> !driver.findElement(resultStats).getText().isEmpty());
        String actualText = driver.findElement(resultStats).getText();
        Assertions.assertNotEquals("", actualText);

    }*/
}