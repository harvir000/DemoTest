package com.VTB.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonFileWriter 
{
// in progress.............................
	public String fileName="";
	 
	public JsonFileWriter(String fileName)
	{
		this.fileName=fileName;
	}
	
	
	public void write(String Key, String value) throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser=new JSONParser();
		
		Object obj=parser.parse(new FileReader("."+File.separator+"GridBatchFiles"+File.separator+fileName));
		
		JSONObject jsonObject=(JSONObject) obj;
		jsonObject.put(Key, value);
		
		
		
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException 
	{
		JsonFileWriter json=new JsonFileWriter("jsonAppiumConfig - Copy.json");
		json.write("capabilities.applicationName", "demoApplicationName");
		
	}
	
	
}
