package com.VTB.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateUserPage {
	
	WebDriver driver;
	public CreateUserPage(WebDriver driver)
	{
		this.driver = driver;
	}
	@FindBy(how = How.ID, id ="firstname")
	public WebElement FirstName;
	
	@FindBy(how = How.ID, id ="lastname")
	public WebElement lastname;
	
	@FindBy(how = How.ID, id ="day")
	public WebElement day;
	
	@FindBy(how = How.XPATH, xpath ="//*[@id='day']/option[7]")
	public WebElement currentDay;
	
	@FindBy(how = How.ID, id ="month")
	public WebElement month;
	
	@FindBy(how = How.XPATH, xpath ="//*[@id='month']/option[6]")
	public WebElement currentmonth;
	
	@FindBy(how = How.ID, id ="year")
	public WebElement year;
	
	@FindBy(how = How.XPATH, xpath =".//*[@id='year']/option[83]")
	public WebElement currentyear;
	
	@FindBy(how = How.ID, id ="mobileno")
	public WebElement mobileno;
	
	@FindBy(how = How.ID, id ="username")
	public WebElement username;
	
	@FindBy(how = How.ID, id ="email")
	public WebElement email;
	
	@FindBy(how = How.ID, id ="cemail")
	public WebElement cemail;
	
	@FindBy(how = How.ID, id ="password")
	public WebElement password;
	
	@FindBy(how = How.ID, id ="cpassword")
	public WebElement cpassword;
	
	@FindBy(how = How.ID, id ="question")
	public WebElement question;
	
	@FindBy(how = How.XPATH, xpath =".//*[@id='question']/option[4]")
	public WebElement questionnum;
	
	@FindBy(how = How.ID, id ="answer")
	public WebElement answer;
	
	
	public void createUserProfile()
	{
		FirstName.sendKeys("Tom");
		lastname.sendKeys("Johnson");
		day.click();
		currentDay.click();
		month.click();
		currentmonth.click();
		year.click();
		currentyear.click();
		mobileno.sendKeys("9810198101");
		username.sendKeys("tJohnson");
		email.sendKeys("tJohnson@hotmail.com");
		cemail.sendKeys("tJohnson@hotmail.com");
		password.sendKeys("@9810198101@");
		cpassword.sendKeys("@9810198101@");
		question.click();
		questionnum.click();
		answer.sendKeys("@NAHI BATAUNGA@");
	}

}
