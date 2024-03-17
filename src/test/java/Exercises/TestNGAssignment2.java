package Exercises;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
public class TestNGAssignment2 extends Tests {
    /**
     * Go to <a href="https://testpages.eviltester.com/styled/apps/notes/simplenotes.html">Test page</a>(done)
     * <br>Add 10 notes using data provider with Excel(done)
     * <br>Run it with three different browsers using XML file(done)
     * <br>Run it parallel with three threads(done)
     */
    @Test
    public void Assignment2() throws IOException {
//        Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

//        Add 10 notes using data provider with Excel
        String path = System.getProperty("user.home") + "/IdeaProjects/testProject/src/test/resources/testData/Book2.xlsx";
        Workbook workbook = new XSSFWorkbook(new FileInputStream(path));

        Sheet sheet = workbook.getSheetAt(0);
        By titleLocator = By.id("note-title-input");
        By notesLocator = By.id("note-details-input");
        By submitLocator = By.id("add-note");
        By listLocator = By.className("note-in-list");
        for (int i = 0; i < 10; i++) {
            bot.type(titleLocator, sheet.getRow(i).getCell(0).toString());
            bot.type(notesLocator, sheet.getRow(i).getCell(1).toString());
            bot.click(submitLocator);

        }
        int listSize = driver.findElements(listLocator).size();
        System.out.println("The list notes size is: " + listSize);
        Assert.assertEquals(listSize,10);


//        Run it with 3 different browsers using XML file
//        Run it parallel with 3 threads
        /** check assignment2XML.xml */

    }



}
