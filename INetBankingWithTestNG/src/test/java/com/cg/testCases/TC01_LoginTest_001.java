package com.cg.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cg.pageObjects.LoginPageObjects;

import junit.framework.Assert;

public class TC01_LoginTest_001	extends Base {
	
	@Test
	public void LoginTest() throws InterruptedException, Exception {
		
		logger.info("*******OPEN URL***********");
		
		
		login=new LoginPageObjects(driver);
		
		logger.info("*******Enter username***********");
		login.setUserID(userName);
		logger.info("*******Enter password***********");
		login.setUserPassword(password);
		
		Thread.sleep(5000);
		
		login.clickLoginButton();
		
		//check title of the page
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("*******Test case passed!!!!!***********");
			Assert.assertTrue(true);
		}
		else {
			takeScreenshotOfPage(driver,"LoginTest");
			Assert.assertTrue(false);
			
		}
			
		
	}
}
