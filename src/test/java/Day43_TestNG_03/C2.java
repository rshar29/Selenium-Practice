package Day43_TestNG_03;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C2 {
	
	@Test
	void xyz() {
		System.out.println("this is xyz method from C2 class");
	}
	
	@AfterTest
	void at() {
		System.out.println("this is after test at() method from C2 class");
	}

}
