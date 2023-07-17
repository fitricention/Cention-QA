package pageFactory;

import java.awt.AWTException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateErrand {

WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/div[1]/div/div[1]/div[1]/span[1]")
	WebElement createErrandTab;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='start-errand']")
	WebElement sendErrandTab;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='anchor_select an area']")
	WebElement selectArea;
	
/*	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/div[1]/div/div[1]/div[2]/form/div[1]/div[2]/div/div/div[2]")
	WebElement areaDropDown;*/
	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/div[1]/div/div[1]/div[2]/form/div[1]/div[2]/div/div/div[2]/button[5]")
	WebElement selectAreaName;
	
	@FindBy(how = How.CSS, using = ".btn.btn-danger")
	WebElement confirmArea;
	
	@FindBy(how = How.CLASS_NAME, using = "errand-tags-list")
	WebElement selectTags;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_tagpicker_errand-email-to']")
	WebElement fromField;

	@FindBy(how = How.CSS, using = "[data-qa-id='QA_tagpicker_errand-email-to']")
	WebElement toField;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_tagpicker_errand-email-cc']")
	WebElement ccField;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_tagpicker_errand-email-bcc']")
	WebElement bccField;
	
	@FindBy(how = How.ID, using = "meSubject")
	WebElement subjectField;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div/div[1]/div[2]/form/div[2]/div[1]/div/div[6]/div/div/div/iframe")
	WebElement answerIFrame;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div[2]/div[1]/div[2]/form/div[2]/div[1]/div/div[4]/div/div/div/iframe")
	WebElement startErrandAnswerIFrame;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div/div[1]/div[2]/form/div[5]/div/div/div/iframe")
	WebElement teitterErrandAnswerIFrame;
	
	@FindBy(how = How.XPATH, using = "//*[@id='QA_replyEditor_ckev5me']")
	WebElement answerField;
	
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_showManualErrand']")
	WebElement createButton;
	
	@FindBy(how = How.CLASS_NAME, using = "btn-blue")
	WebElement doneButton;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_btn_create']")
	WebElement createButton2;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_btn_send']")
	WebElement sendButton;
	@FindBy(how = How.XPATH, using = "//*[@id='container']/div/div[1]/div/div[1]/div[2]/form/div[9]/button[2]")
	//@FindBy(how = How.CLASS_NAME, using = "btn-blue")
	WebElement manualDoneButton;
	
	//@FindBy(how = How.CSS, using = ".errand-inner > div:nth-child(2) > i:nth-child(1)")
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_btn_send']")
	//@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/div[1]/div/div[2]/i")
	WebElement erandCreationPopUpClose;
	
	
	@FindBy(how = How.CLASS_NAME, using = "popup-close")
	WebElement clickClose;
	
	
	@FindBy(how = How.XPATH, using = "//*[@id='tagData']/div/div/div/ul/li/a")
	WebElement addTagLink;
	
	@FindBy(how = How.CSS, using = ".btn.btn-primary")
	WebElement tagConfirmButton;
	
	@FindBy(how = How.CLASS_NAME, using = "errand-number")
	WebElement errandNumber;
	
	@FindBy(how = How.CSS, using = "span.reply-toolbar.manual-errand-toolbar > div.channel-select")
	WebElement channelDropDown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='dd_list_twitter']")
	WebElement twitterChannel;
	
	@FindBy(how = How.CSS, using = "div.label-block.account > div.jq-selectbox.jqselect.errand-subject.sidebar-nav-select > div.jq-selectbox__select > div.jq-selectbox__select-text")
	WebElement chooseTwitterAccount;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='select-list-jessica50393632']")
	WebElement twitterAccount;
	
	@FindBy(how = How.CLASS_NAME, using = "icon-chevron-down")
	WebElement channelDropdown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='dd_list_email']")
	WebElement emailChannelDropdown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='dd_list_sms']")
	WebElement smsChannelDropdown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='dd_list_line']")
	WebElement lineChannelDropdown;
	
	//@FindBy(how = How.CSS, using = ".block-checkboxes:nth-child(6) .icon-staple")
	//.block-checkboxes:nth-child(8) .icon-staple
	@FindBy(how = How.CSS, using = "div.block-checkboxes > div.right-sidebar > div > div.reply-editor-action.errand-file > a > i")
	WebElement attachFileButton;
	
	@FindBy(how = How.LINK_TEXT, using = "Choose archive file")
	WebElement chooseArchiveFileButton;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='dd-one-itemAutomationCention.txt']")
	WebElement archiveFileTextButton;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='dd-one-itemAuotImage.jpg']")
	WebElement archiveFileImageButton;
	
	@FindBy(how = How.CSS, using = "span.errand-attachment-list.serial")
	WebElement attachedFiles;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='create-errand-type-select']")
	WebElement selectBox;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='select-list-as closed errand']")
	WebElement closeErrand;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='select-list-in My errands']")
	WebElement myErrand;
	
	@FindBy(how = How.CSS, using = "span.btn.btn-default.btn-file.btn-fileupload")
	WebElement browseFileButton;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_knowledgeBasePopup']")
	WebElement openKnowledgeBase;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='kb-select-folder']")
	WebElement knowledgeBaseListArrow;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='select-list-Automation Knowledge Answer']")
	WebElement automationKnowledgeAnswer;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='kb-select-sub-folder']")
	WebElement selectAutomationKnowledgeAnswerFolder;
	
	@FindBy(how = How.CSS, using = "#container > div > div.knowledge-base-backdrop.popup.open > div > div.knowledge-base-sidebar > div.toggle-tabs > div > div:nth-child(2) > div > div:nth-child(2) > div > div.toggle-btn.folder-sprite")
	WebElement selectSubCategoryfolder;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='kb-add-answer']")
	WebElement addAlternativeAnswerButton;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='contact-card-icon-to']")
	WebElement contactIconForTo;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='contact-card-icon-cc']")
	WebElement contactIconForCC;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='contact-card-icon-bcc']")
	WebElement contactIconForBCC;
	
	@FindBy(how = How.CSS, using = "#container > div > div.contact-book-backdrop.popup.open > div > div.contact-book-content > div.button-row > button.btn-blue")
	WebElement insertContactName;
	
	
	@FindBy(how = How.CSS, using = ".form-1-2:nth-child(1) .tag-input-container")
	WebElement getTofield;
	
	@FindBy(how = How.CSS, using = ".form-1-2:nth-child(3) .tag-input-container")
	WebElement getBccfield;
	
	@FindBy(how = How.CSS, using = ".form-1-2:nth-child(2) .tag-input-container")
	WebElement getCcfield;
	
	@FindBy(how = How.LINK_TEXT, using = "Preview")
	WebElement preview;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='manual-add-tag']")
	WebElement tag;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='text-field-input-tagSearchBox']")
	WebElement searchTags;
	
	public CreateErrand(WebDriver driver)
	{
		this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
	
	public void clickCreateButton()
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.createButton)).click();	

	}
	
	public void clickSelectArea()
	{
		//new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.selectArea)).click();
		Actions builder = new Actions(driver);
		
		builder .moveToElement(new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(this.selectArea))).click().perform();		
		try{
			   Thread.sleep(3000);
			  }catch (InterruptedException ie1) {
			    ie1.printStackTrace();
			  }
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].scrollIntoView();",new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[data-qa-id='dd-one-itemFitri QA Area 1 - Microsoft Mail']")))));
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[data-qa-id='dd-one-itemFitri QA Area 1 - Microsoft Mail']")))).click();	
		try{
			   Thread.sleep(2000);
			  }catch (InterruptedException ie1) {
			    ie1.printStackTrace();
			  }
	}
	
	public void fillFromField(String From) throws AWTException
	{
		try{
			   Thread.sleep(3000);
			  }catch (InterruptedException ie1) {
			    ie1.printStackTrace();
			  }
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.fromField)).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.fromField)).sendKeys(From);
		/*Robot r = new Robot();
		
		  r.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		  r.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		  r.delay(500);*/
		
	}
	
	
	public void fillSubject (String Subject)
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.subjectField)).click();
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.subjectField)).sendKeys(Subject);
	}
	
	public String enterTextInAnswerField(String Text)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.switchTo().frame(this.startErrandAnswerIFrame);
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.answerField)).click();
		this.answerField.sendKeys(Text);
		driver.switchTo().defaultContent();
		return Text;
	}
	
	public boolean clickCreateErrandBtn ()
	{
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.createButton2)).click();
		boolean actual = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(this.errandNumber)).isDisplayed();
		
		//display Errand ID
		return actual;
	}
	
}
