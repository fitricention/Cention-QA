package testCasesArea;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageFactory.LoginPage;

public class LoginTC extends BaseSetup{
	
	
	@BeforeClass
	public void loginToApplication() 
	{
		//Log in to application
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginToApplication("tobias","fitri","123456789");
	}
	
	@Test
	public void VerifyLogin_01()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
}
