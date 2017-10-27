package com.VTB.Utils;


import com.VTB.TestCases.*;

public class FactoryMethod{
	
	/***
	 * Function in which all the Module classes should be mentioned
	 * and return the object of that selected Module class
	 * @param ModuleName
	 * @return
	 */
	public TCSelection testModulesSelection(String ModuleName)
	{
		if(ModuleName.equalsIgnoreCase("AOPModule"))
			return new AOPModule();
		else if(ModuleName.equalsIgnoreCase("TicketingModule"))
			return new TicketingModule();
		else
			return null;
	}

}
