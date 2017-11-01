package com.VTB.Utils;

import com.VTB.Utils.HubNodeConfiguration;
import com.VTB.TestCases.Controller;

public class CreatingThreads {

	public XMLReader xml;
	
	/***
	 * default constructor 
	 */
	public CreatingThreads() {
		
		/*Creating and Starting Hub and Nodes*/
		HubNodeConfiguration objHubNodeConfig = new HubNodeConfiguration();
		
//		objHubNodeConfig.createHubAndNode();
//		objHubNodeConfig.startHubAndNode();
		
		DriverFactory UtilObj = new DriverFactory();
		UtilObj.ipBrowserConfig();
		
		xml = new XMLReader("config.xml");
	}
	
	/***
	 * function to start Execution
	 */
	public void startExecution() {
		
		/*Creating Threads according to the 'NUMOFTHREADS' present in 'config.xml' file*/
		for (int counter = 0; counter < Integer.parseInt(xml.readTagVal("NUMOFTHREADS")); counter++) {
			ImplementsRunnable target = new ImplementsRunnable();
			Thread thread = new Thread(target, String.valueOf(counter + 1));
			thread.start();
		}
	}
	
}

class ImplementsRunnable implements Runnable {

	/**
	 * function to start a Thread
	 */
	public void run() {
		try {
			Controller objController = new Controller();
			Thread.sleep(2000);
			System.out.println("Thread Name: " + Thread.currentThread().getName());

			objController.getDriver(Thread.currentThread().getName());
			objController.controllerMethod();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}