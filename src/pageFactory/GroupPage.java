package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GroupPage {

WebDriver driver; 
	
	public GroupPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//*[@id='page-wrapper']/section/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div")
	WebElement mainMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_with_subAdministration']")
	WebElement administrationMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='menu_Groups']")
	WebElement groupMenu;

	@FindBy(how = How.XPATH, using="//*[@id='AdminGroup']/div[1]/div[1]/div/div/div[1]/h2")
	WebElement groupTitle;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Create New']")
	WebElement addNewButton;
	
	
	
	public void clickGroupMenu(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.mainMenu)).click();
		administrationMenu.click();
		groupMenu.click();
	}
	
	public String verifyGroupPage(){

	   String actual = groupTitle.getText();
	   return actual;
	}
	
	public void clickAddNewButton(){

		}
	
}
