package pageFactory;


import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseSetup;

public class LoginPage extends BaseSetup{

	WebDriver driver;
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginButton")
	WebElement login;
	
	@FindBy(id="errormessage")
	WebElement login_errormessage;

	//@FindBy(css="[data-qa-id='agent_menu_logout']")
	@FindBy(xpath="/html/body/div[5]/div/div/div/div/ul/li[2]/div[2]/div/div/ul/li[8]/a/div[2]/span")
	WebElement logout;
	
	@FindBy(className="app-logo")
	WebElement centionLogo;
	
	//@FindBy(css="[data-qa-id='login-lock-error']")
	@FindBy(id="errormessage")
	WebElement lockErrorMessage;
	
	//@FindBy(css="[data-qa-id='QA_headerUserProfile']")
	@FindBy(xpath="/html/body/div[1]/div/div/main/div[2]/div/div/section/div[1]/div[2]/ul/ul[1]/div[3]")
	WebElement userProfile;
	
	@FindBy(how = How.ID, using = "workspace")
	WebElement workspace;
	
	@FindBy(how = How.ID, using = "submit")
	WebElement cloudLoginButton;
	
	@FindBy(xpath="/html/body/div[5]/div/div/div/div/ul/li[2]/div[2]/div/div/ul/li[1]/a/div[2]/span/span")
	WebElement userPreference;
	
	@FindBy(how = How.CSS, using="[data-qa-id='selection-box-twofa_flag']")
	WebElement qr2faoption;
	
	@FindBy(xpath="/html/body/div[1]/div/div[4]/div/div[1]/div[1]")
	WebElement PrefBox;
	
	@FindBy(how = How.CSS, using="[data-qa-id='select-list-Yes']")
	WebElement selectYes;
	
	@FindBy(how = How.CSS, using="[data-qa-id='btn-Save']")
	WebElement buttonSave;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[4]/div/div[2]")
	WebElement exit;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	
	public void setUsername(String strUsername )
	{
		username.sendKeys(strUsername);
	}
	 
	
    public void setPassword(String strPassword)
	{
		 password.sendKeys(strPassword);
	}

    
	 public void clickLogin(){
		 
		 new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.cloudLoginButton)).click();
	 }
	 
	 
 
	 public String loginToApplication(String strWorkspace, String strUsername,String strPasword)
	 {
		 new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.workspace)).clear();
		 new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.workspace)).sendKeys(strWorkspace);
		 this.clickContinue();
		 new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.username)).clear();
		 new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.username)).sendKeys(strUsername);
		 new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.password)).clear();
		 new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.password)).sendKeys(strPasword);
	     this.clickLogin();
	
	        
	     String pageTitleAfterLogin = driver.getTitle();
	        System.out.println(pageTitleAfterLogin);

	     
	     return pageTitleAfterLogin;     
	 }
	
	 
	 
	 public void clickContinue()
	 {
		 new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(driver.findElement( By.id("submit")))).click(); 	 	 
	 }
	  	 
	 
	 public String errorMessage()
	 {
		 try{
			 return	 this.login_errormessage.getText();
	 }
		 catch (NoSuchElementException ex){
				String filePresent = "false";
				return filePresent;}
		 }
	
	public void clickLogout()
	{
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.userProfile)).click();	 
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.logout)).click();
	}
	
	
	public void clickUserPreference()
	{
		//new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.userProfile)).click();
		Actions action = new Actions(driver);
		action.moveToElement(userProfile).perform();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.userPreference)).click();
		
	}
	
	public boolean verifyLogout(){
		if(new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.centionLogo)).isDisplayed()){
			return true;
		}
		return false;
	
	}
	
	public void AdminPagelogout()
	{
	 
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(driver.findElement( By.id("logout")))).click();	 
	}
	
	public void clickCentionLOGO()
	{
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.centionLogo)).click();
	}
	
	//test comment as sofea 
	public String userLockErrorMessage()
	{
		
		try{	
			String errorMessage = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.lockErrorMessage)).getText();
			return errorMessage;
		}
		catch (Exception e){	
			String errorMessage = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.login_errormessage)).getText();
			return errorMessage;
		}
	}
	
	// Test Case = Failed
	public void verify2FACode(){
		
		Actions action = new Actions(driver);
		action.moveToElement(PrefBox).perform();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.qr2faoption)).click();
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.selectYes)).click();
		//Codes for checking QR Code exist
			
	}
	
	public void closePreferencePage(){
		JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down using JavaScript
        js.executeScript("window.scrollBy(0, 300);");
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.buttonSave)).click();
               
	}
	
	public void exitPrefPage(){
		 new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.exit)).click();
	}
}