package com.Gmail.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class GmailHomePage {
	
	WebDriver driver;
	
	/***
	 * Constructor
	 */
	public GmailHomePage(WebDriver driver)
	{
		this.driver = driver;
        
        /*Initialize Elements*/
        PageFactory.initElements(driver, this);
   }

	/***
	 * Locators
	 */
	
	@FindBy(how = How.CSS, using = "#identifierId")
	private WebElement usernameField;
	
	@FindBy(how = How.CSS, using = ".CwaK9")
	private WebElement nextButton;
	
	@FindBy(how = How.CSS, using = "input[name=password]")
	private WebElement passwordField;
	
	
	/***
	 * Methods
	 */
	
	public void loginEmail(String username, String password) {
		try {
			usernameField.sendKeys(username);
			nextButton.click();
			Thread.sleep(2000);
			passwordField.sendKeys(password);
			nextButton.click();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
