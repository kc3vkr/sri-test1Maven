package sri.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import sri.object.ui.ActiTimeLoginPage;
import sri.utils.CreateDriver;

public class LoginPage2CredentialsTest {
	
	WebDriver driver;
	ActiTimeLoginPage login;
	
	
	@BeforeMethod
	public void preCondition() {
		driver = CreateDriver.getDriverInstance();
		login = new ActiTimeLoginPage(driver);
		
	}
	
	@AfterMethod
	public void postCondtion() {
		driver.close();
	}
	
	
	@Test
	public void test2LoginPageInvalidLogin() {
		login.waitForLoginPageToLoad();
		
		login.getUsernameTexbox().sendKeys("admin");
		login.getPasswordTextbox().sendKeys("Invalid");
		login.getLoginButton().click();
		
		String actualErrMsg = login.getLoginErrMsg().getText();
		String expectedErrMsg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErrMsg, expectedErrMsg);		
		
	}
	
	

}
