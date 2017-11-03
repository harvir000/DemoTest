package com.VTB.Utils;

import org.openqa.selenium.WebDriver;

import com.applitools.eyes.Eyes;

public interface TCSelection 
{
	public void testCasesSelection(String testCaseId, Reporting report, WebDriver driver, Eyes eyes);
}
