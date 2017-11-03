package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;
import com.applitools.eyes.Eyes;

public class VTBPersonalDetailsPage {

	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	public Eyes eyes;
	
	/***
	 * Constructor
	 */
	public VTBPersonalDetailsPage(WebDriver driver, Reporting report, Eyes eyes) {
		this.driver = driver;
		this.report = report;
		this.eyes	= eyes;
		
		/* Initialize Elements */
		PageFactory.initElements(driver, this);

		browserAction = new BrowserActions(driver, report);
		imgPath = report.imagePath;
	}

	/***
	 * Locators
	 */

	/* Title */
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

	/* First Name and Surname */
	@FindBy(how = How.CSS, using = "#givenName")
	private WebElement FirstNameField;

	@FindBy(how = How.CSS, using = "#familyName")
	private WebElement SurnameField;

	/* Day, Month and Year */
	@FindBy(how = How.CSS, using = "#day")
	private WebElement dobDayField;

	@FindBy(how = How.CSS, using = "#month")
	private WebElement dobMonthField;

	@FindBy(how = How.CSS, using = "#year")
	private WebElement dobYearField;

	/* City of Birth and Country of Birth */
	@FindBy(how = How.CSS, using = "#placeOfBirth")
	private WebElement cityOfBirthField;

	@FindBy(how = How.CSS, using = "#countryOfBirth")
	private WebElement countryOfBirthField;

	/* Tax information */
	@FindBy(how = How.CSS, using = "#tax_yes")
	private WebElement taxInformationYesRadioButton;

	@FindBy(how = How.CSS, using = "#tax_no")
	private WebElement taxInformationNoRadioButton;

	@FindBy(how = How.CSS, using = "#countryTax1")
	private WebElement taxInformationCountryField;

	@FindBy(how = How.CSS, using = "#taxNumber1")
	private WebElement taxInformationTaxNumberField;

	/* Current Address */
	@FindBy(how = How.CSS, using = "#houseNo")
	private WebElement currentAddressHouseNumberField;

	@FindBy(how = How.CSS, using = "#postcode-for-search")
	private WebElement currentAddressPostCodeField;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-link cta3 showMan']")
	private WebElement currentEnterAddressManuallyButton;
	
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

	/* Living Eligibility */
	@FindBy(how = How.CSS, using = "#optionsRadios1")
	private WebElement livingEligibilityYesRadioButton;

	@FindBy(how = How.CSS, using = "#optionsRadios2")
	private WebElement livingEligibilityNoRadioButton;

	/* Previous Address */
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

	/* Email and Mobile */
	@FindBy(how = How.CSS, using = "#email")
	private WebElement emailAddressField;

	@FindBy(how = How.CSS, using = "#mobile")
	private WebElement mobileNumberField;

	@FindBy(how = How.CSS, using = "#alternatePhone")
	private WebElement alternatePhoneNumberField;

	/* Security questions and answers */
	@FindBy(how = How.CSS, using = "#securityQuestion1")
	private WebElement securityQuestion1Field;

	@FindBy(how = How.CSS, using = "#answer1")
	private WebElement securityAnswer1Field;

	@FindBy(how = How.CSS, using = "#securityQuestion2")
	private WebElement securityQuestion2Field;

	@FindBy(how = How.CSS, using = "#answer2")
	private WebElement securityAnswer2Field;

	/* Pin, Nominated Account Number and Sort Code */
	@FindBy(how = How.CSS, using = "#pin")
	private WebElement pinField;

	@FindBy(how = How.CSS, using = "#accountNumber")
	private WebElement nominatedAccountNumberField;

	@FindBy(how = How.CSS, using = "#sortCode")
	private WebElement nominatedSortCodeField;

	/* Interest Payment */
	@FindBy(how = How.CSS, using = "#interestPayment_monthly")
	private WebElement monthlyInterestPaymentRadioButton;

	@FindBy(how = How.CSS, using = "#interestPayment_annually")
	private WebElement annuallyInterestPaymentRadioButton;

	@FindBy(how = How.CSS, using = "#paymentAccount")
	private WebElement paymentAccountField;

	/* Confirmation */
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

	@FindBy(css = "#address")
	private WebElement selectCurrentAddress;

	/***
	 * Methods
	 */

