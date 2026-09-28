package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
Assignment

https://testautomationpractice.blogspot.com/

1. provide some string search for it
2. count number of links
3. click each links using for loop
4. get window Id's for every browser window
5. close specific browser window
 */
public class Assignment1 {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		String parentWindowID = driver.getWindowHandle();
		
		driver.findElement(By.cssSelector("#Wikipedia1_wikipedia-search-input")).sendKeys("selenium");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		By resultLinks=By.xpath("//div[@id='Wikipedia1_wikipedia-search-results']//a");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(resultLinks));
		
		
		List<WebElement> links=driver.findElements(resultLinks);
		System.out.println("Total links found: "+links.size());
		
		for(WebElement link:links) {
			System.out.println("Clicking: " + link.getText());
			link.click();
		}
		//Wait until all child windows have loaded (parent + 5 search result tabs = 6)
		wait.until(ExpectedConditions.numberOfWindowsToBe(links.size()+1));
		
		Set<String> winIds=driver.getWindowHandles();
		System.out.println("\n--- Iterating Through Browser Windows ---");
		
		String targetTitle="Selenium (software) - Wikipedia";
		
		for(String win:winIds) {
			String title=driver.switchTo().window(win).getTitle();
			
			if(title.equals(targetTitle)) {
				System.out.println(title);
				driver.close();
			}
			
		}
		driver.switchTo().window(parentWindowID);
		
		System.out.println("\nCurrent active window: " + driver.getTitle());

        // 9. Clean up session properly
        driver.quit();
	}

}
