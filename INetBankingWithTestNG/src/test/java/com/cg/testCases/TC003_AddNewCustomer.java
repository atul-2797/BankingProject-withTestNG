package com.cg.testCases;


import org.testng.annotations.Test;

import com.cg.pageObjects.LoginPageObjects;
import com.cg.pageObjects.NewCustomerPage;

import junit.framework.Assert;

public class TC003_AddNewCustomer extends Base {
		
	@Test
	public void addNewCustomer() throws Exception {
		
		
		logger.info("******Login to the Demo Site*******");
		login=new LoginPageObjects(driver);
		
		logger.info("*******Enter username***********");
		login.setUserID(userName);
		logger.info("*******Enter password***********");
		login.setUserPassword(password);
		
		Thread.sleep(5000);
		takeScreenshotOfPage(driver,"TC003_AddNewCustomer","TC003_AddNewCustomerScreenshot1");
		login.clickLoginButton();
		
		
		newCust=new NewCustomerPage(driver);
		logger.info("******New Customer clicked Successfully*******");
		Thread.sleep(5000);
		takeScreenshotOfPage(driver,"TC003_AddNewCustomer","TC003_AddNewCustomerScreenshot2");
		newCust.clickNewCustomer();
		
		Thread.sleep(5000);
		
		logger.info("******Enter customer details*******");
		newCust.setName("Rohini");
		newCust.setGender("Female");
		newCust.setDateOfBirth("12", "12", "1996");
		
		Thread.sleep(5000);
		newCust.setAddress("karad");
		newCust.setCity("Satara");
		newCust.setState("Maharashtra");
		newCust.setPinNo(415205);
		newCust.setMobileNo(9673491449L);
		Thread.sleep(5);
		String email=generateRandomEmail();
		newCust.setEmail(email+"@gmail.com");
		
		newCust.setPassword("abcde");
		
		takeScreenshotOfPage(driver,"TC003_AddNewCustomer","TC003_AddNewCustomerScreenshot3");
		Thread.sleep(3000);
		logger.info("******Click On submit button*******");
		newCust.clickSubmit();
		
		Thread.sleep(3000);
		takeScreenshotOfPage(driver,"TC003_AddNewCustomer","TC003_AddNewCustomerScreenshot4");
				
		boolean status=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(status==true) {
			logger.info("Test case Passed");
			Assert.assertTrue(true);
		}
		else {
			logger.info("Test case Failed");
			takeScreenshotOfPage(driver,"TC003_AddNewCustomer","TC003_FailedScreenshot");
			Assert.assertTrue(false);
		}
		
		
	}
	
	

}
