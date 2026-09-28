package Day38_Screenshots_Headless_SSL_AdBlock_Extensions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class CaptureScreenshots {
	
	public static void takescreenshot(WebDriver driver, String fileName) {
		
		TakesScreenshot ts= (TakesScreenshot) driver;	
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File(".\\screenshots" +fileName+ ".png");
		
		try {
			FileUtils.copyFile(sourceFile, destinationFile);			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://bstackdemo.com/");
		//driver.get("https://demo.nopcommerce.com/");
		
		
		driver.manage().window().maximize();
		
		
		//getScreenshotAs 
		//1. full page screenshot
		/*
		TakesScreenshot ts= (TakesScreenshot) driver;	
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		File destinationFile=new File(System.getProperty("user.dir")+"\\screenshots\\fullpage.png");
		
		sourceFile.renameTo(destinationFile);
		*/
		
		//2. Capture the screenshot of specific selection
		WebElement featuredPrd=driver.findElement(By.xpath("//img[@alt='banner main']"));
		File srcBanner=featuredPrd.getScreenshotAs(OutputType.FILE);
		File targetBanner= new File(System.getProperty("user.dir")+"\\screenshots\\featureProduct1.png");
		srcBanner.renameTo(targetBanner);
		
		
		//2. Capture the screenshot of specific element
		
		WebElement logo=driver.findElement(By.xpath("//img[@alt='logo']"));
		File SourceLogo=logo.getScreenshotAs(OutputType.FILE);
		File TargetLogo=new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
		SourceLogo.renameTo(TargetLogo);
		
		driver.quit();
		
	}

}
