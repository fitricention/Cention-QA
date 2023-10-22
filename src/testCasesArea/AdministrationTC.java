package testCasesArea;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseSetup;
import pageFactory.Accounts;
import pageFactory.ContactCard;
import pageFactory.GroupPage;
import pageFactory.LoginPage;

public class AdministrationTC extends BaseSetup{
	
	String AccountPage = "https://cloud-qa.cention.com/ng/v5/admin/accounts";
	String ContCardPage = "https://cloud-qa.cention.com/ng/v5/admin/contactcards";

	
	@BeforeClass
	public void loginToApplication() 
	{
		//Log in to application
		LoginPage objLogin = new LoginPage(driver);
		objLogin.loginToApplication("tobias","fitri2","987654321");			
	}
	

	@Test
	public void verifyAccountsPage_01(){
		Accounts account = new Accounts(driver);
		account.clickAccountMenu();
		Assert.assertEquals(account.verifyAccountPage(), "Accounts");
	}
	
	@Test
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
	
	
	@Test
	public void verifyTestEmailAccount_03(){
		Accounts account = new Accounts(driver);
		driver.navigate().to(AccountPage);
		account.clickTestButton();
		//add assertion

	}
	
	@Test
	public void verifyEditButtonAccount_04(){
		Accounts account = new Accounts(driver);
		driver.navigate().to(AccountPage);
		account.clickEditButton();
		account.enterFieldName("QA Email Account");
		account.clickSaveButton();
		//add assertion
	}
	
	@Test
	public void verifyDeleteEmailAccount_05(){
		Accounts account = new Accounts(driver);
		driver.navigate().to(AccountPage);
		//Assert.assertEquals(account.deleteAccount(), true);

	}
	
	@Test
	public void verifyAddContactCard_06(){
		ContactCard contact = new ContactCard(driver);
		driver.navigate().to(ContCardPage);	
		contact.clickCreateNewButton();
		contact.fillContactCardDetails();
		contact.addAccountChannel();
		contact.saveButton();
		//add assertion
	}
	
	@Test
	public void verifyEditContactCard_07(){
		ContactCard contact = new ContactCard(driver);
		driver.navigate().to(ContCardPage);
		contact.editButton();
		contact.saveButton();
	
	}
	
	@Test
	public void verifyDeleteContactCard_08(){
		ContactCard contact = new ContactCard(driver);
		driver.navigate().to(ContCardPage);
		contact.deleteFirstRecord();
	}
	
	@Test
	public void verifyGroupPage_09(){
		GroupPage group = new GroupPage(driver);
		driver.navigate().to(ContCardPage);
		group.clickGroupMenu();
		Assert.assertEquals(group.verifyGroupPage(),"Groups");
		
	}
	
	@Test
    public void verifyAddNewGroupPage_10(){
    	GroupPage group = new GroupPage(driver);
    	driver.navigate().to(ContCardPage);
		group.clickAddNewButton();
	}
    
    public void verifyEditGroup_11(){
		
	}
    
    public void verifyDeleteGroup_12(){
		
 	}
    
    public void verifyCORSWhitelistPage_13(){
		
   	}
    
    public void verifyAddNewCORSWhitelist_14(){
		
   	}
    
    public void verifyDeleteCORSWhitelist_15(){
		
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
