package Day35_Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoverAction {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement PointMe=driver.findElement(By.xpath("//button[normalize-space()='Point Me']"));
		WebElement Mobiles=driver.findElement(By.xpath("//a[text()='Mobiles']"));
		
		Actions act=new Actions(driver);
		//Mouse Hover
		//act.moveToElement(PointMe).moveToElement(Mobiles).build().perform();
		
		//click operation after hover
		act.moveToElement(PointMe).moveToElement(Mobiles).click().build().perform();
		
		//we can use directly perform 
		//act.moveToElement(Desktop).moveToElement(mac).click().perform();
		
		
		
		
		
	}

}
