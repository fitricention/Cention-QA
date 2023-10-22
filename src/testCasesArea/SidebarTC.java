package testCasesArea;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageFactory.LoginPage;
import pageFactory.Sidebar;

public class SidebarTC extends BaseSetup {
	
	@BeforeClass
	public void loginToApplication() 
	{
		//Log in to application
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginToApplication("tobias","fitri2","987654321");			
	}
	
	@Test
	public void verifyCollapseSidebar_01(){
		Sidebar objSidebar = new Sidebar(driver);
		objSidebar.setDefaultView();
		Assert.assertEquals(objSidebar.clickCollapseButton(), true);

	}
	
	@Test
	public void verifyDisplayAllMenu(){
		Sidebar objSidebar = new Sidebar(driver);
		objSidebar.displayNotificationMenu();
		objSidebar.displayErrandsMenu();
		objSidebar.displaySearchAnswerMenu();
		objSidebar.displayStatisticMenu();
		objSidebar.displayLiveReportMenu();
		objSidebar.displayExportMenu();
		Assert.assertEquals(objSidebar.displayAdminMenu(), true);
	}
	
 
}