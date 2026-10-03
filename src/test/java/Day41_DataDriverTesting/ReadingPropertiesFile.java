package Day41_DataDriverTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {
	
	public static void main(String[] args) throws IOException {

		//Location of the properties file
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testData\\config.properties");
		//C:\Users\rakes\eclipse-workspace\Selenium-Practice\testData\config.properties
		//Load the properties file
		Properties prop = new Properties();
		prop.load(file);
		
		
		//Read data from properties file
		String url = prop.getProperty("appURL");
		String email = prop.getProperty("email");
		String pwd = prop.getProperty("password");
		String product = prop.getProperty("searchProduct");
		
		System.out.println("URL: "+url);
		System.out.println("Email: "+email);
		System.out.println("Password: "+pwd);
		System.out.println("Product: "+product);
		
		//Reading all the keys and values from properties file
		
		Set<String> keys=prop.stringPropertyNames();
		System.out.println(keys);  //[password, searchProduct, appURL, email]
		
		file.close();
		
		
		
		
			
		
		
		
	}


}
