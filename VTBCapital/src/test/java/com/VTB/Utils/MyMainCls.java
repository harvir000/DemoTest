package com.VTB.Utils;

public class MyMainCls {
	
	/***
	 * This is the Entry Point of the Framework
	 * @param args
	 */
	public static void main(String[] args)
	{
	
		CreatingThreads startExec = new CreatingThreads();
		
		/*Navigating to startExecution() method which will create threads*/
		startExec.startExecution();
	}
}
