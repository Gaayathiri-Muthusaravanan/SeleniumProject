package utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtilityClass {
    FileInputStream file = new FileInputStream("src/test/resources/LoginData.xlsx");
    Workbook workbook;


    public ExcelUtilityClass() throws IOException {
        workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheet("Sheet1");

    }
    public String getCellData(int rowNumber,int cellNumber){
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);
        return cell.toString();
    }
    public int getRowCount(){
        Sheet sheet = workbook.getSheet("Sheet1");
        return sheet.getPhysicalNumberOfRows();
    }
    public int getColumnCount(){
        Sheet sheet = workbook.getSheet("Sheet1");
        Row row = sheet.getRow(1);
        return row.getPhysicalNumberOfCells();
    }

}
