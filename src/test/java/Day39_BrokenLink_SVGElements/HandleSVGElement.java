package Day39_BrokenLink_SVGElements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSVGElement {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//abs xpath
		//driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[6]/a[1]/span[1]")).click();
		
		//rel path - works
		//driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();
		
		//identify svg
		driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();
		
		//a[@class='oxd-icon oxd-main-menu-item--icon']//*[name()='svg']

	}

}
