package Day36_Slider_Tabs_Wins;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//clicking method from the actions class accept arguments.

public class OpenLinkInNewTab {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://practicesoftwaretesting.com/");
		driver.manage().window().maximize();
		
		System.out.println("Title: " + driver.getTitle());
		WebElement SignIn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Sign in']")));
		
		String parentWindow = driver.getWindowHandle();

		Actions act = new Actions(driver);
		// Ctrl+Registration link
		act.keyDown(Keys.CONTROL).click(SignIn).keyUp(Keys.CONTROL).perform();
		
		// Wait for new tab
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Switch to new tab
		for (String windowId : driver.getWindowHandles()) {

		    if (!windowId.equals(parentWindow)) {
		        driver.switchTo().window(windowId);
		        break;
		    }
		}
		WebElement emailss = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(
		                By.id("email")
		        )
		);
		emailss.sendKeys("rakesh");

		
		driver.switchTo().window(parentWindow);
		/*
		List<String> ids = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1)); // Sign In

		// Registration
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("rakesh@gmail.com");

		// Home page
		driver.switchTo().window(ids.get(0)); // switching to homepage

		driver.findElement(By.xpath("//a[normalize-space()='Contact']")).click();
		*/
		
	}

}
