package com.VTB.Utils;

import com.VTB.TestCases.Controller;

public class CreatingThreads {
	
	public XMLReader xml;
	
	public CreatingThreads(){
		//Before starting we are defining or telling on which browser which ip port will work
		// as 'ipBrowserConfig()' method is static hence we are calling direct by class name.
		DriverFactory UtilObj = new DriverFactory();
		UtilObj.ipBrowserConfig();
		xml = new XMLReader("config.xml");
	}
	
	public void startExecution(){
		
		for(int counter = 0; counter< Integer.parseInt(xml.readTagVal("NUMOFTHREADS")); counter ++) {
			ImplementsRunnable rc = new ImplementsRunnable();
			Thread t = new Thread(rc, String.valueOf(counter+1));
			t.start();
		}
		
	}
}

class ImplementsRunnable implements Runnable {

	public void run(){
		try{
			Controller obj1 = new Controller();
			Thread.sleep(2000);
			System.out.println("Thread Name: "+Thread.currentThread().getName());
			obj1.getDriver(Thread.currentThread().getName());
			obj1.controllerMethod();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}