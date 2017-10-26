package com.VTB.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.VTB.Utils.Excel;
import com.VTB.Utils.JavaScriptExecuterUtility;

public class VTBConfirmationPage {
	
	WebDriver driver;
	Actions action;
	JavascriptExecutor jse;
	Excel objExcel;
	WebDriverWait wait;
	JavaScriptExecuterUtility jsExecuter;
	
	/*Constructor*/
	public VTBConfirmationPage(WebDriver driver){
       this.driver=driver;
       //Initialise Elements
       PageFactory.initElements(driver, this);
       jsExecuter = new JavaScriptExecuterUtility(driver);
   }

	/*Locators*/
	@FindBy(how = How.XPATH, using = "//h1[@class='a1 col-xs-8']")
	private WebElement headingThankYouForApplication;
	
	@FindBy(how = How.XPATH, using = "//div[@class='t2'][1]")
	private WebElement applicationReferenceNumber;
	
	@FindBy(how = How.XPATH, using = "//div[@class='t2'][2]")
	private WebElement savingAccountType;
	
	/*Methods*/
	
}
