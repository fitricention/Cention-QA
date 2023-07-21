package base;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseSetup {
	public static WebDriver driver;
	String browser;
	
	
	@Parameters("browser")
	@BeforeClass
	public  WebDriver Base(String browser) throws Exception
	{
		
		if(browser.equalsIgnoreCase("firefox")){
			
			//create firefox instance
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	        //System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
	        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"C:\\temp\\logs.txt");
			
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("focusmanager.testmode",true);
			//WebDriver webDriver =  new FirefoxDriver(profile);
			driver =new FirefoxDriver();
			driver.get("https://cloud.cention.com/");
			}
		
		
		else if(browser.equalsIgnoreCase("chrome")){
				
				System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32/chromedriver.exe");
				driver =new ChromeDriver();
				//driver.get("https://cloud-qa.cention.com/ng/v5");		
				//DesiredCapabilities cap=DesiredCapabilities.chrome();
				//cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				
				
			}
		//Check if parameter passed as 'IE'
		else if(browser.equalsIgnoreCase("IE")){
						//set path to Edge.exe
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.22.0-win64\\geckodriver.exe");
				System.setProperty("webdriver.ie.driver", "C:\\IEDriverServer_Win32_3.9.0\\IEDriverServer.exe");
				//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer(); capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
				//Runtime.getRuntime().exec("RunDll32.exe InetCpl.cpl,ClearMyTracksByProcess 2");
			    driver = new InternetExplorerDriver();
		//	DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer(); capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			}
		
		else if(browser.equalsIgnoreCase("Edge")){
						
				System.setProperty("webdriver.gecko.driver", "C:\\geckodriver-v0.22.0-win64\\geckodriver.exe");
				System.setProperty("webdriver.ie.driver", "C:\\MicrosoftWebDriver.exe");
				driver = new EdgeDriver();	
			}
		
		else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
		
		  driver.get("https://cloud-qa.cention.com");
		  driver.manage().window().maximize();
		 // System.out.println(driver.getTitle());
		 // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		 return driver;
		 }
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}
	
	
	@AfterClass public static void tearDown()
	 {
		 driver.manage().deleteAllCookies();
		 driver.close();

	 }
	
}
