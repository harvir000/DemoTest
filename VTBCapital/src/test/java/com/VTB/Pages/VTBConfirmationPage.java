package com.VTB.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;
import com.applitools.eyes.Eyes;

public class VTBConfirmationPage {
	
	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	public Eyes eyes;
	
	/***
	 * Constructor
	 */
	
	public VTBConfirmationPage(WebDriver driver,Reporting report, Eyes eyes){
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
	
	@FindBy(how = How.XPATH, using = "//h1[@class='a1 col-xs-8']")
	private WebElement headingThankYouForApplication;
	
	@FindBy(how = How.XPATH, using = "//div[@class='t2'][1]")
	private WebElement applicationReferenceNumber;
	
	@FindBy(how = How.XPATH, using = "//div[@class='t2'][2]")
	private WebElement savingAccountType;
	
	/***
	 * Methods
	 */
	
}
