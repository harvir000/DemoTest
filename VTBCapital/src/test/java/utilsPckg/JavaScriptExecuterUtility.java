package utilsPckg;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class JavaScriptExecuterUtility {
	
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	public JavaScriptExecuterUtility(WebDriver driver){
		this.driver	= driver;
	}
	
	/***
	 * @description - alertPopUpWindow Function to Pop up a Alert on the current Page
	 */
    public void alertPopUpWindow(String message){
        js.executeScript("alert(message);");
        driver.switchTo().alert().accept();
    }
    
    /***
	 * @description - verifyTitle Function to verify that the Expected title is 
	 * equals to Actual title
	 */
    public void verifyTitle(String expectedValue){
        String title = js.executeScript("return document.title;").toString();
        Assert.assertEquals(expectedValue, title);
    }

    /***
	 * @description - refreshBrowser Function to Refresh the Browser
	 */
    public void refreshBrowser(){
        js.executeScript("history.go(0);");
    }
  
    /***
	 * @description - scrollDownUntilAnElementDisplayed Function to scroll down to the 
	 * page until the specified element displayed 
	 */
    public void scrollDownUntilAnElementDisplayed(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    
    /***
	 * @description - verifyURL Function to verify that the Expected URL is  
	 * equal to the Actual URL
	 */
    public void verifyURL(String expectedValue){
        String currentUrl	= (String) js.executeScript("return document.URL;");
        Assert.assertEquals(expectedValue, currentUrl);
    }
    
    /***
	 * @description - highLightAnElement Function to highlight the specified Element
	 */
    public void highLightAnElement(WebElement element){
//        js.executeScript("arguments[0].style.border='3px dotted blue'", element);
        
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			Thread.sleep(1000);
		} 
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
        
    }
	
    /***
	 * @description - clickOnElement Function to Click on the specified Element
	 */
    public void clickOnElement(WebElement element){
        js.executeScript("arguments[0].click();", element);
    }

}
