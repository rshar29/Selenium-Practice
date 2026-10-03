package Day44_TestNG_04;

import org.testng.annotations.Test;

public class LoginTests_Grouping {
	
	
	@Test(priority = 1, groups = {"sanity"})
	void loginByEmail() {
		System.out.println("this is login method by email");
	}
	
	@Test(priority = 2, groups = {"sanity"})
	void loginByFacebook() {
		System.out.println("this is login method by facebook");
	}
	
	@Test(priority = 3, groups = {"sanity"})
	void loginByGoogle() {
		System.out.println("this is login method by google");
	}

}
