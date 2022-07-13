package com.cg.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.cg.pageObjects.LoginPageObjects;
import com.cg.pageObjects.NewCustomerPage;
import com.cg.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public LoginPageObjects login;
	public NewCustomerPage newCust;
	public WebDriver driver;
	public Logger logger;

	ReadConfig config = new ReadConfig();
	public String baseURL = config.getURL();
	public String userName = config.getUsername();
	public String password = config.gePassword();

	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp

	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {

		if (browser.equals("chrome")) {
			// open chrome browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		// maximize window
		driver.manage().window().maximize();

		driver.get(baseURL);

		// initialize logger instance
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4J.properties");

	}

	@AfterClass
	public void tearDown() {

		// close the browser
		driver.close();
	}

	public void takeScreenshotOfPage(WebDriver driver, String fname, String tcname) throws IOException {
		
		File testCaseFolder = new File(System.getProperty("user.dir") + "/Screenshots/" + fname);
		
		if (testCaseFolder.exists() == false) {
			testCaseFolder.mkdir();
		}

		if (testCaseFolder.exists() == true) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			File trgFile = new File(
			System.getProperty("user.dir") + "/Screenshots/" + fname + "/" + tcname + "-" + timeStamp + ".png");
			FileUtils.copyFile(srcFile, trgFile);
			System.out.println("Screenshot Taken...");
		}

	}

	public String generateRandomEmail() {
		String email = RandomStringUtils.randomAlphanumeric(8);
		return email;
	}

}
