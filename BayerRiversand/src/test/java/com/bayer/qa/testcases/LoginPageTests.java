package com.bayer.qa.testcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bayer.qa.base.BaseBayerTest;
import com.bayer.qa.pages.LoginPage;
import com.bayer.qa.util.XlsReader;

public class LoginPageTests extends BaseBayerTest {
	
	LoginPage loginpageObj;
	XlsReader obj = new XlsReader();

	LoginPageTests(){
		
		super();
	}
	
	@BeforeMethod
	public void setUpTests() {
		initialization();
		loginpageObj = new LoginPage();
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest()
	{
		String title = loginpageObj.validatePageTitle();
		Assert.assertEquals(prop.getProperty("pagetitle"), title);
	}
	
	@Test(priority = 2)
	public void loginTest() throws IOException {
		//XSSFSheet excelSheet;
		//excelSheet = obj.returnExcel(prop.getProperty("datapath"), prop.getProperty("sheetname"));
		//for (int i = 0; i <= 50; i++) {
		//	loginpageObj.enterDetails(excelSheet.getRow(0).getCell(0).getStringCellValue(),
		//			excelSheet.getRow(0).getCell(1).getStringCellValue());
		//}
		
		loginpageObj.enterDetails(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
}
