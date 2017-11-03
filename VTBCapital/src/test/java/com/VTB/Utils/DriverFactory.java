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
			DesiredCapabilities capability;
			DesiredCapabilities firefoxCapability;
			switch(CURRENT_BROWSER)
			{
			case INTERNET_EXPLORER:
				SelectedBrowserName="Internet Explorer";
				capability=DesiredCapabilities.internetExplorer();
				capability.setPlatform(Platform.ANY);
				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name)-1)), capability);
				driver.manage().window().maximize();
				break;
			case FIREFOX:
				SelectedBrowserName="Mozilla FireFox";
				
				firefoxCapability = DesiredCapabilities.firefox();
				firefoxCapability.setCapability("acceptSslCerts", true);
				firefoxCapability.setCapability("acceptInsecureCerts", true);
				
				FirefoxProfile profile = new FirefoxProfile();
				profile.setAcceptUntrustedCertificates(true); 
				profile.setAssumeUntrustedCertificateIssuer(false);
				
				//capability.setPlatform(Platform.ANY);
				//firefoxCapability.setCapability(FirefoxDriver.PROFILE, profile);
				
				driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name)-1)), firefoxCapability);
				
				driver.manage().window().maximize();
				break;

			case CHROME:                            
				SelectedBrowserName="Google Chrome";
				//capability=DesiredCapabilities.chrome();
				//capability.setPlatform(Platform.ANY);
				//String userName="vikas.pandey%40soprasteria.com";
			//	String api_key="uc54890330d6f5a5";

				//driver = new RemoteWebDriver(new URL(ipPort.get(Integer.parseInt(name)-1)), capability);
				//driver = new RemoteWebDriver(new URL("http://" + userName+ ":" + api_key + "@hub.crossbrowsertesting.com:80/wd/hub"), capability);
				//driver = new RemoteWebDriver(new URL("http://vikas.pandey%40soprasteria.com:uc54890330d6f5a5@hub.crossbrowsertesting.com:80/wd/hub"), capability);

				//"http://vikas.pandey@soprasteria.com:uc54890330d6f5a5@hub.crossbrowsertesting.com:80/wd/hub"
				
				
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("name", "Login Form Example");
		        caps.setCapability("build", "1.0");
		        caps.setCapability("browserName", "Internet Explorer");
		        caps.setCapability("version", "11");
		        caps.setCapability("platform", "Windows 10");
		        caps.setCapability("screenResolution", "1366x768");
		        caps.setCapability("record_video", "true");

		        
		       // RemoteWebDriver driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub"), caps);
		        URI uri = new URI("http://" + username + ":" + authkey +"@hub.crossbrowsertesting.com:80/wd/hub");

		        	RemoteWebDriver driver = new RemoteWebDriver(uri.toURL(), caps);
		        System.out.println(driver.getSessionId());
				
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
				
				driver=new AndroidDriver(new URL(ipPort.get(Integer.parseInt(name)-1)),androidDesiredCapabilities);
				
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
