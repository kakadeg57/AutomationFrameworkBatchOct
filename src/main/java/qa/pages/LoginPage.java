package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.testbase.TestBase;

public class LoginPage extends TestBase{
	
	// Element repository
	// modification
	
	@FindBy (id = "txtUsername") 
	WebElement usernametxt;
	
	@FindBy (id = "txtPassword")
	WebElement passwordtxt;
	
	@FindBy(xpath = "//input[@value='LOGIN']")
	WebElement lgnbtn;
	
	@FindBy(xpath ="//div[@id='divLogo']/img")
	WebElement logo;
	
	@FindBy(linkText = "Forgot your password?")
	WebElement forgotPasslink;
	
	
	
	// actions or methods
		public void login(String userid,String pwd) {
		usernametxt.sendKeys(userid);
		passwordtxt.sendKeys(pwd);
		lgnbtn.click();
	}
		
		public boolean isLogoDisplayed() {
			boolean logostatus = logo.isDisplayed();
			return logostatus;
		}
		
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
}
