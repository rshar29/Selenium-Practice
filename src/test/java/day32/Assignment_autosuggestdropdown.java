package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment_autosuggestdropdown {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.bjs.com/");
		driver.manage().window().maximize();
		
		List<WebElement> sugessions=driver.findElements(By.xpath("//div[@data-cnstrc-item-section='Search Suggestions']"));
		
		System.out.println(sugessions.size());
		
		for(WebElement ele:sugessions) {
			System.out.println(ele.getText());
			
			if(ele.getText().equals("organic eggs")) {
				ele.click();
				//ele.findElement(By.tagName("a")).click();
				break;
			}
		}	
	}

}
