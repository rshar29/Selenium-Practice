package Day43_TestNG_02;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardVsSoftAssertion {
	//SoftAssert softAssert;
	//@Test
	void test_hardAssertion() {
		System.out.println("this is hard assertion");
		System.out.println("this is HardAssertion");
		
		Assert.assertEquals("A", "AS");
		
		System.out.println("hard assertion");
		System.out.println("HardAssertion");
	}
	
	
	@Test
	void test_softAssertion() {
		System.out.println("this is hard assertion");
		System.out.println("this is HardAssertion");
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals("A", "AS");
		
		
		System.out.println("hard assertion");
		System.out.println("HardAssertion");
		softAssert.assertAll();  // it will mark the test case as failed if any soft assertion is failed
		
	}

}
