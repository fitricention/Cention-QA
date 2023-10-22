package pageFactory;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactCard {

	WebDriver driver;
	
	public ContactCard(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subAdministration']")
	WebElement administrationMenu;
	
	@FindBy(how = How.XPATH, using="//*[@id='page-wrapper']/section/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div")
	WebElement mainMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subAdministration']")
	WebElement adminMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_Contact cards']")
	WebElement contCardMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Create new']")
	WebElement createNewButton;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-name']")
	WebElement nameField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-city']")
	WebElement cityField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-PostCode']")
	WebElement postCodeField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-externalId']")
	WebElement externalIDField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='custom-field serviceType']")
	WebElement accountField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='dd-one-itemEmail']")
	WebElement emailAcc;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Save']")
	WebElement saveButton;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-contact']")
	WebElement inputAccount;
	
	@FindBy(how = How.XPATH, using="//*[@id='AdminContactCard']/div[1]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[2]/div/span[1]/button")
	WebElement editButton;
	
	@FindBy(how = How.XPATH, using="//*[@id='contactCardEdit']/div[1]/section[2]/div[1]/div[2]/i")
	WebElement editButtonIn;
	
	@FindBy(how = How.XPATH, using="//*[@id='AdminContactCard']/div[1]/div[2]/div/div/div[2]/table/tbody/tr[1]/td[2]/div/span[2]/button")
	WebElement deleteButton;
	
	

	
	public void clickContactMenu(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.mainMenu)).click();
		adminMenu.click();
		contCardMenu.click();
	}
	
	public void clickCreateNewButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.createNewButton)).click();
		
	}
	
	
	public void addAccountChannel(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.accountField)).click();	
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.emailAcc)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.inputAccount)).sendKeys("test@gmail.com");
		
	}
	
	public void fillContactCardDetails(){
		nameField.clear();
		nameField.sendKeys("ABC cendol");
		
		cityField.clear();
		cityField.sendKeys("City");
		
		postCodeField.clear();
		postCodeField.sendKeys("71350");
		
		externalIDField.clear();
		externalIDField.sendKeys("999");
	}
	
	public void saveButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.saveButton)).click();
	}
	
	public void editButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.editButton)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.editButtonIn)).click();
		fillContactCardDetails();

	}
	
	public void deleteFirstRecord(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.deleteButton)).click();
   
		Alert alert = driver.switchTo().alert();  
	    alert.accept();  
	}
	
}
