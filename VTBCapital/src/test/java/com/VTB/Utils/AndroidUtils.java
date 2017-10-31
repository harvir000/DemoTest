package com.VTB.Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AndroidUtils 
{

	CommandExecutor cmd=new CommandExecutor();
	public static List<String> validDeviceIds = new ArrayList<>();
	private Map<String, String> devices = new LinkedHashMap<String, String>();
	



	/**
	 * This method start adb server
	 */
	public void startADB() throws Exception {
		String output = cmd.runCommand("adb start-server");
		String[] lines = output.split("\n");
		if (lines[0].contains("internal or external command")) {
			System.out.println("Please set ANDROID_HOME in your system variables");
		}
	}


	/**
	 * This method stop adb server
	 */
	public void stopADB() throws Exception {
		cmd.runCommand("adb kill-server");
	}



	/**
	 * to get connected devices
	 * @throws Exception 
	 */
	public List<String> getConnectedDevices()
	{
		List<String> connectedDevices = new ArrayList<>();
		String output;
		try {
			output = cmd.runCommand("adb devices");
			if(output.contains("internal or external command"))
			{
				return null;
			}

			String[] lines = output.split("\n");
			if(lines.length>1)
			{
				for(int i=1; i<=lines.length-1;i++)
				{
					lines[i]=	lines[i].replaceAll("\\s+", "");
					if(lines[i].contains("device"))
					{
						String devicesID=lines[i].replaceAll("device", "").trim();
						connectedDevices.add(devicesID);
					}


				}
			}
		}
		
		catch (InterruptedException | IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connectedDevices;

	}

	/**
	 * to get connected devices details
	 * @throws Exception 
	 */

	public  Map<String, String> getConnectedDevicesDetails() throws Exception

	{ 
		startADB(); // start adb service
		String output = cmd.runCommand("adb devices");
		String[] lines = output.split("\n");

		if (lines.length <= 1) {
			stopADB();
		} else {
			for (int i = 1; i < lines.length; i++) {
				lines[i] = lines[i].replaceAll("\\s+", "");

				if (lines[i].contains("device")) {
					lines[i] = lines[i].replaceAll("device", "");
					String deviceID = lines[i];

					if (validDeviceIds.size() > 0) {
						if (validDeviceIds.contains(deviceID)) {
							getDeviceInfo(i, deviceID);
						}
					} else {
						getDeviceInfo(i, deviceID);
					}

				}
			}
		}
		return devices;
	}

	public void getDeviceInfo(int i, String deviceID) throws InterruptedException, IOException 
	{
		String model =cmd.runCommand("adb -s " + deviceID+ " shell getprop ro.product.model").replaceAll("\\s+", "");
		String brand =cmd.runCommand("adb -s " + deviceID+ " shell getprop ro.product.brand").replaceAll("\\s+", "");
		String osVersion = cmd.runCommand("adb -s " + deviceID + " shell getprop ro.build.version.release").replaceAll("\\s+", "");
		String deviceName = brand + " " + model;
		String apiLevel =cmd.runCommand("adb -s " + deviceID+ " "+ ".sdk").replaceAll("\n", "");

		devices.put("deviceID" + i, deviceID);
		devices.put("deviceName" + i, deviceName);
		devices.put("osVersion" + i, osVersion);
		devices.put(deviceID+" API Lavel", apiLevel);

	}
}

