package com.cg.testCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.cg.pageObjects.LoginPageObjects;

import junit.framework.Assert;

public class TC001_LoginTest	extends Base {
	
	@Test
	public void LoginTest() throws InterruptedException, Exception {
		
		logger.info("*******OPEN URL***********");
		takeScreenshotOfPage(driver,"TC001_LoginTest","TC001_LoginTestScreenshot1");
		
		login=new LoginPageObjects(driver);
		
		logger.info("*******Enter username***********");
		login.setUserID(userName);
		logger.info("*******Enter password***********");
		login.setUserPassword(password);
		Thread.sleep(3000);
		takeScreenshotOfPage(driver,"TC001_LoginTest","TC001_LoginTestScreenshot2");
		Thread.sleep(5000);
		
		login.clickLoginButton();
		Thread.sleep(5000);
		takeScreenshotOfPage(driver,"TC001_LoginTest","TC001_LoginTestScreenshot3");
		//check title of the page
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			logger.info("*******Test case passed!!!!!***********");
			Assert.assertTrue(true);
		}
		else {
			takeScreenshotOfPage(driver,"LoginTest","FailedScreenshot");
			takeScreenshotOfPage(driver,"TC001_LoginTest","TC001_FailedScreenshot");
			Assert.assertTrue(false);
			
		}
			
		
	}
}
