package com.VTB.Utils;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.maven.surefire.shade.org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Reporting  {

	public String folderName;
	public String ImagesFolder;
	public String folder;
	public String folderpath;
	WebDriver driver;
	public String imagePath = "";
	public ExtentReports extentReports;
	public ExtentTest test;
	DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ss_SSaa");
	Date date = new Date();
	//public EnvironmentVars envVar = new EnvironmentVars();
	
	public Reporting(WebDriver driver, String Browserip) throws Exception, InterruptedException 
	{
		this.driver = driver;
		Thread.sleep(Integer.parseInt(Thread.currentThread().getName()+"000"));
		createFolder();
//		System.out.println("Reporting calss :"+envVar.browsername );
		extentReports = new ExtentReports(folderpath + "\\"+Browserip +"-" + dateFormat.format(date) + ".html", false);
		extentReports.loadConfig(new File("extent-config.xml"));
	}
	
	public Reporting()
	{	}
    
	public String createFolder() 
	{
		String basePath = new File("").getAbsolutePath();
		String Uniqueid = generateCurrentDateNumber();
		folderName = "";
		try
		{
			File file = new File(basePath+"\\test-output");
	        if (!file.exists()) 
	        {
	            if (file.mkdir()) 
	            {
	                System.out.println("Directory is created!");
	            } 
	        }
	        folderName = basePath+"\\test-output\\"+Uniqueid;
	        file = new File(folderName);
	        if (file.mkdir()) 
	        {
	            System.out.println("Run result directory '"+folderName+"' is created!");
	            file = new File(folderName+"\\Images");
	            if (file.mkdir()) 
	            {
	                System.out.println(file+" 'Images' directory is created!");
	                ImagesFolder=folderName+"\\Images";
	            }
	        }
	        else 
	        {
	            System.out.println("Failed to create sub-directory!");
	        }
		}
		catch(Exception e)
		{
			folderName = "";
			System.out.println("Oops...there is something wrong while creating reporting folder(s).");
		}
	    setFolderpath(folderName);
		setfolder(Uniqueid);
	    return folderName;   
	}

	public void setFolderpath(String folderpath)
	{
		this.folderpath = folderpath;
		imagePath = folderpath+"\\Images\\";
	}
	
	public void setfolder(String foldername)
	{
		this.folder = foldername;
	}
	
	private String generateCurrentDateNumber() 
	{
		
		// Following method as thread are hitting at the same time hence folder not get created.
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Date dNow = new Date();
		SimpleDateFormat sFrmt = new SimpleDateFormat("yyyyMMddhhmmss");
		return sFrmt.format(dNow)+Long.toString(timestamp.getTime());
//		return sFrmt.format(dNow);
	}
	
	public String getscreenshot(String fileName, WebElement element) 
	{
		// Thread.sleep(1000);
		DateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy__hh_mm_ss_SSaa");
		Date date = new Date();
		String screenshotfile = dateFormat.format(date) + ".png";
		try 
		{
			if (element != null) 
			{
				JavascriptExecutor javascript = (JavascriptExecutor) this.driver;
				javascript.executeScript("arguments[0].style.border='3px solid red'", element);
				// }Change - Moved Screenshot Command out of bracket
				FileUtils.copyFile(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE),
						new File(fileName+screenshotfile));
//				javascript.executeScript("arguments[0].style.border='3px solid black'", element);
				javascript.executeScript("arguments[0].style.border='3px solid red'", element);
			} 
			else 
			{
				JavascriptExecutor javascript = (JavascriptExecutor) this.driver;
				FileUtils.copyFile(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE),
						new File(fileName+screenshotfile));
			}
		} 
		catch (Exception e) 
		{

			try
			{
				JavascriptExecutor javascript = (JavascriptExecutor) this.driver;
				FileUtils.copyFile(((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE),
						new File(fileName+screenshotfile));
			}
			catch(Exception e1)
			{
				System.out.println(e1.getMessage());
			}
			e.printStackTrace();
		}
		return "./../"+folder+"/Images/" + screenshotfile;
	}

	public void extentReportlogSteps_Update(LogStatus status, String stepname, String Details, String filenamePath,WebElement element) {
		highlightWebElement(driver, element);
		if(!filenamePath.equalsIgnoreCase(""))
		{
			try {
				test.log(status, stepname, Details + "<div align='right' style='float:right'><a href="+ getscreenshot(filenamePath, element) + ">Screenshot</a></div>");
			}
			catch(Exception e)
			{
				test.log(status, stepname, Details + "<div align='right' style='float:right'>Unable to take screenshot</div>");	
			}
		}
		else
		{
			test.log(status, stepname, Details);
		}
		extentReports.flush();
	}
//	public void extentReportlogSteps_Update(LogStatus status, String stepname, String Details, String filenamePath,WebElement element) 
//	{
//			highlightWebElement(driver, element);
//			try {
//			test.log(status, stepname, Details + "<div align='right' style='float:right'><a href="+ getscreenshot(filenamePath, element) + ">Screenshot</a></div>");
//			}
//			catch(Exception e)
//			{
//				test.log(status, stepname, Details + "<div align='right' style='float:right'>Unable to take screenshot</div>");	
//			}
//			extentReports.flush();
//	}
	public String getImageFileLocation() 
	{
		return imagePath.replace("test-output/", "");
	}
	
	/***
	 * function to highlight WebElement
	 * @param driver
	 * @param element
	 */
	public void highlightWebElement(WebDriver driver, WebElement element){
		JavascriptExecutor js	=	(JavascriptExecutor)driver; 

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		try {
			Thread.sleep(100);
		} 
		catch (InterruptedException e) {
			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
	}
	
}