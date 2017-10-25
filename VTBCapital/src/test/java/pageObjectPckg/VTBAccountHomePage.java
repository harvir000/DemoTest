package pageObjectPckg;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import functionLibrary.BrowserActions;
import reportingPckg.Reporting;
import utilsPckg.Excel;

public class VTBAccountHomePage {
	
	WebDriver driver;
	Actions action;
	Excel objExcel;
	Reporting report;
	BrowserActions browserAction;
	
	/*Constructor*/
	public VTBAccountHomePage(WebDriver driver,Reporting report){
		this.driver=driver;
        this.report = report;
        //Initialise Element
        PageFactory.initElements(driver, this);
        browserAction = new BrowserActions(driver, report);
   }

	/*Locators*/
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
	@FindBy(how = How.CSS, using = "#applyNow")
	private WebElement applyNowButton;
	
   /*Methods*/
	public void clickOnFindOutMoreButton(){
		browserAction.WaittoPageLoad();
		browserAction.click(findOutMoreButton, report.imagePath, "Selecting Find out More");
	}
	
	public void selectAccountType(WebElement element, String message){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		browserAction.clickJS(element, report.imagePath, message);
	}
	
	public void selectCustomerType(WebElement element, String message){
		browserAction.clickJS(element, report.imagePath, message);
	}
	
	public void clickOnApplyNowButton(){
		browserAction.clickJS(applyNowButton, report.imagePath, "Selecting Apply now");
	}
	
	/*Choose Account Opening Criteria*/
	public void setAccountOpeningCriteria(String rowValue) throws Exception {
		
		objExcel			=	new Excel();
		
	/*Getting Data from Test Data sheet*/
		LinkedHashMap <String,String> testCaseData	= objExcel.getTestCaseData(rowValue);
		
	/*Setting AccountType and CustomerType*/	
		clickOnFindOutMoreButton();
		
		if (testCaseData.get("AccountType").equalsIgnoreCase("Individual Account")) {
			selectAccountType(this.individualAccountRadioButton, "Selecting Individual Account");
		} else {
			selectAccountType(this.jointAccountRadioButton, "Selecting Joint Account");
		}
		
		if (testCaseData.get("CustomerType").equalsIgnoreCase("New Customer")) {
			selectCustomerType(this.newCustomerRadioButton, "Selecting New Customer");
		}else if (testCaseData.get("CustomerType").equalsIgnoreCase("Existing Customer")) {
			selectCustomerType(this.existingCustomerRadioButton, "Selecting Existing Customer");
		}else if (testCaseData.get("CustomerType").equalsIgnoreCase("Both New Customers")) {
			selectCustomerType(this.bothNewCustomerRadioButton, "Selecting both New Customers");
		}else if (testCaseData.get("CustomerType").equalsIgnoreCase("Both Existing Customers")) {
			selectCustomerType(this.bothExistingCustomerRadioButton, "Selecting both Existing Customers");
		} else {
			selectCustomerType(this.oneNewAndOneExistingCustomerRadioButton, "Selecting one New and one Existing Customer");
		}
		
		clickOnApplyNowButton();
	}
	
}
