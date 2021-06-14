package com.bayer.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bayer.qa.base.BaseBayerTest;
import com.bayer.qa.util.UtilityMethods;

public class HomePage extends BaseBayerTest{
	BaseBayerTest objUtil;
	
	@FindBy(xpath = "//div[@class ='login-role text-ellipsis")
	WebElement logoImage; //logo on login window
	
	//+ "//*[@id=\"pageMenuIcon_3\"]\\pebble-icon[@id='menuIcon3']")
	@FindBy(xpath = "//*[@id=\"menuIcon3\"]//svg/g/path")
	WebElement searchOption;
	
	@FindBy(tagName = "app-drawer")
	WebElement drawerHost;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String LoggedOnUser() {
		WebElement userName = expandHost(logoImage, driver);
		String uName = userName.getText();
		return uName;
	}
	
	public void searcUPC() {
		WebElement searchOpt = expandHost(drawerHost, driver);
		searchOpt.click();
		//String uName = userName.getText();
		//return uName;
	}
}
