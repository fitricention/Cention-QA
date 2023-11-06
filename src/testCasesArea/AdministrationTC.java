package testCasesArea;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageFactory.APIaccessTokenPage;
import pageFactory.APIcallbackPage;
import pageFactory.Accounts;
import pageFactory.CORSpage;
import pageFactory.ContactCard;
import pageFactory.GroupPage;
import pageFactory.LoginPage;
import pageFactory.IPAddressBlacklistPage;

public class AdministrationTC extends BaseSetup{
	
	String AccountPage = "https://cloud-qa.cention.com/ng/v5/admin/accounts";
	String ContCardPage = "https://cloud-qa.cention.com/ng/v5/admin/contactcards";
	String GroupPage = "https://cloud-qa.cention.com/ng/v5/admin/groups";
	String WhiteListPage = "https://cloud-qa.cention.com/ng/v5/admin/cors";
	String IPAddressBlacklistPage = "https://cloud-qa.cention.com/ng/v5/admin/blacklist";
	String APIaccessTokens = "https://cloud-qa.cention.com/ng/v5/admin/jwt";
	

	
	@BeforeClass
	public void loginToApplication() 
	{
		//Log in to application
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginToApplication("tobias","fitri2","987654321");			
	}
	

	@Test(enabled = false)
	public void verifyAccountsPage_01(){
		Accounts account = new Accounts(driver);
		account.clickAccountMenu();
		Assert.assertEquals(account.verifyAccountPage(), "Accounts");
	}
	
	@Test(enabled = false)
	public void verifyCreateNewEmail_02(){
		Accounts account = new Accounts(driver);
		account.clickCreateNewAccount();
		account.selectArea();
		account.enterName("Email QA");
		account.enterServer("mail.cust.cention.se");
		account.enterUsername("fitriAutomationQA");
		account.enterPassword("Pass1234");
		Assert.assertEquals(account.verifyCreateNewEmailAcc(), true); // need revise code again
	}
	
	
	@Test(enabled = false)
	public void verifyTestEmailAccount_03(){
		Accounts account = new Accounts(driver);
		driver.navigate().to(AccountPage);
		account.clickTestButton();
		//add assertion

	}
	
	@Test(enabled = false)
	public void verifyEditButtonAccount_04(){
		Accounts account = new Accounts(driver);
		driver.navigate().to(AccountPage);
		account.clickEditButton();
		account.enterFieldName("QA Email Account");
		account.clickSaveButton();
		//add assertion
	}
	
	@Test(enabled = false)
	public void verifyDeleteEmailAccount_05(){
		Accounts account = new Accounts(driver);
		driver.navigate().to(AccountPage);
		//Assert.assertEquals(account.deleteAccount(), true);

	}
	
	@Test(enabled = false)
	public void verifyAddContactCard_06(){
		ContactCard contact = new ContactCard(driver);
		driver.navigate().to(ContCardPage);	
		contact.clickCreateNewButton();
		contact.fillContactCardDetails();
		contact.addAccountChannel();
		contact.saveButton();
		//add assertion
	}
	
	@Test(enabled = false)
	public void verifyEditContactCard_07(){
		ContactCard contact = new ContactCard(driver);
		driver.navigate().to(ContCardPage);
		contact.editButton();
		contact.saveButton();
	
	}
	
	@Test(enabled = false)
	public void verifyDeleteContactCard_08(){
		ContactCard contact = new ContactCard(driver);
		driver.navigate().to(ContCardPage);
		contact.deleteFirstRecord();
	}
	
	@Test(enabled = false)
	public void verifyGroupPage_09(){
		GroupPage group = new GroupPage(driver);
		driver.navigate().to(GroupPage);
		group.clickGroupMenu();
		Assert.assertEquals(group.verifyGroupPage(),"Groups");
		
	}
	
	@Test(enabled = false)
    public void verifyAddNewGroupPage_10(){
    	GroupPage group = new GroupPage(driver);
    	driver.navigate().to(GroupPage);
		group.createNewGroup();
	}
    
    public void verifyEditGroup_11(){
		
	}
    
    public void verifyDeleteGroup_12(){
		
 	}
    
    //@Test(priority = 0) = PASS
    public void verifyCORSWhitelistPage_13(){
    	CORSpage cors = new CORSpage(driver);
    	driver.navigate().to(WhiteListPage);
    	Assert.assertEquals(cors.verifyCORSpage(), "Cross-Origin Resource Sharing");
    	
   	}
    
