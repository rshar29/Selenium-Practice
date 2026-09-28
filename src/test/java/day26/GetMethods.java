package day26;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver =new ChromeDriver();
		//get(url) opens the url in the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		//getTitle() - returns the title of the webpage
		System.out.println(driver.getTitle());
		// getCurrentUrl() - returns URL of the page
		System.out.println(driver.getCurrentUrl());
		/*
		// getPageSource() - returns source code of the page
		System.out.println(driver.getPageSource());
		*/
		//getWindowHandle() - returns ID of the single browser window
		String windowId=driver.getWindowHandle();
		//System.out.println(windowId);
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // this open the new window
		
		Set<String> windowIds=driver.getWindowHandles();
		System.out.println(windowIds);
		
		
		
		
		

		
		
		
		
		
	}

}
