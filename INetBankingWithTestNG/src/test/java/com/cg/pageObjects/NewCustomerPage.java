package com.cg.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage {

	public WebDriver ldriver;

	public NewCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='New Customer']")
	@CacheLookup
	WebElement lnkNewCustomer;

	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(how = How.XPATH, using = "//input[@value='m']")
	@CacheLookup
	WebElement maleGender;

	@FindBy(how = How.XPATH, using = "//input[@value='f']")
	@CacheLookup
	WebElement femaleGender;

	@FindBy(how = How.NAME, using = "dob")
	@CacheLookup
	WebElement txtDateBox;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtAddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtCity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtState;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtPinNo;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtMobileNo;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtEmail;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(how = How.XPATH, using = "//input[@name='sub']")
	@CacheLookup
	WebElement btnSubmit;

	public void clickNewCustomer() {
		lnkNewCustomer.click();
	}

	public void setName(String custName) {
		txtCustomerName.sendKeys(custName);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			maleGender.click();
		} else if (gender.equals("Female")) {
			femaleGender.click();
		}
	}

	public void setDateOfBirth(String date, String month, String year) {
		txtDateBox.sendKeys(date);
		txtDateBox.sendKeys(month);
		txtDateBox.sendKeys(year);
	}

	public void setAddress(String address) {
		txtAddress.sendKeys(address);
	}

	public void setCity(String city) {
		txtCity.sendKeys(city);
	}

	public void setState(String state) {
		txtState.sendKeys(state);
	}

	public void setPinNo(int pin) {
		txtPinNo.sendKeys(String.valueOf(pin));
	}

	public void setMobileNo(Long mobile) {
		txtMobileNo.sendKeys(String.valueOf(mobile));
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

}
