package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		
		WebElement frame5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(frame5);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("java");
		
		//driver.switchTo().frame(0);
		driver.findElement(By.linkText("https://a9t9.com")).click();
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='Ui.Vision by a9t9 software - Image-Driven Automation']"));
		boolean logostatus= logo.isDisplayed();
		
		Assert.assertTrue(logostatus, "Logo is not displayed");
	}
}
