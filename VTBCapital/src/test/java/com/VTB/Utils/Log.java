package com.VTB.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;

public class Log 

{

	public Log(String fileName)
	{

		Properties props = new Properties();
		
		InputStream cpr = Log.class.getResourceAsStream("/log4j.properties");
		try {
			props.load(cpr);
			props.setProperty("", fileName);
			
			System.out.println(props);
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PropertyConfigurator.configure(props);
		
	}
	
	public void message(String sMessage)
	{
		
		
	}
	
	
	public static void main(String[] args) {
		
		Log log=new Log("Hello");
	}


}
