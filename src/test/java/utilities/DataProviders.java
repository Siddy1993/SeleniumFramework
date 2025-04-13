package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public static Object[][] getData() throws IOException {
    	String filePath = System.getProperty("user.dir") + "/testData/ExcelTestData.xlsx";
        String sheetName = "Sheet 1";  // Update this with your actual sheet name
        
        ExcelUtility excel = new ExcelUtility(filePath);
        int rowCount = excel.getRowCount(sheetName);
        int colCount = 3; // Update based on how many columns you want

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = excel.getCellData(excel.sheet.getRow(i).getCell(j));
            }
        }

        excel.closeWorkbook();  // Closing resources
        return data;
    }
}