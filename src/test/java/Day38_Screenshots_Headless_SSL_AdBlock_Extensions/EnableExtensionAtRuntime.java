package Day38_Screenshots_Headless_SSL_AdBlock_Extensions;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
1. Add CRX Extractor/Downloader to the chrome brower
2. Add maybe any extension which is needed like SeclectorsHub 
3. Capture the crx file for selector hub from extension by right click on logo.
4. pass crx file path in the automation script in the ChomeOptions


 */

public class EnableExtensionAtRuntime {
	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		File file=new File("C:\\Automation\\automationFiles\\crx files\\SelectorsHub.crx");
		option.addExtensions(file);
		WebDriver driver =new ChromeDriver(option);
		
		driver.get("https://test-compare.com");
		
		
	}

}
