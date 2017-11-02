package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;

public class VTBSummaryPage {

	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";

	/***
	 * Constructor
	 */
	public VTBSummaryPage(WebDriver driver, Reporting report) {
		this.driver = driver;
		this.report = report;

		/* Initialize Elements */
		PageFactory.initElements(driver, this);

		browserAction = new BrowserActions(driver, report);
		imgPath = report.imagePath;
	}

	/***
	 * Locators
	 */

	@FindBy(how = How.CSS, using = "a[href='/sites/ntw/flow-1-review/container/showres.updateAOPAnswersController.do#personal_details']")
	private WebElement editPersonalDetailsLink;

	@FindBy(how = How.CSS, using = "a[href='/sites/ntw/flow-1-review/container/showres.updateAOPAnswersController.do#current_address']")
	private WebElement editCurrentAddressLink;

	@FindBy(how = How.CSS, using = "a[href='/sites/ntw/flow-1-review/container/showres.updateAOPAnswersController.do#contact_details']")
	private WebElement editContactDetailsLink;

	@FindBy(how = How.CSS, using = "a[href='/sites/ntw/flow-1-review/container/showres.updateAOPAnswersController.do#security_information']")
	private WebElement editSecurityInformationLink;

	@FindBy(how = How.CSS, using = "a[href='/sites/ntw/flow-1-review/container/showres.updateAOPAnswersController.do#product_information']")
	private WebElement editNominatedAccountLink;

	@FindBy(how = How.CSS, using = "a[href='/sites/ntw/flow-1-review/container/showres.updateAOPAnswersController.do#interest_payment']")
	private WebElement editInterestPaymentLink;

	@FindBy(how = How.CSS, using = "a[href='/sites/ntw/flow-1-review/container/showres.updateAOPAnswersController.do#marketing_preferences']")
	private WebElement editMarketingPreferencesLink;

	@FindBy(how = How.CSS, using = "#SMS")
	private WebElement mobileRadioButton;

	@FindBy(how = How.CSS, using = "#Email")
	private WebElement emailRadioButton;

	@FindBy(how = How.XPATH, using = "(//button[@class='row btn btn-default cta2 send-new-code-btn'])[1]")
	private WebElement sendMyCodeButton;

	@FindBy(how = How.CSS, using = "#code")
	private WebElement verificationCodeField;

	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-default cta1 pull-right']")
	private WebElement continueSecurelyButton;

	@FindBy(how = How.XPATH, using = "//button[@class='row btn btn-default cta2 resend-code-btn']")
	private WebElement resendMyCodeButton;

	@FindBy(how = How.XPATH, using = "(//button[@class='btn btn-default cta2 switch-verification-code-btn'])[1]")
	private WebElement switchVerificationMethodButton;

	/***
	 * Methods
	 */

	/***
	 * function to Set Identity Preference i.e. Mobile or Email
	 * 
	 * @param testCaseData
	 */
	public void setIdentityPreference(LinkedHashMap<String, String> testCaseData) {
		if (testCaseData.get("IdentityPreference").equalsIgnoreCase("Mobile")) {
			browserAction.ScrollAndClickOnElement(mobileRadioButton, imgPath,
					"Mobile has been selected as an Identity Preference");
		} else {
			browserAction.ScrollAndClickOnElement(emailRadioButton, imgPath,
					"Email has been selected as an Identity Preference");
		}
		report.assertThat(verifyIdentityPreference(), "Identity Preference has been selected successfully", "Identity Preference has not been selected successfully");
	}
	
	public boolean verifyIdentityPreference(){
		boolean dataToBeReturn = false;
		if (mobileRadioButton.isSelected() || emailRadioButton.isSelected()) {
			dataToBeReturn = true;
		}

		return dataToBeReturn;
	}

	/***
	 * Set Verification Code
	 * 
	 * @throws InterruptedException
	 */
	public void setVerificationCodeField() throws InterruptedException {
		browserAction.waitForElement(verificationCodeField);
		browserAction.setText(verificationCodeField, "1234", imgPath, "Code has been entered");
	}

	/***
	 * function to Continue Securely
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnContinueSecurely() throws InterruptedException {
		browserAction.WaittoPageLoad();
		browserAction.waitForElement(continueSecurelyButton);
		browserAction.scrollToElement(continueSecurelyButton);
		browserAction.clickJS(continueSecurelyButton);
	}

	/***
	 * function to set OTP Details
	 * 
	 * @param testCaseData
	 * @throws InterruptedException
	 */
	public void enterOTPDetails(LinkedHashMap<String, String> testCaseData) throws InterruptedException {

		verifySummaryPageTitle();
		/* Setting Identity Preference */
		setIdentityPreference(testCaseData);
		browserAction.ScrollAndClickOnElement(sendMyCodeButton, imgPath, "Clicking on Send My Code button");
		setVerificationCodeField();
		clickOnContinueSecurely();
	}
	
	public void verifySummaryPageTitle() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		browserAction.WaittoPageLoad();
		report.assertThat(browserAction.verifyPageTitle("VTB Capital Direct | Apply | Summary"), "VTB Summary Page has been opened successfully", "VTB Summary Page has different Title");
	}

}
