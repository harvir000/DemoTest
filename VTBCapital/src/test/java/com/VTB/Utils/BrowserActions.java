package com.VTB.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class BrowserActions {

	public WebDriver driver;
	public JavascriptExecutor jse;
	public Reporting report;
	public WebDriverWait wait;
	
	
	/***
	 * Constructor
	 * @param driver
	 * @param report
	 */
	public BrowserActions(WebDriver driver, Reporting report) {
		this.driver = driver;
		this.report = report;
		
		jse = (JavascriptExecutor)driver;
	}
	
	/**
	 * function for waiting Page Load to complete
	 */
	public void WaittoPageLoad()
	{
		// Below line of code will wait till page loaded completely
		Boolean readyStateComplete = false;
		try {
			while (!readyStateComplete)
			{
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				readyStateComplete = ((String) executor.executeScript("return document.readyState")).equals("complete");
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
	}
	
	/***
	 * function to click on a WebElement
	 * @param element
	 * @param imagePath
	 * @param message
	 * @return
	 */
	public String click(WebElement element, String imagePath, String message) {

		String click = "false";

		try {
			element.click();
			report.logStepToReport(LogStatus.INFO, "Click", message, imagePath, element);
			click = "true";
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Click", message, imagePath, element);
			System.out.println("Unable to perform click");
		}
		return click;
	}
	
	/***
	 * function to click using JavaScriptExecuter
	 * @param element
	 * @param imagePath
	 * @param message
	 * @return
	 */
	public String clickJS(WebElement element, String imagePath, String message)
	{

		String click = "false";

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
			
			report.logStepToReport(LogStatus.INFO, "Click", message, imagePath, element);
			click = "true";
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Click", message, imagePath, element);
			System.out.println("Unable to perform click");
		}
		return click;
	}
	
	/***
	 * function to click using JavaScriptExecuter
	 * @param element
	 * @param imagePath
	 * @param message
	 * @return
	 */
	public String clickJS(WebElement element)
	{

		String click = "false";

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
			click = "true";
		} catch (Exception e) 
		{	
			report.logStepToReport(LogStatus.FAIL, "JS Click", e.getMessage(), report.imagePath, element);
			System.out.println("Unable to perform click");
		}
		return click;
	}
	
	/***
	 * function to Scroll to element using JavaScriptExecuter
	 * @param element
	 */
	public void scrollToElement(WebElement element) {
		try{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
		}
		catch(Exception e){
			report.logStepToReport(LogStatus.FAIL, "JS Scroll", e.getMessage(), report.imagePath, element);
			System.out.println("Unable to perform scroll.");
		}
	}
	
	/***
	 * function to get text from an element 
	 * @param element
	 * @return
	 */
	public String getText(WebElement element) {

		String elementText = null;

		try {
			elementText = element.getText();
		} catch(Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Get Text", e.getMessage(), report.imagePath, element);
			System.out.println("Unable to get Element's Text");
		}

		return elementText;
	}
	
	/***
	 * function to set text in the field
	 * @param element
	 * @param value
	 * @param imagePath
	 * @param message
	 */
	public void setText(WebElement element, String value, String imagePath, String message) {
		try {
			element.sendKeys(value);
			report.logStepToReport(LogStatus.INFO, "Text Entered", message, imagePath, element);
		} catch (Exception e) {
			report.logStepToReport(LogStatus.FAIL, "Text Entered", message, imagePath, element);
			System.out.println("Unable to set text "+e);
		}
	}
	
	/***
	 * function to clear text from the field
	 * @param element
	 */
	public void clearText(WebElement element) {
		element.clear();
	}
	
	/***
	 * function to send TAB key
	 * @param element
	 */
	public void sendTab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	/***
	 * function to wait explicitly for an element to be clickable
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitForElement(WebElement element) throws InterruptedException
	{
		wait	= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/***
	 * function to wait explicitly for an element
	 * @param element
	 * @param time
	 * @throws InterruptedException 
	 */
	public void waitForElement(WebElement element,int time) throws InterruptedException
	{
		waitForElement(element);
	}
	
	/***
	 * function to Scroll and Click on element
	 * @param element
	 * @param imgPath
	 * @param message
	 */
	public void ScrollAndClickOnElement(WebElement element, String imgPath, String message) {
		scrollToElement(element);
		clickJS(element, imgPath, message);
	}
	
	/***
	 * function to Scroll on element and set text in field
	 * @param element
	 * @param value
	 * @param imgPath
	 * @param message
	 */
	public void ScrollAndSetText(WebElement element, String value, String imgPath, String message) 
	{
		scrollToElement(element);
		setText(element, value, imgPath, message);
	}
	
	/***
	 * function to select value from Drop Down
	 * @param element
	 * @param value
	 */
	public void selectFromDD(WebElement element, String value)
	{
		try {
			Select select = new Select(element);
			select.selectByVisibleText(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public boolean verifyPageTitle(String title)
	{
		
		return driver.getTitle().trim().contains(title);
		
	}

}

