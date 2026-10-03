package Day43_TestNG_03;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	
	@Test
	void abc() {
		System.out.println("this is abc method from C1 class");
	}
	
	@BeforeTest
	void bt() {
		System.out.println("this is before test bt() method from C1 class");
	}

}
