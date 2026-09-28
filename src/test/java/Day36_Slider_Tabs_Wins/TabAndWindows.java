package Day36_Slider_Tabs_Wins;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TabAndWindows {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicesoftwaretesting.com/");
		
		//driver.switchTo().newWindow(WindowType.TAB);  //opens -bstackdemo in new tab
		driver.switchTo().newWindow(WindowType.WINDOW);  //opens -bstackdemo in new window
		
		driver.get("https://bstackdemo.com/");
		driver.manage().window().maximize();
		
		
		
		
		
		
		
	}

}
