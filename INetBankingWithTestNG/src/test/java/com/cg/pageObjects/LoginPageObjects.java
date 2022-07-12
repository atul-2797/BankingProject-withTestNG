package com.cg.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjects {
	
	public WebDriver ldriver;
	
	public LoginPageObjects(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement txtUserID;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement lnkLogout;
	
	
	
	public void setUserID(String userID) {
		txtUserID.sendKeys(userID);
	}
	
	public void setUserPassword(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
	
	public void clickLogoutLink() {
		lnkLogout.click();
	}
	
	
	
	
	

}
