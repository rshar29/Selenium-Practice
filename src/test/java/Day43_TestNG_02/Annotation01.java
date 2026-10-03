package Day43_TestNG_02;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/*
1. login   ---> @BeforeMethod
2. Search  ---> @Test
3. logout  ---> @AfterMethod
4. Login
5. Adv search  ---> @Test
6. logout


 */
public class Annotation01 {
	
	@BeforeMethod
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
	
	@AfterMethod
	void logout() {
		System.out.println("this is logout method");
	}

}
