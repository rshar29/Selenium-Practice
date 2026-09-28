package Day36_Slider_Tabs_Wins;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
(59, 247) => (x,y)

x - increase when you want to increase Horizontally 
y - increase when you want to increase vertically

 */

public class Slider_01 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions action=new Actions(driver);
		
		//Min Slider
		WebElement min_slider=driver.findElement(By.xpath("//div[@id='slider-range']//span[1]"));
		
		System.out.println("Default  Location of minimum slider: "+min_slider.getLocation()); // (59, 247) => (x,y)
		//Also we can use = +min_slider.getLocation().getX() or +min_slider.getLocation().getY()
		action.dragAndDropBy(min_slider, 100, 247).perform();
		
		System.out.println("Location of slider after moving: "+min_slider.getLocation());

		
		
		//Max Slider
		System.out.println("======Max Slider=======");
        WebElement max_slider=driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		
		System.out.println("Default  Location of minimum slider: "+max_slider.getLocation()); // (510, 247) => (x,y)
		action.dragAndDropBy(max_slider, -200, 247).perform();
		
		System.out.println("Location of slider after moving: "+max_slider.getLocation());
		
		
		

	}

}
