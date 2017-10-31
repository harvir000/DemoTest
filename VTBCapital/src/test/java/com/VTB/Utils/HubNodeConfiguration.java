package com.VTB.Utils;

import java.io.File;
import java.io.FileWriter;

import com.VTB.Utils.XMLReader;

public class HubNodeConfiguration {
	
	public XMLReader xml;
	public String basePath = new File("").getAbsolutePath() + "\\GridBatchFiles\\";
	public String startCommand = "cmd.exe /c start " + basePath;

	File node;
	File hub;
	FileWriter nodeWriter;
	FileWriter hubWriter;
	
	/***
	 * default Constructor
	 */
	public HubNodeConfiguration() {
		xml = new XMLReader("config.xml");
	}
	
	/***
	 * function to create batch file for Nodes and Hub
	 */
	public void createHubAndNode() {
		EnvironmentPropertiesReader propReader=EnvironmentPropertiesReader.getInstance();
		
		try {
			String SeleniumServer = xml.readTagVal("SELENIUMSERVER");
			
			/*Close all the Cmd files first*/
			closeHubAndNode();
			
			/*Creating Batch files for IE, GC and FF based on IPPORTS, BROWSERS and SELENIUM SERVER in 'config.xml'*/
			for(int counter = 0; counter< Integer.parseInt(xml.readTagVal("NUMOFTHREADS")); counter ++) {
				String BrowserConfig = xml.readTagVal("IPPORT" + (counter+1));
				String BrowserName = xml.readTagVal("BROWSER" + (counter+1));
				String PortNumber = BrowserConfig.substring(BrowserConfig.length()-11, BrowserConfig.length()-7);
				String deviceName=propReader.getProperty("deviceName");
				
				node = new File(basePath + BrowserName + ".bat");
				
				if(node.exists()) {
					node.delete();
				}
				
				nodeWriter = new FileWriter(node);
				nodeWriter.write("cd " + basePath + " ");
				nodeWriter.write("\r\n");
		        if (BrowserName.equalsIgnoreCase("IE") || BrowserName.equalsIgnoreCase("Internet Explorer")) {
		        	nodeWriter.write("java -Dwebdriver.ie.driver=.\\IEDriverServer.exe -jar .\\selenium-server-standalone-" + SeleniumServer + ".jar -role node -hub http://localhost:4444/wd/register -port" + " " + PortNumber);
				} else if (BrowserName.equalsIgnoreCase("GC") || BrowserName.equalsIgnoreCase("Google Chrome") || BrowserName.equalsIgnoreCase("Chrome")){
					nodeWriter.write("java -Dwebdriver.chrome.driver=.\\chromedriver.exe -jar .\\selenium-server-standalone-" + SeleniumServer + ".jar -role node -hub http://localhost:4444/wd/register -port" + " " + PortNumber);
				} else if (BrowserName.equalsIgnoreCase("FF") || BrowserName.equalsIgnoreCase("Firefox")){
					nodeWriter.write("java -Dwebdriver.gecko.driver=.\\geckodriver.exe -jar .\\selenium-server-standalone-" + SeleniumServer + ".jar -role node -hub http://localhost:4444/wd/register -port" + " " + PortNumber);
				}
		        
				/* else if (BrowserName.equalsIgnoreCase("android") || BrowserName.equalsIgnoreCase("androidChrome")){
					// appium -a 127.0.0.1 -p 4726 --no-reset --bootstrap-port 4727 -U 94d8dcbf --nodeconfig D:\Users\harvesingh\Desktop\GridSetup\jsonRealDevice.json
						nodeWriter.write("appium -a 127.0.0.1 -p "+PortNumber+" --no-reset --bootstrap-port 4727 -U "+deviceName+" --nodeconfig .\\jsonAppiumConfig.json");
					}*/
		        nodeWriter.close();
			}
			
			/*Creating Batch files for Hub based on SELENIUM SERVER in 'config.xml'*/
			hub = new File(basePath + "Hub.bat");
			
			if(hub.exists()) {
				hub.delete();
			}
			
			hubWriter = new FileWriter(hub);
			hubWriter.write("cd " + basePath + " ");
			hubWriter.write("\r\n");
			hubWriter.write("java -jar .\\selenium-server-standalone-" + SeleniumServer + ".jar -role hub");
			hubWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	/***
	 * function to start Hub and Node
	 */
	public void startHubAndNode() {
		
		try {
			/*Starting Hub*/
			Thread.sleep(500);

	        Runtime.getRuntime().exec(startCommand + "Hub.bat");
	        
	        /*Starting Nodes*/
			for(int counter = 0; counter< Integer.parseInt(xml.readTagVal("NUMOFTHREADS")); counter ++) {
				String BrowserName = xml.readTagVal("BROWSER" + (counter+1));
				Thread.sleep(Integer.parseInt(((counter+1) + "000"))/2);
				if(!BrowserName.equalsIgnoreCase("androidchrome"))
					Runtime.getRuntime().exec(startCommand + BrowserName +".bat");
				   
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	/***
	 * function to close all the cmd.exe files and browserDrivers.exe
	 */
	public void closeHubAndNode() {
		try {
			
			/*Closing java.exe and cmd.exe files*/
			Runtime.getRuntime().exec("taskkill /f /im java.exe");
			Runtime.getRuntime().exec("taskkill /f /im cmd.exe");
			
			/*Closing chromedriver.exe, IEDriverServer.exe and geckodriver.exe files*/
			Runtime.getRuntime().exec("taskkill /im chromedriver.exe /f");
			Runtime.getRuntime().exec("taskkill /im IEDriverServer.exe /f");
			Runtime.getRuntime().exec("taskkill /im geckodriver.exe /f");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
