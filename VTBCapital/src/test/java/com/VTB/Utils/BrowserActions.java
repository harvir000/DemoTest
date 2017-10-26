package com.VTB.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

public class BrowserActions {

	public WebDriver driver;
	public JavascriptExecutor jse;
	public Reporting report;
	WebDriverWait wait;

	public BrowserActions(WebDriver driver, Reporting report) {
		this.driver = driver;
		this.report = report;
		jse = (JavascriptExecutor)driver;
	}

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

	public String click(WebElement element, String imagePath, String message) {

		String click = "false";

		try {
			element.click();
			report.extentReportlogSteps_Update(LogStatus.INFO, "Click", message, imagePath, element);
			click = "true";
		} catch (Exception e) {
			report.extentReportlogSteps_Update(LogStatus.FAIL, "Click", message, imagePath, element);
			System.out.println("Unable to perform click");
		}
		return click;
	}

	public String clickJS(WebElement element, String imagePath, String message)
	{

		String click = "false";

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);

			report.extentReportlogSteps_Update(LogStatus.INFO, "Click", message, imagePath, element);
			click = "true";
		} catch (Exception e) {
			report.extentReportlogSteps_Update(LogStatus.FAIL, "Click", message, imagePath, element);
			System.out.println("Unable to perform click");
		}
		return click;
	}



	public String clickJS(WebElement element)
	{

		String click = "false";

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
			click = "true";
		} catch (Exception e) 
		{	
			System.out.println("Unable to perform click");
		}
		return click;
	}

	public void scrollToElement(WebElement element) {
		try{
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
		}
		catch(Exception e){
			System.out.println("Unable to perform scroll.");
		}
	}

	public String getText(WebElement element) {

		String elementText = null;

		try {
			elementText = element.getText();
		} catch(Exception e) {
			System.out.println("Unable to get Element's Text");
		}

		return elementText;
	}

	public void setText(WebElement element, String value, String imagePath, String message) {
		try {

			if(driver.toString().contains("ANDROID"))
			{
				Actions action=new Actions(driver);
				action.moveToElement(element).click().sendKeys(value).build().perform();
			}
			else
			{

				element.sendKeys(value);
			}
			report.extentReportlogSteps_Update(LogStatus.INFO, "Text Entered", message, imagePath, element);
		} catch (Exception e) {
			report.extentReportlogSteps_Update(LogStatus.FAIL, "Text Entered", message, imagePath, element);
			System.out.println("Unable to set text "+e);
		}
	}

	public void clearText(WebElement element) {
		element.clear();
	}

	public void sendTab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

	/**
	 * 
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitForElement(WebElement element) throws InterruptedException
	{
		Thread.sleep(5000);// just for temp
		/*	wait	= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));*/
	}
	/**
	 * 
	 * @param element
	 * @param time
	 * @throws InterruptedException 
	 */
	public void waitForElement(WebElement element,int time) throws InterruptedException
	{
		waitForElement(element);
	}


	public void ScrollAndClickOnElement(WebElement element, String imgPath, String message) {
		scrollToElement(element);
		clickJS(element, imgPath, message);
	}


	public void ScrollAndSetText(WebElement element, String value, String imgPath, String message) 
	{
		scrollToElement(element);
		setText(element, value, imgPath, message);
	}

	/**
	 * to select value from drop down
	 */

	public void selectFromDD(WebElement element, String value)
	{
		try
		{

			/*if(driver.toString().contains("ANDROID"))	
			{
				element.sendKeys(value);
			}
			else
			{*/
				Select select =new Select(element);
				select.selectByVisibleText(value);
			//}
		}
		catch(Exception e)
		{


		}


	}

}

