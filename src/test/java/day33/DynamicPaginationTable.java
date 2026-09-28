package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.opencart.com/TlbeVW/");
		driver.manage().window().maximize();
		
		WebElement Username=driver.findElement(By.xpath("//input[@id='input-username']"));
		Username.clear();
		Username.sendKeys("demo");
		
		WebElement Password=driver.findElement(By.xpath("//input[@id='input-password']"));
		Username.clear();
		Username.sendKeys("demo");
		
		WebElement loginBtn=driver.findElement(By.cssSelector("button[type='submit']"));
		loginBtn.click();
		
		
		if(driver.findElement(By.xpath("//button[@class='btnclose']")).isDisplayed()) {
			
			driver.findElement(By.xpath("//button[@class='btnclose']")).click();
		}
		driver.findElement(By.cssSelector(".parent[href='#collapse-5']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		//Showing 1 to 10 of 36539 (3654 Pages)

		String text=driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
		
		int total_pages=Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1 ));
		
		//repeating the pages
		for(int p=1;p<=total_pages;p++) {
			
			if(p>1) {
				WebElement active_pages=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				active_pages.click();
				
			}
			//reading data from table
			int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			
			for(int r=1;r<=rows;r++) {
			String CustomerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
			String CustomerEmail=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
			String Status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[5]")).getText();


			System.out.println(CustomerName+"\t"+CustomerEmail+"\t"+Status);
			}
			
			
		}
	}
	

}
