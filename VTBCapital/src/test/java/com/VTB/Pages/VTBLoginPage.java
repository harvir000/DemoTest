package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;

public class VTBLoginPage {

	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	
	/***
	 * Constructor
	 */

	public VTBLoginPage(WebDriver driver, Reporting report) {
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
	
	@FindBy(how = How.CSS, using = "#username")
	private WebElement usernameField;

	@FindBy(how = How.CSS, using = "#password")
	private WebElement passwordField;

	@FindBy(how = How.CSS, using = "#loginBtn")
	private WebElement loginButton;

	/***
	 * Methods
	 */
	
	public void loginUser1(LinkedHashMap <String,String> testCaseData) {
		browserAction.WaittoPageLoad();
		browserAction.ScrollAndSetText(usernameField, testCaseData.get("Username1"), imgPath, "Username for customer has been entered");
		browserAction.ScrollAndSetText(passwordField, testCaseData.get("Password1"), imgPath, "Password for customer has been entered");
		clickOnLoginButton();
	}
	
	public void loginUser2(LinkedHashMap <String,String> testCaseData) {
		browserAction.WaittoPageLoad();
		browserAction.ScrollAndSetText(usernameField, testCaseData.get("Username2"), imgPath, "Username for 2nd customer has been entered");
		browserAction.ScrollAndSetText(passwordField, testCaseData.get("Password2"), imgPath, "Password for 2nd customer has been entered");
		clickOnLoginButton();
	}
	
	public void clickOnLoginButton() {
		browserAction.scrollToElement(loginButton);
		browserAction.clickJS(loginButton);
	}
	
}
