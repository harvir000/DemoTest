package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;

public class VTBAccountHomePage {
	
	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	
	/***
	 * Constructor
	 */
	
	public VTBAccountHomePage(WebDriver driver,Reporting report)
	{
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
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[1]")
	private WebElement findOutMoreButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios1")
	private WebElement individualAccountRadioButton;
	
	@FindBy(how = How.CSS, using = "input#optionsRadios2")
	private WebElement jointAccountRadioButton;
	
	@FindBy(how = How.CSS, using = "input#option1")
	private WebElement newCustomerRadioButton;
	
	@FindBy(how = How.CSS, using = "input#option2")
	private WebElement existingCustomerRadioButton;
	
	@FindBy(how = How.CSS, using = "input#option3")
	private WebElement bothNewCustomerRadioButton;
	
	@FindBy(how = How.CSS, using = "input#option4")
	private WebElement bothExistingCustomerRadioButton;
	
	@FindBy(how = How.CSS, using = "input#option5")
	private WebElement oneNewAndOneExistingCustomerRadioButton;
	
	@CacheLookup
	@FindBy(xpath = "//button[@id='applyNow']")
	private WebElement applyNowButton;
	
	/***
	 * Methods
	 */
	
	/*Set Account Type i.e. Individual or Joint Account*/
	public void chooseAccountType(LinkedHashMap <String,String> testCaseData) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (testCaseData.get("AccountType").equalsIgnoreCase("Individual Account")) {
			browserAction.clickJS(individualAccountRadioButton, imgPath, "Selecting Individual Account");
		} else {
			browserAction.clickJS(jointAccountRadioButton, imgPath, "Selecting Joint Account");
		}
	}
	
	/*Set Customer Type i.e. New, Existing, Both New, Both Existing or One New and One Existing*/
	public void chooseCustomerType(LinkedHashMap <String,String> testCaseData)
	{
		if (testCaseData.get("CustomerType").equalsIgnoreCase("New Customer"))
		{
			browserAction.clickJS(newCustomerRadioButton, imgPath, "Selecting New Customer");
		}
		else if (testCaseData.get("CustomerType").equalsIgnoreCase("Existing Customer")) {
			browserAction.clickJS(existingCustomerRadioButton, imgPath, "Selecting Existing Customer");
		}
		else if (testCaseData.get("CustomerType").equalsIgnoreCase("Both New Customers")) {
			browserAction.clickJS(bothNewCustomerRadioButton, imgPath, "Selecting both New Customers");
		}
		else if (testCaseData.get("CustomerType").equalsIgnoreCase("Both Existing Customers")) 
		{
			browserAction.clickJS(bothExistingCustomerRadioButton, imgPath, "Selecting both Existing Customers");
		} 
		else {
			browserAction.clickJS(oneNewAndOneExistingCustomerRadioButton, imgPath, "Selecting one New and one Existing Customer");
		}
	}
	
	/*Choose Account Opening Criteria*/
	public void setAccountOpeningCriteria(LinkedHashMap <String,String> testCaseData) {
		
		browserAction.WaittoPageLoad();
		
	/*Selecting AccountType and CustomerType*/
		browserAction.ScrollAndClickOnElement(findOutMoreButton, imgPath, "Selecting Find out More");
		chooseAccountType(testCaseData);
		chooseCustomerType(testCaseData);
		browserAction.clickJS(applyNowButton);
	}
	
}
