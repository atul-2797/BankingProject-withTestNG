package com.cg.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cg.pageObjects.LoginPageObjects;
import com.cg.utilities.XLUtils;

public class TC002_LoginDDT extends Base {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		LoginPageObjects lp = new LoginPageObjects(driver);
		lp.setUserID(user);
		logger.info("user name provided");
		lp.setUserPassword(pwd);
		logger.info("password provided");
		takeScreenshotOfPage(driver,"TC002_LoginDDT","TC002_LoginDDTScreenshot1");
		
		lp.clickLoginButton();

		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			takeScreenshotOfPage(driver,"TC002_LoginDDT","TC002_LoginDDTScreenshot2");
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			takeScreenshotOfPage(driver,"TC002_LoginDDT","TC002_LoginDDTScreenshot3");
			Assert.assertTrue(false);
			//takeScreenshotOfPage(driver, "LoginTestDD");
			logger.warn("Login failed");
		} else {
			takeScreenshotOfPage(driver,"TC002_LoginDDT","TC002_LoginDDTScreenshot2");
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogoutLink();
			Thread.sleep(3000);
			takeScreenshotOfPage(driver,"TC002_LoginDDT","TC002_LoginDDTScreenshot3");
			driver.switchTo().alert().accept();// close logout alert
			driver.switchTo().defaultContent();
			takeScreenshotOfPage(driver,"TC002_LoginDDT","TC002_LoginDDTScreenshot4");

		}

	}

	public boolean isAlertPresent() // user defined method created to check alert is presetn or not
	{
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = "F:\\QA All\\EclipseAutomationTask\\INetBankingWithTestNG\\src\\test\\java\\com\\cg\\testData\\LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
			}

		}
		return logindata;
	}

}
