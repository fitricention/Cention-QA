package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Features {

	
	WebDriver driver;

	@FindBy(how = How.ID, using = "show-popup-message.other.contacts.errands.default")
	WebElement showAPopupMessageUnderOtherContacts;


	public void enableShowAPopUpMessageOtherContacts()
	{
		//String value = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(this.showAPopupMessageUnderOtherContacts)).getAttribute("value");
		System.out.println(value);
		if (value.equals("true"))
		{
			System.out.println("Already showAPopupMessageUnderOtherContacts is enabled.");	
		}
		else
		{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(this.showAPopupMessageUnderOtherContacts)).click();
		Select option = new Select(this.showAPopupMessageUnderOtherContacts);
		option.selectByVisibleText("true");
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(this.setshowAPopupMessageUnderOtherContacts)).click();
		System.out.println("showAPopupMessageUnderOtherContacts is enabled");	
		}

	}

	public Features (WebDriver driver)
	{
		this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);
	}
	
}

