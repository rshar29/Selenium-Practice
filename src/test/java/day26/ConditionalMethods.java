package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {
	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		//isDisplayed() - applicable for all kind of webElement 
		/*
		WebElement logo=driver.findElement(By.id("//img[@alt='nopCommerce demo store']"));
		System.out.println("Logo display status" +logo.isDisplayed());
		*/
		//use like this also
		/*
		boolean logoDisplay=driver.findElement(By.id("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Logo display status" +logoDisplay);
		*/
		
		//isEnabled()
		boolean firstName=driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		System.out.println("firstName field is enabled or not:" +firstName);
		
		//isSelected
		
		WebElement male=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female =driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selecting radio button");
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		
		
		System.out.println("After selecting radio button");
		male.click();
		System.out.println(male.isSelected());
		System.out.println(female.isSelected());
		
		//checkbox - isSelected()
		boolean newsLetter=driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']")).isSelected();
		System.out.println("newsletter is selected?"+newsLetter);
		
	}

}
