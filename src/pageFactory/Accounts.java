package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Accounts {
	
	WebDriver driver; 
	
	public Accounts(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//*[@id='page-wrapper']/section/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div")
	WebElement mainMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subAdministration']")
	WebElement AdministrationMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subOrganizations']")
	WebElement OrganizationMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_Accounts']")
	WebElement AccountsMenu;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/main/div[2]/div/div/section/div[2]/div[2]/div/div[1]/h2")
	WebElement AccounTitle;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Create New']")
	WebElement newButton;
	
	@FindBy(how = How.CSS, using="[data-qa-id='custom-field area']")
	WebElement areaField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='dd-one-itemE Area E']")
	WebElement areaItem1;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-name']")
	WebElement nameField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-host']")
	WebElement serverField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-username']")
	WebElement usernameField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-password']")
	WebElement passField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='btn-Save']")
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/main/div[2]/div/div/section/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[2]/table/tbody/tr[8]/td[5]")
	WebElement emailAccCreated;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[2]/div/div/section/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[2]/table/tbody/tr[4]/td[8]")
	WebElement testButton;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[3]/div/div/section/div[2]/div[2]/div/div[2]/div[2]/div/div/div/div[1]/div[2]/table/tbody/tr[1]/td[9]/div/span[1]/button")
	WebElement editButton;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-name']")
	WebElement fieldName;
	
	
	
	
	
	public void clickAccountMenu(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.mainMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.AdministrationMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.OrganizationMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.AccountsMenu)).click();
	}

	
	public void clickCreateNewAccount(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.newButton)).click();
	}
	
	public void selectArea(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.areaField)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.areaItem1)).click();
	}
	
	public String enterName(String name){
	     new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.nameField)).sendKeys(name);
		return name;
	}
	
	public String enterServer(String server){
	     new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.serverField)).sendKeys(server);
		return server;
	}
	
	public String enterUsername(String username){
	     new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.usernameField)).sendKeys(username);
		return username;
	}
	
	public String enterPassword(String pass){
	     new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.passField)).sendKeys(pass);
		return pass;
	}
	
	
	public String verifyAccountPage(){
		String actual = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.AccounTitle)).getText();
		return actual;
	}
	
	public boolean verifyCreateNewEmailAcc(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.saveButton)).click();
		//Thread.sleep(2000);
		String actual = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.emailAccCreated)).getText();
		if(actual == "Email QA"){
			return true;
		}
		return false;
		
	}
	
	public void clickTestButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.testButton)).click();
	}
	
	public void clickEditButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.editButton)).click();
	}
	
	public void enterFieldName(String name){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.fieldName)).sendKeys();
	
	}
	public void clickSaveButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.saveButton)).click();
	}
	
	
}
