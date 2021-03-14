package com.selenium.practoautomation.PractoAutomation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.practoautomation.utils.ExtentReportManager;

public class FindHospital extends BaseUI{
	int itemCount = 0;
	String searchPageId, itemPageId;

	ExtentReports report=ExtentReportManager.getReportInstance();
@Parameters("browser")
	@Test
	// Search for hospital with specified location
	public void searchForHospital(String browser) throws IOException {

	ExtentTest logger=report.createTest("searchHospital");

	logger.log(Status.PASS,"Test executed successfully...");

	try {
		openBrowserAndNavigateToPracto(browser);
		getElement("searchLocation_xpath").click();
		clickElement("clearSearchLocationButton_xpath");
		enterText("searchLocation_xpath", ExcelDataInput.readExcelDataForSearchValue("Sheet1", 0, 0));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("bangaloreLocationButton_xpath"))));
		clickElement("bangaloreLocationButton_xpath");
		enterText("searchBox_xpath", ExcelDataInput.readExcelDataForSearchValue("Sheet1", 0, 1));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("hospitalButton_xpath"))));
		clickElement("hospitalButton_xpath");

		clickElement("open24X7_xpath");
		
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
		clickElement("Filters_xpath");
		clickElement("hasParking_xpath");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Displaying the search results where rating greater than 3.5
		int i = 0;
		float[] ratingsFloat = new float[10];
		List<WebElement> ratings = getElements("ratings_xpath");
		Iterator<WebElement> rItr = ratings.iterator();
		while (rItr.hasNext()) {
			WebElement ob = rItr.next();
			ratingsFloat[i] = Float.parseFloat(ob.getText());
			i++;
		}

		List<WebElement> hospitalNames = getElements("hospNames_xpath");
		Iterator<WebElement> hnItr = hospitalNames.iterator();
		i=0;
		while (hnItr.hasNext()) {
			WebElement ob = hnItr.next();
				if (ratingsFloat[i] > 3.5) {
					System.out.println(ob.getText());
				}
				i++;
		}
		closeBrowser();
	}
@AfterTest
public void endReport()
{
	report.flush();
}

}
