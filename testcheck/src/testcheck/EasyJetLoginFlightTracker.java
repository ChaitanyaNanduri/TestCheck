package testcheck;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

public class EasyJetLoginFlightTracker extends Reusablemethods {

	public static void main(String[] args) throws IOException {
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
		typeinEditbox(driver, "cssselector", "input#signin-username", "testautomationchaitanya@gmail.com");
		typeinEditbox(driver, "cssselector", "input#signin-password", "Srinivas1234");
		javaScriptClickObject(driver, "cssselector", "input#signin-login");
		//Mouse over Flight info
		Actions action=new Actions(driver);
		WebElement flightinfo = driver.findElement(By.xpath("//ul/li/p[contains(text(),'Flights & travel info')]"));
		action.moveToElement(flightinfo).click().build().perform();
		javaScriptClickObject(driver, "linktext", "Arrivals & Departures");
		typeinEditbox(driver, "id", "flight-number-textbox", "12");
		javaScriptClickObject(driver, "id", "flight-number-submit");
		File scrFiletoday = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFiletoday, new File("C:\\Users\\nanduric\\Desktop\\Personal\\Chaitanya\\Automation\\Screenshots\\EasyJetFlightTracker\\Today.png"));
		javaScriptClickObject(driver, "xpath", "//div[@class='summary-navigation']/ul/li[1]/a");
		File scrFileyesterday = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFileyesterday, new File("C:\\Users\\nanduric\\Desktop\\Personal\\Chaitanya\\Automation\\Screenshots\\EasyJetFlightTracker\\Yesterday.png"));
		javaScriptClickObject(driver, "xpath", "//div[@class='summary-navigation']/ul/li[3]/a");
		File scrFiletomorrow=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFiletomorrow, new File("C:\\Users\\nanduric\\Desktop\\Personal\\Chaitanya\\Automation\\Screenshots\\EasyJetFlightTracker\\Tomorrow.png"));

	}

}
