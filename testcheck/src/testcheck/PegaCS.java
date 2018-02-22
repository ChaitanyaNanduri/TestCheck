package testcheck;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.ElementScrollBehavior;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class PegaCS extends Reusablemethods {
	@Test
	public void PegaCSTest() throws IOException {
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		cap.setJavascriptEnabled(true);
		System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_Win32_3.8.0\\IEDriverServer.exe");
		@SuppressWarnings("deprecation")
		WebDriver driver = new InternetExplorerDriver(cap);
		driver.get("https://rh0271v:8443/prweb/");
		driver.manage().window().maximize();
		javaScriptClickObject(driver, "id", "overridelink");
		typeinEditbox(driver, "id", "txtUserID", "FOCSA00018");
		typeinEditbox(driver, "id", "txtPassword", "pega");
		javaScriptClickObject(driver, "id", "sub");
		javaScriptClickObject(driver, "xpath", "//a[@title='Create New Interaction']");
		javaScriptClickObject(driver, "xpath", "//span[@class='menu-item-title-wrap']/span[contains(text(),'Phone Call - Inbound')]");
		int iframecount = driver.findElements(By.tagName("iframe")).size();
		System.out.println(iframecount);
		driver.switchTo().frame(1);
		typeinEditbox(driver, "id", "pyFirstName", "TestoneRoad");
		typeinEditbox(driver, "id", "pyLastName", "TestoneRoad");
		typeinEditbox(driver, "id", "pyEmail", "chaitanya.nanduri@theaa.com");
		typeinEditbox(driver, "id", "$PpyWorkPage$pContactDetails$pDateOfBirthDySel", "12");
		typeinEditbox(driver, "id", "$PpyWorkPage$pContactDetails$pDateOfBirthMoSel", "01");
		typeinEditbox(driver, "id", "$PpyWorkPage$pContactDetails$pDateOfBirthYrSel", "1989");
		clickObject(driver, "id", "houseNumber");
		WebElement norecordserrormessage = driver.findElement(By.xpath("//div[@class='content-inner ']/ul/li"));
		String norecordserrormessagetext = norecordserrormessage.getText();
		System.out.println(norecordserrormessagetext);
		javaScriptClickObject(driver, "xpath", "//div[@class='field-item dataValueRead']//div[contains(text(),'Other actions ')]");
		javaScriptClickObject(driver, "xpath", "//div[@class='menu-panel-wrapper']/ul/li[2]/a/span/span[contains(text(),'Create New Contact')]");
		javaScriptClickObject(driver, "xpath", "//label[contains(text(),'Mr')]");
		typeinEditbox(driver, "id", "pyPhoneNumber", "07123123123");
		javaScriptClickObject(driver, "xpath", "//div[contains(text(),'Next')]");
		typeinEditbox(driver, "id", "HouseName", "cheshire");
		typeinEditbox(driver, "id", "pyPostalCode", "sk101ea");
		javaScriptClickObject(driver, "xpath", "//div[contains(text(),'Find your full address')]");
		javaScriptClickObject(driver, "xpath", "//div[contains(text(),'Next')]");
		javaScriptClickObject(driver, "xpath", "//div[contains(text(),'Submit')]");
		waitUntilElement(driver, "name", "CPMInteractionDriver_D_Interaction_3", true , 30);
		waitUntilElement(driver, "name", "CPMInteractionDriver_D_Interaction_3", true, 30);
		javaScriptClickObject(driver, "name", "CPMInteractionDriver_D_Interaction_3");
		//javaScriptClickObject(driver, "xpath", "//div[@id='RULE_KEY']/div/div/div/div/div/iv/div/div/div/div/div/span/button/div/div/div/div");
		javaScriptClickObject(driver, "linktext", "Road New Business Sales");
		javaScriptClickObject(driver, "linktext", "Road New Business Sales");
		}


	}
