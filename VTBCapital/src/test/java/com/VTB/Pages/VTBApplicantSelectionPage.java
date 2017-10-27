package com.VTB.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;


public class VTBApplicantSelectionPage {
	
	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	
	/***
	 * Constructor
	 */
	
	public VTBApplicantSelectionPage(WebDriver driver,Reporting report){
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
	
	@FindBy(how = How.CSS, using = "#loginforuser1")
	private WebElement user1LoginButton;
	
	@FindBy(how = How.CSS, using = "#signupforuser1")
	private WebElement user1SignupButton;
	
	@FindBy(how = How.CSS, using = "#loginforuser2")
	private WebElement user2LoginButton;
	
	@FindBy(how = How.CSS, using = "#signupforuser2")
	private WebElement user2SignupButton;
	
	@FindBy(how = How.CSS, using = "#signupcontinue")
	private WebElement continueSecurelyButton;
	
	/***
	 * Methods
	 */
	
	/*Select User1 Login Button*/
	public void clickOnUser1LoginButton(){
		browserAction.WaittoPageLoad();
		browserAction.scrollToElement(user1LoginButton);
		browserAction.clickJS(user1LoginButton);
	}
	
	/*Select User1 SignUp Button*/
	public void clickOnUser1SignupButton(){
		browserAction.WaittoPageLoad();
		browserAction.scrollToElement(user1SignupButton);
		browserAction.clickJS(user1SignupButton);
	}
	
	/*Select User2 Login Button*/
	public void clickOnUser2LoginButton(){
		browserAction.scrollToElement(user2LoginButton);
		browserAction.clickJS(user2LoginButton);
	}
	
	/*Select User2 SignUp Button*/
	public void clickOnUser2SignupButton(){
		browserAction.scrollToElement(user2SignupButton);
		browserAction.clickJS(user2SignupButton);
	}
	
	/*Selecting Continue Securely*/
	public void clickOnContinueSecurely() {
		browserAction.scrollToElement(continueSecurelyButton);
		browserAction.clickJS(continueSecurelyButton);
	}
	
}