   //@Test(priority = 1) = PASS
    public void verifyAddNewCORSWhitelist_14(){
    	CORSpage cors = new CORSpage(driver);
    	driver.navigate().to(WhiteListPage);
    	cors.createNewCORS();
    	cors.enterCORS("https://test.cention.test");
    	cors.clickSaveButton();
   	}
    
   // @Test(priority = 2) = PASS
    public void verifyDeleteCORSWhitelist_15(){
       	CORSpage cors = new CORSpage(driver);
    	driver.navigate().to(WhiteListPage);
        cors.deleteCORSdata(); // Delete the 6ixth row from the table.
   	}
    
    //@Test = PASS
    public void verifyIPAddressPage_16(){
       IPAddressBlacklistPage ip = new IPAddressBlacklistPage(driver);
   	   driver.navigate().to(IPAddressBlacklistPage);
       Assert.assertEquals(ip.verifyIPaddressBlacklistPage(), "IP Address Blacklist");
	   
   	}
   
   public void verifyDeleteIPAddress_17(){
		
  	}
   
   //@Test = PASS
   public void verifyAPIAccessTokensPage_18(){
	   APIaccessTokenPage ip = new APIaccessTokenPage(driver);
   	   ip.accessTokenPage();
       Assert.assertEquals(ip.verifyAPIaccessTokenPage(), "Access tokens");
 	}
   
   //@Test = PASS
   public void verifyAddNewAPIAccessTokens_19(){
	   APIaccessTokenPage ip = new APIaccessTokenPage(driver);
   	   //driver.navigate().to(APIaccessTokens);
   	   ip.createNewAccessToken();
   	   ip.inputName();
   	   ip.inputKey();
   	   ip.inputAPI();
   	   ip.saveButton();
 	}
   
   //@Test = PENDING (Web element not work)
   public void verivyEditAPIAccessTokens_20(){
	   APIaccessTokenPage ip = new APIaccessTokenPage(driver);
	  // ip.editTokens();
	   ip.saveButton();
 	}
   
   //@Test = PENDING (Web element not work)
   public void verivyDeleteAPIAccessTokens_21(){
	   APIaccessTokenPage ip = new APIaccessTokenPage(driver);
	   ip.deleteTokens();
  	}
   
   //@Test = PASS
   public void verifyAPICallbackPage_22(){

	   APIcallbackPage cb = new APIcallbackPage(driver);
	   cb.accessCallbackPage();
       Assert.assertEquals(cb.verifyCallbackPage(), "Callback API");
	   
	}
   
   //@Test = PASS
   public void verifyAddNewAPICallback_23(){
	   APIcallbackPage cb = new APIcallbackPage(driver);
	   cb.clickCreateNew();
	   cb.enterName();
	   cb.enterEndPoint();
	   cb.enterSecretKey();
	   cb.chooseEvent();
	   cb.chooseCloseErrandEvent();
	   cb.chooseArea();
	   cb.chooseJidArea();
	   cb.clickSaveButton();
 	}
  
   public void verifyEditAPICallback_24(){

	}
   
   public void verifyDeleteAPICallback_25(){

	}
   
   //@Test (priority=0) = PASS
   public void verifyGroupAgent_26(){
	    GroupPage group = new GroupPage(driver);
		driver.navigate().to(GroupPage);
		group.clickAddButton();
		//Assert.assertEquals(group.verifyGroupAgentPage(),true);
   }
   
   //@Test (priority=1) = PASS
   public void verifySelectAllAgents_27(){
	   GroupPage group = new GroupPage(driver);
	   driver.navigate().to(GroupPage);
	   group.clickAddButton();
	   group.selectMultipleAgents();
   }
   
   @Test (priority=2)
   public void verifyDragDropAgentGroup_28(){
	   GroupPage group = new GroupPage(driver);
	   driver.navigate().to(GroupPage);
	   group.clickAddButton();
	   group.addAgentsInGroup();
   }
   
   
   public void verifySaveDetailsAgentGroup_29(){
	   GroupPage group = new GroupPage(driver);
	   driver.navigate().to(GroupPage);
	   group.clickAddButton();
	   group.enterGroupDetails();
	   group.addAgentsInGroup();
   }
   
   public void verifyResetSelection_30(){
	   GroupPage group = new GroupPage(driver);
	   driver.navigate().to(GroupPage);
	   group.clickAddButton();
	   group.selectMultipleAgents();
	   group.resetSelection();
   }
}
