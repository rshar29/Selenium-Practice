package day34_DatePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker2 {

	//selecting future date
	static void selectFutureDate(WebDriver driver, String year, String month,String date) {
		
		while(true) {
			String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//actual month
			String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();//actual year
			
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			//Going next
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //Next
		
		
	}
		
		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));

		for (WebElement dt : dates) {

			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}
	
	
	
	//selecting past date
	static void selectPastDate(WebDriver driver, String year, String month,String date) {
		
		while(true) {
			String currentMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();//actual month
			String currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();//actual year
			
			if(currentMonth.equals(month) && currentYear.equals(year)) {
				break;
			}
			//Going next
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click(); //Next
		
	}
		
		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));

		for (WebElement dt : dates) {

			if (dt.getText().equals(date)) {
				dt.click();
				break;
			}
		}
	}


	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		// switch to frame
		driver.switchTo().frame(0);

		// method 1 sendkeys
		// driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("10/04/2025");

		// Method2: using date picker
		// expected data
		String year = "2026";
		String month = "January";
		String date = "27";
		driver.findElement(By.xpath("//input[@id='datepicker']")).click(); // opens date picker
		//selectFutureDate(driver, "2027", "May","20");
		selectPastDate(driver, "2023", "May","20");

	}

	// driver.quit();

}

