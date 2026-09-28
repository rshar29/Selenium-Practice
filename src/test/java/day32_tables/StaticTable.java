package day32_tables;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		// 1. Find number of row
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//tr")).size();
		System.out.println(rows);

		// int rows=driver.findElements(By.tagName("tr")).size();// if only one table
		// available on webpage

		// 2. find total number of columns
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//tbody//th")).size();
		System.out.println(columns);

		// 3. Read data from specific row and column (ex: 5th row and 1st column)
		String col5th = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[5]/td[1]")).getText();
		System.out.println(col5th);
		// table[@name='BookTable']//tbody//tr[4]/td[3] - javascript

		// 4. Read all the data from the table
		System.out.println("BookName" + "\t" + "Author" + "\t" + "Subject" + "\t" + "Price");
		for (int r = 2; r <= rows; r++) {

			for (int c = 1; c <= columns; c++) {

				String tableData = driver
						.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]/td[" + c + "]"))
						.getText();
				System.out.print(tableData + "\t");
			}
			System.out.println();

		}

		// 5. Print the books who's author is Mukesh

		for (int r = 2; r < rows; r++) {
			String authors = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]/td[2]"))
					.getText();
			if (authors.equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr[" + r + "]/td[1]"))
						.getText();
				System.out.println(bookName + "\t" + authors);
				
				

			}
		}
		
		System.out.println("=====================================================");
		//6. Find total price of all the books
		int total=0;
		for (int r = 2; r < rows; r++) {
			String prince=driver.findElement(By.xpath("//table[@name='BookTable']//tbody//tr["+r+"]/td[4]")).getText();
			total=total+Integer.parseInt(prince);
		}
		System.out.println("Total prince of all the books: "+total);
		

	}

}
