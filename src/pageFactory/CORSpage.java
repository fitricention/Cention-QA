package pageFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CORSpage {

	WebDriver driver;
	
	public CORSpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//*[@id='page-wrapper']/section/div[1]/div[2]/div/div/div/div/div[1]/div[2]/div")
	WebElement mainMenu;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Create New']")
	WebElement createButton;
	
	@FindBy(how = How.CSS, using="[data-qa-id='text-field-input-corsUrl']")
	WebElement inputCORSurl;
	
	@FindBy(how = How.CSS, using="[data-qa-id='table-btn-Save']")
	WebElement saveButton;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[3]/div/div/section/div[2]/div[2]/div/div[1]/div[1]")
	WebElement title;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[3]/div/div/section/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/ul/li[3]/a")
	WebElement nextPage;
	
	@FindBy(how = How.XPATH, using="/html/body/div[1]/div/div/main/div[3]/div/div/section/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/table/tbody/tr[5]/td[2]/div/span")
	WebElement deleteRow;
	
	
	public void createNewCORS(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.createButton)).click();
	}
	
	public String enterCORS(String url){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.inputCORSurl)).sendKeys(url);
		return url;
	}
	
	public void clickSaveButton(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.saveButton)).click();
	}
	
	public String verifyCORSpage(){
		String actual = new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.title)).getText();
	
		return actual;
	}
	
	public void deleteCORSdata(){
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.nextPage)).click();
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(this.deleteRow)).click();
		
		driver.switchTo().alert().accept();
		
	}
	
	
}
