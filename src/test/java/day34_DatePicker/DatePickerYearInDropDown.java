package day34_DatePicker;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//If the Month is on text format and Year is on dropdown then we can use this logic. All date picker has different logic

public class DatePickerYearInDropDown {

	// user defined method for converting month from string -->Month
	static Month convertMonth(String month) {

		HashMap<String, Month> monthMap = new HashMap<String, Month>();
		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid Month..");
		}
		return null;

	}
	
	static void selectDate(WebDriver driver, String year,String month,String date) {
		
		// Select year from dropdown
		WebElement yearDropDown = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selctYear = new Select(yearDropDown);
		selctYear.selectByVisibleText(year);

		// select Month
		while (true) {
			String displayedMonth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")).getText();

			// convert month & displayedMonth in to Month Objects

			Month expecedMonth = convertMonth(month);
			Month currentMonth = convertMonth(displayedMonth);
			// compare
			int result = expecedMonth.compareTo(currentMonth);
			  /*
			   0 months are equal 
			  >0 - future month 
			  0< - past
			 */

			if (result < 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			} else if (result > 0) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			} else {
				break;
			}
		}
		
		//select date
		List<WebElement> allDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td//a"));
		
		for(WebElement dt:allDates) {
			
			if(dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
		
	}

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// input DOB
		String year = "2021";
		String month = "June";
		String date = "15";

		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		selectDate(driver, year, month,date);

	}

}
