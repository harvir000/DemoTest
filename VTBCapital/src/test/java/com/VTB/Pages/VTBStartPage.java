package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import functionLibrary.BrowserActions;
import reportingPckg.Reporting;
import utilsPckg.Excel;

public class VTBStartPage {
	
	WebDriver driver;
	Excel objExcel;
	WebDriverWait wait;
	Reporting report;
	BrowserActions browserAction;
	
	/*Constructor*/
	public VTBStartPage(WebDriver driver,Reporting report){
		this.driver=driver;
	    this.report = report;
	    //Initialise Element
	    PageFactory.initElements(driver, this);
	    browserAction = new BrowserActions(driver, report);
   }

	/*Locators*/
	@FindBy(how = How.CSS, using = "input#optionsRadios1")
	private WebElement ageEligibilityYesRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios2")
	private WebElement ageEligibilityNoRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios3")
	private WebElement residentEligibilityYesRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios4")
	private WebElement residentEligibilityNoRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios5")
	private WebElement fatcaEligibilityYesRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios6")
	private WebElement fatcaEligibilityNoRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios7")
	private WebElement currentAccountEligibilityYesRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios8")
	private WebElement currentAccountEligibilityNoRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios9")
	private WebElement individualAccountOnlyRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios10")
	private WebElement jointAccountOnlyRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios11")
	private WebElement bothAnIndividualAndAJointAccountRadioButton;
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default cta2']")
	private WebElement loginButton;
	
	@CacheLookup
	@FindBy(how = How.CSS, using = "button#begin")
	private WebElement startApplicationButton;
	
   /*Methods*/
	
	public void selectCriteria(WebElement element, String message) {
		browserAction.scrollToElement(element);
		browserAction.clickJS(element, report.imagePath, message);
	}
	
	public void setEligilibiltyCriteria(String rowValue) throws Exception {
		
		browserAction.WaittoPageLoad();
		
		objExcel	=	new Excel();
		
	/*Getting Data from Test Data sheet*/
		LinkedHashMap <String,String> testCaseData	= objExcel.getTestCaseData(rowValue);
		
	/*Setting Eligibility Criteria*/	
		if (testCaseData.get("EligibleAge").equalsIgnoreCase("Yes")) {
			selectCriteria(this.ageEligibilityYesRadioButton, "Age is Eligible");
		} else {
			selectCriteria(this.ageEligibilityNoRadioButton, "Age is not Eligible");
		}
		
		if (testCaseData.get("EligibleResident").equalsIgnoreCase("Yes")) {
			selectCriteria(this.residentEligibilityYesRadioButton, "Resident is Eligible");
		} else {
			selectCriteria(this.residentEligibilityNoRadioButton, "Resident is not Eligible");
		}
		
		if (testCaseData.get("EligibleAge").equalsIgnoreCase("Yes")) {
			selectCriteria(this.ageEligibilityYesRadioButton, "Age is Eligible");
		} else {
			selectCriteria(this.ageEligibilityNoRadioButton, "Age is not Eligible");
		}
		
		if (testCaseData.get("EligibleFATCA").equalsIgnoreCase("Yes")) {
			selectCriteria(this.fatcaEligibilityYesRadioButton, "Fatca is Eligible");
		} else {
			selectCriteria(this.fatcaEligibilityNoRadioButton, "Fatca is not Eligible");
		}
		
		if (testCaseData.get("EligiblePayment").equalsIgnoreCase("Yes")) {
			selectCriteria(this.currentAccountEligibilityYesRadioButton, "Payment is Eligible");
		} else {
			selectCriteria(this.currentAccountEligibilityNoRadioButton, "Payment is not Eligible");
		}
		
		if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Individual Account Only")) {
			selectCriteria(this.individualAccountOnlyRadioButton, "Individual Account Only has been selected");
		} else if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Joint Account Only")) {
			selectCriteria(this.jointAccountOnlyRadioButton, "Joint Account Only has been selected");
		} else if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Both an Individual and a Joint Account")) {
			selectCriteria(this.bothAnIndividualAndAJointAccountRadioButton, "Both an Individual and a Joint Account has been selected");
		}
		
		selectCriteria(this.startApplicationButton, "Seleting Start Application");
	}
	
}
