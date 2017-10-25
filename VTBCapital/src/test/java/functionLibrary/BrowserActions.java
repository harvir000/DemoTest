package functionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import reportingPckg.Reporting;

public class BrowserActions {
	
	public WebDriver driver;
	public JavascriptExecutor jse;
	public Reporting report; 
	
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
			driver.findElement(By.xpath("(//a[@href='120-day-notice-account.html'])")).click();
			driver.findElement(By.xpath("(//div[@class='col-lg-12 col-md-12 col-sm-12 col-xs-12 light-blue-2 module-content'])[1]")).click();
			element.click();
			report.extentReportlogSteps_Update(LogStatus.INFO, "Click", message, imagePath, element);
			click = "true";
		} catch (Exception e) {
			report.extentReportlogSteps_Update(LogStatus.FAIL, "Click", message, imagePath, element);
			System.out.println("Unable to perform click");
		}
		return click;
	}
	
	public String clickJS(WebElement element, String imagePath, String message) {
		
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
			element.sendKeys(value);
			report.extentReportlogSteps_Update(LogStatus.INFO, "Text Entered", message, imagePath, element);
		} catch (Exception e) {
			report.extentReportlogSteps_Update(LogStatus.FAIL, "Text Entered", message, imagePath, element);
			System.out.println("Unable to set text");
		}
	}
	
	public void clearText(WebElement element) {
		element.clear();
	}
	
	public void sendTab(WebElement element) {
		element.sendKeys(Keys.TAB);
	}

}

