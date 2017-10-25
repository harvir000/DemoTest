package testCasePckg;

import java.io.File;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.VTB.Pages.*;

import utilsPckg.*;
import reportingPckg.*;
public class BookingModule extends UtillityClass implements TCSelection{

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
		report.test = report.extentReports.startTest(testCaseId);
		ArrayList<String> testData = excel.getTestData(xml.readTagVal("TESTDATAEXCELPATH"), this.getClass().getSimpleName(), testCaseId);

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
	}
	
	public void TC1001(String rowValue, Reporting report)
	{
		
		/*Initialize Browser setup and Pages*/
		VTBCapitalHomePage objHomePage 				= 	new VTBCapitalHomePage(Driver,report);
		VTBAccountHomePage	objAccountHomePage 		= 	new VTBAccountHomePage(Driver,report);
		VTBStartPage objStartPage					=	new VTBStartPage(Driver,report);
		VTBPersonalDetailsPage objPersonalDetails	= 	new VTBPersonalDetailsPage(Driver,report);
		VTBSummaryPage objSummaryPage				=	new VTBSummaryPage(Driver,report);
		
	/*VTB Capital Home Page*/
		try {
			objHomePage.selectPlanType(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	/*Account Opening Criteria Page*/
		try {
			objAccountHomePage.setAccountOpeningCriteria(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*Eligibility Criteria Page*/
		try {
			objStartPage.setEligilibiltyCriteria(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		/*Personal Details Page*/
		try {
			objPersonalDetails.enterPersonalDetails(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		//Summary Page
		try {
			objSummaryPage.enterOTPDetails(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
//		CreateUserPage CrtUPg = PageFactory.initElements(Driver, CreateUserPage.class);
//		
//		
//		
////		CrtUPg.createUserProfile();
//		
////		System.out.println("TC0001, Class Module 1");
////		CrtUPg.FirstName.sendKeys("TOM");
////		report.extentReportlogSteps_Update(LogStatus.PASS, "Enter First name", "First name is", report.imagePath, Driver.findElement(By.id("firstname")));
////		
////		Driver.findElement(By.id("lastname")).sendKeys("Jason");
////		report.extentReportlogSteps_Update(LogStatus.PASS, "Enter Last name", "Last name is", report.imagePath, Driver.findElement(By.id("lastname")));
////		Driver.findElement(By.id("day")).click();
////		Driver.findElement(By.xpath("//*[@id='day']/option[7]")).click();
////		
////		Driver.findElement(By.id("month")).click();
////		Driver.findElement(By.xpath("//*[@id='month']/option[6]")).click();
////		
////		Driver.findElement(By.id("year")).click();
////		Driver.findElement(By.xpath(".//*[@id='year']/option[83]")).click();
////		
////		Driver.findElement(By.id("mobileno")).sendKeys("9810198101");
////		Driver.findElement(By.id("username")).sendKeys("TJason");
////		Driver.findElement(By.id("email")).sendKeys("TJason4296@hotmail.com");
////		Driver.findElement(By.id("cemail")).sendKeys("TJason4296@hotmail.com");
////		Driver.findElement(By.id("password")).sendKeys("@9810198101@");
////		Driver.findElement(By.id("cpassword")).sendKeys("@9810198101@");
////		
////		
////		Driver.findElement(By.id("question")).click();
////		Driver.findElement(By.xpath(".//*[@id='question']/option[4]")).click();
////		Driver.findElement(By.id("answer")).sendKeys("@NAHI BATAUNGA@");
////		
////		report.extentReportlogSteps_Update(LogStatus.PASS, "First Login step", "Here we are giving some extra details", report.imagePath, null);
//	
//		System.out.println("TC0001, Class Module 1");
//		Driver.findElement(By.id("firstname")).sendKeys("TOM");
//		report.extentReportlogSteps_Update(LogStatus.PASS, "Enter First name", "First name is", report.imagePath, Driver.findElement(By.id("firstname")));
//		Driver.findElement(By.id("lastname")).sendKeys("Jason");
//		report.extentReportlogSteps_Update(LogStatus.PASS, "Enter Last name", "Last name is", report.imagePath, Driver.findElement(By.id("lastname")));
//		Driver.findElement(By.id("day")).click();
//		Driver.findElement(By.xpath("//*[@id='day']/option[7]")).click();
//		
//		Driver.findElement(By.id("month")).click();
//		Driver.findElement(By.xpath("//*[@id='month']/option[6]")).click();
//		
//		Driver.findElement(By.id("year")).click();
//		Driver.findElement(By.xpath(".//*[@id='year']/option[83]")).click();
//		
//		Driver.findElement(By.id("mobileno")).sendKeys("9810198101");
//		Driver.findElement(By.id("username")).sendKeys("TJason");
//		Driver.findElement(By.id("email")).sendKeys("TJason4296@hotmail.com");
//		Driver.findElement(By.id("cemail")).sendKeys("TJason4296@hotmail.com");
//		Driver.findElement(By.id("password")).sendKeys("@9810198101@");
//		Driver.findElement(By.id("cpassword")).sendKeys("@9810198101@");
//		
//		
//		Driver.findElement(By.id("question")).click();
//		Driver.findElement(By.xpath(".//*[@id='question']/option[4]")).click();
//		Driver.findElement(By.id("answer")).sendKeys("@NAHI BATAUNGA@");
//		
//		report.extentReportlogSteps_Update(LogStatus.PASS, "First Login step", "Here we are giving some extra details", report.imagePath, null);
	}

	public void TC1002(String rowValue, Reporting report)
	{
		
		/*Initialize Browser setup and Pages*/
		VTBCapitalHomePage objHomePage 				= 	new VTBCapitalHomePage(Driver,report);
		VTBAccountHomePage	objAccountHomePage 		= 	new VTBAccountHomePage(Driver,report);
		VTBStartPage objStartPage					=	new VTBStartPage(Driver,report);
		VTBPersonalDetailsPage objPersonalDetails	= 	new VTBPersonalDetailsPage(Driver,report);
		VTBSummaryPage objSummaryPage				=	new VTBSummaryPage(Driver,report);
		
	/*VTB Capital Home Page*/
		try {
			objHomePage.selectPlanType(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	/*Account Opening Criteria Page*/
		try {
			objAccountHomePage.setAccountOpeningCriteria(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	/*Eligibility Criteria Page*/
		try {
			objStartPage.setEligilibiltyCriteria(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	/*Personal Details Page*/
		try {
			objPersonalDetails.enterPersonalDetails(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	/*Summary Page*/
		try {
			objSummaryPage.enterOTPDetails(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void TC1003(String rowValue, Reporting report)
	{
		
		/*Initialize Browser setup and Pages*/
		VTBCapitalHomePage objHomePage 				= 	new VTBCapitalHomePage(Driver,report);
		VTBAccountHomePage	objAccountHomePage 		= 	new VTBAccountHomePage(Driver,report);
		VTBStartPage objStartPage					=	new VTBStartPage(Driver,report);
		VTBPersonalDetailsPage objPersonalDetails	= 	new VTBPersonalDetailsPage(Driver,report);
		VTBSummaryPage objSummaryPage				=	new VTBSummaryPage(Driver,report);
		
	/*VTB Capital Home Page*/
		try {
			objHomePage.selectPlanType(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	/*Account Opening Criteria Page*/
		try {
			objAccountHomePage.setAccountOpeningCriteria(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	/*Eligibility Criteria Page*/
		try {
			objStartPage.setEligilibiltyCriteria(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	/*Personal Details Page*/
		try {
			objPersonalDetails.enterPersonalDetails(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	/*Summary Page*/
		try {
			objSummaryPage.enterOTPDetails(rowValue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
