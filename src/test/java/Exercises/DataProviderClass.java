package Exercises;

import org.testng.annotations.DataProvider;

/**
 * Using the Search function does it with Data Provider for Mac, iPad and Samsung.
 */
public class DataProviderClass {
    @DataProvider(name = "data-provider")
    public Object[][] dataProvider() {
        // Using the Search function does it with Data Provider for Mac, iPad and Samsung.
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}

        };

    }

}
