package com.VTB.Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Clock;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class WebElementWait extends FluentWait<WebElement> {

	public final static long DEFAULT_SLEEP_TIMEOUT = 500;

	public WebElementWait(WebElement element, long timeOutInSeconds) {
		this(element, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, DEFAULT_SLEEP_TIMEOUT);
	}

	public WebElementWait(WebElement element, long timeOutInSeconds, long sleepInMillis) {
		this(element, new SystemClock(), Sleeper.SYSTEM_SLEEPER, timeOutInSeconds, sleepInMillis);
	}

	protected WebElementWait(WebElement element, Clock clock, Sleeper sleeper, long timeOutInSeconds, long sleepTimeOut) {
		super(element, clock, sleeper);
		withTimeout(timeOutInSeconds, TimeUnit.SECONDS);
		pollingEvery(sleepTimeOut, TimeUnit.MILLISECONDS);
		ignoring(NotFoundException.class);
	}

	public boolean isValid(WebElement e) {
		try {
			WebElementWait wait = new WebElementWait(e, 1);
			wait.until(new Function<WebElement, WebElement>() {
				public WebElement apply(WebElement d) {
					return d.findElement(By.xpath("./following-sibling::div[class='invalid-icon']"));
				}
			});
			return false;
		} catch (TimeoutException exception) {
			return true;
		}
	}


	/**
	 *  to wait for element visibility 
	 *  @param: first param would be driver instance
	 *  @param: ByLocator: second param would be By Locator
	 */

	public boolean waitForElement(WebDriver driver, final By byLocator)

	{
		boolean dataToBeReturn=false;

		WebDriverWait wait=new WebDriverWait(driver, Constant.MAX_WAIT_TIME);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
		WebElement tempElement=wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver)
			{
				return driver.findElement(byLocator);
			}

		}
				);
		if(tempElement.isDisplayed())
		{
			dataToBeReturn=true;

		}

		return dataToBeReturn;

	}
	
	/**
	 *  to wait for element visibility 
	 *  @param: first param would be driver instance
	 *  @param: WebElement: second param would be By Locator
	 */

	public WebElement waitForElement(WebDriver driver,  WebElement element)

	{
		

		WebDriverWait wait=new WebDriverWait(driver, Constant.MAX_WAIT_TIME);
		wait.pollingEvery(1, TimeUnit.SECONDS);
		wait.ignoring(StaleElementReferenceException.class,NoSuchElementException.class);
		WebElement tempElement=wait.until(ExpectedConditions.visibilityOf(element));
		
		
		

		return tempElement;

	}
	
	
	
	

}
