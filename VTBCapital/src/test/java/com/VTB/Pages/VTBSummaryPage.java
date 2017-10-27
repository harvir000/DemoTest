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
	
	public VTBSummaryPage(WebDriver driver,Reporting report){
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
	
	/*Set Identity Preference i.e. Mobile or Email*/
	public void setIdentityPreference(LinkedHashMap <String,String> testCaseData){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		if (testCaseData.get("IdentityPreference").equalsIgnoreCase("Mobile")) {
			browserAction.ScrollAndClickOnElement(mobileRadioButton, imgPath, "Mobile has been selected as an Identity Preference");
		} else {
			browserAction.ScrollAndClickOnElement(emailRadioButton, imgPath, "Email has been selected as an Identity Preference");
		}
	}
	
	/*Set Verification Code*/
	public void setVerificationCodeField() throws InterruptedException {
		browserAction.waitForElement(verificationCodeField);
		browserAction.setText(verificationCodeField, "1234", imgPath, "Code has been entered");
	}
	
	public void clickOnContinueSecurely() throws InterruptedException {
		browserAction.WaittoPageLoad();
		browserAction.waitForElement(continueSecurelyButton);
		browserAction.scrollToElement(continueSecurelyButton);
		browserAction.clickJS(continueSecurelyButton);
	}
	
	/*Set OTP Details*/
	public void enterOTPDetails(LinkedHashMap <String,String> testCaseData) throws InterruptedException {
		
		browserAction.WaittoPageLoad();
		
	/*Setting Identity Preference*/
		setIdentityPreference(testCaseData);
		browserAction.ScrollAndClickOnElement(sendMyCodeButton, imgPath, "Send my Code button has been selected");
		setVerificationCodeField();
		clickOnContinueSecurely();
	}
	
}
