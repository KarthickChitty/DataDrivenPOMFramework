package com.auto.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.auto.main.TestAutoApp;

public class AddCustomerTest extends TestAutoApp {

	
	  //@Test(dataProvider="getCustData")
	@Test
	  public void addCustomer() throws InterruptedException
	  {
	  String fName ="Adk";
	  String lName = "LastName";
	  String pCode="KAD78A";
	  
		  driver.findElement(By.cssSelector(locatorProp.getProperty("add.customer"))).click();
		  driver.findElement(By.cssSelector(locatorProp.getProperty("customer.fname"))).sendKeys(fName);
		  driver.findElement(By.cssSelector(locatorProp.getProperty("customer.lname"))).sendKeys(lName);;
		  driver.findElement(By.cssSelector(locatorProp.getProperty("customer.postcode"))).sendKeys(pCode);;
		  driver.findElement(By.cssSelector(locatorProp.getProperty("add.button"))).click();
		  log.debug("Add Customer click event performed");
		  
		  String alerttext =""; 
		  Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		  Assert.assertTrue(alert.getText().contains(alerttext));
		//  Thread.sleep(3000);
		  alert.accept();
	  }
	  
	  @DataProvider
	  public Object[][] getCustData() {
		  String sheetName="AddCustomerTest";
		  
		  int rows = excel.getRowCount(sheetName);
		  int cols = excel.getColumnCount(sheetName);
		  log.debug("excel.getRowCount: " + rows);
		  log.debug("excel.getColCount: " + cols);
		  
		  Object[][] data = new Object[rows-1][cols];
		  
		  for(int rowNum =2; rowNum <=rows; rowNum++) {
			  for(int colNum =0; colNum < cols; colNum++) {
				  //data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			  }
		  }
		return data;
		  
	  }
	  
	  
}
