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
	
	/*Constructor*/
	public VTBCapitalHomePage(WebDriver driver,Reporting report){
       this.driver=driver;
       this.report = report;
       //Initialise Element
       PageFactory.initElements(driver, this);
       browserAction = new BrowserActions(driver, report);
       imgPath = report.imagePath;
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
	
	public void clickOnPlan(WebElement element, String message) {
		browserAction.scrollToElement(element);
		browserAction.clickJS(element, imgPath, message);
	}
	
	public void choosePlan(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("PlanType").equalsIgnoreCase("120 Days Notice Account")) {
			clickOnPlan(interestRate1_60Button, "Selecting 120 Days Notice Account");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("1 Year Fixed Term")) {
			clickOnPlan(interestRate2_20Button, "Selecting 1 Year Fixed Term");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("2 Year Fixed Term")) {
			clickOnPlan(interestRate2_60Button, "Selecting 2 Year Fixed Term");
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("5 Year Tracker")) {
			clickOnPlan(interestRate3_90Button, "Selecting 5 Year Tracker");
		} else {
			clickOnPlan(interestRate3_10Button, "Selecting 3 Year Fixed Term");
		}
	}
	
	public void selectPlanType(LinkedHashMap <String,String> testCaseData) {
		
		browserAction.WaittoPageLoad();
		choosePlan(testCaseData);
	}
	
}
