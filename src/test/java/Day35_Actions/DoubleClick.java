package Day35_Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoubleClick {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		
		driver.switchTo().frame("iframeResult");

		WebElement textbox1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement textbox2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement buttonClickMe= driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		textbox1.clear();
		textbox1.sendKeys("Selenium");
		
		Actions act=new Actions(driver);
		act.doubleClick(buttonClickMe).perform();
		
		//validation - textbox2 should contain "Selenium";
		
		String text=textbox2.getAttribute("value");
		System.out.println("textbox2 captured value is: "+text);
		
		if(text.equals("Selenium")) {
			System.out.println("Text copied");
		}else {
			System.out.println("Text not copied");
		}
	}

}
