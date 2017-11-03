package com.VTB.Utils;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.ProxySettings;

public class AppliTool {
	
	public Eyes eyes;
	
	public AppliTool() {
		eyes = new Eyes();
		eyes.setProxy(new ProxySettings("http://10.135.0.26:8080")); 
		eyes.setApiKey("e799djkQEECBaJq1114uu3nbWXbLqZ3OqTNbJhzmUM6HiM110");
		eyes.setSaveNewTests(true);
		eyes.setForceFullPageScreenshot(true);
	}
	
	public Eyes getEyes() {
		return eyes;
	}
	
}
