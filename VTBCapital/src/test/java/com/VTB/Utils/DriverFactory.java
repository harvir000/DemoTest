package com.VTB.Utils;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	public  WebDriver driver;
	static public ArrayList <String>browser = new ArrayList<String>();
	static public ArrayList <String>ipPort = new ArrayList<String>();
	static String username = "vikas.pandey%40soprasteria.com"; // Your username
	static String authkey = "uc54890330d6f5a5";
	static String credential="vikas.pandey%40soprasteria.com:uc54890330d6f5a5";//temp

	static public AndroidUtils androidUtils=new AndroidUtils();
	static public Queue<String> connectedDevices=new LinkedList<>(androidUtils.getConnectedDevices());
	//	static int  CURRENT_BROWSER=-1;
	int  CURRENT_BROWSER=-1;
	static final int INTERNET_EXPLORER=1;
	static final int FIREFOX=2;
	static final int CHROME=3;
	static final int OPERA=4;
	static final int ANDROID=5;
	static String SelectedBrowserName="NONE";

	public EnvironmentPropertiesReader propReader=EnvironmentPropertiesReader.getInstance();
	public XMLReader xml;

	public DriverFactory()
	{
		//EnvVar = new EnvironmentVars(); // Intialized here so that browser and ipPort set in global variable
		xml = new XMLReader("config.xml");
		//connectedDevices=
	}

	public void ipBrowserConfig()
	{
		/***********************************************************************
		 * FF is not working on my machine hence I commented code for the same
		 ***********************************************************************/
		for(int counter = 0; counter< Integer.parseInt(xml.readTagVal("NUMOFTHREADS")); counter ++)
		{
			browser.add(xml.readTagVal("BROWSER"+(counter+1)));
			ipPort.add(xml.readTagVal("IPPORT"+(counter+1)));
		}
	}
	public WebDriver OpenBrowser(String name)
	{

		String currentipport =  ipPort.get(Integer.parseInt(name)-1);
		String currentBrowser = browser.get((Integer.parseInt(name)-1));

		System.out.println(currentipport +" on browser "+browser.get((Integer.parseInt(name)-1)));
		if(currentBrowser.equalsIgnoreCase("IE"))
		{
			CURRENT_BROWSER=1;
		}
		else if(currentBrowser.equalsIgnoreCase("Opera"))
		{
			CURRENT_BROWSER=4;
		}
		else if(currentBrowser.equalsIgnoreCase("GC"))
		{
			CURRENT_BROWSER=3;
		}

		else if(currentBrowser.equalsIgnoreCase("ANDROIDCHROME"))
		{
			CURRENT_BROWSER=5;
		}

		else if(currentBrowser.equalsIgnoreCase("FF"))
		{
			CURRENT_BROWSER=2;
		}


		try
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			try
			{
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			}
			catch(Exception e)
			{
				System.out.println("Error in ");
			}
			try
			{
				capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
			}
			catch(Exception e)
			{
				System.out.println("Unable to set unexpected Alert = accept");
			}         
			
			switch(CURRENT_BROWSER)
			{
			case INTERNET_EXPLORER:
				SelectedBrowserName="Internet Explorer";
				DesiredCapabilities ieCapabilities=DesiredCapabilities.internetExplorer();
				
				
				if(propReader.getProperty("isCBT").equalsIgnoreCase("true"))
				{
					ieCapabilities.setCapability("name", "VTB Automation");
					ieCapabilities.setPlatform(Platform.WIN8);
					ieCapabilities.setCapability("screenResolution", "1366x768");
					ieCapabilities.setCapability("record_video", "false");

					driver = new RemoteWebDriver(new URL("http://" + username+ ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), ieCapabilities);

				}
				
				else
				{
					ieCapabilities.setPlatform(Platform.ANY);
				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name)-1)), ieCapabilities);
				}
				driver.manage().window().maximize();
				break;
				
			case FIREFOX:
				SelectedBrowserName="Mozilla FireFox";

				DesiredCapabilities	firefoxCapabilities = DesiredCapabilities.firefox();
				firefoxCapabilities.setCapability("acceptSslCerts", true);
				firefoxCapabilities.setCapability("acceptInsecureCerts", true);

				if(propReader.getProperty("isCBT").equalsIgnoreCase("true"))
				{
					firefoxCapabilities.setCapability("name", "VTB Automation");
					firefoxCapabilities.setPlatform(Platform.WIN8);
					firefoxCapabilities.setCapability("screenResolution", "1366x768");
					firefoxCapabilities.setCapability("record_video", "false");

					driver = new RemoteWebDriver(new URL("http://" + username+ ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), firefoxCapabilities);

				}
				else
				{
					driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name)-1)), firefoxCapabilities);
				
				}
				driver.manage().window().maximize();
				break;


			case CHROME:                            
				SelectedBrowserName="Google Chrome";
				DesiredCapabilities chromeCapabilities=DesiredCapabilities.chrome();


				if(propReader.getProperty("isCBT").equalsIgnoreCase("true"))
				{
					chromeCapabilities.setCapability("name", "VTB Automation");
					chromeCapabilities.setPlatform(Platform.WIN8);
					chromeCapabilities.setCapability("screenResolution", "1366x768");
					chromeCapabilities.setCapability("record_video", "false");

					driver = new RemoteWebDriver(new URL("http://" + username+ ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"), chromeCapabilities);
				}

				else
				{
					driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name)-1)), chromeCapabilities);
				}

				driver.manage().window().maximize();
				break;


			case ANDROID:                            
				SelectedBrowserName="android chrome";

				DesiredCapabilities androidDesiredCapabilities=DesiredCapabilities.android();
				DesiredCapabilities androidDesiredCapabilitieqs=DesiredCapabilities.android();
				androidDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,propReader.getProperty("deviceName"));
				//androidDesiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,connectedDevices.poll());
				androidDesiredCapabilities.setCapability("platformName", "android");
				androidDesiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
				androidDesiredCapabilities.setCapability("newCommandTimeout", 60*3);
				androidDesiredCapabilities.setCapability("clearSystemFiles", true);

				androidDesiredCapabilities.setCapability("noReset", true);
				androidDesiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

				if(propReader.getProperty("isCBT").equalsIgnoreCase("true"))
				{

					driver=new AndroidDriver(new URL("http://" + username+ ":" + authkey + "@hub.crossbrowsertesting.com:80/wd/hub"),androidDesiredCapabilities);
				}
				else
				{
					driver=new AndroidDriver(new URL(ipPort.get(Integer.parseInt(name)-1)),androidDesiredCapabilities);

				}
				break;

			case OPERA:
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Error ID 46: Could not open Browser "+e);
			System.out.println("Error ID 46: Could not open Browser ");
		}
		return driver;
	}
}
