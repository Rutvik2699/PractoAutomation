package com.selenium.practoautomation.PractoAutomation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.practoautomation.utils.ExtentReportManager;

public class TopCities extends BaseUI{
	int itemCount = 0;
	String searchPageId, itemPageId;

	ExtentReports report=ExtentReportManager.getReportInstance();

@Parameters("browser")
@Test
//Finding Top cities in Diagnostic Page.
public void TopCities(String browser)
{
	ExtentTest logger=report.createTest("TopCities");

	logger.log(Status.PASS,"Test executed successfully...");

openBrowserAndNavigateToPracto(browser);
clickElement("Diagnostics_xpath");
System.out.println("Top Cities:\n");
List<WebElement> topCity = (List<WebElement>) getElements("topCity_xpath");
for(WebElement city:topCity)
{
	System.out.println(city.getText());
}
closeBrowser(); 
}
@AfterTest
public void endReport()
{
	report.flush();
}

}
