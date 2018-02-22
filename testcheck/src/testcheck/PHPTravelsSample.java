package testcheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class PHPTravelsSample extends Reusablemethods {

	@Test	
	public void PHPTravelstest(){
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_Win32_3.8.0\\IEDriverServer.exe");
		@SuppressWarnings("deprecation")
		WebDriver driver = new InternetExplorerDriver(cap);
		driver.get("http://phptravels.org/clientarea.php");
		driver.manage().window().maximize();
	    javaScriptClickObject(driver, "partiallinktext", "Account");
	    javaScriptClickObject(driver, "partiallinktext", "Register");
	    typeinEditbox(driver, "id", "inputFirstName", "Chaitanya");
	}
}
