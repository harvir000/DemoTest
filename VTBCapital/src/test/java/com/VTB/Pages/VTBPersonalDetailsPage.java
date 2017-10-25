package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import functionLibrary.BrowserActions;
import reportingPckg.Reporting;
import utilsPckg.Excel;

public class VTBPersonalDetailsPage {
	
	WebDriver driver;
	Excel objExcel;
	WebDriverWait wait;
	Reporting report;
	BrowserActions browserAction;
	
	/*Constructor*/
	public VTBPersonalDetailsPage(WebDriver driver,Reporting report){
		this.driver=driver;
      	this.report = report;
      	//Initialise Element
      	PageFactory.initElements(driver, this);
      	browserAction = new BrowserActions(driver, report);
   }

	/*Locators*/
	
	/*Title*/
	@FindBy(how = How.CSS, using = "#AA")
	private WebElement titleMrRadioButton;
	
	@FindBy(how = How.CSS, using = "#AB")
	private WebElement titleMrsRadioButton;
	
	@FindBy(how = How.CSS, using = "#AC")
	private WebElement titleMissRadioButton;
	
	@FindBy(how = How.CSS, using = "#Z1")
	private WebElement titleMsRadioButton;
	
	@FindBy(how = How.CSS, using = "#Z2")
	private WebElement titleMxRadioButton;
	
	@FindBy(how = How.CSS, using = "#otherTitle")
	private WebElement titleOtherRadioButton;
	
	@FindBy(how = How.CSS, using = "#titles")
	private WebElement selectOtherTitleField;
	
	/*First Name and Surname*/
	@FindBy(how = How.CSS, using = "#givenName")
	private WebElement FirstNameField;
	
	@FindBy(how = How.CSS, using = "#familyName")
	private WebElement SurnameField;
	
	/*Day, Month and Year*/
	@FindBy(how = How.CSS, using = "#day")
	private WebElement dobDayField;

	@FindBy(how = How.CSS, using = "#month")
	private WebElement dobMonthField;

	@FindBy(how = How.CSS, using = "#year")
	private WebElement dobYearField;
	
	/*City of Birth and Country of Birth*/
	@FindBy(how = How.CSS, using = "#placeOfBirth")
	private WebElement cityOfBirthField;

	@FindBy(how = How.CSS, using = "#countryOfBirth")
	private WebElement countryOfBirthField;
	
	/*Tax information*/
	@FindBy(how = How.CSS, using = "#tax_yes")
	private WebElement taxInformationYesRadioButton;

	@FindBy(how = How.CSS, using = "#tax_no")
	private WebElement taxInformationNoRadioButton;

	@FindBy(how = How.CSS, using = "#countryTax1")
	private WebElement taxInformationCountryField;

	@FindBy(how = How.CSS, using = "#taxNumber1")
	private WebElement taxInformationTaxNumberField;
	
	/*Current Address*/
	@FindBy(how = How.CSS, using = "#houseNo")
	private WebElement currentAddressHouseNumberField;

	@FindBy(how = How.CSS, using = "#postcode-for-search")
	private WebElement currentAddressPostCodeField;

	@FindBy(how = How.CSS, using = "#get-address-btn")
	private WebElement currentFindAddressButton;

	@FindBy(how = How.CSS, using = "#address")
	private WebElement currentSelectedAddressField;

	@FindBy(how = How.CSS, using = "#flatNumber")
	private WebElement currentFlatNumberField;

	@FindBy(how = How.CSS, using = "#buildingNumber")
	private WebElement currentBuildingNumberField;

	@FindBy(how = How.CSS, using = "#buildingName")
	private WebElement currentBuildingNameField;

	@FindBy(how = How.CSS, using = "#street")
	private WebElement currentStreetField;

	@FindBy(how = How.CSS, using = "#city")
	private WebElement currentCityField;

