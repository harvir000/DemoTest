package com.Gmail.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GmailInboxPage {

	WebDriver driver;
	JavascriptExecutor jse;
	
	/***
	 * Constructor
	 */
	public GmailInboxPage(WebDriver driver)
	{
		this.driver = driver;
        
        /*Initialize Elements*/
        PageFactory.initElements(driver, this);
        jse = (JavascriptExecutor)driver;
   }

	/***
	 * Locators
	 */
	
	@FindBy(how = How.XPATH, using = "//span[@name='donotreply']")
	private WebElement emailToOpen;
	
	@FindBy(how = How.CSS, using = ".gs")
	private WebElement emailContent;
	
	@FindBy(how = How.XPATH, using = "//div[@aria-label='More']")
	private WebElement moreButton;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Delete this message']")
	private WebElement deleteThisMessageButton;
	
	/***
	 * Methods
	 */
	
	public void openEmail(WebElement element) {
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public String getCodeFromContent() {
		String content = emailContent.getText();
		String contentParts[] = content.split("is: ");
		String code = contentParts[1];
		String verificationCode = code.substring(0, 4);
		return verificationCode;
	}
	
	public String getVerificationCode() {
		openEmail(emailToOpen);
		String verificationCode = getCodeFromContent();
		return verificationCode;
	}
	
}
