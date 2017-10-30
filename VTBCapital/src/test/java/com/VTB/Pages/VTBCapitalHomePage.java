package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;

public class VTBCapitalHomePage {
	
	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	
	/***
	 * Constructor
	 */
	
	public VTBCapitalHomePage(WebDriver driver,Reporting report){
		this.driver = driver;
        this.report = report;
        
        /*Initialize Elements*/
        PageFactory.initElements(driver, this);
        
        browserAction = new BrowserActions(driver, report);
        imgPath = report.imagePath;
   }
	
	/***
	 * Locators
	 */
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[1]")
	private WebElement interestRate1_60Button;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[2]")
	private WebElement interestRate2_20Button;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[3]")
	private WebElement interestRate2_60Button;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[4]")
	private WebElement interestRate3_90Button;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[5]")
	private WebElement interestRate3_10Button;

	
	/***
	 * Methods
	 */
	
	/*Choose Plan Type*/
	public void choosePlan(LinkedHashMap <String,String> testCaseData) {
		report.assertThat(browserAction.verifyPageTitle("Home"), driver.getTitle(),"Home","VTB capital has been opened succesfully", "opened application has different Title");
		if (testCaseData.get("PlanType").equalsIgnoreCase("120 Day Notice Account")) {
			browserAction.ScrollAndClickOnElement(interestRate1_60Button, imgPath, "Selecting 120 Day Notice Account");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("1 Year Fixed Term")) {
			browserAction.ScrollAndClickOnElement(interestRate2_20Button, imgPath, "Selecting 1 Year Fixed Term");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("2 Year Fixed Term")) {
			browserAction.ScrollAndClickOnElement(interestRate2_60Button, imgPath, "Selecting 2 Year Fixed Term");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("5 Year Tracker")) {
			browserAction.ScrollAndClickOnElement(interestRate3_90Button, imgPath, "Selecting 5 Year Tracker");
		} else {
			browserAction.ScrollAndClickOnElement(interestRate3_10Button, imgPath, "Selecting 3 Year Fixed Term");
		}
	}
	
	/*Select Plan*/
	public void selectPlanType(LinkedHashMap <String,String> testCaseData) 
	{
		browserAction.WaittoPageLoad();
		choosePlan(testCaseData);
	}
	
}