	/***
	 * function to Set Title from Mr., Mrs, Miss, Ms, Mx and Other
	 * 
	 * @param testCaseData
	 */
	public void setTitle(LinkedHashMap<String, String> testCaseData) {
		if (testCaseData.get("Title").equalsIgnoreCase("Mr")) {
			browserAction.clickJS(titleMrRadioButton, imgPath, "Selecting Mr. Title");
		} else if (testCaseData.get("Title").equalsIgnoreCase("Mrs")) {
			browserAction.clickJS(titleMrsRadioButton, imgPath, "Selecting Mrs. Title");
		} else if (testCaseData.get("Title").equalsIgnoreCase("Miss")) {
			browserAction.clickJS(titleMissRadioButton, imgPath, "Selecting Miss Title");
		} else if (testCaseData.get("Title").equalsIgnoreCase("Ms")) {
			browserAction.clickJS(titleMsRadioButton, imgPath, "Selecting Ms Title");
		} else if (testCaseData.get("Title").equalsIgnoreCase("Mx")) {
			browserAction.clickJS(titleMxRadioButton, imgPath, "Selecting Mx Title");
		} else if (testCaseData.get("Title").equalsIgnoreCase("other")) {
			browserAction.clickJS(titleOtherRadioButton, imgPath, "Selecting Other Title");
		}
		report.assertThat(verifyTitle(), "Title has been selected successfully", "Title has not been selected successfully");
	}

	/***
	 * function to verify that Title has been selected
	 * 
	 * @return
	 */
	public boolean verifyTitle() {
		boolean dataToBeReturn = false;
		if (titleMrRadioButton.isSelected() || titleMrsRadioButton.isSelected() || titleMissRadioButton.isSelected()
				|| titleMsRadioButton.isSelected() || titleMxRadioButton.isSelected()
				|| titleOtherRadioButton.isSelected()) {
			dataToBeReturn = true;
		}

		return dataToBeReturn;
	}

	/***
	 * function to Set First Name and Last Name
	 * 
	 * @param testCaseData
	 */
	public void setName(LinkedHashMap<String, String> testCaseData) {
		browserAction.ScrollAndSetText(FirstNameField, testCaseData.get("FirstName"), imgPath,
				"FirstName has been entered");
		browserAction.ScrollAndSetText(SurnameField, testCaseData.get("Surname"), imgPath, "Surname has been entered");
	}

	/***
	 * function to Set Date of Birth
	 * 
	 * @param testCaseData
	 */
	public void setDOB(LinkedHashMap<String, String> testCaseData) {
		browserAction.ScrollAndSetText(dobDayField, testCaseData.get("Day"), imgPath, "DOB's Day has been entered");
		browserAction.ScrollAndSetText(dobMonthField, testCaseData.get("Month"), imgPath, "DOB's Month has been entered");
		browserAction.ScrollAndSetText(dobYearField, testCaseData.get("Year"), imgPath, "DOB's Year has been entered");
	}

	/***
	 * function to Set Birth Place i.e. City and Country Of Birth
	 * 
	 * @param testCaseData
	 */
	public void setBirthPlace(LinkedHashMap<String, String> testCaseData) {
		browserAction.ScrollAndSetText(cityOfBirthField, testCaseData.get("CityOfBirth"), imgPath,
				"City of Birth has been entered");
		browserAction.selectFromDD(countryOfBirthField, testCaseData.get("CountryOfBirth"));
	}

	/***
	 * function to Set Tax Information
	 * 
	 * @param testCaseData
	 */
	public void setTaxInformation(LinkedHashMap<String, String> testCaseData) {
		if (testCaseData.get("TaxInformation").equalsIgnoreCase("no")) {
			browserAction.clickJS(taxInformationNoRadioButton, imgPath, "Selecting Tax Information as 'No'");
		} else {
			browserAction.clickJS(taxInformationYesRadioButton, imgPath, "Selecting Tax Information as 'Yes'");
			browserAction.ScrollAndSetText(taxInformationCountryField, testCaseData.get("TaxCountry"), imgPath,
					"Tax Country has been entered");
			browserAction.ScrollAndSetText(taxInformationTaxNumberField, testCaseData.get("TaxNumber"), imgPath,
					"Tax Number has been entered");
		}
		report.assertThat(verifyTax(), "Tax Information has been selected successfully", "Tax Information has not been selected successfully");
	}

	/***
	 * function to verify that Tax Information has been selected
	 * 
	 * @return
	 */
	public boolean verifyTax() {
		boolean dataToBeReturn = false;
		if (taxInformationNoRadioButton.isSelected() || taxInformationYesRadioButton.isSelected()) {
			dataToBeReturn = true;
		}
		return dataToBeReturn;
	}

