package com.VTB.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.Reporting;
import com.applitools.eyes.Eyes;


public class VTBApplicantSelectionPage {
	
	WebDriver driver;
	Reporting report;
	BrowserActions browserAction;
	String imgPath = "";
	public Eyes eyes;
	
	/***
	 * Constructor
	 */
	public VTBApplicantSelectionPage(WebDriver driver,Reporting report, Eyes eyes){
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
	
	/***
	 * function to verify Applicant selection Page Title
	 */
	public void verifyApplicantSelectionPageTitle() {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		browserAction.WaittoPageLoad();
		eyes.checkWindow("VTB Application Selection Page");
		report.assertThat(browserAction.verifyPageTitle("VTB Capital Direct | Apply | Applicant selection"), driver.getTitle(),"VTB Capital Direct | Apply | Applicant selection","VTB capital Start Page has been opened succesfully", "opened Page has different Title");
	}
	
	/***
	 * function to Select User1 Login Button
	 */
	public void clickOnUser1LoginButton(){
		verifyApplicantSelectionPageTitle();
		browserAction.scrollToElement(user1LoginButton);
		browserAction.clickJS(user1LoginButton);
	}
	
	/***
	 * function to Select User1 SignUp Button
	 */
	public void clickOnUser1SignupButton(){
		verifyApplicantSelectionPageTitle();
		browserAction.scrollToElement(user1SignupButton);
		browserAction.clickJS(user1SignupButton);
	}
	
	/***
	 * function to Select User2 Login Button
	 */
	public void clickOnUser2LoginButton(){
		browserAction.scrollToElement(user2LoginButton);
		browserAction.clickJS(user2LoginButton);
	}
	
	/***
	 * function to Select User2 SignUp Button
	 */
	public void clickOnUser2SignupButton(){
		browserAction.scrollToElement(user2SignupButton);
		browserAction.clickJS(user2SignupButton);
	}
	
	/***
	 * function to Select Continue Securely
	 */
	public void clickOnContinueSecurely() {
		browserAction.scrollToElement(continueSecurelyButton);
		browserAction.clickJS(continueSecurelyButton);
	}
	
}
