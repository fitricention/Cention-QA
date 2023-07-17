package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.BaseSetup;

public class Sidebar extends BaseSetup {

WebDriver driver;
	
	@FindBy(how = How.CSS, using = "div.sidebar-nav-select:nth-child(2) > div:nth-child(1) > div:nth-child(1)")
	WebElement errandsDropDown;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/div/main/div[2]/div/div/section/div[1]/div[2]/div/div/div/div/div[1]/div[1]")
	WebElement mainMenu;
	
	@FindBy(how = How.ID, using = "searcherrands")
	WebElement searchMenu;
	
	@FindBy(how = How.CSS, using = "#administration > a > i")
	WebElement administrationMenu;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='menu_Statistics']")
	WebElement statisticsMenu;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='menu_Contact cards']")
	WebElement contactCardPage;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='menu_Knowledge bases']")
	WebElement knowledgeBaseMenu;
	
	
	
	@FindBy(how = How.CSS, using = "div.sidebar-nav-select:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1)")
	WebElement errandsOpenDropDown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_folder_myErrands']")
	WebElement myErrandsMenu;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_folder_allErrands']")
	WebElement allErrandsMenu;
	
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/section/div[1]/div[2]/div/ul[2]/li[1]/a")
	WebElement priorityDropDown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_toggleAreaFilter']")
	WebElement areasDropDown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='agentFilter_swathi agent_1716']")
	WebElement agentSwathiAgent;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='agentFilter_swathi_149']")
	WebElement agentSwathi;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_areaFilter_S&G Support_46']")
	WebElement areaSGSupport;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_toggleAgentFilter']")
	WebElement agentsDropDown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_toggleAreaFilter']")
	WebElement areaDropDown;
	
	@FindBy(how = How.XPATH, using = "//*[@id='page-wrapper']/section/div[1]/div[2]/div/ul[2]/li[4]/a")
	WebElement tagsDropDown;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='tagList_Automation tag_413']")
	WebElement AutomationTagFilter;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_searchFilter_search_tag']")
	WebElement searchTagFilter;
	
	@FindBy(how = How.CSS, using = "li > ul.sidebar-menu.tags")
	WebElement listOfSearchedTags;
	
	
	
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_showManualErrand']")
	WebElement plusErrand;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='QA_folder_186']")
	WebElement salesFolder;
	
	@FindBy(how = How.XPATH, using = "//*[@id='47']")
	WebElement SGSalesArea;
	
	@FindBy(how = How.CLASS_NAME, using = "react-autosuggest__container")
	WebElement areaSearchField;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[4]/div/div[1]/div/div/div[2]/button[1]")
	WebElement confirmMoveToArea;
	
	
	@FindBy(how = How.CLASS_NAME, using = "icon-refresh")
	WebElement refresh;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='menu_with_subOrganizations']")
	WebElement Organizations;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='menu_with_subSystem Setup']")
	WebElement SystemSetup;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='menu_Features']")
	WebElement Features;
	
	
	@FindBy(how = How.CSS, using = "[data-qa-id='menu_Agents']")
	WebElement agentsAdmin;
	
	
	@FindBy(how = How.ID, using = "workflow")
	WebElement workflow;
	
	@FindBy(how = How.CSS, using = "[data-qa-id='menu_Contact cards']")
	WebElement contactCards;
	//"[data-qa-id='QA_pick-up_next-styler']"
	@FindBy(how = How.XPATH, using = "//span[contains(.,'Pick-up next')]")
	WebElement pickUpNext;
	
	
	/* Methods */
	public Sidebar(WebDriver driver)
	{
		this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
	
	
}
