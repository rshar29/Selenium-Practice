package Day39_BrokenLink_SVGElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*

1. Link href="https://xyz.com"
2. https://xyz.com --> server --> status code
3. status code>=400 broken link
   status code<400 not a broken link
 */
public class BrokenLinks {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		// Capture all links from website.
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links: " + links.size());

		int noOfBrokenLink = 0;
		for (WebElement link : links) {

			String hrefAttributeVal = link.getAttribute("href");
			if (hrefAttributeVal == null || hrefAttributeVal.isEmpty()) {
				System.out.println("href attribute value is null or empty, not possible to proceed ");
				continue;
			}

			// hit url to the server -- Need to convert String hrefAttributeVal to URL format

			try {
				URL linkURL = new URL(hrefAttributeVal); // convert String hrefAttributeVal to URL format
				HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection(); // open connection to server
																							
				connection.connect(); // connect to server and sent request to the server

				if (connection.getResponseCode() >= 400) {
					System.out.println(hrefAttributeVal + "============> Broken link");
					noOfBrokenLink++;
				} else {
					System.out.println(hrefAttributeVal + "============> Not a broken link");
				}

			} catch (Exception e) {

			}

		}
		System.out.println("Number of broke links: " + noOfBrokenLink);

	}

}