	/***
	 * function to Set Current Address i.e. House No., Post Code, Address, Flat
	 * Number, Building Number and Street
	 * 
	 * @param testCaseData
	 */	
	public void setCurrentAddress(LinkedHashMap<String, String> testCaseData) throws InterruptedException {
		
		browserAction.ScrollAndSetText(currentAddressHouseNumberField, testCaseData.get("CurrentHouseNumber"), imgPath,
				"Current Address's House Number has been entered");
		
		browserAction.clickJS(currentEnterAddressManuallyButton);
		
		browserAction.clickJS(currentFlatNumberField);
		browserAction.clearText(currentFlatNumberField);
		browserAction.ScrollAndSetText(currentFlatNumberField, testCaseData.get("CurrentFlatNumber"), imgPath,
				"Current Address's Flat Number has been entered");

		browserAction.clearText(currentBuildingNumberField);
		browserAction.ScrollAndSetText(currentBuildingNumberField, testCaseData.get("CurrentBuildingNumber"), imgPath,
				"Current Address's Building Number has been entered");
		
		browserAction.clearText(currentBuildingNameField);
		browserAction.ScrollAndSetText(currentBuildingNameField, testCaseData.get("CurrentBuildingName"), imgPath,
				"Current Address's Building Name has been entered");
		
		browserAction.clearText(currentStreetField);
		browserAction.ScrollAndSetText(currentStreetField, testCaseData.get("CurrentStreet"), imgPath,
				"Current Address's Street has been entered");
		
		browserAction.clearText(currentCityField);
		browserAction.ScrollAndSetText(currentCityField, testCaseData.get("CurrentCity"), imgPath,
				"Current Address's City has been entered");
		
		browserAction.clearText(currentPostCodeField);
		browserAction.ScrollAndSetText(currentPostCodeField, testCaseData.get("CurrentPostCode"), imgPath,
				"Current Address's Post Code has been entered");
		
	}

	/***
	 * function to Set Living Eligibility Criteria i.e. Yes or No
	 * 
	 * @param testCaseData
	 */
	public void setLivingEligibility(LinkedHashMap<String, String> testCaseData) throws InterruptedException {
		if (testCaseData.get("LivingEligibility").equalsIgnoreCase("yes")) {
			browserAction.clickJS(livingEligibilityYesRadioButton, imgPath,
					"Customer satisfied Living Eligible Criteria");
		} else {
			browserAction.clickJS(livingEligibilityNoRadioButton, imgPath,
					"Customer does not satisfy Living Eligible Criteria");
			/* Setting Previous Address */
			setPreviousAddress(testCaseData);
		}
		report.assertThat(verifyLivingEligibility(),"Living Eligibility has been selected successfully","Living Eligibility has not been selected successfully");
	}

	/***
	 * function to verify Living Eligibility has been selected
	 * 
	 * @return
	 */
	public boolean verifyLivingEligibility() {
		boolean dataToBeReturn = false;
		if (livingEligibilityYesRadioButton.isSelected() || livingEligibilityNoRadioButton.isSelected()) {
			dataToBeReturn = true;
		}

		return dataToBeReturn;
	}

	/***
	 * function to Set Previous Address i.e. House No., Post Code, Address, Flat
	 * Number and Building Number
	 * 
	 * @param testCaseData
	 */
	public void setPreviousAddress(LinkedHashMap<String, String> testCaseData) throws InterruptedException {
		browserAction.ScrollAndSetText(previousAddressHouseNumberField, testCaseData.get("PreviousHouseNumber"),
				imgPath, "Previous Address's House Number has been entered");
		browserAction.ScrollAndSetText(previousAddressPostCodeField, testCaseData.get("PreviousPostCode"), imgPath,
				"Previous Address's Post Code has been entered");

		browserAction.clickJS(previousFindAddressButton, imgPath, "Find Address has been selected");

		browserAction.waitForElement(previousSelectedAddressField);
		browserAction.selectFromDD(previousSelectedAddressField, testCaseData.get("PreviousSelectedAddress"));

		browserAction.clearText(previousFlatNumberField);
		browserAction.ScrollAndSetText(previousFlatNumberField, testCaseData.get("PreviousFlatNumber"), imgPath,
				"Previous Address's Flat Number has been entered");

		browserAction.clearText(previousBuildingNumberField);
		browserAction.ScrollAndSetText(previousBuildingNumberField, testCaseData.get("PreviousBuildingNumber"), imgPath,
				"Previous Address's Building Number has been entered");
	}

