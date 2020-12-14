package com.auto.main;

import org.testng.ITestResult;
import org.testng.Reporter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.auto.utilities.ExcelReader;
import com.auto.utilities.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class TestAutoApp {
	
	/*
	 * WebDriver
	 * Properties
	 * Logs
	 * ExtentReports
	 * DB
	 * Excel
	 * Mail
	 * 
	 */
	
	public static WebDriver driver;
	public static Properties confProp = new Properties();
	private static FileInputStream configFile;
	public static Properties locatorProp = new Properties();
	private static FileInputStream locFile;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/testdata.xlsx");
	public static WebDriverWait wait; 
	public static ExtentReports rep;
	public static ExtentTest test;
	
	
	@BeforeSuite
	public void startUp() throws IOException {
		String userDir = System.getProperty("user.dir");
		rep = ExtentManager.getInstance();
		if(driver==null) {
			configFile = new FileInputStream(userDir  + "/src/test/resources/properties/config.properties");

			confProp.load(configFile);
			
			locFile = new FileInputStream(userDir + "/src/test/resources/properties/locators.properties");
			locatorProp.load(locFile);

			
			String browser = confProp.getProperty("browser").toString();

			switch(browser) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/executables/chromedriver");
				driver = new ChromeDriver();
				log.debug("Driver initiated ...");
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", userDir + "/src/test/resources/executables/geckodriver");
				break;
			}
		
			
			driver.get(confProp.get("environmentURL").toString());
			log.debug("Home Page Loadded");
			Reporter.log("Home Page Loaded");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(confProp.getProperty("implicit.wait")), TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			
		}
	}
	
	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			log.debug("Element Found");
			return true;
		}catch(NoSuchElementException e) {
			log.debug("Element not found");
			return false;
		}
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver!=null)
			driver.quit();
		log.debug("Driver tearDown Complete");

	}

}