	@FindBy(how = How.CSS, using = "#postcode")
	private WebElement currentPostCodeField;
	
	/*Living Eligibility*/
	@FindBy(how = How.CSS, using = "#optionsRadios1")
	private WebElement livingEligibilityYesRadioButton;

	@FindBy(how = How.CSS, using = "#optionsRadios2")
	private WebElement livingEligibilityNoRadioButton;
	
	/*Previous Address*/
	@FindBy(how = How.CSS, using = "#secound-houseNo")
	private WebElement previousAddressHouseNumberField;

	@FindBy(how = How.CSS, using = "#secound-postcode-for-search")
	private WebElement previousAddressPostCodeField;

	@FindBy(how = How.CSS, using = "#get-address-btn1")
	private WebElement previousFindAddressButton;

	@FindBy(how = How.CSS, using = "#selectAddress1")
	private WebElement previousSelectedAddressField;

	@FindBy(how = How.CSS, using = "#flatNumber1")
	private WebElement previousFlatNumberField;

	@FindBy(how = How.CSS, using = "#buildingNumber1")
	private WebElement previousBuildingNumberField;

	@FindBy(how = How.CSS, using = "#buildingName1")
	private WebElement previousBuildingNameField;

	@FindBy(how = How.CSS, using = "#street1")
	private WebElement previousStreetField;

	@FindBy(how = How.CSS, using = "#secound-city")
	private WebElement previousCityField;

	@FindBy(how = How.CSS, using = "#secound-postcode")
	private WebElement previousPostCodeField;
	
	/*Email and Mobile*/
	@FindBy(how = How.CSS, using = "#email")
	private WebElement emailAddressField;

	@FindBy(how = How.CSS, using = "#mobile")
	private WebElement mobileNumberField;

	@FindBy(how = How.CSS, using = "#alternatePhone")
	private WebElement alternatePhoneNumberField;
	
	/*Security questions and answers*/
	@FindBy(how = How.CSS, using = "#securityQuestion1")
	private WebElement securityQuestion1Field;

	@FindBy(how = How.CSS, using = "#answer1")
	private WebElement securityAnswer1Field;

	@FindBy(how = How.CSS, using = "#securityQuestion2")
	private WebElement securityQuestion2Field;

	@FindBy(how = How.CSS, using = "#answer2")
	private WebElement securityAnswer2Field;
	
	/*Pin, Nominated Account Number and Sort Code*/	
	@FindBy(how = How.CSS, using = "#pin")
	private WebElement pinField;

	@FindBy(how = How.CSS, using = "#accountNumber")
	private WebElement nominatedAccountNumberField;

	@FindBy(how = How.CSS, using = "#sortCode")
	private WebElement nominatedSortCodeField;
	
	/*Interest Payment*/
	@FindBy(how = How.CSS, using = "#interestPayment_monthly")
	private WebElement monthlyInterestPaymentRadioButton;

	@FindBy(how = How.CSS, using = "#interestPayment_annually")
	private WebElement annuallyInterestPaymentRadioButton;

	@FindBy(how = How.CSS, using = "#paymentAccount")
	private WebElement paymentAccountField;
	
	/*Confirmation*/
	@FindBy(how = How.CSS, using = "#marketing_yes")
	private WebElement emailConfirmationRadioButton;

	@FindBy(how = How.CSS, using = "#marketing_no")
	private WebElement mobileConfirmationRadioButton;

	@FindBy(how = How.CSS, using = "#terms")
	private WebElement termAndCondition1RadioButton;

	@FindBy(how = How.CSS, using = "#agree")
	private WebElement termAndCondition2RadioButton;

	@FindBy(how = How.CSS, using = "#submit_applicationForm")
	private WebElement continueSecurelyRadioButton;
	
   /*Methods*/

	public void selectCriteria(WebElement element, String message){
		browserAction.clickJS(element, report.imagePath, message);
	}
	
