package Day43_TestNG_03;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
	
	@Test
	void m1() {
		System.out.println("this is m1 method from C3 class");
	}
	
	
	@BeforeSuite
	void m2() {
		System.out.println("this is BeforeSuite m2 method from C3 class");
	}
	
	
	@AfterSuite
	void m3() {
		System.out.println("this is AfterSuite m3 method from C3 class");
	}

}
