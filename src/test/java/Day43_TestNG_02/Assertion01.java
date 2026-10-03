package Day43_TestNG_02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion01 {
	
	@Test
	void testTitle() {
		String actualTitle = "Opencart";
		String expectedTitle = "Openshop";
		
		/*
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		*/
		
		//Assert.assertEquals(actualTitle, expectedTitle);
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		} else {
			System.out.println("Test Failed");
			Assert.assertTrue(false);
	}
}
}