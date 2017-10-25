package utilsPckg;

import org.openqa.selenium.WebDriver;

import reportingPckg.Reporting;

public interface TCSelection {

	public void testCasesSelection(String testCaseId, Reporting report, WebDriver driver);
}
