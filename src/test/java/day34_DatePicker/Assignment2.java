package day34_DatePicker;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment2 {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/");
		driver.manage().window().maximize();

		WebElement BuyTicketBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Buy Ticket')]")));
		BuyTicketBtn.click();

		WebElement product = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='product_549']")));
		product.click();

		String expectedMsg = "added to your order. Complete your order below.";

		WebElement confirmationMsg = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'" + expectedMsg + "')]")));

		Assert.assertTrue(confirmationMsg.getText().contains(expectedMsg));

		driver.findElement(By.cssSelector("#travname")).sendKeys("Rakesh");
		driver.findElement(By.cssSelector("#travlastname")).sendKeys("Rakesh");
		driver.findElement(By.cssSelector("#order_comments")).sendKeys("Good choice of product");

		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys("22/10/2026");

		driver.findElement(By.cssSelector("#sex_1")).click();

		WebElement radioButton = driver.findElement(By.cssSelector("#traveltype_1"));

		if (!radioButton.isSelected()) {
			radioButton.click();
		}
		driver.findElement(By.cssSelector("#fromcity")).sendKeys("Bangalore");
		driver.findElement(By.cssSelector("#tocity")).sendKeys("Chennai");

		driver.findElement(By.cssSelector("#departon")).sendKeys("22/10/2026");
		driver.findElement(By.cssSelector("#notes")).sendKeys("GoAir wow");

		WebElement PurposeOfTicketDropdown = driver.findElement(By.xpath("//select[@id='reasondummy']"));
		Select Purposeselect = new Select(PurposeOfTicketDropdown);
		Purposeselect.selectByVisibleText("Visa extension");

		driver.findElement(By.cssSelector("#appoinmentdate")).sendKeys("25/10/2026");

		driver.findElement(By.cssSelector("#deliverymethod_1")).click();
		driver.findElement(By.cssSelector("#billing_email")).sendKeys("rakesh@gmail.com");

		WebElement Billing_Country = driver.findElement(By.xpath("//select[@id='billing_country']"));
		Select BillingCountryselect = new Select(Billing_Country);
		BillingCountryselect.selectByValue("IN");

		driver.findElement(By.cssSelector("#billing_address_1")).sendKeys("HSR layout");
		driver.findElement(By.cssSelector("##billing_city")).sendKeys("Bangalore");

		WebElement Billing_State = driver.findElement(By.cssSelector("#billing_state"));
		Select BillingStateSelect = new Select(Billing_Country);
		BillingStateSelect.selectByVisibleText("Karnataka");

		driver.findElement(By.cssSelector("#billing_postcode")).sendKeys("560068");
		driver.findElement(By.cssSelector("#billing_phone")).sendKeys("9708938392");

		driver.findElement(By.cssSelector("#place_order")).click();

	}

}
