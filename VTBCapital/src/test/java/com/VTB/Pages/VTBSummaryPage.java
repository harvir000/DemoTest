package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import functionLibrary.BrowserActions;
import reportingPckg.Reporting;
import utilsPckg.Excel;

public class VTBSummaryPage {
	
	WebDriver driver;
	Excel objExcel;
	WebDriverWait wait;
	Reporting report;
	BrowserActions browserAction;
	
	/*Constructor*/
	public VTBSummaryPage(WebDriver driver,Reporting report){
		this.driver=driver;
	    this.report = report;
	    //Initialise Element
	    PageFactory.initElements(driver, this);
	    browserAction = new BrowserActions(driver, report);
   }

	/*Locators*/
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
	
	/*Methods*/
	public void selectVerificationMethod(WebElement element, String message) {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		browserAction.scrollToElement(element);
		browserAction.clickJS(element, report.imagePath, message);
	}
	
	public void selectCriteria(WebElement element, String message) {
		browserAction.scrollToElement(element);
		browserAction.clickJS(element, report.imagePath, message);
	}
	
//	public void clickOnSendMyCodeButton(){
//		jse.executeScript("arguments[0].scrollIntoView(true);",sendMyCodeButton);
//		jse.executeScript("arguments[0].click();", sendMyCodeButton);
////		funbank.scrollToElement(sendMyCodeButton);
////		funbank.clickOnElement(sendMyCodeButton);
//	}

	public void setVerificationCodeField() {
		wait	= new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(verificationCodeField));
		browserAction.setText(verificationCodeField, "1234", report.imagePath, "Code has been entered");
	}
	
//	public void clickOnContinueSecurelyButton(){
//		jse.executeScript("arguments[0].scrollIntoView(true);",continueSecurelyButton);
//		jse.executeScript("arguments[0].click();", continueSecurelyButton);
////		funbank.scrollToElement(continueSecurelyButton);
////		funbank.clickOnElement(continueSecurelyButton);
//	}
	
	public void enterOTPDetails(String rowValue) throws Exception {
		
		browserAction.WaittoPageLoad();
		
		objExcel	=	new Excel();
		
	/*Getting Data from Test Data sheet*/
		LinkedHashMap <String,String> testCaseData	= objExcel.getTestCaseData(rowValue);
		
	/*Setting Identity Preference*/
		if (testCaseData.get("IdentityPreference").equalsIgnoreCase("Mobile")) {
			selectVerificationMethod(this.mobileRadioButton, "Mobile has been selected as an Identity Preference");
		} else {
			selectVerificationMethod(this.emailRadioButton, "Email has been selected as an Identity Preference");
		}
		
		selectCriteria(this.sendMyCodeButton, "Send my Code button has been selected");
		setVerificationCodeField();
		selectCriteria(this.continueSecurelyButton, "Continue Securely has been selected");
	}
	
}
