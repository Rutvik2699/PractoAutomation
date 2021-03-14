package com.selenium.practoautomation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {
	
	public static ExtentReports report;
	public static ExtentTest logger;

	public static ExtentReports getReportInstance() {
		
		if(report==null)
		{
			ExtentHtmlReporter htmlReporter =new ExtentHtmlReporter(System.getProperty("user.dir")+"//test-output//test-report.html");
			report= new ExtentReports();
			
			report.attachReporter(htmlReporter);
			
			report.setSystemInfo("Windows","10");
			report.setSystemInfo("Envirnoment","UAT");
			report.setSystemInfo("Build Number","10.8.1");
			report.setSystemInfo("Browser","chrome");
			
			
			htmlReporter.config().setDocumentTitle("Practo Automation");
			htmlReporter.config().setReportName("Practo Automation Report");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd,yyyy HH:mm:ss");
			htmlReporter.config().setTheme(Theme.DARK);
		}
		
		return report;
		
	} 

}
