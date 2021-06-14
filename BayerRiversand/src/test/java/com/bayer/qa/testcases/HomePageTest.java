package com.bayer.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bayer.qa.base.BaseBayerTest;
import com.bayer.qa.pages.HomePage;
import com.bayer.qa.pages.LoginPage;

public class HomePageTest extends BaseBayerTest{
	
	int datePicker = 10;
	HomePage homepageobj;
	LoginPage loginObj;
	HomePageTest(){
		
		super();
	}
	
	@BeforeMethod
	public void setUpTests() throws IOException {
		initialization();
		homepageobj = new HomePage();
		//loginObj = loginObj.enterDetails(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void searchUPCtest() throws IOException, InterruptedException
	{
		loginObj.enterDetails(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
		homepageobj.searcUPC();
	}
	
	/*@AfterMethod
	public void tearDown(){
		driver.quit();
	}*/

}
