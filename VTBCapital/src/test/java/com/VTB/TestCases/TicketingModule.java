package com.VTB.TestCases;

import java.io.File;

import org.openqa.selenium.WebDriver;

import com.VTB.Utils.Excel;
import com.VTB.Utils.Reporting;
import com.VTB.Utils.TCSelection;
import com.VTB.Utils.DriverFactory;
import com.VTB.Utils.XMLReader;

public class TicketingModule extends DriverFactory implements TCSelection
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
