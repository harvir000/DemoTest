package com.VTB.TestCases;

import java.io.File;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.VTB.Pages.*;
import com.VTB.Utils.*;

public class BookingModule extends DriverFactory implements TCSelection{

	public Reporting report;
	public XMLReader xml;
	public Excel excel;
	WebDriver Driver;

	public BookingModule() 
	{
		excel = new Excel();
		xml = new XMLReader(new File("config.xml").getAbsolutePath());
		
	}

	public void testCasesSelection(String testCaseId, Reporting reportObj, WebDriver driver) {
		this.Driver = driver;
		this.report = reportObj;

		if(testCaseId.equalsIgnoreCase("TC_1001"))
		{
			try {
				TC1001(testCaseId,  report);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(testCaseId.equalsIgnoreCase("TC_1002"))
		{
			try {
				TC1002(testCaseId,  report);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if(testCaseId.equalsIgnoreCase("TC_1003"))
		{
			try {
				TC1003(testCaseId,  report);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void TC1001(String testCaseId, Reporting report) throws Exception
	{

		/*Initialize Pages*/
		VTBCapitalHomePage objHomePage 				= 	new VTBCapitalHomePage(Driver,report);
		VTBAccountHomePage	objAccountHomePage 		= 	new VTBAccountHomePage(Driver,report);
		VTBStartPage objStartPage					=	new VTBStartPage(Driver,report);
		VTBPersonalDetailsPage objPersonalDetails	= 	new VTBPersonalDetailsPage(Driver,report);
		VTBSummaryPage objSummaryPage				=	new VTBSummaryPage(Driver,report);

		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData	= 	excel.getTestCaseData(testCaseId);

		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Personal Details Page*/
		objPersonalDetails.enterPersonalDetails(testCaseData);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData);
	}

	public void TC1002(String testCaseId, Reporting report) throws Exception
	{

		/*Initialize Pages*/
		VTBCapitalHomePage objHomePage 				= 	new VTBCapitalHomePage(Driver,report);
		VTBAccountHomePage	objAccountHomePage 		= 	new VTBAccountHomePage(Driver,report);
		VTBStartPage objStartPage					=	new VTBStartPage(Driver,report);
		VTBPersonalDetailsPage objPersonalDetails	= 	new VTBPersonalDetailsPage(Driver,report);
		VTBSummaryPage objSummaryPage				=	new VTBSummaryPage(Driver,report);

		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData	= 	excel.getTestCaseData(testCaseId);

		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Personal Details Page*/
		objPersonalDetails.enterPersonalDetails(testCaseData);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData);
	}

	public void TC1003(String testCaseId, Reporting report) throws Exception
	{

		/*Initialize Pages*/
		VTBCapitalHomePage objHomePage 				= 	new VTBCapitalHomePage(Driver,report);
		VTBAccountHomePage	objAccountHomePage 		= 	new VTBAccountHomePage(Driver,report);
		VTBStartPage objStartPage					=	new VTBStartPage(Driver,report);
		VTBPersonalDetailsPage objPersonalDetails	= 	new VTBPersonalDetailsPage(Driver,report);
		VTBSummaryPage objSummaryPage				=	new VTBSummaryPage(Driver,report);

		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData	= 	excel.getTestCaseData(testCaseId);

		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Personal Details Page*/
		objPersonalDetails.enterPersonalDetails(testCaseData);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData);
	}

}
