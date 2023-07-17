package testCasesArea;

import java.awt.AWTException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageFactory.CreateErrand;
import pageFactory.LoginPage;

public class ErrandAndWorkflowTC extends BaseSetup{

	
		@BeforeClass
		public void loginToApplication() 
		{
			//Log in to application
			LoginPage objLogin = new LoginPage(driver);
			objLogin.loginToApplication("tobias","fitri","123456789");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));			
		}
		
		@Test
		public void verifyCreateNewErrand_01() throws AWTException{
			
			CreateErrand objCreateErrand = new CreateErrand(driver);
			objCreateErrand.clickCreateButton();
			objCreateErrand.clickSelectArea();
			objCreateErrand.fillFromField("centionqa@gmail.com");
			objCreateErrand.fillSubject("Test Errand 1 - Automation");
			objCreateErrand.enterTextInAnswerField("This is test errand 1 created by Automation tool - Fitri");	
			//Verify errand is successfully created in "All errands" folder
			Assert.assertTrue(objCreateErrand.clickCreateErrandBtn());
			
		}
		
}
