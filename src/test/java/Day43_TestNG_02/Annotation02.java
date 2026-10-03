package Day43_TestNG_02;
/*
1. login   ---> @BeforeClass
2. Search  ---> @Test
3. Adv search  ---> @Test
4. logout  -->@AfterClass
*/

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Annotation02 {
	
	@BeforeClass
	void login() {
		System.out.println("this is login method");
	}
	
	@Test(priority = 1)
	void search() {
		System.out.println("this is search method");
	}
	
	@Test(priority = 2)
	void advSearch() {
		System.out.println("this is advanced search method");
	}
	
	@AfterClass
	void logout() {
		System.out.println("this is logout method");
	}

}
