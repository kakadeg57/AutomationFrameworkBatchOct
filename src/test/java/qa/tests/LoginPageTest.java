package qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import qa.pages.LoginPage;
import qa.testbase.TestBase;

public class LoginPageTest extends TestBase {
	
	

	LoginPage loginpage;
	
	
	@BeforeMethod
	public void setUp() {
		initilization();
		loginpage = new LoginPage();
	}

	@Test
	public void validateLoginTest() {
		loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		String ActUrl = driver.getCurrentUrl();
		Assert.assertEquals(ActUrl, prop.getProperty("expUrl"), "Test is failed");
	}
	
	@Test
	public void validateLogoTest() {
		boolean logo = loginpage.isLogoDisplayed();
		Assert.assertEquals(logo, true);
	}
	
	@AfterMethod
	
	public void closeResources() {
		driver.close();
	}

}
