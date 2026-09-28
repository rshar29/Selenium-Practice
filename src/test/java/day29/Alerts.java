package day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Alert myalert=driver.switchTo().alert();
 
myalert.accept();
myalert.dismiss();
myalert.getText();
myalert.sendKeys("text");

*/

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();

		/*
		 * 
		 * //1. Normal button with ok button
		 * driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		 * Thread.sleep(5000); 
		 * //driver.switchTo().alert().accept(); 
		 * Alert myalert=driver.switchTo().alert(); 
		 * System.out.println(myalert.getText());
		 * myalert.accept();
		 * 
		 * 
		 * //2. Confirmation alert - Ok and cancel
		 * driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		 * Thread.sleep(5000); //driver.switchTo().alert().accept();
		 * driver.switchTo().alert().dismiss();
		 * 
		 */

		// 3. Prompt alert

		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		Alert alertPrompt = driver.switchTo().alert();
		alertPrompt.sendKeys("welcome");
		alertPrompt.accept();

	}

}
