package Day44_TestNG_04;

import org.testng.annotations.Test;

public class SignupTests_Grouping {
	
	@Test(priority = 1, groups = {"regression"})
	void signupByEmail() {
		System.out.println("this is signup method by email");
	}
	
	@Test(priority = 2, groups = {"regression"})
	void signupByFacebook() {
		System.out.println("this is signup method by facebook");
	}
	
	@Test(priority = 3, groups = {"regression"})
	void signupByGoogle() {
		System.out.println("this is signup method by google");
	}

}
