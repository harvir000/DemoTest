package com.VTB.TestCases;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.VTB.Utils.Excel;
import com.VTB.Utils.FactoryMethod;
import com.VTB.Utils.Reporting;
import com.VTB.Utils.TCSelection;
import com.VTB.Utils.AppliTool;
import com.VTB.Utils.BrowserActions;
import com.VTB.Utils.DriverFactory;
import com.VTB.Utils.XMLReader;
import com.applitools.eyes.Eyes;

public class Controller{

	public WebDriver driver;
	public Reporting report;
	String BrowserIP;
	
	public Eyes eyes;

	public Controller(){
	}
	
	/***
	 * function to get Driver,
	 * wait as per thread.. i.e. thread 2 will for 2 seconds,
	 * 'OpenBrowser' method will create & return driver
	 * @param name
	 * @return
	 * @throws InterruptedException
	 */
	public WebDriver getDriver(String name) throws InterruptedException{
		AppliTool tool = new AppliTool();
		eyes = tool.getEyes();
		
		DriverFactory utilObj = new DriverFactory();
		Thread.sleep(Integer.parseInt(name+"000"));
		driver = utilObj.OpenBrowser(name);
		BrowserIP =  utilObj.browser.get(Integer.parseInt(name)-1);
		return driver;
	}

	/***
	 * function to read data from Master Excel sheet and
	 * execute Test cases having status marked as 'Yes' or 'Y'
	 * @throws Exception
	 */
	public void controllerMethod() throws Exception
	{
		
		/*Getting complete data from MasterSheet so that object won't be created every time*/
		LinkedHashMap<String, ArrayList<String>> map = new Excel().getMasterSheetData();
		
		/*Passing browser name for report so that every browser will be having its own Report*/
		report = new Reporting(this.driver, BrowserIP);
		
		FactoryMethod FactMethodObj = new FactoryMethod();
		BrowserActions browserAction = new BrowserActions(this.driver, report);
		
		/*Execute Test Cases having status marked as 'Yes' or 'Y'*/
		for(String key: map.keySet())
		{
			ArrayList<String> values = map.get(key);
			for(String value: values)
			{
				if(value.equalsIgnoreCase("Yes")||value.equalsIgnoreCase("Y"))
				{	
					String testid 		   	= key;
					String testDescription 	= values.get(0);
					String module			= values.get(2);
					
					driver = eyes.open(driver, testid, testDescription);
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.navigate().to(new XMLReader(new File("config.xml").getAbsolutePath()).readTagVal("URL"));
					handleSecurityCertificate();
					browserAction.WaittoPageLoad();

					System.out.println(testid);
					System.out.println(testDescription);
					
					TCSelection TestCaseSelectionObj = FactMethodObj.testModulesSelection(module);
					if(TestCaseSelectionObj != null)
					{
						/*Creating object of test case class. It is identified with TESTID as mentioned in master sheet and testdata sheet*/
						report.test = report.extentReports.startTest(testid);
						TestCaseSelectionObj.testCasesSelection(testid, report, this.driver, this.eyes);
						report.extentReports.endTest(report.test);
					}
					else
					{
						throw new Exception("Unable to create Object of class : "+module);
					}
					
					/*Close Eyes Instance for Current Test*/

					eyes.close();
					eyes.abortIfNotClosed();
				}
			}
		}
		//		driver.close();
	}

	/***
	 * function to handle Security certificate
	 */
	public void handleSecurityCertificate() {
		try {
			WebElement element = null;
			JavascriptExecutor js = (JavascriptExecutor) driver;
			element = (WebElement) js.executeScript("return document.getElementById('overridelink');");		
			if (element != null) {
				driver.navigate().to("javascript:document.getElementById('overridelink').click()");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}