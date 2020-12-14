package com.auto.subs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropHandlers {
	
	public static void main(String[] args) throws IOException {
		String userDir = System.getProperty("user.dir");
		Properties confProp = new Properties();
		FileInputStream configFile = new FileInputStream(userDir  + "/src/test/resources/properties/config.properties");

		confProp.load(configFile);
		
		Properties locatorProp = new Properties();
		FileInputStream locFile = new FileInputStream(userDir + "/src/test/resources/properties/locators.properties");
		locatorProp.load(locFile);
		
//		String browser = confProp.getProperty("browser").toString();
//		if(confProp.getProperty("browser").equals("chrome"))
		/*
		 * switch(browser) { case "chrome":
		 * System.setProperty("webdriver.chrome.driver", userDir +
		 * "/src/test/resources/executables/chromedriver"); driver = new ChromeDriver();
		 * break; case "firefox": System.setProperty("webdriver.gecko.driver", userDir +
		 * "/src/test/resources/executables/geckodriver"); break; }
		 */
	
		
		System.out.println(locatorProp.getProperty("bnk.manage.login.buttion"));
		
	}

}
