package testcheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CompareTheMarketTest extends Reusablemethods {

	public static void main(String[] args) {

		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_Win32_3.8.0\\IEDriverServer.exe");
		@SuppressWarnings("deprecation")
		WebDriver driver=new InternetExplorerDriver(cap);
		driver.get("https://www.comparethemarket.com/");
		driver.manage().window().maximize();
		javaScriptClickObject(driver,"linktext","Sign in");
		//driver.switchTo().defaultContent();
		typeinEditbox(driver, "id","emailAddress","chaitu89nandurinew@gmail.com");
		typeinEditbox(driver, "id","password","Srinivas1234");
		javaScriptClickObject(driver,"id","signin-button-submit");
		javaScriptClickObject(driver,"linktext","Start a new quote");
		javaScriptClickObject(driver, "xpath","//div[@class='flex main-products-inner']/ul/li[5]/a[@id='newVanComparison']/span");
		clickObject(driver, "id","registration-number");
		typeinEditbox(driver, "id","registration-number","A1");
		clickObject(driver, "xpath","//li[@id='knows-registration-number-wrapper']/span[1]");
		javaScriptClickObject(driver,"xpath","//div[@id='vehicle-lookup']/ol/li[3]/div/button[2]");
		
	}	

}
