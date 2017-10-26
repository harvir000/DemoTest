package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;

public class VTBPersonalDetailsPage {
	
	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	
	/*Constructor*/
	public VTBPersonalDetailsPage(WebDriver driver,Reporting report){
		this.driver=driver;
      	this.report = report;
      	//Initialise Element
      	PageFactory.initElements(driver, this);
      	browserAction = new BrowserActions(driver, report);
      	imgPath = report.imagePath;
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
	
	@FindBy(css="#address")
	private WebElement selectCurrentAddress;
	
   /*Methods*/
	
	public void setTitle(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("Title").equalsIgnoreCase("Mr")) {
			browserAction.clickJS(titleMrRadioButton, imgPath, "Mr. Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("Mrs")) {
			browserAction.clickJS(titleMrsRadioButton, imgPath, "Mrs. Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("Miss")) {
			browserAction.clickJS(titleMissRadioButton, imgPath, "Miss Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("Ms")) {
			browserAction.clickJS(titleMsRadioButton, imgPath, "Ms Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("Mx")) {
			browserAction.clickJS(titleMxRadioButton, imgPath, "Mx Title has been selected");
		}else if (testCaseData.get("Title").equalsIgnoreCase("other")) {
			browserAction.clickJS(titleOtherRadioButton, imgPath, "Other Title has been selected");
		}
	}
	
	public void setName(LinkedHashMap <String,String> testCaseData) {
		browserAction.ScrollAndSetText(FirstNameField, testCaseData.get("FirstName"), imgPath, "FirstName has been entered");
		browserAction.ScrollAndSetText(SurnameField, testCaseData.get("Surname"), imgPath, "Surname has been entered");
	}
	
	public void setDOB(LinkedHashMap <String,String> testCaseData) {
		browserAction.ScrollAndSetText(dobDayField, testCaseData.get("Day"), imgPath, "Day has been entered");
		browserAction.ScrollAndSetText(dobMonthField, testCaseData.get("Month"), imgPath, "Month has been entered");
		browserAction.ScrollAndSetText(dobYearField, testCaseData.get("Year"), imgPath, "Year has been entered");
	}
	
	public void setBirthPlace(LinkedHashMap <String,String> testCaseData) {
		browserAction.ScrollAndSetText(cityOfBirthField, testCaseData.get("CityOfBirth"), imgPath, "City of Birth has been entered");
		browserAction.ScrollAndSetText(countryOfBirthField, testCaseData.get("CountryOfBirth"), imgPath, "Country of Birth has been entered");
	}
	
	public void setTaxInformation(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("TaxInformation").equalsIgnoreCase("no")) {
			browserAction.clickJS(taxInformationNoRadioButton, imgPath, "No Tax Information is selected");
		} else {
			browserAction.clickJS(taxInformationYesRadioButton, imgPath, "Yes Tax Information is selected");
			browserAction.ScrollAndSetText(taxInformationCountryField, testCaseData.get("TaxCountry"), imgPath, "Tax Country has been entered");
			browserAction.ScrollAndSetText(taxInformationTaxNumberField, testCaseData.get("TaxNumber"), imgPath, "Tax Number has been entered");
		}
	}
	
	public void setCurrentAddress(LinkedHashMap <String,String> testCaseData) throws InterruptedException {
		browserAction.ScrollAndSetText(currentAddressHouseNumberField, testCaseData.get("CurrentHouseNumber"), imgPath, "Current Address's House Number has been entered");
		browserAction.ScrollAndSetText(currentAddressPostCodeField, testCaseData.get("CurrentPostCode"), imgPath, "Current Address's Post Code has been entered");
		browserAction.clickJS(currentFindAddressButton, imgPath, "Find Address has been selected");
		browserAction.waitForElement(currentSelectedAddressField);
		
			browserAction.selectFromDD(selectCurrentAddress,testCaseData.get("CurrentSelectedAddress"));
	
		browserAction.ScrollAndSetText(currentSelectedAddressField, testCaseData.get("CurrentSelectedAddress"), imgPath, "Current Selected Address has been entered");
		
		browserAction.clearText(currentFlatNumberField);
		browserAction.ScrollAndSetText(currentFlatNumberField, testCaseData.get("CurrentFlatNumber"), imgPath, "Current Address's Flat Number has been entered");
		browserAction.clearText(currentBuildingNumberField);
		browserAction.ScrollAndSetText(currentBuildingNumberField, testCaseData.get("CurrentBuildingNumber"), imgPath, "Current Address's Building Number has been entered");
	}
	
	public void setLivingEligibility(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("LivingEligibility").equalsIgnoreCase("yes")) {
			browserAction.clickJS(livingEligibilityYesRadioButton, imgPath, "Customer satisfied Living Eligible Criteria");
		} else {
			browserAction.clickJS(livingEligibilityNoRadioButton, imgPath, "Customer does not satisfy Living Eligible Criteria");
			/*Setting Previous Address*/
			setPreviousAddress(testCaseData);
		}
	}
	
	public void setPreviousAddress(LinkedHashMap <String,String> testCaseData) {
		browserAction.ScrollAndSetText(previousAddressHouseNumberField, testCaseData.get("PreviousHouseNumber"), imgPath, "Previous Address's House Number has been entered");
		browserAction.ScrollAndSetText(previousAddressPostCodeField, testCaseData.get("PreviousPostCode"), imgPath, "Previous Address's Post Code has been entered");
		browserAction.clickJS(previousFindAddressButton, imgPath, "Find Address has been selected");
		browserAction.ScrollAndSetText(previousSelectedAddressField, testCaseData.get("PreviousSelectedAddress"), imgPath, "Previous Selected Address has been entered");
		browserAction.ScrollAndSetText(previousFlatNumberField, testCaseData.get("PreviousFlatNumber"), imgPath, "Previous Address's Flat Number has been entered");
		browserAction.ScrollAndSetText(previousBuildingNumberField, testCaseData.get("PreviousBuildingNumber"), imgPath, "Previous Address's Building Number has been entered");
	}
	
	public void setEmailAndMobile(LinkedHashMap <String,String> testCaseData) {
		browserAction.ScrollAndSetText(emailAddressField, testCaseData.get("EmailAddress"), imgPath, "Email has been entered");
		browserAction.ScrollAndSetText(mobileNumberField, testCaseData.get("MobileNumber"), imgPath, "Mobile has been entered");
	}
	
	public void setQuestionsAndAnswers(LinkedHashMap <String,String> testCaseData) {
		browserAction.ScrollAndSetText(securityQuestion1Field, testCaseData.get("SecurityQuestion1"), imgPath, "Security Question 1 has been entered");
		browserAction.ScrollAndSetText(securityAnswer1Field, testCaseData.get("SecurityAnswer1"), imgPath, "Security Answer 1 has been entered");
		browserAction.ScrollAndSetText(securityQuestion2Field, testCaseData.get("SecurityQuestion2"), imgPath, "Security Question 2 has been entered");
		browserAction.ScrollAndSetText(securityAnswer2Field, testCaseData.get("SecurityAnswer2"), imgPath, "Security Answer 2 has been entered");
	}
	
	public void setPinAndNominatedAccountDetails(LinkedHashMap <String,String> testCaseData) {
		browserAction.ScrollAndSetText(pinField, testCaseData.get("Pin"), imgPath, "Pin has been entered");
		browserAction.ScrollAndSetText(nominatedAccountNumberField, testCaseData.get("NominatedAccountNumber"), imgPath, "Nominated Account Number has been entered");
		browserAction.ScrollAndSetText(nominatedSortCodeField, testCaseData.get("NominatedSortCode"), imgPath, "Nominated Sort Code has been entered");
	}
	
	public void setInterestPayment(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("InterestPaid").equalsIgnoreCase("monthly")) {
			browserAction.clickJS(monthlyInterestPaymentRadioButton, imgPath, "Monthly Interest Paid has been selected");
		} else {
			browserAction.clickJS(annuallyInterestPaymentRadioButton, imgPath, "Annually Interest Paid has been selected");
		}
		
		browserAction.ScrollAndSetText(paymentAccountField, testCaseData.get("PaymentAccount"), imgPath, "Payment Account has been entered");
	}
	
	public void setConfirmationOptions(LinkedHashMap <String,String> testCaseData){
		if (testCaseData.get("ConfirmationOption").equalsIgnoreCase("by email")) {
			browserAction.clickJS(emailConfirmationRadioButton, imgPath, "Selecting only Email as Confirmation option");
		}else if (testCaseData.get("ConfirmationOption").equalsIgnoreCase("by mobile")) {
			browserAction.clickJS(mobileConfirmationRadioButton, imgPath, "Selecting only Mobile as Confirmation option");
		}else {
			browserAction.clickJS(emailConfirmationRadioButton, imgPath, "Selecting Email as Confirmation option");
			browserAction.clickJS(mobileConfirmationRadioButton, imgPath, "Selecting Mobile as Confirmation option");
		}
		
		if (testCaseData.get("Confirmation1").equalsIgnoreCase("Yes")) {
			browserAction.clickJS(termAndCondition1RadioButton, imgPath, "Selecting Terms and condition1");
		}
		
		if (testCaseData.get("Confirmation2").equalsIgnoreCase("Yes")) {
			browserAction.clickJS(termAndCondition2RadioButton, imgPath, "Selecting Terms and condition2");
		}
	}
	
	/*Enter Personal Details*/
	public void enterPersonalDetails(LinkedHashMap <String,String> testCaseData) throws InterruptedException 
	{
		
		browserAction.WaittoPageLoad();
		
	/*Selecting Title*/
		setTitle(testCaseData);
	/*Setting FirstName and Surname*/
		setName(testCaseData);
	/*Setting Date of Birth*/
		setDOB(testCaseData);
	/*Setting City of Birth and Country of Birth*/
		setBirthPlace(testCaseData);
	/*Setting Tax Information*/
		setTaxInformation(testCaseData);
	/*Setting Current Address*/	
		setCurrentAddress(testCaseData);
	/*Setting Living Eligibility*/
		setLivingEligibility(testCaseData);
	/*Setting Email and Mobile Number*/
		setEmailAndMobile(testCaseData);
	/*Setting Security Questions and Answers*/
		setQuestionsAndAnswers(testCaseData);
	/*Setting Pin, Nominated Account Number and Nominated SortCode*/
		setPinAndNominatedAccountDetails(testCaseData);
	/*Setting Interest Payment*/
		setInterestPayment(testCaseData);
	/*Setting Confirmation Options*/
		setConfirmationOptions(testCaseData);
		browserAction.scrollToElement(continueSecurelyRadioButton);
		browserAction.clickJS(continueSecurelyRadioButton);
		
	}
	
}

