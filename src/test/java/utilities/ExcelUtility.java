package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {
    private String filePath;
    private FileInputStream fis;
    private FileOutputStream fos;
    private XSSFWorkbook workbook;
    XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    // Constructor to load Excel file
    public ExcelUtility(String filePath) throws IOException {
        this.filePath = filePath;
        fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
    }

    // Get row count from a given sheet
    public int getRowCount(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        if (sheet == null) {
            throw new IllegalArgumentException("Sheet " + sheetName + " not found.");
        }
        return sheet.getLastRowNum();
    }

    // Get column count from a given sheet
    public String getCellData(Cell cell) {
        try {
            switch (cell.getCellType()) { // Use getCellType() directly in POI 3.9
                case Cell.CELL_TYPE_STRING:
                    return cell.getStringCellValue();
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        return cell.getDateCellValue().toString();
                    } else {
                        return String.valueOf(cell.getNumericCellValue());
                    }
                case Cell.CELL_TYPE_BOOLEAN:
                    return String.valueOf(cell.getBooleanCellValue());
                case Cell.CELL_TYPE_FORMULA:
                    return cell.getCellFormula();
                case Cell.CELL_TYPE_BLANK:
                    return "";
                default:
                    return "Unknown Cell Type";
            }
        } catch (Exception e) {
            return "Error reading cell: " + e.getMessage();
        }
    }
               
    // Close the workbook
    public void closeWorkbook() throws IOException {
        if (workbook != null) {
            workbook = null;  // POI 3.9 does not support close()
        }
        if (fis != null) {
            fis.close();
        }}}