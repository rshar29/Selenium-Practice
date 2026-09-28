package Day35_Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 DEBIT - BANK - 5000   
 CREDIT- SALES - 5000
 */
public class Assignment2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("http://demo.guru99.com/test/drag_drop.html");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		//DEBIT SIDE
		WebElement debitside1_src=driver.findElement(By.xpath("//a[normalize-space()='BANK']"));
		WebElement debitside1_des=driver.findElement(By.xpath("//ol[@id='bank']//li[@class='placeholder']"));
		act.dragAndDrop(debitside1_src, debitside1_des).perform();
		
		WebElement debitside2_src=driver.findElement(By.xpath("(//li[@id='fourth']//a)[1]"));
		WebElement debitside2_des=driver.findElement(By.xpath("//ol[@id='amt7']//li[@class='placeholder']"));
		act.dragAndDrop(debitside2_src, debitside2_des);
		
		//CREDIT SIDE
		
		WebElement creditside1_src=driver.findElement(By.xpath("//a[normalize-space()='SALES']"));
		WebElement creditside1_des=driver.findElement(By.xpath("//ol[@id='loan']//li[@class='placeholder']"));
		act.dragAndDrop(creditside1_src, creditside1_des).perform();
		
		WebElement creditside2_src=driver.findElement(By.xpath("((//li[@id='fourth']//a)[2]"));
		WebElement creditside2_des=driver.findElement(By.xpath("//ol[@id='amt8']//li[@class='placeholder']"));
		act.dragAndDrop(creditside2_src, creditside2_des);
		
		
		
		
	}
}
