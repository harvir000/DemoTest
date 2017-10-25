package testCasePckg;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import reportingPckg.Reporting;
import utilsPckg.Excel;
import utilsPckg.FactoryMethod;
import businessFunction.*;
import utilsPckg.TCSelection;
import utilsPckg.UtillityClass;
import utilsPckg.XMLReader;

public class Controller{
	
	
	public WebDriver driver;
	public Reporting report;
	String BrowserIP;
	
	public Controller(){
	}
	
	public WebDriver getDriver(String name) throws InterruptedException{
		UtillityClass utilObj = new UtillityClass();
		// Following 'OpenBrowser' method will create & return driver and we are recieving.
	
		// will wait as per thread.... e.g. thread 2 will for 2 seconds
		Thread.sleep(Integer.parseInt(name+"000"));
		driver = utilObj.OpenBrowser(name);
		BrowserIP =  utilObj.browser.get(Integer.parseInt(name)-1);
		return driver;
	}
	
	
	public void controllerMethod() throws Exception{
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
}


