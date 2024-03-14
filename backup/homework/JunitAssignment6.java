package homework;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JunitAssignment6 {
    /**
     * Store the path of the file as string and open the file.(done)
     * <br>Open the workbook.(done)
     * <br>Open the first worksheet.(done)
     * <br>Go to the first row.(done)
     * <br>Create a cell on the 3rd column (2nd index) on the first row.(done)
     * <br>Write “POPULATION” on that cell.(done)
     * <br>Create a cell on the 2nd row 3rd cell(index2), and write data.(done)
     * <br>Create a cell on the 3rd row 3rd cell(index2), and write data.(done)
     * <br>Create a cell on the 4th row 3rd cell(index2), and write data.(done)
     * <br>Write and save the workbook.(done)
     * <br>Close the file.(done)
     * <br>Close the workbook.(done)
     * <br>The 3rd column on Excel file must be empty before running.(done)
     * <br>Otherwise, new data will be written on the old data(done)
     * */


    private Sheet sheet;
    @Test
    public void junitAssignment6() throws IOException {
        //Store the path of the file as string and open the file.
        String path = System.getProperty("user.home")+"/IdeaProjects/testProject/src/test/resources/testData/Book1.xlsx";

        //Open the workbook.
        Workbook workbook = new XSSFWorkbook(new FileInputStream(path));

        //Open the first worksheet.
         sheet = workbook.getSheetAt(0);

        //The 3rd column on Excel file must be empty before running.
        // Otherwise, new data will be written on the old data
         reStart();

        //Go to the first row.
        //Create a cell on the 3rd column (2nd index) on the first row.
        //Write “POPULATION” on that cell.
         writeInExist(0,2,"POPULATION");

        //Create a cell on the 2nd row 3rd cell(index2), and write data.
        writeInExist(1,2,"data");

        //Create a cell on the 3rd row 3rd cell(index2), and write data.
        writeInExist(2,2,"data");

        //Create a cell on the 4th row 3rd cell(index2), and write data.
        writeInExist(3,2,"data");

        //Write and save the workbook.
        FileOutputStream fos = new FileOutputStream(path);
        workbook.write(fos);

        //Close the file.
        fos.close();
        //Close the workbook.
        workbook.close();

    }

    private void writeInExist(int rowIndex, int cellIndex, String value){

        if (sheet.getRow(rowIndex) == null) {
            sheet.createRow(rowIndex);
        }
        Row row = sheet.getRow(rowIndex);
        Cell cell = row.createCell(cellIndex);
        cell.setCellValue(value);
        System.out.println("The value on Row "+(row.getRowNum()+1) +" and cell " + (cell.getColumnIndex()+1) +" is " +cell.getStringCellValue());

    }

    private void reStart(){

        int lastRow = sheet.getLastRowNum();
        for(int i=0; i<=lastRow; i++){
            if (sheet.getRow(i) != null){
                Row row = sheet.getRow(i);
                System.out.println("The row "+(row.getRowNum()+1)+" is clean now");
                sheet.removeRow(row);
            }

        }
    }


}
