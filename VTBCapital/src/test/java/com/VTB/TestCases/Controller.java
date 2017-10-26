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
import com.VTB.Utils.DriverFactory;
import com.VTB.Utils.XMLReader;

import businessFunction.*;

public class Controller{


	public WebDriver driver;
	public Reporting report;
	String BrowserIP;

	public Controller(){
	}

	public WebDriver getDriver(String name) throws InterruptedException{
		DriverFactory utilObj = new DriverFactory();
		// Following 'OpenBrowser' method will create & return driver and we are recieving.

		// will wait as per thread.... e.g. thread 2 will for 2 seconds
		Thread.sleep(Integer.parseInt(name+"000"));
		driver = utilObj.OpenBrowser(name);
		BrowserIP =  utilObj.browser.get(Integer.parseInt(name)-1);
		return driver;
	}


	public void controllerMethod() throws Exception
	{
		//		System.out.println("Number of availabe sheets in test data "+excel.getNumberOfSheets(xml.readTagVal("TESTDATAEXCELPATH")));

		// all data will get received here, we have created method for it so that we should not be creating object everytime calling method.
		LinkedHashMap<String, ArrayList<String>> map = new Excel().getMasterSheetData();

		FactoryMethod FactMethodObj = new FactoryMethod();
		FunctionBank FunBank = new FunctionBank(this.driver);
		// here we are passing browser name for report
		report = new Reporting(this.driver, BrowserIP);
		/****************************************************************************************************************
		 * Following will read data from Master.xlsx file and proceed if it will find either "Y" or "YES" in terms		* 
		 * of ignoring the upper and lower cases
		 * 
		 * Here we are loading all the test data in arraylist if flag is yes against the test case id
		 ***************************************************************************************************************/
		for(String key: map.keySet())
		{
			ArrayList<String> values = map.get(key);
			for(String value: values)
			{
				if(value.equalsIgnoreCase("Yes")||value.equalsIgnoreCase("Y"))
				{
					// create object for report
					driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
					driver.navigate().to(new XMLReader(new File("config.xml").getAbsolutePath()).readTagVal("URL"));
					handleSecurityCertificate();
					FunBank.WaittoPageLoad();

					String testid 		   	= key;
					String testDescription 	= values.get(0);
					String module			= values.get(2);
					System.out.println(testid);
					System.out.println(testDescription);
					TCSelection TestCaseSelectionObj = FactMethodObj.testModulesSelection(module);
					if(TestCaseSelectionObj != null)
					{
						// Now create the object of test cases class.
						//test cases will identified with TESTID as mentioned in master sheet and testdata sheet.

						report.test = report.extentReports.startTest(testid);
						TestCaseSelectionObj.testCasesSelection(testid, report, this.driver);
						report.extentReports.endTest(report.test);
					}
					else
					{
						throw new Exception("Unable to create Object of class : "+module);
					}
				}
			}
		}
		//		driver.close();
	}  // End controllerMethod method



	public void handleSecurityCertificate() {

		WebElement element = null;
		JavascriptExecutor js = (JavascriptExecutor) driver;
		element = (WebElement) js.executeScript("return document.getElementById('overridelink');");		
		if (element != null) {
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
	}
}


