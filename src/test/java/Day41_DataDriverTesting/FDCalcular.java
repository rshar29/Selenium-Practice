package Day41_DataDriverTesting;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FDCalcular {
	
	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filePath=System.getProperty("user.dir")+"\\testData\\Interest_Calculation_Data.xlsx";
		
		String sheetName = "Interest Calculation";
		ExcelUtility excel = new ExcelUtility(filePath);
		int totalRows = excel.getRowCount(sheetName);

		for (int r = 1; r <= totalRows; r++) {
			//1. read data from excel
			String Principal = excel.getCellData(sheetName, r, 0);
			String roi = excel.getCellData(sheetName, r, 1);
			String Period1 = excel.getCellData(sheetName, r, 2);
			String frequency = excel.getCellData(sheetName, r, 4);
			String expectedMaturity = excel.getCellData(sheetName, r, 5);
			
			if (Principal.isEmpty()) continue;
			
			//2. Pass above data into application
			driver.findElement(By.xpath("//input[@id='edulonvalue_1']")).sendKeys(Principal);
			driver.findElement(By.xpath("//input[@id='edulonvalue_2']")).sendKeys(Period1);
			driver.findElement(By.xpath("//input[@id='edulonvalue_3']")).sendKeys(roi);
			driver.findElement(By.xpath("//span[@class='radiotext'][normalize-space()='Yearly']")).click();
			
			
			//Submit
			driver.findElement(By.xpath("//a[normalize-space()='Submit']")).click();
			//validation
			String actual_TotalInteresr=driver.findElement(By.xpath("//span[@class='tc']")).getText();	
			
			if(Double.parseDouble(expectedMaturity)==Double.parseDouble(actual_TotalInteresr)) {
				System.out.println("Test Passed");
				excel.setCellData(sheetName, r, 6, "Test Passed");
				ExcelUtility.fillGreenColor(sheetName, r, 6);
				
			
			}
			else {
				System.out.println("Test Failed");
				excel.setCellData(sheetName, r, 6, "Test Failed");
				ExcelUtility.fillRedColor(sheetName, r, 6);
			}
			
		}
		
		
		driver.quit();
	}

}
