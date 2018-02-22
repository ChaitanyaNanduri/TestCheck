package testcheck;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RES extends Reusablemethods{

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
		driver.get("http://rh0113p:8143/res/admin/FindPolicy.res");
		driver.manage().window().maximize();
		typeinEditbox(driver, "id","membershipNo","6356011575180454");
		javaScriptClickObject(driver,"name","find");		
		javaScriptClickObject(driver,"linktext","Show 6356011575180454");
		for(int i=1;i<=9;i++){
			System.out.println(driver.findElement(By.xpath("//div[@id='policy_0']/table/tbody/tr[" + i + "]/td[1]")).getText()
					+ driver.findElement(By.xpath("//div[@id='policy_0']/table/tbody/tr[" + i + "]/td[2]")).getText());
			}
		}
		//System.out.println(driver.findElement(By.xpath("//div[@id='policy_0']/table/tbody/tr[1]/td[1]")).getText());
}
