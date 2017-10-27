package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting; 	

public class VTBStartPage {

	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	
	/***
	 * Constructor
	 */
	
	public VTBStartPage(WebDriver driver,Reporting report){
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

	/***
	 * Methods
	 */

	/*Select Age Eligibility i.e. Yes or No*/ 
	public void setAge(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("EligibleAge").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(ageEligibilityYesRadioButton, imgPath, "Age is Eligible");
		} else {
			browserAction.ScrollAndClickOnElement(ageEligibilityNoRadioButton, imgPath, "Age is not Eligible");
		}
	}
	
	/*Select Resident Eligibility i.e. Yes or No*/
	public void setResident(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("EligibleResident").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(residentEligibilityYesRadioButton, imgPath, "Resident is Eligible");
		} else {
			browserAction.ScrollAndClickOnElement(residentEligibilityNoRadioButton, imgPath, "Resident is not Eligible");
		}
	}
	
	/*Select Fatca Eligibility i.e. Yes or No*/
	public void setFatca(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("EligibleFATCA").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(fatcaEligibilityYesRadioButton, imgPath, "Fatca is Eligible");
		} else {
			browserAction.ScrollAndClickOnElement(fatcaEligibilityNoRadioButton, imgPath, "Fatca is not Eligible");
		}
	}
	
	/*Select Payment Eligibility i.e. Yes or No*/
	public void setPayment(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("EligiblePayment").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(currentAccountEligibilityYesRadioButton, imgPath, "Payment is Eligible");
		} else {
			browserAction.ScrollAndClickOnElement(currentAccountEligibilityNoRadioButton, imgPath, "Payment is not Eligible");
		}
	}
	
	/*Select Eligibility Criteria*/
	public void selectEligibility(LinkedHashMap <String,String> testCaseData) {
		setAge(testCaseData);
		setResident(testCaseData);
		setAge(testCaseData);
		setFatca(testCaseData);
		setPayment(testCaseData);
	}
	
	/*Select Account Type i.e. Individual Only, Joint Only or both an Individual or Joint Account*/
	public void selectCurrentAccountType(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Individual Account Only")) {
			browserAction.ScrollAndClickOnElement(individualAccountOnlyRadioButton, imgPath, "Individual Account Only has been selected");
		} else if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Joint Account Only")) {
			browserAction.ScrollAndClickOnElement(jointAccountOnlyRadioButton, imgPath, "Joint Account Only has been selected");
		} else if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Both an Individual and a Joint Account")) {
			browserAction.ScrollAndClickOnElement(bothAnIndividualAndAJointAccountRadioButton, imgPath, "Both an Individual and a Joint Account has been selected");
		}
	}
	
	/*Set Eligibility Criteria*/
	public void setEligilibiltyCriteria(LinkedHashMap <String,String> testCaseData) {

		browserAction.WaittoPageLoad();

		/*Selecting Eligibility Criteria*/
		selectEligibility(testCaseData);
		selectCurrentAccountType(testCaseData);
		browserAction.scrollToElement(startApplicationButton);
		browserAction.clickJS(startApplicationButton);
	}

}
