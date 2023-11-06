package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
	
	//@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Create New']")
	//WebElement addNewButton;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[3]/div/div/section/div[2]/div[2]/div/div[1]/div[1]/div/div/div[2]/button[2]/i")
	WebElement addNewButton;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-name']")
	WebElement nameField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-description']")
	WebElement descriptionField;
	
	@FindBy(how = How.CSS, using="[data-qa-id='anchor_undefined']")
	WebElement areaField;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[2]/div/div/section/div[2]/div[2]/div/div[2]/div[2]/section/div/div[1]/form/div[1]/div[3]/div/div[2]/div/div/div/div/div/div[3]/div[1]/div/div/div")
	WebElement area_ABC_Orgz;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Save']")
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[3]/div/div/section/div[2]/div[2]/div/div[2]/div[2]/section/ul/li[1]")
	WebElement titleGroup;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[3]/div/div/section/div[2]/div[2]/div/div[2]/div[2]/section/div/div[1]/form/div[1]/div[4]/div/div/div[2]/div/div[1]/div/div[1]/h2")
	WebElement titleAgentInGroup;
	
	@FindBy(how = How.CSS, using="[data-qa-id='41']")
	WebElement agent1;
	
	@FindBy(how = How.CSS, using="[data-qa-id='11']")
	WebElement agent2;
	
	@FindBy(how = How.CSS, using="[data-qa-id='42']")
	WebElement agent3;
	
	@FindBy(how = How.CSS, using="[data-qa-id='28']")
	WebElement agent4;
	
	@FindBy(how = How.CSS, using="[data-qa-id='63']")
	WebElement agent5;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[2]/div/div/section/div[2]/div[2]/div/div[2]/div[2]/section/div/div[1]/form/div[1]/div[4]/div/div/div[2]/div/div[2]/div[2]/div[2]")
	WebElement addedAgentBox;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Clear']")
	WebElement clearButton;
	
	
	
	public void clickGroupMenu(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.mainMenu)).click();
		administrationMenu.click();
		groupMenu.click();
	}
	
	public String verifyGroupPage(){

	   String actual = groupTitle.getText();
	   return actual;
	}
	
	public void clickAddButton(){
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(this.addNewButton)).click();
	}
	
	public void createNewGroup(){
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(this.addNewButton)).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.nameField)).click();
		nameField.sendKeys("New Group");
		
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.descriptionField)).click();
		descriptionField.sendKeys("Group Description");	
		
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.areaField)).click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.area_ABC_Orgz)).click();
		areaField.click();
		
		saveButton.click();
	}
	
	public boolean verifyGroupAgentPage(){
		String actual = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.titleGroup)).getText();
		String actual2 = new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.titleAgentInGroup)).getText();
		
		System.out.println(actual);
		System.out.println(actual2);
		
		if((actual == "Group") && (actual2 == "Agents in the group")){
		
			return true;
		}else 
			return false;
	}
	
	public void selectMultipleAgents(){
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.agent1)).click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.agent2)).click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.agent3)).click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.agent4)).click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.agent5)).click();
		
	}
	
	public void addAgentsInGroup(){
		//Creating object of Actions class to build composite actions
		Actions builder = new Actions(driver);

		//Building a drag and drop action
		Action dragAndDrop = builder.clickAndHold(agent1)
		.moveToElement(addedAgentBox)
		.release(addedAgentBox)
		.build();

		//Performing the drag and drop action
		dragAndDrop.perform();
	}
	
	public void enterGroupDetails(){
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.nameField)).click();
		nameField.sendKeys("New Group");
		
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.descriptionField)).click();
		descriptionField.sendKeys("Group Description");	
		
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.areaField)).click();
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(this.area_ABC_Orgz)).click();
	}
	
	public void resetSelection(){
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(this.clearButton)).click();
	}
}
