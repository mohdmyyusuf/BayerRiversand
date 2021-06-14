package com.bayer.qa.pages;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bayer.qa.base.BaseBayerTest;
import com.bayer.qa.util.XlsReader;

public class LoginPage extends BaseBayerTest {
	
	public LoginPage LoginPage = null;
	XlsReader obj = new XlsReader();
	//public String userName = prop.getProperty("username");
	public String password = prop.getProperty("password");
	
	@FindBy(xpath = "//img[@class ='auth0-lock-header-logo centered']")
	WebElement logoImage; //logo on login window
	@FindBy(xpath = "//input[@name='email']")
	WebElement inputEmail;
	@FindBy(xpath = "//input[@name='password']")
	WebElement inputPass;
	@FindBy(xpath = "//span[text()='Log In']")
	WebElement loginLink;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	
	public LoginPage enterDetails(String uname, String pwrd) throws IOException {
		//XSSFSheet excelSheet;
		//uname = prop.getProperty("username");
		//pwrd = prop.getProperty("password");
		inputEmail.sendKeys(uname);
		inputPass.sendKeys(pwrd);
		loginLink.click();
		return LoginPage;
		
		//excelSheet = obj.returnExcel("", "Sheet1");
		
	   //	for (int i = 0; i < 12; i++) {
			
		///}
		
	}

}
