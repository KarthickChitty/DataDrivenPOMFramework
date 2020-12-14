package com.auto.listeners;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.auto.main.TestAutoApp;
import com.auto.utilities.TestUtil;
import com.aventstack.extentreports.MediaEntityBuilder;



public class CustomListeners extends TestAutoApp implements ITestListener {
	
	/*
	 * public void onTestStart(ITestResult testResult) { test =
	 * rep.createTest(testResult.getName().toUpperCase()); }
	 */

	public void onTestFailure(ITestResult testResult) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		String screenShotPath  = "";
		try {
			screenShotPath = TestUtil.captureScreenshot();
		} catch (IOException e) {
			Reporter.log("Capturing ScreenshotException");
			e.printStackTrace();
		}

		try {
			test = rep.createTest(testResult.getName().toUpperCase()).fail("Extent Failed", MediaEntityBuilder.createScreenCaptureFromPath("1.png").build());
			log.debug("TEST FAIL logger");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

//		test.log(Status.FAIL, testResult.getName() + "FAIL");
		rep.flush();
		rep.removeTest(test);
/*			test.log(Status.FAIL, testResult.getName() + "FAIL");
			rep.removeTest(test);
			rep.config();
			rep.flush();*/		

		Reporter.log("Capturing Screenshot.....");
		Reporter.log("<a target=\"_blank\" href=\""+ screenShotPath + "\">Error Screenshot</a>");
	}
	
	
	public void onTestSuccess(ITestResult testResult) {
		test = rep.createTest(testResult.getName().toUpperCase()).pass("Extent Passed");
		log.debug("TEST PASS logger");
		rep.flush();
		rep.removeTest(test);
		
	}
}
