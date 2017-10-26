package com.VTB.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.Excel;
import com.VTB.Utils.Reporting;

public class VTBLoginPage {

	WebDriver driver;
	Excel objExcel;
	Reporting report;

	/* Constructor */
	public VTBLoginPage(WebDriver driver, Reporting report) {
		this.driver = driver;
		this.report = report;
		// Initialise Element
		PageFactory.initElements(driver, this);
	}

	/* Locators */
	@FindBy(how = How.CSS, using = "#username")
	private WebElement usernameField;

	@FindBy(how = How.CSS, using = "#password")
	private WebElement passwordField;

	@FindBy(how = How.CSS, using = "#loginBtn")
	private WebElement loginButton;

	/* Methods */
	public void setUsernameField(String value) {
		usernameField.sendKeys(value);
		// funbank.enterText(usernameField, value);
	}

	public void setPasswordField(String value) {
		passwordField.sendKeys(value);
		// funbank.enterText(passwordField, value);
	}

	public void clickOnLoginButton() {
		// jsExecuter.clickOnElement(loginButton);
	}

}
