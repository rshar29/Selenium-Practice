package day31;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		WebElement drpdownCounty = driver.findElement(By.xpath("//select[@id='country']"));
		Select drpOptions = new Select(drpdownCounty);
		// drpOptions.selectByVisibleText("France");
		// drpOptions.selectByValue("japan");
		// drpOptions.selectByIndex(2);

		// capture all the options from the dropdown
		List<WebElement> options = drpOptions.getOptions();
		System.out.println("Number of options in dropdown: " + options.size());

		// printing in the console Enhanced for loop
		for (WebElement opt : options) {
			System.out.println(opt.getText());
		}
		/*

		// printing in the console normal for loop
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}
		*/

	}

}
