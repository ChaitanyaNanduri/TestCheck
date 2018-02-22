package testcheck;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Reusablemethods {

	
		public String XPATH="xpath";
		public String NAME="name";
		public String ID="id";
		public String LINKTEXT="linkText";
		public String PARTIALLINKTEXT="partialLinkText";
		public String CSS="cssSelector";
		public String CLASSNAME="className";
		public static WebDriver driver;
		/**
		 * Constructor to initialize the {@link ScriptHelper} object and in turn the objects wrapped by it
		 * @param scriptHelper The {@link ScriptHelper} object
		 */
				public static boolean isAlertPresent(WebDriver driver) {
			try {
				driver.switchTo().alert();
				return true;
			} // try
			catch (NoAlertPresentException Ex) {
				return false;
			} // catch
		}


				public static void waitOnPage(WebDriver driver,int TimeInSec) {
			try {
				driver.switchTo().alert();
				int time=TimeInSec*1000;
				Thread.sleep(time);
			} 
			catch (Exception Ex) {
			}
		}


		public static void waitOnPage(WebDriver driver){
			try {
				int time=2*1000;
				Thread.sleep(time);
				
			} 
			catch (Exception Ex) {
			}
		}

		public String generateString(Random rng, String characters, int length)
		{
			char[] text = new char[length];
			for (int i = 0; i < length; i++)
			{
				text[i] = characters.charAt(rng.nextInt(characters.length()));
			}
			return new String(text);
		}


		// #############################################################################
		// Function Name : typeinEditbox
		// Description : Function to type in text box
		// Input Parameters : driver, identifier, locator and value to be typed
		// Return Value : None
		// Author : Cognizant
		// Date Created : 05/16/2012
		// #############################################################################
		public static boolean typeinEditbox(WebDriver driver, String identifyBy,
				String locator, String valuetoType) {
			boolean isPresent = false;	
			checkPresence1(5, driver, identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator)) {
				isPresent=true;
				WebElement element=getWebElement1(driver, identifyBy, locator);
				element.clear();
				element.sendKeys(valuetoType);
			}		
			return isPresent;

		}


		public static void SelectValuefromDropDown(WebDriver driver, String identifyBy, String locator, String valuetoSelect)
		{
			//WebElement select =(driver.findElement(By.id("unitOfMeasure")));
			//select.sendKeys(value);
			if (isElementPresent1(driver, identifyBy, locator)) {
				//	System.out.println("clicking radio button" +locator);
				WebElement select= getWebElement1(driver, identifyBy, locator);
				select.sendKeys(valuetoSelect);
			}
		} 



		// #############################################################################
		// Function Name : clickButton
		// Description : Function to click a button
		// Input Parameters : driver, identifier, locator
		// Return Value : None
		// Author : 
		// Date Created : 05/16/2012
		// #############################################################################
		public static void clickObject1(WebDriver driver1, String identifyBy1,String locator1) {
			checkPresence1(5, driver1, identifyBy1, locator1);
			if (isElementPresent1(driver1, identifyBy1, locator1)) {
				getWebElement1(driver1, identifyBy1, locator1).click();
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		public static void clickObject(WebDriver driver, String identifyBy,
				String locator) {
			checkPresence1(5, driver, identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator)) {
				getWebElement1(driver, identifyBy, locator).click();
			}

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void safeJavaScriptClick(WebElement element) throws Exception {
			try {
				
				if (element.isEnabled() || element.isDisplayed()) {
					System.out.println("Clicking on element with using java script click");

					((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
				} else {
					System.out.println("Unable to click on element");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element is not attached to the page document "+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element was not found in DOM "+ e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to click on element "+ e.getStackTrace());
			}
		}

		public static void waitUntilClickable(WebDriver driver, String identifyBy, String locator)
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			@SuppressWarnings("unused")
			WebElement element=null;
			if (identifyBy.equalsIgnoreCase("id")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By.id(locator)));
			} 
			else if (identifyBy.equalsIgnoreCase("xpath")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
			} 
			else if (identifyBy.equalsIgnoreCase("name")) {
				element = wait.until(ExpectedConditions.elementToBeClickable(By.name(locator)));
			} 
		}
		

		public void waitForPageLoad(int period)
		{
			WebDriverWait wait = new WebDriverWait(driver, period);

			wait.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver wdriver) {
					return ((JavascriptExecutor) driver).executeScript(
							"return document.readyState"
							).equals("complete");
				}
			});
		}


		// #############################################################################
		// Function Name : closeJscriptPopup
		// Description : Function to close the Javascript Popup
		// Input Parameters : driver and alert
		// Return Value : None
		// Author : 
		// Date Created : 05/16/2012
		// #############################################################################
		public static void ignorePopup(WebDriver driver, Alert alert) {
			try {
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				alert = driver.switchTo().alert();
				String str = alert.getText();
				System.out.println("Alert-" + str);
				alert.accept();
			} catch (Exception e) {
				System.out.println("Alert Not appearing");
			}
		}

		@SuppressWarnings("null")
		public boolean isAlertPresent() {
			try {
				WebDriver driver = null;
				driver.switchTo().alert();
				return true;
			} // try
			catch (NoAlertPresentException Ex) {
				return false;
			} // catch
		} // isAlertPresent()

		// #############################################################################
		// Function Name : navigatetoWebpage
		// Description : Function to Navigate to the WebPage
		// Input Parameters : driver and url
		// Return Value : None
		// Author : 
		// Date Created : 05/16/2012
		// #############################################################################
		public static void navigatetoWebpage(WebDriver driver, String url) {
			driver.get(url);
		}
		// #############################################################################
		// Function Name : getText
		// Description : Function to text from the WebPage
		// Input Parameters : driver and url
		// Return Value : None
		// Author : 
		// Date Created : 05/16/2012
		// #############################################################################
		public static String  getText(WebDriver driver, String identifyBy,
				String locator) {
			String strText = null;
			WebElement element=getWebElement1(driver, identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator)) {
				strText=element.getText();
			}
			return strText;
		}

		// #############################################################################
		// Function Name : clickButton
		// Description : Function to click a button
		// Input Parameters : driver, identifier, locator
		// Return Value : None
		// Author : 
		// Date Created : 05/16/2012
		// #############################################################################
		public static void clearText(WebDriver driver, String identifyBy,
				String locator) {
			WebElement element=getWebElement1(driver , identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator)) {
				element.clear();
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// #############################################################################
		// Function Name : isElementPresent
		// Description : Function to validate the existence of an element
		// Input Parameters : driver, identifier, locator
		// Return Value : None
		// Author : 
		// Date Created : 05/16/2012
		// #############################################################################
		public static boolean isElementPresent1(WebDriver driver, String identifyBy,
				String locator) {
			int timeout =30;
			boolean isPresent = false;
			WebElement element=getWebElement1(driver, identifyBy, locator);
			try {
				int x = 0;
				do {
					if (element.isDisplayed()) {
						isPresent = true;
					} else {
						waitOnPage(driver,1);
						x = x + 1;
						isPresent = false;
					}
				} while (x < timeout && isPresent == false);

			} catch (Exception e) {

			}
			return isPresent;

		}
		
		public void mouseOver(WebDriver driver, String identifyBy,
				String locator) {
			WebElement element=getWebElement1(driver, identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator)) {
				Actions action = new Actions(driver);
				action.moveToElement(element).build().perform();

			}
			
		}

		// #############################################################################
		// Function Name : isElementPresent
		// Description : Function to validate the existence of an element
		// Input Parameters : wait time, driver, identifier, locator
		// Return Value : tpuAmoha
		// Author : 
		// Date Created : 05/02/2016
		// #############################################################################
		public static boolean checkPresence1(int waitTime, WebDriver driver, String identifyBy,
				String locator) {
			int timeout = waitTime;
			boolean isPresent = false;
			List<WebElement> elements=getWebElements(driver, identifyBy, locator);
			try {
				int x = 0;
				do {
					if (elements.size()!=0) {
						isPresent = true;
					} else {
						waitOnPage(driver);
						x = x + 1;
						isPresent = false;
					}
				} while (x < timeout && isPresent == false);

			} catch (Exception e) {

			}
			return isPresent;

		}

		// #############################################################################
		// Function Name : clickLink - updated
		// Description : Function to click the Link
		// Input Parameters : driver, identifier, locator
		// Return Value : None
		// Author : 
		// Date Created : 05/06/2015
		// #############################################################################
		public static boolean javaScriptClickObject(WebDriver driver, String identifyBy,String locator) {
			boolean isPresent=false;
			checkPresence1(5, driver, identifyBy, locator);
			WebElement element=getWebElement1(driver, identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator) ||element.isEnabled()) {
				isPresent = true;
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return isPresent;
		}

	public static void doubleClickObject(WebDriver driver, String identifyBy,String locator){
	try{
		Actions action = new Actions(driver);
		checkPresence1(5, driver, identifyBy, locator);
		WebElement element=getWebElement1(driver, identifyBy, locator);
		action.doubleClick(element).perform();
	}catch(Exception e){
		
	}
	}
		
		
		// #############################################################################
		// Function Name : selectCheckbox
		// Description : Function to Select a check box
		// Input Parameters : driver, identifier, locator and check flag to be
		// Switched on/off
		// Return Value : None
		// Author : 
		// Date Created : 05/16/2012
		// #############################################################################
		public static void selectCheckbox(WebDriver driver, String identifyBy,
				String locator, String checkFlag) {
			WebElement element=getWebElement1(driver, identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator)) {
				if ((checkFlag).equalsIgnoreCase("ON")) {
					if (!(element.isSelected())) {
						element.click();
					}
				}
			}
		}

		/**
		 * Component to verify header. Uses h1 tag in page.
		 * 
		 * @param pgText
		 * @return Returns true if header is found
		 */
		public  boolean verifyHeader(WebDriver driver, String identifyBy,String locator,String pgText) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			long start = System.currentTimeMillis();
			boolean isPresent = false;
			try {
				if (isElementPresent1(driver,identifyBy,locator)) {
					String strText = getText(driver, identifyBy, locator);
					System.out.println(strText);
					if (strText.contains(pgText))
						isPresent = true;
				}
			} catch (Exception e) {
			}
			System.out.println("Time taken in this verify header call is "
					+ (System.currentTimeMillis() - start));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return (isPresent);
		}

		/**
		 * Convenience function to verify header by Class 'page-title'
		 * 
		 * @FunctionName verifyHeaderByClassPageTitle
		 * @InputParameters None
		 * @Author 
		 * @DateCreated Jun 25, 2012
		 * @param pgText
		 * @return True of False
		 */
		public boolean verifyHeaderByClassPageTitle(String pgText) {
			long start = System.currentTimeMillis();
			boolean isPresent = false;
			try {
				//if (isElementPresent(driver, "xpath", "//h1[@class='page-title']")) {
				if (driver.findElement(By.tagName("h1")).isDisplayed()) {
					String strText = driver.findElement(
							//	By.xpath("//h1[@class='page-title']")).getText();
							By.tagName("h1")).getText();
					System.out.println(strText);
					if (strText.matches(pgText))
						isPresent = true;
				}
			} catch (Exception e) {
			}
			System.out.println("Time taken in this verify header" + pgText
					+ " call is " + (System.currentTimeMillis() - start));
			return (isPresent);
		}

		// #############################################################################
		// Function Name : click link from table
		// Description : Function to click a link from a table
		// Input Parameters : driver and url
		// Return Value : None
		// Author : 
		// Date Created : 8-July-13
		// #############################################################################		
		public static void clickLinkFromTable(WebDriver driver, String identifyBy,
				String locator, int Row) {
			@SuppressWarnings("unused")
			int timeout = 3;
			@SuppressWarnings("unused")
			String text = "";		
			locator=locator.replaceAll("<>","["+Row+"]");		
			try {


				getWebElement1(driver, identifyBy, locator).click() ;


			} catch (Exception e) {

			}
		}


		/********************************************************
		 *FUNCTION    :switchToWindow
		 *AUTHOR      :
		 *DATE        :02-July-13
		 *DESCRIPTION :Function to Switch to New Window.
		 *PAGE        :Navigating to new window. 
		 ********************************************************/
		public void switchToWindow()throws NoSuchWindowException
		{
			try
			{
				Set<String> handles = driver.getWindowHandles();
				String current = driver.getWindowHandle();
				handles.remove(current);
				Thread.sleep(1000);
				String newTab = handles.iterator().next();
				driver.switchTo().window(newTab);

			}
			catch(Exception e)
			{
				e.printStackTrace();
				//report.updateTestLog("Switvh to Window", "Switch to window not appear"+e.toString(), Status.FAIL);
			}

		}

		/********************************************************
		 *FUNCTION    :switchToFrame
		 *AUTHOR      :
		 *DATE        :02-July-13
		 *DESCRIPTION :Function to Switch to New Window.
		 *PAGE        :Navigating to new window. 
		 ********************************************************/
		public void switchToFrame(String frameName)throws NoSuchWindowException
		{
			try
			{
				waitOnPage(driver);
				driver.switchTo().frame(frameName);
				waitOnPage(driver);

			}
			catch(Exception e)
			{
				e.printStackTrace();
				//report.updateTestLog("Switvh to Frame", "Switch to Frame not appear"+e.toString(), Status.FAIL);
			}

		}

		/********************************************************
		 *FUNCTION    :Frame size, Get id and name
		 *AUTHOR      :Chaitanya
		 *DATE        :20-Feb-18
		 *DESCRIPTION :Function to get Frame Size, To Get id and name of all frames.
		 *PAGE        :Frame. 
		 ********************************************************/
	/*	public static int framesize(WebDriver driver, String identifyBy,
				String locator, String property) {
			int framesize = 0;
			getWebElements(driver, "tagname", "iframe");
			if (isElementPresent1(driver, identifyBy, locator)) {
				strText=element.getAttribute(property);
			}

			return framesize;
		}
		{
			
			try
			{
				waitOnPage(driver);
				List<WebElement> ele = driver.findElements(By.tagName("iframe"));
				System.out.println(ele.size());
				framesize=ele.size();
				for(WebElement el : ele){
				      //Returns the Id of a frame.
				        System.out.println("Frame Id :" + el.getAttribute("id"));
				      //Returns the Name of a frame.
				        System.out.println("Frame name :" + el.getAttribute("name"));
				    }
				waitOnPage(driver);
				


			}
			catch(Exception e)
			{
				e.printStackTrace();
				//report.updateTestLog("Switvh to Frame", "Switch to Frame not appear"+e.toString(), Status.FAIL);
			}
			return framesize;

		}
		*/
		public static String  getAttribute1(WebDriver driver, String identifyBy, String locator, String property) {
			String strText = null;
			WebElement element=getWebElement1(driver, identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator)) {
				strText=element.getAttribute(property);
			}

			return strText;
		}
		
		
		/********************************************************
		 *FUNCTION    :switchToDefault
		 *AUTHOR      :
		 *DATE        :02-July-13
		 *DESCRIPTION :Function to Switch to New Window.
		 *PAGE        :Navigating to new window. 
		 ********************************************************/
		public void switchToFrame()
		{
			try
			{
				waitOnPage(driver);
				driver.switchTo().defaultContent();

			}
			catch(Exception e)
			{
				e.printStackTrace();
				//report.updateTestLog("Switvh to Frame", "Switch to Frame not appear"+e.toString(), Status.FAIL);
			}

		}
		/********************************************************
		 *FUNCTION    :waitUntilElement
		 *AUTHOR      :
		 *DATE        :15-July-14
		 *DESCRIPTION :Function to validate the existence and non-Existence of an element
		 ********************************************************/ 

		public boolean waitUntilElement(WebDriver driver, String identifyBy,
				String locator, boolean checkPresence, int timeInSec) {
			int timeout = timeInSec;
			boolean isPresent = false;
			WebElement element=getWebElement1(driver, identifyBy, locator);
			if(checkPresence){
				try {
					int x = 0;
					do {
						if (element.isDisplayed()) {
							isPresent = true;
						} else {
							waitOnPage(driver,1);
							x = x + 1;
							isPresent = false;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {

				}	 
			}else
			{
				try {
					int x = 0;
					do {
						if (element.isDisplayed()) {
							Thread.sleep(1000);
							x = x + 1;
							isPresent = false;
						} else {
							isPresent = true;
						}
					} while (x < timeout && isPresent == false);

				} catch (Exception e) {

				}
			}
			return isPresent;

		}

		/********************************************************
		 *FUNCTION    :scrollDownTillEndpage
		 *AUTHOR      :
		 *DATE        :16-Jul-14
		 *DESCRIPTION :Function to scroll down till end of the page
		 *PAGE        :Re-usable component. 
		 ********************************************************/
		public void scrollDownTillEndpage()
		{
			try
			{
				Actions actions = new Actions(driver);
				actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				//report.updateTestLog("Scroll down", "Scroll down till page end", Status.DONE);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//report.updateTestLog("Scroll down", "Scroll down is not happened"+e.toString(), Status.FAIL);
			}
		}
		/********************************************************
		 *FUNCTION    :scrollUpTillToppage
		 *AUTHOR      :
		 *DATE        :16-Jul-14
		 *DESCRIPTION :Function to scroll up till top of the page
		 *PAGE        :Re-usable component. 
		 ********************************************************/
		public void scrollUpTillToppage()
		{
			try
			{
				Actions actions = new Actions(driver);
				actions.keyUp(Keys.CONTROL).sendKeys(Keys.UP).perform();
				//report.updateTestLog("Scroll Up", "Scroll Up till top of the page", Status.DONE);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//report.updateTestLog("Scroll Up", "Scroll Up is not happened"+e.toString(), Status.FAIL);
			}
		}
		/********************************************************
		 *FUNCTION    :navigatePreviousPage
		 *AUTHOR      :
		 *DATE        :18-Jul-14
		 *DESCRIPTION :Function to scroll up till top of the page
		 *PAGE        :Re-usable component. 
		 ********************************************************/
		public void navigatePreviousPage()
		{
			try
			{
				driver.navigate().back();
				//report.updateTestLog("Navigate Previous Page", "Navigated to previos page", Status.DONE);
			}
			catch(Exception e)
			{
				e.printStackTrace();
				//report.updateTestLog("Navigate Previous Page", "Not Navigated to previos page"+e.toString(), Status.FAIL);
			}
		}
		//#############################################################################
		//Function Name : isEnabled
		//Description : Function to check is element is enabled
		//Input Parameters : driver, identifier, locator
		//Return Value : boolean
		//Author : 
		//Date Created : 31-Jul-2014
		//#############################################################################
		public static boolean isEnabled(WebDriver driver, String identifyBy,
				String locator) {
			int timeout = 10;
			boolean isPresent = false;
			WebElement element=getWebElement1(driver, identifyBy, locator);
			try {
				int x = 0;
				do {
					if (element.isEnabled()) {
						isPresent = true;
					} else {
						waitOnPage(driver);
						x = x + 1;
						isPresent = false;
					}
				} while (x < timeout && isPresent == false);

			} catch (Exception e) {

			}
			return isPresent;

		}

		//#############################################################################
		// Function Name : getAttribute
		// Description : Function to get any property value of the element
		// Author : 
		// Date Created : 13-nov-2014
		// #############################################################################
		public static String  getAttribute(WebDriver driver, String identifyBy,
				String locator, String property) {
			String strText = null;
			WebElement element=getWebElement1(driver, identifyBy, locator);
			if (isElementPresent1(driver, identifyBy, locator)) {
				strText=element.getAttribute(property);
			}

			return strText;
		}

		public static void SelectValuefromDropDownByIndex(WebDriver driver, String identifyBy, String locator, String valuetoSelect)
		{
			WebElement element =getWebElement1(driver, identifyBy, locator);
			//select.sendKeys(value);
			if (isElementPresent1(driver, "id", locator)) {
				//	System.out.println("clicking radio button" +locator);
				Select select1 = new Select(element);
				select1.selectByIndex(Integer.parseInt(valuetoSelect));
			}
		}

		public static void SelectValuefromDropDownByVisibleText(WebDriver driver, String identifyBy, String locator, String valuetoSelect)
		{
				checkPresence1(5, driver, identifyBy, locator);
				WebElement element =getWebElement1(driver, identifyBy, locator);
				Select select1 = new Select(element);
				select1.selectByVisibleText(valuetoSelect);
			
		}
		/********************************************************
		 *FUNCTION    :getWebElement
		 *AUTHOR      :
		 *DATE        :07-July-17
		 *DESCRIPTION :Function to get web element from HTML tags
		 ********************************************************/ 

		public static WebElement getWebElement1(WebDriver driver, String identifyBy, String locator ) {
			WebElement element=null;
			if (identifyBy.equalsIgnoreCase("xpath")) {
				try {
					element=driver.findElement(By.xpath(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				try {
					element=driver.findElement(By.id(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				try {
					element=driver.findElement(By.name(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				try {
					element=driver.findElement(By.linkText(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}		
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				try {
					element=driver.findElement(By.partialLinkText(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				try {
					element=driver.findElement(By.cssSelector(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}	
			} else if (identifyBy.equalsIgnoreCase("className")) {
				try {
					element=driver.findElement(By.className(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}				
			}
			return element;
		}

		/********************************************************
		 *FUNCTION    :getWebElement
		 *AUTHOR      :
		 *DATE        :07-July-17
		 *DESCRIPTION :Function to get web element from HTML tags
		 ********************************************************/ 

		public static List<WebElement> getWebElements(WebDriver driver, String identifyBy,
				String locator ) {
			List<WebElement> elements=null;
			if (identifyBy.equalsIgnoreCase("xpath")) {
				try {
					elements=driver.findElements(By.xpath(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				try {
					elements=driver.findElements(By.id(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				try {
					elements=driver.findElements(By.name(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				try {
					elements=driver.findElements(By.linkText(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}		
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				try {
					elements=driver.findElements(By.partialLinkText(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				try {
					elements=driver.findElements(By.cssSelector(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}	
			} else if (identifyBy.equalsIgnoreCase("className")) {
				try {
					elements=driver.findElements(By.className(locator));
				} catch (Exception e) {
					System.out.println("Error in Webelement identifier :"+e.getMessage());
				}				
			}
			return elements;
		}



		// #############################################################################
		// Function Name : getListCount
		// Description : Function to get List Count
		// Input Parameters : Driver Object, Identifyby, Locator 
		// Return Value : List Count
		// Author : 
		// Date Created : 08/24/2012
		// #############################################################################
		public static int  getListCount(WebDriver driver, String identifyBy,
				String locator) {
			int intListCount = 0;
			if (identifyBy.equalsIgnoreCase("xpath")) {
				if (isElementPresent1(driver, "xpath", locator)) {
					List<WebElement> element=driver.findElements(By.xpath(locator));
					intListCount = element.size();
				}
			} else if (identifyBy.equalsIgnoreCase("id")) {
				if (isElementPresent1(driver, "id", locator)) {
					List<WebElement> element=driver.findElements(By.id(locator));
					intListCount = element.size();
				}
			} else if (identifyBy.equalsIgnoreCase("name")) {
				if (isElementPresent1(driver, "name", locator)) {
					List<WebElement> element=driver.findElements(By.name(locator));
					intListCount = element.size();
				}
			} else if (identifyBy.equalsIgnoreCase("cssSelector")) {
				if (isElementPresent1(driver, "cssSelector", locator)) {
					List<WebElement> element=driver.findElements(By.cssSelector(locator));
					intListCount = element.size();
				}
			} else if (identifyBy.equalsIgnoreCase("className")) {
				if (isElementPresent1(driver, "className", locator)) {
					List<WebElement> element=driver.findElements(By.className(locator));
					intListCount = element.size();
				}
			} else if (identifyBy.equalsIgnoreCase("linkText")) {
				if (isElementPresent1(driver, "linkText", locator)) {
					List<WebElement> element=driver.findElements(By.linkText(locator));
					intListCount = element.size();
				}
			} else if (identifyBy.equalsIgnoreCase("partialLinkText")) {
				if (isElementPresent1(driver, "partialLinkText", locator)) {
					List<WebElement> element=driver.findElements(By.partialLinkText(locator));
					intListCount = element.size();
				}
			}
			return intListCount;
		}


		/********************************************************
		 *FUNCTION    :explicitWait
		 *DATE        :30/05/14
		 *DESCRIPTION :Function to explicitWait
		 *PAGE        :Wait for expected element. 
		 ********************************************************/
		/*public void explicitWait(WebDriver driver, String identifyBy, String locator,String locatorname)
		{
			try
			{
				if(identifyBy.equalsIgnoreCase("id"))
				{
					WebElement elementCheck=(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
					if(elementCheck.isDisplayed())
					{
						//report.updateTestLog("Expected Element", "Expected element is present in page"+locatorname, Status.PASS);
					}
					else
						//report.updateTestLog("Expected Element", "Expected element is not present in page", Status.FAIL);
				
				if(identifyBy.equalsIgnoreCase("xpath"))
				{
					WebElement elementCheck1=(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
					if(elementCheck1.isDisplayed())
					{
						//report.updateTestLog("Expected Element", "Expected element is present in page"+locatorname, Status.PASS);
					}
					else
						//report.updateTestLog("Expected Element", "Expected element is not present in page", Status.FAIL);
				
				if(identifyBy.equalsIgnoreCase("linkText"))
				{
					WebElement elementCheck11=(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.linkText(locator)));
					if(elementCheck11.isDisplayed())
					{
						//report.updateTestLog("Expected Element", "Expected element is present in page"+locatorname, Status.PASS);
					}
					else
						//report.updateTestLog("Expected Element", "Expected element is not present in page", Status.FAIL);
				
				if(identifyBy.equalsIgnoreCase("name"))
				{
					WebElement elementCheck2=(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
					if(elementCheck2.isDisplayed())
					{
						//report.updateTestLog("Expected Element", "Expected element is present in page"+locatorname, Status.PASS);
					}
					else
						//report.updateTestLog("Expected Element", "Expected element is not present in page", Status.FAIL);
				
				if(identifyBy.equalsIgnoreCase("partialLinkText"))
				{
					WebElement elementCheck4=(new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(locator)));
					if(elementCheck2.isDisplayed())
					{
						//report.updateTestLog("Expected Element", "Expected element is present in page"+locatorname, Status.PASS);
					}
					else
					{
						//report.updateTestLog("Expected Element", "Expected element is not present in page", Status.FAIL);
				}
				}
				}
					
		
		*/

	

}
