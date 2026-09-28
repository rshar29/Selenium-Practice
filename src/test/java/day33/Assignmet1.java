package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignmet1 {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		int pages = driver.findElements(By.xpath("//ul[@id='pagination']//li")).size();

		for (int p = 1; p <= pages; p++) {

			if (p > 1) {

				WebElement allpages = driver.findElement(By.xpath("//ul[@id='pagination']//li[" + p + "]"));
				allpages.click();
				// Short wait to allow table rows to refresh after pagination click
                Thread.sleep(1000);

			}
			// reading data from table
			int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();

			for (int r = 1; r <= rows; r++) {

				String Name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[2]"))
						.getText();
				String Price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[3]"))
						.getText();

				WebElement checkbox = driver
						.findElement(By.xpath("//table[@id='productTable']//tbody//tr[" + r + "]//td[4]//input"));
				checkbox.click();

				System.out.println(Name + "\t" + Price + checkbox.isSelected());
			}

		}

	}
}
