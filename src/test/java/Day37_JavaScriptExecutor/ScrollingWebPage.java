package Day37_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingWebPage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		/*
		//1. scroll down page by pixel number
		js.executeScript("window.scrollBy(0,9000)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		*/


		//2. Scroll based on the element
		//this approach can be use when we face exception like ElementIsNotVisible the we get element and pass
		//--it it will work
		
		/*
		WebElement ele=driver.findElement(By.xpath("//td[normalize-space()='Libya']"));
		
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//System.out.println(js.executeScript("return window.pageXOffset;")); //In case we hv horizontal scroll
		
		*/

		//3. Scroll down till bottom of the page   Note we can use also - scrollWidth for horizontal
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		Thread.sleep(5000);
		//4. scroll up from bottom to top
		
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		
	}

}
