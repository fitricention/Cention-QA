package testCasesArea;

import java.awt.AWTException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageFactory.CreateErrand;
import pageFactory.ErrandList;
import pageFactory.ErrandPage;
import pageFactory.LoginPage;
import pageFactory.Sidebar;

public class ErrandAndWorkflowTC extends BaseSetup{

	
		@BeforeClass
		public void loginToApplication() 
		{
			//Log in to application
			LoginPage objLogin = new LoginPage(driver);
			objLogin.loginToApplication("tobias","fitri2","987654321");			
		}
		
		@Test
		public void verifyAllComponentsInManualErrandPage_01(){
			
			CreateErrand objCreateErrand = new CreateErrand(driver);
			objCreateErrand.clickCreateButton();
			objCreateErrand.viewAttachmentOption();
			objCreateErrand.viewErrandID();
			objCreateErrand.viewErrandTypesBox();
			Assert.assertTrue(objCreateErrand.viewManualErrandBox());

		}
		
		
		@Test
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
		
		@Test
		public void verifySendManualErrand_03() throws AWTException{
			CreateErrand objCreateErrand = new CreateErrand(driver);
			objCreateErrand.clickCreateButton();
			objCreateErrand.clickSendErrandTab();
			objCreateErrand.clickSelectArea();
			objCreateErrand.fillToField("centionqa@gmail.com");
			objCreateErrand.fillSubject("Test Send Errand - Automation");
			objCreateErrand.enterTextInAnswerFieldSendErrand("This is test Manual errand sent by Automation tool - Fitri");
			
			Assert.assertTrue(objCreateErrand.clickSendBtn());
			driver.get("https://cloud-qa.cention.com");
		}
		
		
		@Test
		public void verifyInternalComment_04() throws AWTException, InterruptedException{
			Sidebar objSidebar = new Sidebar(driver);
			ErrandList objErrandList = new ErrandList(driver);
			ErrandPage objErrandPage = new ErrandPage(driver);
//			LoginPage objLogin = new LoginPage(driver);
			
			objSidebar.clickAllErrandMenu();
			objErrandList.clickFirstErrand();
	//		objErrandList.closeAcquireErrandPopup();
			objErrandPage.clickInternalCommentTab();
			
			}

		
		
		
}
