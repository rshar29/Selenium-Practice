package Day38_Screenshots_Headless_SSL_AdBlock_Extensions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleSSL {
	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.setAcceptInsecureCerts(true);  //accepts SSL certificates
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://expired.badssl.com/");
		System.out.println("title of the page: "+ driver.getTitle()); //privacy error
		                                                              //expired.badssl.com
		
		
	}

}
