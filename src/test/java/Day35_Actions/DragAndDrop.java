package Day35_Actions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://seleniumbase.io/other/drag_and_drop");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		WebElement source=driver.findElement(By.xpath("//img[@id='drag1']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='div1']"));
		
		act.dragAndDrop(source, target).perform();
	}

}
