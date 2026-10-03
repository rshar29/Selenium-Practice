package Day44_TestNG_04;

import org.testng.annotations.Test;

public class PaymetTests_Grouping {
	
	@Test(priority = 1, groups = {"sanity", "regression", "functional"})
	void paymentByDollers() {
		System.out.println("this is payment method by Dollers");
	}
	
	@Test(priority = 2, groups = {"sanity", "regression", "functional"})
	void paymentInRupees() {
		System.out.println("this is payment method in rupees");
	}

}
