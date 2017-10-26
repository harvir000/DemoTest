package com.VTB.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForLocator {
	
	public int maxElementWait = 10;
	
	/**
	 * @param driver
	 * @param element
	 * @return
	 */
	public boolean waitForElement(WebDriver driver, WebElement element) {
		return waitForElement(driver, element, maxElementWait);
	}

/**
 * To wait for the specific element on the page
 * 
 * @param driver : WebDriver
 * @param element: WebElement to wait for
 * @param maxWait: Max wait duration
 * @return boolean - return true if element is present else return false
 */
	public boolean waitForElement(WebDriver driver, WebElement element, int maxWait) {
		boolean statusOfElementToBeReturned = false;
		
		WebDriverWait wait = new WebDriverWait(driver, maxWait);
		try {
			WebElement waitElement = wait.until(ExpectedConditions.visibilityOf(element));
			if (waitElement.isDisplayed() && waitElement.isEnabled()) {
				statusOfElementToBeReturned = true;
			}
		} catch (Exception e) {
			statusOfElementToBeReturned = false;
		}
		return statusOfElementToBeReturned;
	}
	
}
