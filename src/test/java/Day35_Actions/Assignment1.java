package Day35_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Assignment 1:
1. double click & Drag and drop 
https://testautomationpractice.blogspot.com/

 */
public class Assignment1 {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		/*
		//1. scroll down page by pixel number
		js.executeScript("window.scrollBy(0,9000)", "");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		System.out.println(js.executeScript("return window.pageXOffset;")); //in case horizontally scroll needs
		*/
		
		//2. scroll page till element is visible
		//Use case- sometimes we can't be able to click element due to big webpage thn we can scroll and perform

		/*
		WebElement ele=driver.findElement(By.xpath("//td[normalize-space()='Luxembourg']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;")); //9558.6669921875
		
		*/
		
		//3. scroll page till end of the webpage
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		
		//4. scrolling up again from bottom to up
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		

		
		
		
	}

}
