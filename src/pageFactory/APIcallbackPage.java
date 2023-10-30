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
	
}
