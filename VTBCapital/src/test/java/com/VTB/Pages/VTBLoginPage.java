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

public class VTBLoginPage {

	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	public Eyes eyes;
	
	/***
	 * Constructor
	 */
	public VTBLoginPage(WebDriver driver, Reporting report, Eyes eyes) {
		this.driver = driver;
        this.report = report;
        this.eyes	= eyes;
        
        /*Initialize Elements*/
        PageFactory.initElements(driver, this);
        
        browserAction = new BrowserActions(driver, report);
        imgPath = report.imagePath;
	}

	/***
	 * Locators
	 */
	
	@FindBy(how = How.CSS, using = "#username")
	private WebElement usernameField;

	@FindBy(how = How.CSS, using = "#password")
	private WebElement passwordField;

	@FindBy(how = How.CSS, using = "#loginBtn")
	private WebElement loginButton;

	/***
	 * Methods
	 */
	
	/***
	 * function to verify Login Page Title
	 */
	public void verifyLoginPageTitle() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		browserAction.WaittoPageLoad();
		eyes.checkWindow("VTB Login Page");
		report.assertThat(browserAction.verifyPageTitle("VTB Capital Direct | Apply | Login"), driver.getTitle(),
				"VTB Capital Direct | Apply | Login", "VTB Summary Page has been opened succesfully",
				"opened Page has different Title");
	}
	
	/***
	 * function to Login through User1
	 * @param testCaseData
	 */
	public void loginUser1(LinkedHashMap <String,String> testCaseData) {
		verifyLoginPageTitle();
		browserAction.ScrollAndSetText(usernameField, testCaseData.get("Username1"), imgPath, "Username for customer has been entered");
		browserAction.ScrollAndSetText(passwordField, testCaseData.get("Password1"), imgPath, "Password for customer has been entered");
		clickOnLoginButton();
	}
	
	/***
	 * function to Login through User2
	 * @param testCaseData
	 */
	public void loginUser2(LinkedHashMap <String,String> testCaseData) {
		verifyLoginPageTitle();
		browserAction.ScrollAndSetText(usernameField, testCaseData.get("Username2"), imgPath, "Username for 2nd customer has been entered");
		browserAction.ScrollAndSetText(passwordField, testCaseData.get("Password2"), imgPath, "Password for 2nd customer has been entered");
		clickOnLoginButton();
	}
	
	/***
	 * function to Login
	 * @param testCaseData
	 */
	public void clickOnLoginButton() {
		browserAction.scrollToElement(loginButton);
		browserAction.clickJS(loginButton);
	}
	
}
