package testCasesArea;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageFactory.Accounts;
import pageFactory.CORSpage;
import pageFactory.ContactCard;
import pageFactory.GroupPage;
import pageFactory.LoginPage;

public class AdministrationTC extends BaseSetup{
	
	String AccountPage = "https://cloud-qa.cention.com/ng/v5/admin/accounts";
	String ContCardPage = "https://cloud-qa.cention.com/ng/v5/admin/contactcards";
	String GroupPage = "https://cloud-qa.cention.com/ng/v5/admin/groups";
	String WhiteListPage = "https://cloud-qa.cention.com/ng/v5/admin/cors";

	
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
    
    @Test(priority = 0)
    public void verifyCORSWhitelistPage_13(){
    	CORSpage cors = new CORSpage(driver);
    	driver.navigate().to(WhiteListPage);
    	Assert.assertEquals(cors.verifyCORSpage(), "Cross-Origin Resource Sharing");
    	
   	}
    
   @Test(priority = 1)
    public void verifyAddNewCORSWhitelist_14(){
    	CORSpage cors = new CORSpage(driver);
    	driver.navigate().to(WhiteListPage);
    	cors.createNewCORS();
    	cors.enterCORS("https://test.cention.test");
    	cors.clickSaveButton();
   	}
    
    @Test(priority = 2)
    public void verifyDeleteCORSWhitelist_15(){
       	CORSpage cors = new CORSpage(driver);
    	driver.navigate().to(WhiteListPage);
        cors.deleteCORSdata(); // Delete the 6ixth row from the table.
        
    	
   	}
    
   public void verifyIPAddressPage_16(){
		
   	}
   
   public void verifyDeleteIPAddress_17(){
		
  	}
   
   public void verifyAPIAccessTokensPage_18(){
		
 	}
   
   public void verifyAddNewAPIAccessTokens_19(){
		
 	}
   
   public void verivyEditAPIAccessTokens_20(){
		
 	}
   
   public void verivyDeleteAPIAccessTokens_21(){
		
  	}
   
   public void verifyAPICallbackPage_22(){

	}
   
   public void verifyAddNewAPICallback_23(){

 	}
   
   public void verifyEditAPICallback_24(){

	}
   
   public void verifyDeleteAPICallback_25(){

	}
}
