package Day43_TestNG_02;
import org.testng.annotations.*;


public class AnnotationAllTypes {
	
	
	@BeforeSuite
	void beforeSuite() {
		System.out.println("this is before suite method");
	}
	
	@BeforeTest
	void beforeTest() {
		System.out.println("this is before test method");
	}
	
	@BeforeClass
	void beforeClass() {
		System.out.println("this is before class method");
	}
	
	@BeforeMethod
	void beforeMethod() {
		System.out.println("this is before method");
	}
	
	@Test(priority = 1)
	void test1() {
		System.out.println("this is test1 method");
	}
	
	@Test(priority = 2)
	void test2() {
		System.out.println("this is test2 method");
	}
	
	@AfterMethod
	void afterMethod() {
		System.out.println("this is after method");
	}
	
	@AfterClass
	void afterClass() {
		System.out.println("this is after class method");
	}
	
	@AfterTest
	void afterTest() {
		System.out.println("this is after test method");
	}
	
	@AfterSuite
	void afterSuite() {
		System.out.println("this is after suite method");
	}

}
