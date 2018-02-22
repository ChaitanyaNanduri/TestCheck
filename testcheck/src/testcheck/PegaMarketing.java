package testcheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PegaMarketing extends Reusablemethods{

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
		driver.get("https://rh0274v:8443/prweb/PRServlet");
		driver.manage().window().maximize();
		driver.navigate ().to ("javascript:document.getElementById('overridelink').click()");
		typeinEditbox(driver, "id", "txtUserID", "Tester1");
		typeinEditbox(driver, "id", "txtPassword", "pega");
		javaScriptClickObject(driver, "id", "sub");
		//driver.switchTo().frame("PegaGadget0Ifr");
		javaScriptClickObject(driver, "xpath", PageObjects.campaigns_xpath);
		clickObject(driver, "cssselector", PageObjects.campaigns_cssselector);
		
	}

}
