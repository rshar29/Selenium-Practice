package day34_DatePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment1 {
	
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://dummy-tickets.com/buyticket");
		driver.manage().window().maximize();
		
		System.out.println("Title: " + driver.getTitle());
		System.out.println("URL: " + driver.getCurrentUrl());
		System.out.println("Page Source contains source[]: "
		        + driver.getPageSource().contains("source[]"));
		
		//sssssssssssssssssssssssssssssssssssssssssssssssss
		List<WebElement> fromInputs =
		        driver.findElements(By.xpath("//input[@name='source[]']"));

		System.out.println("Number of source inputs: " + fromInputs.size());

		for (int i = 0; i < fromInputs.size(); i++) {

		    WebElement input = fromInputs.get(i);

		    System.out.println(
		        "Input " + i +
		        " | displayed = " + input.isDisplayed() +
		        " | enabled = " + input.isEnabled()
		    );
		}
		
		
		WebElement BothTab= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Both']")));
		BothTab.click();
		
        // ---------------- FROM ----------------

        By fromLocator = By.xpath("//input[@name='source[]' and not(@type='hidden')]");

        WebElement from = wait.until(
                ExpectedConditions.visibilityOfElementLocated(fromLocator)
        );

        from.clear();
        from.sendKeys("BLR");

        By suggestedOptionFrom = By.xpath(
                "//div[@class='suggestion-block']//p[contains(text(),'Bangalore')]"
        );

        WebElement suggestionBLR = wait.until(
                ExpectedConditions.elementToBeClickable(suggestedOptionFrom)
        );

        suggestionBLR.click();


        // ---------------- TO ----------------

        By toLocator = By.xpath("//input[@name='destination[]' and not(@type='hidden')]");

        WebElement to = wait.until(
                ExpectedConditions.visibilityOfElementLocated(toLocator)
        );

        to.clear();
        to.sendKeys("CHENN");

        By suggestedOptionTo = By.xpath(
                "//div[@class='suggestion-block']//p[contains(text(),'Chennai')]"
        );

        WebElement suggestionChennai = wait.until(
                ExpectedConditions.elementToBeClickable(suggestedOptionTo)
        );

        suggestionChennai.click();


        
		
		
		
		
		/*
		// input DOB
		String year = "2021";
		String month = "June";
		String date = "15";

		driver.findElement(By.xpath("//input[@id='txtDate']")).click();
		*/
	}

}
