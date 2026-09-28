package day28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClosingSpecificWin {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		driver.manage().window().maximize();

		// driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM,
		// Inc')]")).click();
		WebElement link = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")));
		link.click();

		Set<String> WindowIds = driver.getWindowHandles();

		for (String winID : WindowIds) {

			String title = driver.switchTo().window(winID).getTitle();
			System.out.println(title);
			
			if(title.equals("OrangeHRM") || title.equals("Human Resources")) {
				driver.close();
				break;
			}

		}

	}

}
