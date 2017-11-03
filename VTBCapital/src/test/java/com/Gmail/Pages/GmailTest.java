package com.Gmail.Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GmailTest {
	
	private String proxyHost = "10.110.9.75";
    private int proxyPort = 8080;
    private String ignoreProxy = "localhost, 127.0.0.1";
	
    /***
     * Function to get WebDriver with Manually enabled proxies
     * @return
     */
    public WebDriver getDriver() {
    	
    	/*Set GeckoDriver Path*/
    	System.setProperty("webdriver.gecko.driver", new File("").getAbsolutePath() +  "\\GridBatchFiles\\geckodriver.exe");
		
    	/*Set Firefox Profile*/
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
        profile.setPreference("network.proxy.http", proxyHost);
        profile.setPreference("network.proxy.http_port", proxyPort);
        profile.setPreference("network.proxy.ssl", proxyHost);
        profile.setPreference("network.proxy.ssl_port", proxyPort);
        profile.setPreference("network.proxy.socks", proxyHost);
        profile.setPreference("network.proxy.socks_port", proxyPort);
        profile.setPreference("network.proxy.ftp", proxyHost);
        profile.setPreference("network.proxy.ftp_port", proxyPort);
        profile.setPreference("network.proxy.no_proxies_on", ignoreProxy);
		
        /*Set Firefox Capabilities*/
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability(FirefoxDriver.PROFILE, profile);
        
        @SuppressWarnings("deprecation")
		WebDriver driver = new FirefoxDriver(capabilities);
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.gmail.com");
        return driver;
	}
    
    /***
     * Function to get Verification Code for Account Opening Process via Gmail
     * @param driver
     * @return
     */
    public String getCodeForAOP(WebDriver driver) {
    	
    	GmailHomePage objHomePage = new GmailHomePage(driver);
        GmailInboxPage objInboxPage = new GmailInboxPage(driver);
        
        objHomePage.loginEmail("aggarwalnits5", "Nitish052");
        String code = objInboxPage.getVerificationCode();
        
        return code;
    }
     
	public static void main(String [] args) {
		
		GmailTest objTest = new GmailTest();
		WebDriver driver = objTest.getDriver();
		System.out.println(objTest.getCodeForAOP(driver));
        
	}
	
}
