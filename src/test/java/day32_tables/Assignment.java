package day32_tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		WebElement drpdowndeparture=driver.findElement(By.xpath("//select[@name='fromPort']"));
		Select departure=new Select(drpdowndeparture);
		departure.selectByVisibleText("Boston");
		
		WebElement drpdowndestination=driver.findElement(By.xpath("//select[@name='toPort']"));
		Select destination=new Select(drpdowndestination);
		destination.selectByVisibleText("Rome");

	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    
	    List<WebElement> rows=driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));
	    
	    double lowestPrice=Double.MAX_VALUE;
	    WebElement lowestPriceRow = null;
	    
	    
	    for(WebElement row:rows) {
	    	
	    	String priceText=row.findElement(By.xpath(".//td[contains(text(),'$')]")).getText();
	    	System.out.println(priceText);
	    	
	    	double price=Double.parseDouble(priceText.replace("$", ""));
	    	
	    	   // Check lowest price
            if (price < lowestPrice) {
                lowestPrice = price;
                lowestPriceRow = row;
            }
	    }
	 // Print lowest price
        System.out.println("Lowest Price: $" + lowestPrice);
        lowestPriceRow.findElement(By.xpath(".//input[@type='submit']")).click();
        
        driver.findElement(By.cssSelector("#inputName")).sendKeys("Rakesh");
        driver.findElement(By.cssSelector("#address")).sendKeys("HSR Layout");
        driver.findElement(By.cssSelector("#city")).sendKeys("Bengalore");
        driver.findElement(By.cssSelector("#state")).sendKeys("Karnataka");
        driver.findElement(By.cssSelector("#zipCode")).sendKeys("560068");
        
        WebElement cardType=driver.findElement(By.cssSelector("#cardType"));
        Select cardtype=new Select(cardType);
        cardtype.selectByVisibleText("American Express");
        
        driver.findElement(By.cssSelector("#creditCardNumber")).sendKeys("5689283982093219");
        
        driver.findElement(By.cssSelector("#creditCardMonth")).sendKeys("03");
        driver.findElement(By.cssSelector("#creditCardYear")).sendKeys("2028");
        driver.findElement(By.cssSelector("#nameOnCard")).sendKeys("Rakesh sharma");
        
        WebElement checbox=driver.findElement(By.cssSelector("#rememberMe"));
        checbox.click();
        
        driver.findElement(By.cssSelector("input[value='Purchase Flight']")).click();
        
        
        String confirmationMsg=driver.findElement(By.xpath("//h1[normalize-space()='Thank you for your purchase today!']")).getText();
       
        String expectedMsg = "Thank you for your purchase today!";
        Assert.assertEquals(confirmationMsg, expectedMsg,"Confirmation message is incorrect");
        
        
        driver.quit();
   
	
	}

}
