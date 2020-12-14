package com.auto.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentAventReporter;

public class ExtentManager{
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance() {
		String userdir = System.getProperty("user.dir");
		if(extent == null) {
			//extent = new ExtentReports(userdir + "/test-output/extentReport/index.xml");
			ExtentAventReporter avent = new ExtentAventReporter("./extentReportTest/index.html");
//			avent.loadXMLConfig(userdir + "/src/test/java/extent-config.xml");
			
			extent = new ExtentReports();
			extent.attachReporter(avent);

//            extent = new ExtentReports(userdir + "\\ExtentReports\\ExtentReportResults.html", true);
			return extent;
		}
		else
			return extent;
		
	}
	
	

}
