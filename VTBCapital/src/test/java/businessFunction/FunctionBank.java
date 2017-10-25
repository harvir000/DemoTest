package businessFunction;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FunctionBank {
	
	public WebDriver driver;
	public JavascriptExecutor jse;
	
	public FunctionBank(WebDriver Driver) {
		this.driver = Driver;
		jse = (JavascriptExecutor)driver;
	}
	
	public void WaittoPageLoad()
	{
		// Below line of code will wait till page loaded completely
		Boolean readyStateComplete = false;
		try {
	        while (!readyStateComplete)
	        {
	            JavascriptExecutor executor = (JavascriptExecutor) driver;
	            readyStateComplete = ((String) executor.executeScript("return document.readyState")).equals("complete");
	        }
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
	}
	
	public void click(WebElement ele)
	{
		try{
			ele.click();
		}
		catch(Exception e)
		{
			System.out.println("Unable to perform click.");
		}
	}
	
	public void clickOnElement(WebElement ele) {
		try{
			jse.executeScript("arguments[0].click();", ele);
		}
		catch(Exception e)
		{
			System.out.println("Unable to perform click.");
		}
	}
	
	public void scrollToElement(WebElement ele) {
		try{
			jse.executeScript("arguments[0].scrollIntoView(true);",ele);
		}
		catch(Exception e)
		{
			System.out.println("Unable to perform scroll.");
		}
	}
	
	public void enterText(WebElement ele, String value) {
		ele.sendKeys(value);
	}
	
	public String WaitForElementPresent(WebDriver driver,WebElement ele)
	{
		String Flag = "False";
		for (int counter = 0;; counter++) 
		{
			try {
			if (counter >= 40) 
			{
				System.out.println("TimeOut");
				break;
			}
			try { 
//					if(finder.equalsIgnoreCase("ID"))
//					{
//						if (ele.isDisplayed())
						if(! ele.equals(null))
						{
							System.out.println("Element took "+counter+" seconds to get visible");
//							takeSnapshot("Element took "+counter+" seconds to get visible<> EXISTS - PASS",PASS, driver, fL);
							Flag = "True";
							break;	
						}
//					}
//					else if(finder.equalsIgnoreCase("XPATH"))
//					{
//						if (driver.findElement(By.xpath(LocatorName)).isDisplayed())
//						{
//							System.out.println("Element took "+counter+" seconds to get visible");
////							takeSnapshot("Element took "+counter+" seconds to get visible<> EXISTS - PASS",PASS, driver, fL);
//							Flag = "True";
//							break;	
//						}
//					}
				} 
			catch (Exception e) {}
			Thread.sleep(1000);
			System.out.println("in wait method"+counter);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		return Flag;
//		performAction("xpath","//span[contains(text(),'Skyform')]/../span[3]","","click","","Skyform menu");
		
	} 
	
	
	public  WebElement getElement(String objectType,String objectNameProperty,String idx) throws NullPointerException
	{
		 int index=0;
	        try
	        {
	            index=Integer.parseInt(idx);
	        }
	        catch(Exception e)
	        {
	        }
	        ArrayList <WebElement> elementList = new ArrayList<WebElement>();
	            try
	            {
	                if(objectType.equalsIgnoreCase("ID"))
	                {
	                    elementList=(ArrayList<WebElement>)driver.findElements(By.id(objectNameProperty));
	                }
	                else if(objectType.equalsIgnoreCase("NAME"))
	                {
	                    elementList=(ArrayList<WebElement>)driver.findElements(By.name(objectNameProperty));
	                }
	                else if(objectType.equalsIgnoreCase("LINK"))
	                {
	                    elementList=(ArrayList<WebElement>)driver.findElements(By.linkText(objectNameProperty));
	                }
	                else if(objectType.equalsIgnoreCase("PARTIALLINK"))
	                {
	                    elementList=(ArrayList<WebElement>)driver.findElements(By.partialLinkText(objectNameProperty));
	                }
	                else if(objectType.equalsIgnoreCase("CLASS"))
	                {
	                    elementList=(ArrayList<WebElement>)driver.findElements(By.className(objectNameProperty));
	                }
	                else if(objectType.equalsIgnoreCase("CSS"))
	                {
	                    elementList=(ArrayList<WebElement>)driver.findElements(By.cssSelector(objectNameProperty));            
	                }
	                else if(objectType.equalsIgnoreCase("TAG"))
	                {
	                    elementList=(ArrayList<WebElement>)driver.findElements(By.tagName(objectNameProperty));
	                }
	                else if(objectType.equalsIgnoreCase("XPATH"))
	                {
	                	elementList=(ArrayList<WebElement>)driver.findElements(By.xpath(objectNameProperty));
	                }
	                return elementList.get(index);
	            }
	            catch(Exception e)
	            {
	            	System.out.println("Error : Unable to find element. Error message "+e.getMessage());
	            	return null;
	            }
	            
		
	}
	
	public void jsClickSecurityCertificate()
	{
		// Following code will click on "Continue to this website (not recommended)." link if exists.
		try {
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			System.out.println("Info     :     Clicked on 'Continue to this website (not recommended).' link");
		}
		catch(Exception e) {}
	}

}
