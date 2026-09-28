package Day37_JavaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUPLOAD {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();

		// Single file upload

		/*
		 * driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("C:\\Users\\rakes\\Videos\\selenium2.txt");
		 * 
		 * if(driver.findElement(By.xpath("//ul[@id='fileList']//li")).getText().equals("selenium2.txt")) {
		 * 
		 * System.out.println("File is uploaded successfully"); 
		 * }else {
		 * System.out.println("File upload Failed"); }
		 * 
		 */

		// Multiple Files

		String file1 = "C:\\\\Users\\\\rakes\\\\Videos\\\\selenium2.txt";
		String file2 = "C:\\\\Users\\\\rakes\\\\Videos\\\\sql interview.txt";

		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1 + "\n" + file2);

		int noOfFiles = driver.findElements(By.xpath("//ul[@id='fileList']//li")).size();

		// validation -1 number of files
		if (noOfFiles == 2) {
			System.out.println("All Files are uploaded");
		} else {
			System.out.println("Files are not uploaded or incorrect files are uploaded");
		}

		// validate file names
		if (driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("selenium2.txt")
				&& driver.findElement(By.xpath("//ul[@id='fileList']//li[2]")).getText().equals("sql interview.txt")) {

			System.out.println("File names are matching and it's correct");
		}else { 
			System.out.println("File names are Not matching and it's not correct");
		}

	}

}
