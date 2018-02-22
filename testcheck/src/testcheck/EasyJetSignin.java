package testcheck;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EasyJetSignin extends Reusablemethods {

	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_Win32_3.8.0\\IEDriverServer.exe");
		@SuppressWarnings("deprecation")
		WebDriver driver = new InternetExplorerDriver(cap);
		driver.get("https://www.easyjet.com/en/");
		driver.manage().window().maximize();
		javaScriptClickObject(driver, "xpath", "//button[contains(text(),'Okay, got it')]");
		javaScriptClickObject(driver, "cssselector", "span.sign-in");
		javaScriptClickObject(driver, "cssselector", "a.ej-link.register-link");
		typeinEditbox(driver, "id", "EmailAddress", "testautomationchaitanya@gmail.com");
		typeinEditbox(driver, "id", "EmailAddressCheck", "testautomationchaitanya@gmail.com");
		typeinEditbox(driver, "id", "Password", "Srinivas1234");
		typeinEditbox(driver, "id", "PasswordCheck", "Srinivas1234");
		SelectValuefromDropDownByVisibleText(driver, "id", "TitleTypeCode", "Mrs");
		typeinEditbox(driver, "id", "FirstName", "Chaitanya");
		typeinEditbox(driver, "id", "LastName", "Nanduri");
		typeinEditbox(driver, "id", "Address1", "test");
		typeinEditbox(driver, "id", "Address2", "test");
		typeinEditbox(driver, "id", "City", "London");
		typeinEditbox(driver, "id", "PostalCode", "TW7 4BX");
		typeinEditbox(driver, "id", "MobilePhone", "07459252081");
		javaScriptClickObject (driver, "id", "OptInEasyJetMailingListCheckBox");
		javaScriptClickObject(driver, "xpath", "//a/span[contains(text(),'Register now')]");
	}

}
