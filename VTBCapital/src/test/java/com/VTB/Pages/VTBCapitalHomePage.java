package com.VTB.Pages;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;

public class VTBCapitalHomePage {
	
	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	
	/***
	 * Constructor
	 */
	public VTBCapitalHomePage(WebDriver driver,Reporting report){
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
	private WebElement interestRate1_60Button;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[2]")
	private WebElement interestRate2_20Button;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[3]")
	private WebElement interestRate2_60Button;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[4]")
	private WebElement interestRate3_90Button;
	
	@FindBy(how = How.XPATH, using = "(//button[@class='module-button module-button-green-hov bright-green pull-right'])[5]")
	private WebElement interestRate3_10Button;

	/***
	 * Methods
	 */
	
	/***
	 * function to Choose Plan Type
	 * @param testCaseData
	 */
	public void choosePlan(LinkedHashMap <String,String> testCaseData) {
		if (testCaseData.get("PlanType").equalsIgnoreCase("120 Day Notice Account")) {
			browserAction.scrollToElement(interestRate1_60Button);
			browserAction.clickJS(interestRate1_60Button);
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("1 Year Fixed Term")) {
			browserAction.scrollToElement(interestRate2_20Button);
			browserAction.clickJS(interestRate2_20Button);
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("2 Year Fixed Term")) {
			browserAction.scrollToElement(interestRate2_60Button);
			browserAction.clickJS(interestRate2_60Button);
		}else if (testCaseData.get("PlanType").equalsIgnoreCase("5 Year Tracker")) {
			browserAction.scrollToElement(interestRate3_90Button);
			browserAction.clickJS(interestRate3_90Button);
		} else {
			browserAction.scrollToElement(interestRate3_10Button);
			browserAction.clickJS(interestRate3_10Button);
		}
	}
	
	/***
	 * function to Select Plan Type
	 * @param testCaseData
	 */
	public void selectPlanType(LinkedHashMap <String,String> testCaseData) {
		browserAction.WaittoPageLoad();
//		report.assertThat(browserAction.verifyPageTitle("Home"), driver.getTitle(),"Home","VTB capital has been opened succesfully", "opened application has different Title");
		report.assertThat(browserAction.verifyPageTitle("Home"),"VTB Capital Home Page has been opened succesfully", "VTB Capital Home Page application has different Title");
		choosePlan(testCaseData);
	}
	
}