	/***
	 * function to Set Email and Mobile Number
	 * 
	 * @param testCaseData
	 */
	public void setEmailAndMobile(LinkedHashMap<String, String> testCaseData) {
		browserAction.ScrollAndSetText(emailAddressField, testCaseData.get("EmailAddress"), imgPath,
				"Email has been entered");
		browserAction.ScrollAndSetText(mobileNumberField, testCaseData.get("MobileNumber"), imgPath,
				"Mobile has been entered");
	}

	/***
	 * function to Set Questions and Answers
	 * 
	 * @param testCaseData
	 */
	public void setQuestionsAndAnswers(LinkedHashMap<String, String> testCaseData) {
		browserAction.selectFromDD(securityQuestion1Field, testCaseData.get("SecurityQuestion1"));
		browserAction.ScrollAndSetText(securityAnswer1Field, testCaseData.get("SecurityAnswer1"), imgPath,
				"Security Answer 1 has been entered");
		browserAction.selectFromDD(securityQuestion2Field, testCaseData.get("SecurityQuestion2"));
		browserAction.ScrollAndSetText(securityAnswer2Field, testCaseData.get("SecurityAnswer2"), imgPath,
				"Security Answer 2 has been entered");
	}

	/***
	 * function to Set Pin
	 * 
	 * @param testCaseData
	 */
	public void setPin(LinkedHashMap<String, String> testCaseData) {
		browserAction.ScrollAndSetText(pinField, testCaseData.get("Pin"), imgPath, "Pin has been entered");
	}

	/***
	 * function to Set Nominated Account Details
	 * 
	 * @param testCaseData
	 */
	public void setNominatedAccountDetails(LinkedHashMap<String, String> testCaseData) {
		browserAction.ScrollAndSetText(nominatedAccountNumberField, testCaseData.get("NominatedAccountNumber"), imgPath,
				"Nominated Account Number has been entered");
		browserAction.ScrollAndSetText(nominatedSortCodeField, testCaseData.get("NominatedSortCode"), imgPath,
				"Nominated Sort Code has been entered");
	}

	/***
	 * function to Set Interest Payment
	 * 
	 * @param testCaseData
	 */
	public void setInterestPayment(LinkedHashMap<String, String> testCaseData) {
		if (testCaseData.get("InterestPaid").equalsIgnoreCase("monthly")) {
			browserAction.clickJS(monthlyInterestPaymentRadioButton, imgPath,
					"Monthly Interest Paid has been selected");
		} else {
			browserAction.clickJS(annuallyInterestPaymentRadioButton, imgPath,
					"Annually Interest Paid has been selected");
		}
		
		report.assertThat(verifyInterestPayment(), "Interest Payment has been selected successfully","Interest Payment has not been selected successfully");
		browserAction.selectFromDD(paymentAccountField, testCaseData.get("PaymentAccount"));
	}
	
	/***
	 * function to verify that Interest Payment has been selected
	 * @return
	 */
	public boolean verifyInterestPayment() {
		boolean dataToBeReturn = false;
		if (monthlyInterestPaymentRadioButton.isSelected() || annuallyInterestPaymentRadioButton.isSelected()) {
			dataToBeReturn = true;
		}
		return dataToBeReturn;
	}

