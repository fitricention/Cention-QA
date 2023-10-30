package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class APIaccessTokenPage {

	WebDriver driver;
	
	public APIaccessTokenPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[2]/div/div/section/div[2]/div[2]/div/div[1]/div[1]")
	WebElement title; //class="adminListTop"
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Create new']")
	WebElement createButton;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-jwtName']")
	WebElement fieldName;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-jwtKey']")
	WebElement fieldKey;
	
	@FindBy(how = How.CSS, using="[data-qa-id='selection-box-Channel']")
	WebElement fieldChannel;	
	
	@FindBy(how = How.CSS, using="[data-qa-id='select-list-Email']")
	WebElement chooseEmail;
	
	@FindBy(how = How.CSS, using="[data-qa-id='QA_jwtAllowAttachment']")
	WebElement enableAttachmentAPI;
	
	@FindBy(how = How.CSS, using="[data-qa-id='btn-Save']")
	WebElement buttonSave;
	
	@FindBy(how = How.XPATH, using="html/body/div[1]/div/div/main/div[2]/div/div/section/div[1]/div[2]/div/div/div")
	WebElement mainMenu; //class="main-menu
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subAdministration']")
	WebElement adminMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subAPI']")
	WebElement apiMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_Access Tokens']")
	WebElement accessTokenMenu;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[2]/div/div/section/div[2]/div[2]/div/div[1]/div[2]/div/div/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[7]/div/span[1]")
	WebElement editButton; //class="main-menu
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Edit']")
	WebElement edit;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[3]/div/div/section/div[2]/div[2]/div/div[1]/div[2]/div/div/div[2]/div[1]/div[2]/table/tbody/tr[2]/td[7]/div/span[2]/button/i")
	WebElement deleteRowButton; //
	
	

	public String verifyAPIaccessTokenPage(){
		String actual = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.title)).getText();
	
		return actual;
	}
	
	public void createNewAccessToken(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.createButton)).click();
	}
	
	public void inputName(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.fieldName)).click();
		fieldName.sendKeys("AccessToken123");
	}
	
	public void inputKey(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.fieldKey)).click();
		fieldKey.sendKeys("abc123");
	}
	
	
	public void inputAPI(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.enableAttachmentAPI)).click();
	}
	
	
	public void inputChannel(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.fieldChannel)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.chooseEmail)).click();
	}
	
	public void saveButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.buttonSave)).click();
	}
	
	public void accessTokenPage(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.mainMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.adminMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.apiMenu)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.accessTokenMenu)).click();
		
	}
	
	public void editTokens(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.editButton)).click();
		fieldName.click();
		fieldName.sendKeys("AccessToken123 - Updates");
	}
	
	public void deleteTokens(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.deleteRowButton)).click();
		
	}
	
}
