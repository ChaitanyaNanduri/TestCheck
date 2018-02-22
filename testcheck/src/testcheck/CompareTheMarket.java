package testcheck;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class CompareTheMarket {

	public WebDriver driver;
	
	@Test
	public void beforetest(){
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
		int cookiesizebeforerdelete = driver.manage().getCookies().size();
		System.out.println(cookiesizebeforerdelete);
		driver.manage().deleteAllCookies();
		int cookiesizeafterdelete = driver.manage().getCookies().size();
		System.out.println(cookiesizeafterdelete);
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.linkText("Sign in"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		System.out.println("Clicked on Sign in");
		
	}
}