	/***
	 * function to Set Confirmation options
	 * 
	 * @param testCaseData
	 */
	public void setConfirmationOptionsAndContinue(LinkedHashMap<String, String> testCaseData) {
		if (testCaseData.get("ConfirmationOption").equalsIgnoreCase("by email")) {
			browserAction.ScrollAndClickOnElement(emailConfirmationRadioButton, imgPath,
					"Selecting only Email as Confirmation option");
		} else if (testCaseData.get("ConfirmationOption").equalsIgnoreCase("by mobile")) {
			browserAction.ScrollAndClickOnElement(mobileConfirmationRadioButton, imgPath,
					"Selecting only Mobile as Confirmation option");
		} else if (testCaseData.get("ConfirmationOption").equalsIgnoreCase("Both")) {
			browserAction.ScrollAndClickOnElement(emailConfirmationRadioButton, imgPath,
					"Selecting Email as Confirmation option");
			browserAction.ScrollAndClickOnElement(mobileConfirmationRadioButton, imgPath,
					"Selecting Mobile as Confirmation option");
		}

		if (testCaseData.get("Confirmation1").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(termAndCondition1RadioButton, imgPath,
					"Selecting Terms and 1st condition");
		}

		if (testCaseData.get("Confirmation2").equalsIgnoreCase("Yes")) {
			browserAction.ScrollAndClickOnElement(termAndCondition2RadioButton, imgPath,
					"Selecting Terms and 2nd condition");
		}
		
		report.assertThat(verifyConfirmationOptions(), "Confirmation Option has been selected successfully","Confirmation Option has not been selected successfully");
		report.assertThat(verifyTermsConditions(), "Terms and Conditions has been selected successfully", "Terms and Conditions has not been selected successfully");
		
		browserAction.scrollToElement(continueSecurelyRadioButton);
		browserAction.clickJS(continueSecurelyRadioButton);
	}
	
	/***
	 * function to verify Confirmation Option has been selected
	 * @return
	 */
	public boolean verifyConfirmationOptions() {
		boolean dataToBeReturn = false;
		if (emailConfirmationRadioButton.isSelected() || mobileConfirmationRadioButton.isSelected()) {
			dataToBeReturn = true;
		}
		return dataToBeReturn;
	}
	
	/***
	 * function to verify Terms and Conditions has been selected
	 * @return
	 */
	public boolean verifyTermsConditions() {
		boolean dataToBeReturn = false;
		if (termAndCondition1RadioButton.isSelected() && termAndCondition2RadioButton.isSelected()) {
			dataToBeReturn = true;
		}
		return dataToBeReturn;
	}
	
	/***
	 * function to enter Personal Details for New Customer
	 * 
	 * @param testCaseData
	 */
	public void enterDetailsForNewCustomer(LinkedHashMap<String, String> testCaseData) throws InterruptedException {

		verifyPersonalDetailsPageTitle();

		/* Selecting Title */
		setTitle(testCaseData);
		/* Setting FirstName and Surname */
		setName(testCaseData);
		/* Setting Date of Birth */
		setDOB(testCaseData);
		/* Setting City of Birth and Country of Birth */
		setBirthPlace(testCaseData);
		/* Setting Tax Information */
		setTaxInformation(testCaseData);
		/* Setting Current Address */
		setCurrentAddress(testCaseData);
		/* Setting Living Eligibility */
		setLivingEligibility(testCaseData);
		/* Setting Email and Mobile Number */
		setEmailAndMobile(testCaseData);
		/* Setting Security Questions and Answers */
		setQuestionsAndAnswers(testCaseData);
		/* Setting Pin */
		setPin(testCaseData);

		/*
		 * To check if the Account Type is Joint Account and Customer Type is Both New
		 * Customers
		 */
		if (!(testCaseData.get("AccountType").equalsIgnoreCase("Joint Account")
				& (testCaseData.get("CustomerType").equalsIgnoreCase("Both New Customers")
						|| testCaseData.get("CustomerType").equalsIgnoreCase("One New And One Existing Customer")))) {
			/* Setting Nominated Account Number and Nominated SortCode */
			setNominatedAccountDetails(testCaseData);
			/* Setting Interest Payment */
			setInterestPayment(testCaseData);
		}

		/* Setting Confirmation Options and Continue */
		setConfirmationOptionsAndContinue(testCaseData);
	}

	/***
	 * function to enter Personal Details for Existing Customer
	 * 
	 * @param testCaseData
	 */
	public void enterDetailsForExistingCustomer(LinkedHashMap<String, String> testCaseData) {
		verifyPersonalDetailsPageTitle();

		/* Setting Nominated Account Number and Nominated SortCode */
		setNominatedAccountDetails(testCaseData);
		/* Setting Interest Payment */
		setInterestPayment(testCaseData);
		/* Setting Confirmation Options and Continue */
		setConfirmationOptionsAndContinue(testCaseData);
	}
	
	/***
	 * function to verify Personal Details Page Title
	 */
	public void verifyPersonalDetailsPageTitle() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browserAction.WaittoPageLoad();
		eyes.checkWindow("VTB Personal Details Page");
		report.assertThat(browserAction.verifyPageTitle("VTB Capital Direct | Apply | Personal details"),"VTB Personal Details Page has been opened succesfully", "VTB Personal Details has different Title");
	}

}
