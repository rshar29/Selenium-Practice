package Day40_DataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//Excel File -> Workbook --> Sheets -> rows -> cells
public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testData\\Data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		
		//XSSFSheet sheet=workbook.getSheetAt(0);  -- can use this
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int totalRows=sheet.getLastRowNum();

		int totalCells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("No. of rows :"+totalRows);
		System.out.println("No. of cells :"+totalCells);
		
		
		for(int r=0;r<=totalRows;r++) {
			
			XSSFRow currentRow=sheet.getRow(r);
			
			for(int c=0;c<totalCells;c++) {
				XSSFCell cell=currentRow.getCell(c);
				System.out.print(cell.toString()+ "\t");
				
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		
		
		
		
		
		
		
		
		
		
		

	}

}
