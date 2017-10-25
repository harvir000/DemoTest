package com.VTB.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import businessFunction.FunctionBank;
import reportingPckg.Reporting;
import utilsPckg.Excel;
import utilsPckg.JavaScriptExecuterUtility;

public class VTBApplicantSelectionPage {
	
	WebDriver driver;
	Actions action;
	JavascriptExecutor jse;
	Excel objExcel;
	WebDriverWait wait;
	Reporting report;
	JavaScriptExecuterUtility jsExecuter;
	FunctionBank funbank;
	
	/*Constructor*/
	public VTBApplicantSelectionPage(WebDriver driver,Reporting report){
		this.driver=driver;
	    this.report = report;
	    //Initialise Element
	    PageFactory.initElements(driver, this);
	    jsExecuter = new JavaScriptExecuterUtility(driver);
	    funbank = new FunctionBank(driver);
   }

	/*Locators*/
	@FindBy(how = How.CSS, using = "#loginforuser1")
	private WebElement user1LoginButton;
	
	@FindBy(how = How.CSS, using = "#signupforuser1")
	private WebElement user1SignupButton;
	
	@FindBy(how = How.CSS, using = "#loginforuser2")
	private WebElement user2LoginButton;
	
	@FindBy(how = How.CSS, using = "#signupforuser2")
	private WebElement user2SignupButton;
	
	/*Methods*/
	public void clickOnUser1LoginButton(){
		jsExecuter.clickOnElement(user1LoginButton);
//		funbank.clickOnElement(user1LoginButton);
	}
	
	public void clickOnUser1SignupButton(){
		jsExecuter.clickOnElement(user1SignupButton);
//		funbank.clickOnElement(user1SignupButton);
	}
	
	public void clickOnUser2LoginButton(){
		jsExecuter.clickOnElement(user2LoginButton);
//		funbank.clickOnElement(user2LoginButton);
	}
	
	public void clickOnUser2SignupButton(){
		jsExecuter.clickOnElement(user2SignupButton);
//		funbank.clickOnElement(user2SignupButton);
	}
	
}
