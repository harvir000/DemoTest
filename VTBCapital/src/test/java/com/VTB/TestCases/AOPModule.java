package com.VTB.TestCases;

import java.io.File;
import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;

import com.VTB.Pages.VTBAccountHomePage;
import com.VTB.Pages.VTBApplicantSelectionPage;
import com.VTB.Pages.VTBCapitalHomePage;
import com.VTB.Pages.VTBLoginPage;
import com.VTB.Pages.VTBPersonalDetailsPage;
import com.VTB.Pages.VTBStartPage;
import com.VTB.Pages.VTBSummaryPage;
import com.VTB.Utils.DriverFactory;
import com.VTB.Utils.Excel;
import com.VTB.Utils.Reporting;
import com.VTB.Utils.TCSelection;
import com.VTB.Utils.XMLReader;

public class AOPModule extends DriverFactory implements TCSelection {
	
	public Reporting report;
	public XMLReader xml;
	public Excel excel;
	public WebDriver Driver;
	public VTBCapitalHomePage objHomePage;
	public VTBAccountHomePage	objAccountHomePage;
	public VTBStartPage objStartPage;
	public VTBApplicantSelectionPage objAppSelectionPage;
	public VTBLoginPage objLoginPage;
	public VTBPersonalDetailsPage objPersonalDetails;
	public VTBSummaryPage objSummaryPage;
	
	/***
	 * default Constructor
	 */
	public AOPModule() 
	{
		excel = new Excel();
		xml = new XMLReader(new File("config.xml").getAbsolutePath());
	}
	
	/***
	 * implementation of Interface-TCSelection's method
	 */
	public void testCasesSelection(String testCaseId, Reporting reportObj, WebDriver driver) {
		this.Driver = driver;
		this.report = reportObj;
		
		/*Initializing Pages Object*/
		objHomePage = new VTBCapitalHomePage(Driver, report);
		objAccountHomePage = new VTBAccountHomePage(Driver, report);
		objStartPage = new VTBStartPage(Driver, report);
		objAppSelectionPage = new VTBApplicantSelectionPage(Driver, report);
		objLoginPage = new VTBLoginPage(Driver, report);
		objPersonalDetails = new VTBPersonalDetailsPage(Driver, report);
		objSummaryPage = new VTBSummaryPage(Driver, report);
		
		try {
			if(testCaseId.equalsIgnoreCase("TC_1001"))
			{
				TC1001(testCaseId,  report);
			}
			else if(testCaseId.equalsIgnoreCase("TC_1002"))
			{
				TC1002(testCaseId,  report);
			}
			else if(testCaseId.equalsIgnoreCase("TC_1003"))
			{
				TC1003(testCaseId,  report);
			}
			else if(testCaseId.equalsIgnoreCase("TC_1008"))
			{
				TC1008(testCaseId,  report);
			}
			else if(testCaseId.equalsIgnoreCase("TC_1019"))
			{
				TC1019(testCaseId,  report);
			}
			else if(testCaseId.equalsIgnoreCase("TC_1020"))
			{
				TC1020(testCaseId,  report);
			}
			else if(testCaseId.equalsIgnoreCase("TC_1021"))
			{
				TC1021(testCaseId,  report);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * function to get Next Test ID 
	 * i.e. if current Id is TC_1001 then next will be TC_1002
	 * @param testCaseId
	 * @return
	 */
	public String getNextTestCaseId(String testCaseId) {
		String currentTestId = testCaseId.substring(testCaseId.length() - 4, testCaseId.length());
		int IdValue = Integer.parseInt(currentTestId);
		IdValue = IdValue + 1;
		String nextTestId = "TC_" + Integer.toString(IdValue);
		return nextTestId;
	}
	
	/***
	 * Test Cases Implementation
	 * @param testCaseId
	 * @param report
	 * @throws Exception
	 */
	public void TC1001(String testCaseId, Reporting report) throws Exception
	{

		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData = excel.getTestCaseData(testCaseId);

		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Personal Details Page*/
		objPersonalDetails.enterDetailsForNewCustomer(testCaseData);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData);
	}

	public void TC1002(String testCaseId, Reporting report) throws Exception
	{

		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData = excel.getTestCaseData(testCaseId);

		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Personal Details Page*/
		objPersonalDetails.enterDetailsForNewCustomer(testCaseData);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData);
	}

	public void TC1003(String testCaseId, Reporting report) throws Exception
	{

		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData = excel.getTestCaseData(testCaseId);

		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Personal Details Page*/
		objPersonalDetails.enterDetailsForNewCustomer(testCaseData);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData);
	}
	
	public void TC1008(String testCaseId, Reporting report) throws Exception
	{

		String nextTestId = getNextTestCaseId(testCaseId);
		
		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData	= excel.getTestCaseData(testCaseId);
		LinkedHashMap <String,String> testCaseData2	= excel.getTestCaseData(nextTestId);
		
		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Application Selection Page*/
		objAppSelectionPage.clickOnUser1SignupButton();
		/*Personal Details Page*/
		objPersonalDetails.enterDetailsForNewCustomer(testCaseData);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData);
		/*Application Selection Page*/
		objAppSelectionPage.clickOnUser2SignupButton();
		/*Personal Details Page*/
		objPersonalDetails.enterDetailsForNewCustomer(testCaseData2);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData2);
	}
	
	public void TC1019(String testCaseId, Reporting report) throws Exception
	{
		
		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData = excel.getTestCaseData(testCaseId);
		
		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Application Selection Page*/
		objAppSelectionPage.clickOnUser1LoginButton();
		/*Login Page*/
		objLoginPage.loginUser1(testCaseData);
		/*Application Selection Page*/
		objAppSelectionPage.clickOnUser2SignupButton();
		/*Personal Details Page*/
		objPersonalDetails.enterDetailsForNewCustomer(testCaseData);
		/*Summary Page*/
		objSummaryPage.enterOTPDetails(testCaseData);
	}
	
	public void TC1020(String testCaseId, Reporting report) throws Exception
	{
		
		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData = excel.getTestCaseData(testCaseId);
		
		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Login Page*/
		objLoginPage.loginUser1(testCaseData);
		/*Personal Details Page*/
		objPersonalDetails.enterDetailsForExistingCustomer(testCaseData);
		/*Summary Page*/
		objSummaryPage.clickOnContinueSecurely();
	}
	
	public void TC1021(String testCaseId, Reporting report) throws Exception
	{
		
		/*Getting Test Case Data*/
		LinkedHashMap <String,String> testCaseData = excel.getTestCaseData(testCaseId);
		
		/*VTB Capital Home Page*/
		objHomePage.selectPlanType(testCaseData);
		/*Account Opening Criteria Page*/
		objAccountHomePage.setAccountOpeningCriteria(testCaseData);
		/*Eligibility Criteria Page*/
		objStartPage.setEligilibiltyCriteria(testCaseData);
		/*Application Selection Page*/
		objAppSelectionPage.clickOnUser1LoginButton();
		/*Login Page*/
		objLoginPage.loginUser1(testCaseData);
		/*Application Selection Page*/
		objAppSelectionPage.clickOnUser2LoginButton();
		/*Login Page*/
		objLoginPage.loginUser2(testCaseData);
		/*Application Selection Page*/
		objAppSelectionPage.clickOnContinueSecurely();
		/*Personal Details Page*/
		objPersonalDetails.enterDetailsForExistingCustomer(testCaseData);
		/*Summary Page*/
		objSummaryPage.clickOnContinueSecurely();
	}
	
}
