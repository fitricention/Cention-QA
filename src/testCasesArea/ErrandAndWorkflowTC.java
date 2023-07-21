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
		
		@Test(enabled=true)
		public void verifyAllComponentsInManualErrandPage_01(){
			
			CreateErrand objCreateErrand = new CreateErrand(driver);
			objCreateErrand.clickCreateButton();
			objCreateErrand.viewAttachmentOption();
			objCreateErrand.viewErrandID();
			objCreateErrand.viewErrandTypesBox();
			Assert.assertTrue(objCreateErrand.viewManualErrandBox());

		}
		
		
		@Test(enabled=true)
		public void verifyCreateManualErrand_02() throws AWTException{
		//To verify errand is successfully created in "All errands" folder	
			CreateErrand objCreateErrand = new CreateErrand(driver);
			objCreateErrand.clickSelectArea();
			objCreateErrand.fillFromField("centionqa@gmail.com");
			objCreateErrand.fillSubject("Test Create Errand - Automation");
			objCreateErrand.enterTextInAnswerField("This is test Manual errand created by Automation tool - Fitri");	

			Assert.assertEquals(true, objCreateErrand.clickCreateErrandBtn());
			objCreateErrand.clickCloseErrandPage();

		}
		
		@Test(enabled=true)
		public void verifySendManualErrand_03() throws AWTException{
			CreateErrand objCreateErrand = new CreateErrand(driver);
			objCreateErrand.clickCreateButton();
			objCreateErrand.clickSendErrandTab();
			objCreateErrand.clickSelectArea();
			objCreateErrand.fillToField("centionqa@gmail.com");
			objCreateErrand.fillSubject("Test Send Errand - Automation");
			objCreateErrand.enterTextInAnswerFieldSendErrand("This is test Manual errand sent by Automation tool - Fitri");
			
			Assert.assertTrue(objCreateErrand.clickSendBtn());
		
		}
		

		
		
		
}
