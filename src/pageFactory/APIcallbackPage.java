package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class APIcallbackPage {

	WebDriver driver;
	
	public APIcallbackPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="html/body/div[1]/div/div/main/div[2]/div/div/section/div[1]/div[2]/div/div/div")
	WebElement mainMenu; //class="main-menu
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subAdministration']")
	WebElement adminMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subAPI']")
	WebElement apiMenu;

	@FindBy(how = How.CSS, using="[data-qa-id='menu_Callback']")
	WebElement callbackMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Create new']")
	WebElement createButton;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[2]/div/div/section/div[2]/div[2]/div/div[1]/div[1]")
	WebElement title; //class='adminListTop'
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-cbName']")
	WebElement fieldName;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-cbEndpoint']")
	WebElement fieldEndPoint;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-cbSecretKey']")
	WebElement fieldSecretKey;
	
	@FindBy(how = How.CSS, using="[data-qa-id='selection-box-cbEvent']")
	WebElement fieldEvent;
	
	@FindBy(how = How.CSS, using="[data-qa-id='select-list-Close errand']")
	WebElement eventCloseErrand;
	
	@FindBy(how = How.CSS, using="[data-qa-id='dd-serialSelect-Select Area']")
	WebElement optionArea;
	
	@FindBy(how = How.CSS, using="[data-qa-id='ddcb-6']")
	WebElement areaJid;
	
	
	@FindBy(how = How.CSS, using="[data-qa-id='btn-Save']")
	WebElement buttonSave;
	
	
	
	public void accessCallbackPage(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.mainMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.adminMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.apiMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.callbackMenu)).click();
		
	}
	
	public String verifyCallbackPage()
	{
		String actual = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.title)).getText();
		return actual;
	}
	
	public void clickCreateNew()
	{
	    new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.createButton)).click();
	}
	
	public void enterName(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.fieldName)).click();
		fieldName.sendKeys("Callback API");
	}
	
	public void enterEndPoint(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.fieldEndPoint)).click();
		fieldEndPoint.sendKeys("Endpoint API");
	}
	
	public void enterSecretKey(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.fieldSecretKey)).click();
		fieldSecretKey.sendKeys("Secret Key API");
	}
	
	public void chooseEvent(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.fieldEvent)).click();
	}
	
	public void chooseCloseErrandEvent(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.eventCloseErrand)).click();
	}
	
	public void chooseArea(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.optionArea)).click();
	}
	
	public void chooseJidArea(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.areaJid)).click();
	}
	
	public void clickSaveButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.buttonSave)).click();
	}
	
}
