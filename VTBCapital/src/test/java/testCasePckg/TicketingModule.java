package testCasePckg;

import java.io.File;

import org.openqa.selenium.WebDriver;

import reportingPckg.Reporting;
import utilsPckg.Excel;
import utilsPckg.TCSelection;
import utilsPckg.UtillityClass;
import utilsPckg.XMLReader;

public class TicketingModule extends UtillityClass implements TCSelection
{
	public Reporting report;
	public XMLReader xml;
	public Excel excel;
	WebDriver Driver;
	
	public TicketingModule()
	{
		excel = new Excel();
		xml = new XMLReader(new File("config.xml").getAbsolutePath());
	}
	
	public void testCasesSelection(String testCaseId, Reporting reportObj, WebDriver driver) {
		// TODO Auto-generated method stub
		this.Driver = driver;
		if(testCaseId.equalsIgnoreCase("TC0001"))
		{
			TC0001();
		}
		else if(testCaseId.equalsIgnoreCase("TC0002"))
		{
			TC0002();
		}
	}
	
	public void TC0001()
	{
		System.out.println("Method1, Class Module 2");
		driver.get("http://www.yahoo.com");
	}
	public void TC0002()
	{
		System.out.println("Method2, Class Module 2");
		driver.get("http://www.google.com");
	}
	
}
