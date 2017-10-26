package com.VTB.Utils;


import com.VTB.TestCases.*;

public class FactoryMethod{
	
	// Here all the Module classes should be mentioned 
	// It will return object of class.
	public TCSelection testModulesSelection(String ModuleName)
	{
		if(ModuleName.equalsIgnoreCase("BookingModule"))
			return new BookingModule();
		else if(ModuleName.equalsIgnoreCase("TicketingModule"))
			return new TicketingModule();
//		else if(ModuleName.equalsIgnoreCase("Module3"))
//			return new Module3();
		else
			return null;
	}

}
