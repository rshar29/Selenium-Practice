package Day41_DataDriverTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");

		driver.manage().window().maximize();

		// Accept cookies

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='onetrust-accept-btn-handler']")))
				.click();

		String filePath = System.getProperty("user.dir") + "\\testData\\Cit_bank.xlsx";

		String sheetName = "CalData";

		ExcelUtility excel = new ExcelUtility(filePath);

		int rowCount = excel.getRowCount("CalData");

		for (int r = 1; r <= rowCount; r++) {

			// 1. read data from excel

			String DepositAmount = excel.getCellData(sheetName, r, 0);

			String TermMonths = excel.getCellData(sheetName, r, 1);

			String InterestRate = excel.getCellData(sheetName, r, 2);

			String CompoundingType = excel.getCellData(sheetName, r, 3);

			String TotalInterestExpected = excel.getCellData(sheetName, r, 4);

			String ExpectedStatus = excel.getCellData(sheetName, r, 5);

			if (DepositAmount.isEmpty())
				continue;

			// 2. Pass above data into application

			WebElement depositeAmt = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mat-input-0']")));

			depositeAmt.clear();

			depositeAmt.sendKeys(DepositAmount);

			WebElement terms = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mat-input-1']")));

			terms.clear();

			terms.sendKeys(TermMonths);
			
			/*

			WebElement rate = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='mat-input-2']")));
			rate.click();
			rate.clear();
			rate.sendKeys(InterestRate);
			
			*/
			
			WebElement rate = wait.until(
				    ExpectedConditions.elementToBeClickable(
				        By.xpath("//input[@id='mat-input-2']")
				    )
				);

				System.out.println("Displayed: " + rate.isDisplayed());
				System.out.println("Enabled: " + rate.isEnabled());
				System.out.println("Readonly: " + rate.getAttribute("readonly"));
				System.out.println("Value before: " + rate.getAttribute("value"));

				rate.click();

				rate.sendKeys(Keys.CONTROL, "a");
				rate.sendKeys(Keys.BACK_SPACE);
				rate.sendKeys(InterestRate);

				System.out.println("Value after: " + rate.getAttribute("value"));

			// clicking on dropdown and selecting the value

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-select[@id='mat-select-0']"))).click();

			// selecting "Compounded Monthly" from dropdown

			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//mat-option[.//span[normalize-space()='" + CompoundingType + "']]"))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='CIT-chart-submit']"))).click();

			// validation

			String actualTotal = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("(//ul[contains(@class,'--card CIT-margin--bottom-50')]//li[3])[2]//p")))
					.getText();

			System.out.println("Expected: " + TotalInterestExpected);

			System.out.println("Actual:   " + actualTotal);

			actualTotal = actualTotal.replace("$", "").replace(",", "").trim();

			TotalInterestExpected = TotalInterestExpected.replace("$", "").replace(",", "").trim();

			if (Double.parseDouble(TotalInterestExpected) == Double.parseDouble(actualTotal)) {

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

	}

}
