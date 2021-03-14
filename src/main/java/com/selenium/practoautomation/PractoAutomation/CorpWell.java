package com.selenium.practoautomation.PractoAutomation;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.practoautomation.utils.ExtentReportManager;

public class CorpWell extends BaseUI{
	int itemCount = 0;
	String searchPageId, itemPageId;
	ExtentReports report=ExtentReportManager.getReportInstance();
@Parameters("browser")
	@Test
	//Capturing the warning message for invalid details
	public void CaptureAlert(String browser) throws IOException
	
	{
	ExtentTest logger=report.createTest("CorporateWellness");

	logger.log(Status.PASS,"Test executed successfully...");

		openBrowserAndNavigateToPracto(browser);
		//driver.navigate().back();
		clickElement("ForProDropdown_xpath");
		
		new WebDriverWait(driver, 50).until(ExpectedConditions
				.visibilityOfElementLocated(By.partialLinkText(prop.getProperty("co_partialLinkText"))));
		clickElement("co_partialLinkText");
		
		Set <String> windowIDs =driver.getWindowHandles();
		Iterator <String> itr = windowIDs.iterator();
		String mainpage=itr.next();
		String nextpage=itr.next();
		driver.switchTo().window(nextpage);
		
		
		
		enterText("name_id", ExcelDataInput.readExcelDataForSearchValue("Sheet2", 0, 0));
		enterText("organization_id",ExcelDataInput.readExcelDataForSearchValue("Sheet2", 0, 1));
		enterText("email_id",ExcelDataInput.readExcelDataForSearchValue("Sheet2", 0, 2));
		enterText("mobileNo_id",ExcelDataInput.readExcelDataForSearchValue("Sheet2", 0, 3));
		clickElement("submit_id");
		
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		    Alert alt = driver.switchTo().alert();	   
	System.out.println(alt.getText());

	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		  
		alt.accept();
		
		closeBrowser();
	}
@AfterTest
public void endReport()
{
	report.flush();
}

	
}
