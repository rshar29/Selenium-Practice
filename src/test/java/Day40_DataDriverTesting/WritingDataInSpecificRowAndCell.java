package Day40_DataDriverTesting;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInSpecificRowAndCell {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testData\\myFileRandom.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("DataRandom");
		
		XSSFRow row=sheet.createRow(3);
		XSSFCell cell=row.createCell(4);
		cell.setCellValue("rakesh");
		
		workbook.write(file);
		workbook.close();
		file.close();

		System.out.println("File is created..");
	}

	}
