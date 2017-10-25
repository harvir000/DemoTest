package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import functionLibrary.BrowserActions;
import reportingPckg.Reporting;
import utilsPckg.Excel;

public class VTBCapitalHomePage {
	
	WebDriver driver;
	Excel objExcel;
	Reporting report;
	BrowserActions browserAction;
	
	/*Constructor*/
	public VTBCapitalHomePage(WebDriver driver,Reporting report){
       this.driver=driver;
       this.report = report;
       //Initialise Element
       PageFactory.initElements(driver, this);
       browserAction = new BrowserActions(driver, report);
   }
	
	/*Locators*/
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

	
   /*Methods*/
	
	public void clickOnPlanType(WebElement element, String message) {
		//browserAction.scrollToElement(element);
		browserAction.click(element, report.imagePath, message);
	}
	
	public void selectPlanType(String rowValue) throws Exception {
		
		objExcel		=	new Excel();
		
	/*Getting Data from Test Data sheet*/
		LinkedHashMap <String,String> testCaseData	= objExcel.getTestCaseData(rowValue);
		
		browserAction.WaittoPageLoad();
		
		if (testCaseData.get("PlanType").equalsIgnoreCase("120 Days Notice Account")) {
			clickOnPlanType(interestRate1_60Button, "Selecting 120 Days Notice Account");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("1 Year Fixed Term")) {
			clickOnPlanType(this.interestRate2_20Button, "Selecting 1 Year Fixed Term");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("2 Year Fixed Term")) {
			clickOnPlanType(this.interestRate2_60Button, "Selecting 2 Year Fixed Term");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("5 Year Tracker")) {
			clickOnPlanType(this.interestRate3_90Button, "Selecting 5 Year Tracker");
		} else {
			clickOnPlanType(this.interestRate3_10Button, "Selecting 3 Year Fixed Term");
		}
	}
	
}
