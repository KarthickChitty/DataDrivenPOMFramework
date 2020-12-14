package com.auto.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.auto.main.TestAutoApp;
import com.google.common.io.Files;

public class TestUtil extends TestAutoApp {
	
	public static String captureScreenshot() throws IOException {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + "/test-output/" + scrFile.getName();
		File screenShot = new File(filePath);
		Files.copy(scrFile, screenShot);
		return screenShot.getAbsolutePath();
	}


}
