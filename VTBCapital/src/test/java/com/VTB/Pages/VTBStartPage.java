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

	/***
	 * function to Select Age Eligibility i.e. Yes or No
	 * @param testCaseData
	 */
	public void setAge(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("EligibleAge").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(ageEligibilityYesRadioButton, imgPath, "Selecting Age Eligibility as 'Yes'");
//			browserAction.clickJS(ageEligibilityYesRadioButton);
		} else {
			browserAction.ScrollAndClickOnElement(ageEligibilityNoRadioButton, imgPath, "Selecting Age Eligibility as 'No'");
		}
	}
	
	/***
	 * function to Select Resident Eligibility i.e. Yes or No
	 * @param testCaseData
	 */
	public void setResident(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("EligibleResident").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(residentEligibilityYesRadioButton, imgPath, "Selecting Resident Eligibility as 'Yes'");
//			browserAction.clickJS(residentEligibilityYesRadioButton);
		} else {
			browserAction.ScrollAndClickOnElement(residentEligibilityNoRadioButton, imgPath, "Selecting Resident Eligibility as 'No'");
		}
	}
	
	/***
	 * function to Select Fatca Eligibility i.e. Yes or No
	 * @param testCaseData
	 */
	public void setFatca(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("EligibleFATCA").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(fatcaEligibilityYesRadioButton, imgPath, "Selecting Fatca Eligibility as 'Yes'");
//			browserAction.clickJS(fatcaEligibilityYesRadioButton);
		} else {
			browserAction.ScrollAndClickOnElement(fatcaEligibilityNoRadioButton, imgPath, "Selecting Fatca Eligibility as 'No'");
		}
	}
	
	/***
	 * function to Select Payment Eligibility i.e. Yes or No
	 * @param testCaseData
	 */
	public void setPayment(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("EligiblePayment").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(currentAccountEligibilityYesRadioButton, imgPath, "Selecting Payment Eligibility as 'Yes'");
//			browserAction.clickJS(currentAccountEligibilityYesRadioButton);
		} else {
			browserAction.ScrollAndClickOnElement(currentAccountEligibilityNoRadioButton, imgPath, "Selecting Payment Eligibility as 'No'");
		}
	}
	
	/***
	 * function to Select Eligibility
	 * @param testCaseData
	 * @throws InterruptedException 
	 */
	public void selectEligibility(LinkedHashMap <String,String> testCaseData) {
		setAge(testCaseData);
		setResident(testCaseData);
		setAge(testCaseData);
		setFatca(testCaseData);
		setPayment(testCaseData);
//		report.assertThat(verifyEligibilityCriteria(), verifyEligibilityCriteria()+"", "true", "Eligibility Criteria has been selected successfully", "Eligibility Criteria has not been selected successfully");
		report.assertThat(verifyEligibilityCriteria(), "Eligibility Criteria has been selected successfully", "Eligibility Criteria has not been selected successfully");
	}
	
	/***
	 * function to Select Account Type i.e. Individual Only, Joint Only or both an Individual or Joint Account
	 * @param testCaseData
	 */
	public void selectCurrentAccountType(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Individual Account Only")) {
			browserAction.ScrollAndClickOnElement(individualAccountOnlyRadioButton, imgPath, "Individual Account Only has been selected");
//			report.assertThat(individualAccountOnlyRadioButton.isSelected(), individualAccountOnlyRadioButton.isSelected()+"", "true", "Individual Account Only button has been selected successfully", "Individual Account Only button has not been selected successfully");
			report.assertThat(individualAccountOnlyRadioButton.isSelected(), "Individual Account Only button has been selected successfully", "Individual Account Only button has not been selected successfully");
		} else if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Joint Account Only")) {
			browserAction.ScrollAndClickOnElement(jointAccountOnlyRadioButton, imgPath, "Joint Account Only has been selected");
//			report.assertThat(jointAccountOnlyRadioButton.isSelected(), jointAccountOnlyRadioButton.isSelected()+"", "true", "Joint Account Only button has been selected successfully", "Joint Account Only button has not been selected successfully");
			report.assertThat(jointAccountOnlyRadioButton.isSelected(), "Joint Account Only button has been selected successfully", "Joint Account Only button has not been selected successfully");
		} else if (testCaseData.get("CurrentAccountWithVTBCapital").equalsIgnoreCase("Both an Individual and a Joint Account")) {
			browserAction.ScrollAndClickOnElement(bothAnIndividualAndAJointAccountRadioButton, imgPath, "Both an Individual and a Joint Account has been selected");
//			report.assertThat(bothAnIndividualAndAJointAccountRadioButton.isSelected(), bothAnIndividualAndAJointAccountRadioButton.isSelected()+"", "true", "Both an Individual Account and a Joint Account button has been selected successfully", "Both an Individual Account and a Joint Account button has not been selected successfully");
			report.assertThat(bothAnIndividualAndAJointAccountRadioButton.isSelected(), "Both an Individual Account and a Joint Account button has been selected successfully", "Both an Individual Account and a Joint Account button has not been selected successfully");
		}
	}
	
	/***
	 * function to Select Eligibility Criteria
	 * @param testCaseData
	 */
	public void setEligilibiltyCriteria(LinkedHashMap <String,String> testCaseData) {

		verifyStartPageTitle();
		/*Selecting Eligibility Criteria*/
		selectEligibility(testCaseData);
		selectCurrentAccountType(testCaseData);
		browserAction.scrollToElement(startApplicationButton);
		browserAction.clickJS(startApplicationButton);
	}
	
	/***
	 * function to verify the Start page title
	 */
	public void verifyStartPageTitle() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browserAction.WaittoPageLoad();
//		report.assertThat(browserAction.verifyPageTitle("VTB Capital Direct | Apply | Start page"), driver.getTitle(),"VTB Capital Direct | Apply | Start Page","VTB Start Page has been opened succesfully", "opened Page has different Title");
		report.assertThat(browserAction.verifyPageTitle("VTB Capital Direct | Apply | Start page"), "VTB Start Page has been opened succesfully", "VTB Start Page has different Title");
	}

	/**
	 * function to verify eligible criteria is selected 
	 */
	public boolean verifyEligibilityCriteria()
	{
		boolean dataToBeReturn = false;
		if(ageEligibilityYesRadioButton.isSelected() && residentEligibilityYesRadioButton.isSelected()
				&& fatcaEligibilityYesRadioButton.isSelected() && currentAccountEligibilityYesRadioButton.isSelected())
		{
			dataToBeReturn = true;
		}
		return dataToBeReturn;
	}
}
