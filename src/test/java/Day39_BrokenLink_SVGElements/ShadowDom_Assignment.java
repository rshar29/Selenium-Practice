package Day39_BrokenLink_SVGElements;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//capture text for all shadow elements
public class ShadowDom_Assignment {
	public static void main(String[] args) {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.automationtesting.in/shadow-dom");
		driver.manage().window().maximize();
	}

}
