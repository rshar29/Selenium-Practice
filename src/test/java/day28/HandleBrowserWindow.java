package day28;

import java.time.Duration;
import java.util.*;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleBrowserWindow {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		WebElement link=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")));
		link.click();
		// 2. CRITICAL FIX: Wait for the browser to register the 2nd window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		Set<String> windowIDs=driver.getWindowHandles();
		//Approach 1
		List<String> windowList=new ArrayList<>(windowIDs);
		String parentID=windowList.get(0);
		String childID=windowList.get(1);
		
		// 4. Switch to child window and get title
        driver.switchTo().window(childID);
        System.out.println("Child Title: " + driver.getTitle());

        // 5. Switch back to parent window and get title
        driver.switchTo().window(parentID);
        System.out.println("Parent Title: " + driver.getTitle());

        
        //Approach 2
        for(String winID:windowIDs) {
        	String title=driver.switchTo().window(winID).getTitle();
        	
        	if(title.equalsIgnoreCase("OrangeHRM")) {
        		System.out.println(driver.getCurrentUrl());
        		//some validation on the parent window
        	}
        }
        
        
        // 6. Clean up
        driver.quit();
	
	}

}
