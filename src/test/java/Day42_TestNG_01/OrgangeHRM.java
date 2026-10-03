package Day42_TestNG_01;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1. Open to OrangeHRM
2. Test logo presence
3. Login to OrangeHRM
4. close
 */

import org.testng.annotations.Test;

public class OrgangeHRM {
	
	WebDriver driver;
	@Test(priority = 1)
	void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
	}
	@Test(priority = 2)
	void testLogo() throws InterruptedException {
		Thread.sleep(2000);
		boolean logo=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("Logo is present...."+logo);
	}
	
	@Test(priority = 3)
	void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
	}
	@Test(priority = 4)
	void close() {
		driver.close();
	}
	
	

}
