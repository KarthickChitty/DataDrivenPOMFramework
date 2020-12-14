package com.auto.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import com.auto.main.TestAutoApp;

public class BankManagerLoginTest extends TestAutoApp {

	
	  @Test
	  public void loginBankManage() throws InterruptedException
	  {
	  
		  driver.findElement(By.cssSelector(locatorProp.getProperty("bnk.manage.login.buttion"))).click();
		  log.debug("Bnk Mannger click event performed");
		  Assert.assertTrue(isElementPresent(By.cssSelector(locatorProp.getProperty("add.customer"))));
//		  Assert.fail();
		  
//		  Thread.sleep(3000);
	  }
}
