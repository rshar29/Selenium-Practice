package Day42_TestNG_01;

import org.testng.annotations.Test;

/*
1. Open app
2. login
3. verify login
4. logout
 */

// 
public class FirstTestCase {
	
	@Test(priority = -2)
	void openApp() {
		System.out.println("Open app");
	}
	
	@Test(priority = -1)
	void login() {
		System.out.println("Login");
	}
	@Test(priority = 0)
	void logout() {
		System.out.println("Logout");
	}
	

}