	public void enterText(WebElement element, String value, String message) {
		browserAction.setText(element, value, report.imagePath, message);
	}
	
	public void clickOnContinueSecurely(WebElement element, String message) {
		browserAction.scrollToElement(element);
		browserAction.clickJS(element, report.imagePath, message);
	}
	
	
	/*Enter Personal Details*/
	public void enterPersonalDetails(String rowValue) throws Exception {
		
		browserAction.WaittoPageLoad();
		
		objExcel	=	new Excel();
		
	/*Getting Data from Test Data sheet*/
		LinkedHashMap <String,String> testCaseData	= objExcel.getTestCaseData(rowValue);
		
	/*Selecting Title*/
		if (testCaseData.get("Title").equalsIgnoreCase("Mr")) {
			selectCriteria(this.titleMrRadioButton, "Mr. Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("Mrs")) {
			selectCriteria(this.titleMrsRadioButton, "Mrs. Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("Miss")) {
			selectCriteria(this.titleMissRadioButton, "Miss Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("Ms")) {
			selectCriteria(this.titleMsRadioButton, "Ms Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("Mx")) {
			selectCriteria(this.titleMxRadioButton, "Mx Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("other")) {
			selectCriteria(this.titleOtherRadioButton, "Other Title has been selected");
		}
		
	/*Setting FirstName and Surname*/
		enterText(this.FirstNameField, testCaseData.get("FirstName"), "FirstName has been entered");
		enterText(this.SurnameField, testCaseData.get("Surname"), "Surname has been entered");
		
	/*Setting Date of Birth*/
		enterText(this.dobDayField, testCaseData.get("Day"), "Day has been entered");
		enterText(this.dobMonthField, testCaseData.get("Month"), "Month has been entered");
		enterText(this.dobYearField, testCaseData.get("Year"), "Year has been entered");
		
	/*Setting City of Birth and Country of Birth*/
		enterText(this.cityOfBirthField, testCaseData.get("CityOfBirth"), "City of Birth has been entered");
		enterText(this.countryOfBirthField, testCaseData.get("CountryOfBirth"), "Country of Birth has been entered");
		
	/*Setting Tax Information*/
		if (testCaseData.get("TaxInformation").equalsIgnoreCase("no")) {
			selectCriteria(this.taxInformationNoRadioButton, "No Tax Information is selected");
		} else {
			selectCriteria(this.taxInformationYesRadioButton, "Yes Tax Information is selected");
			enterText(this.taxInformationCountryField, testCaseData.get("TaxCountry"), "Tax Country has been entered");
			enterText(this.taxInformationTaxNumberField, testCaseData.get("TaxNumber"), "Tax Number has been entered");
		}
		
	/*Setting Current Address*/	
		enterText(this.currentAddressHouseNumberField, testCaseData.get("CurrentHouseNumber"), "Current Address's House Number has been entered");
		enterText(this.currentAddressPostCodeField, testCaseData.get("CurrentPostCode"), "Current Address's Post Code has been entered");
		selectCriteria(this.currentFindAddressButton, "Find Address has been selected");
		enterText(this.currentSelectedAddressField, testCaseData.get("CurrentSelectedAddress"), "Current Selected Address has been entered");
//		browserAction.sendTab(currentSelectedAddressField);
		browserAction.clearText(currentFlatNumberField);
		enterText(this.currentFlatNumberField, testCaseData.get("CurrentFlatNumber"), "Current Address's Flat Number has been entered");
		browserAction.clearText(currentBuildingNumberField);
		enterText(this.currentBuildingNumberField, testCaseData.get("CurrentBuildingNumber"), "Current Address's Building Number has been entered");
		
	/*Setting Living Eligibility*/
		if (testCaseData.get("LivingEligibility").equalsIgnoreCase("yes")) {
			selectCriteria(this.livingEligibilityYesRadioButton, "Customer satisfied Living Eligible Criteria");
		} else {
			selectCriteria(this.livingEligibilityNoRadioButton, "Customer does not satisfy Living Eligible Criteria");
			
			/*Setting Previous Address*/
			enterText(this.previousAddressHouseNumberField, testCaseData.get("PreviousHouseNumber"), "Previous Address's House Number has been entered");
			enterText(this.previousAddressPostCodeField, testCaseData.get("PreviousPostCode"), "Previous Address's Post Code has been entered");
			selectCriteria(this.previousFindAddressButton, "Find Address has been selected");
			enterText(this.previousSelectedAddressField, testCaseData.get("PreviousSelectedAddress"), "Previous Selected Address has been entered");
			enterText(this.previousFlatNumberField, testCaseData.get("PreviousFlatNumber"), "Previous Address's Flat Number has been entered");
			enterText(this.previousBuildingNumberField, testCaseData.get("PreviousBuildingNumber"), "Previous Address's Building Number has been entered");
		}
		
	/*Setting	Email and Mobile Number*/
		enterText(this.emailAddressField, testCaseData.get("EmailAddress"), "Email has been entered");
		enterText(this.mobileNumberField, testCaseData.get("MobileNumber"), "Mobile has been entered");
		
	/*Setting Security Questions and Answers*/
		enterText(this.securityQuestion1Field, testCaseData.get("SecurityQuestion1"), "Security Question 1 has been entered");
		enterText(this.securityAnswer1Field, testCaseData.get("SecurityAnswer1"), "Security Answer 1 has been entered");
		enterText(this.securityQuestion2Field, testCaseData.get("SecurityQuestion2"), "Security Question 2 has been entered");
		enterText(this.securityAnswer2Field, testCaseData.get("SecurityAnswer2"), "Security Answer 2 has been entered");
		
	/*Setting Pin, Nominated Account Number and Nominated SortCode*/
		enterText(this.pinField, testCaseData.get("Pin"), "Pin has been entered");
		enterText(this.nominatedAccountNumberField, testCaseData.get("NominatedAccountNumber"), "Nominated Account Number has been entered");
		enterText(this.nominatedSortCodeField, testCaseData.get("NominatedSortCode"), "Nominated Sort Code has been entered");
		
	/*Setting Interest Payment*/
		if (testCaseData.get("InterestPaid").equalsIgnoreCase("monthly")) {
			selectCriteria(this.monthlyInterestPaymentRadioButton, "Monthly Interest Paid has been selected");
		} else {
			selectCriteria(this.annuallyInterestPaymentRadioButton, "Annually Interest Paid has been selected");
		}
		
		enterText(this.paymentAccountField, testCaseData.get("PaymentAccount"), "Payment Account has been entered");
		
	/*Setting Confirmation Options*/
		if (testCaseData.get("ConfirmationOption").equalsIgnoreCase("by email")) {
			selectCriteria(this.emailConfirmationRadioButton, "Selecting only Email as Confirmation option");
		}else if (testCaseData.get("ConfirmationOption").equalsIgnoreCase("by mobile")) {
			selectCriteria(this.mobileConfirmationRadioButton, "Selecting only Mobile as Confirmation option");
		}else {
			selectCriteria(this.emailConfirmationRadioButton, "Selecting Email as Confirmation option");
			selectCriteria(this.mobileConfirmationRadioButton, "Selecting Mobile as Confirmation option");
		}
		
		if (testCaseData.get("Confirmation1").equalsIgnoreCase("Yes")) {
			selectCriteria(this.termAndCondition1RadioButton, "Selecting Terms and condition1");
		}
		
		if (testCaseData.get("Confirmation2").equalsIgnoreCase("Yes")) {
			selectCriteria(this.termAndCondition2RadioButton, "Selecting Terms and condition2");
		}
		
		clickOnContinueSecurely(continueSecurelyRadioButton,"Selecting Continue Securely");
		
	}
	
}

