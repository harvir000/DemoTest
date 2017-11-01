package com.VTB.Utils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  @author harveer.singh
 *  Command Prompt - this class contains method to run windows and mac commands  
 * 
 *
 */

public class CommandExecutor {
	
	Process p;
	ProcessBuilder builder;
	
	/**
	 * This method run command on windows and mac
	 * @param :command to run  
	 */
	public String runCommand(String command) throws InterruptedException, IOException
	{
		String os = System.getProperty("os.name");
		//System.out.println(os);
		
		// build cmd proccess according to os
		if(os.contains("Windows")) // if windows
		{
			builder = new ProcessBuilder("cmd.exe","/c", command);
			builder.redirectErrorStream(true);
			Thread.sleep(1000);
			p = builder.start();
		}
		else // If Mac
			p = Runtime.getRuntime().exec(command);
		
		// get std output
		BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line="";
		String allLine="";
		int i=1;
		while((line=r.readLine()) != null){
	//		System.out.println(i+". "+line);
			allLine=allLine+""+line+"\n";
			if(line.contains("Console LogLevel: debug"))
				break;
			i++;
		}
		return allLine;
	}
	
	public static void main(String[] args) throws Exception 
	{
		CommandExecutor cmd = new CommandExecutor();
		String str=cmd.runCommand("adb devices");
		System.out.println(str);
	}
	
	
	
	public void execute()
	
	{/*
		
		JSch jsch=new JSch();
		Session session=jsch.getSession(remoteHostUserName, RemoteHostName, 22);
		session.setPassword(remoteHostpassword);
		Properties config = new Properties();
		config.put("StrictHostKeyChecking", "no");
		session.setConfig(config);
		session.connect();

		ChannelExec channel=(ChannelExec) session.openChannel("exec");
		BufferedReader in=new BufferedReader(new InputStreamReader(channel.getInputStream()));
		channel.setCommand("pwd;");
		channel.connect();

		String msg=null;
		while((msg=in.readLine())!=null){
		  System.out.println(msg);
		}

		channel.disconnect();
		session.disconnect();
		
	*/}
}