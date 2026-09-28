package Day38_Screenshots_Headless_SSL_AdBlock_Extensions;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {
		
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");  //setting for headless mode execution
		
		WebDriver driver =new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		String windowId=driver.getWindowHandle();
	
		
		//driver.findElement(By.linkText("OrangeHRM, Inc")).click(); 
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		
		
		
		Set<String> windowIds=driver.getWindowHandles();
		System.out.println(windowIds);
		
		driver.quit();
		

	}

}
