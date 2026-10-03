package Day43_TestNG_02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertions {
	
	@Test
	void test() {
		
		//Assert.assertEquals("acr", "acry");
		//Assert.assertEquals(123 , 232);
		//Assert.assertEquals("abc", 123);
		//Assert.assertEquals("123", 123);
		
		
		//Assert.assertNotEquals(123, 123);  //failed
		//Assert.assertNotEquals(123, 1122);  //passed
		
		
		//Assert.assertTrue(123>12);  //passed
		//Assert.assertTrue(true);  //passed
		
		//Assert.assertTrue(false);  //failed
		//Assert.assertTrue(1==2);  //failed
		//Assert.assertTrue(1==1);  //passed
		
		//Assert.assertFalse(1==2);//passed
		
		//Assert.assertFalse(1==1);//failed
		
		Assert.fail(); // it will directly fail the test case and mark it as failed
		
	}

}
