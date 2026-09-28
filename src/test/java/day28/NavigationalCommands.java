package day28;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationalCommands {
	public static void main(String[] args) throws MalformedURLException {
WebDriver driver =new ChromeDriver();
		
		//driver.get("https://demo.nopcommerce.com/");
		//driver.navigate().to("https://practicesoftwaretesting.com/"); //accepts URL in the string format and URL object object format

		/*
		URL url=new URL("https://practicesoftwaretesting.com/");
		driver.navigate().to(url);
		*/
		
		driver.get("https://demo.nopcommerce.com/");
		driver.navigate().to("https://practicesoftwaretesting.com/");
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().refresh();

		driver.manage().window().maximize();
		
	}

}
