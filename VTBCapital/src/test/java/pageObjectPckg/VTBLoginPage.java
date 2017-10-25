package pageObjectPckg;

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

public class VTBLoginPage {
	
	WebDriver driver;
	Actions action;
	JavascriptExecutor jse;
	Excel objExcel;
	WebDriverWait wait;
	Reporting report;
	JavaScriptExecuterUtility jsExecuter;
	FunctionBank funbank;
	
	/*Constructor*/
	public VTBLoginPage(WebDriver driver,Reporting report){
		this.driver=driver;
	    this.report = report;
	    //Initialise Element
	    PageFactory.initElements(driver, this);
	    jsExecuter = new JavaScriptExecuterUtility(driver);
	    funbank = new FunctionBank(driver);
   }

	/*Locators*/
	@FindBy(how = How.CSS, using = "#username")
	private WebElement usernameField;
	
	@FindBy(how = How.CSS, using = "#password")
	private WebElement passwordField;
	
	@FindBy(how = How.CSS, using = "#loginBtn")
	private WebElement loginButton;
	
	
	/*Methods*/
	public void setUsernameField(String value) {
		usernameField.sendKeys(value);
//		funbank.enterText(usernameField, value);
	}
	
	public void setPasswordField(String value) {
		passwordField.sendKeys(value);
//		funbank.enterText(passwordField, value);		
	}
	
	public void clickOnLoginButton(){
		jsExecuter.clickOnElement(loginButton);
//		funbank.clickOnElement(loginButton);
	}
	
}
