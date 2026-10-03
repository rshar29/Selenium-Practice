package Day41_DataDriverTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private static String path;

    public ExcelUtility(String path) {
        this.path = path;
    }

    // Get total number of rows
    public static int getRowCount(String sheetName) throws IOException {

        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null)
                return 0;

            return sheet.getLastRowNum();
        }
    }

    // Get total number of cells in a row
    public int getCellCount(String sheetName, int rowNum) throws IOException {

        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null)
                return 0;

            XSSFRow row = sheet.getRow(rowNum);

            if (row == null)
                return 0;

            return row.getLastCellNum();
        }
    }

    // Read cell data
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {

        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null)
                return "";

            XSSFRow row = sheet.getRow(rowNum);

            if (row == null)
                return "";
 
            XSSFCell cell = row.getCell(colNum);

            if (cell == null)
                return "";

            DataFormatter formatter = new DataFormatter();

            return formatter.formatCellValue(cell);
        }
    }

    // Write data into Excel
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {

        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null)
                sheet = workbook.createSheet(sheetName);

            XSSFRow row = sheet.getRow(rowNum);

            if (row == null)
                row = sheet.createRow(rowNum);

            XSSFCell cell = row.getCell(colNum);

            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(data);

            fis.close();

            try (FileOutputStream fos = new FileOutputStream(path)) {
                workbook.write(fos);
            }
        }
    }

    // Fill Green Color
    public static void fillGreenColor(String sheetName, int rowNum, int colNum) throws IOException {

        fillCellColor(sheetName, rowNum, colNum, IndexedColors.GREEN);
    }

    // Fill Red Color
    public static void fillRedColor(String sheetName, int rowNum, int colNum) throws IOException {

        fillCellColor(sheetName, rowNum, colNum, IndexedColors.RED);
    }

    // Common method for coloring cells
    private static void fillCellColor(String sheetName, int rowNum, int colNum, IndexedColors color)
            throws IOException {

        try (FileInputStream fis = new FileInputStream(path);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);

            if (sheet == null)
                return;

            XSSFRow row = sheet.getRow(rowNum);

            if (row == null)
                row = sheet.createRow(rowNum);

            XSSFCell cell = row.getCell(colNum);

            if (cell == null)
                cell = row.createCell(colNum);

            CellStyle style = workbook.createCellStyle();

            style.setFillForegroundColor(color.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            cell.setCellStyle(style);

            fis.close();

            try (FileOutputStream fos = new FileOutputStream(path)) {
                workbook.write(fos);
            }
        }
    }
}