package com.bayer.qa.ptactice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ImplicitWaitClass {
	
	protected WebDriver driver;
	
	@Test
	public void titleMatcher() {
		System.setProperty("webdriver.chrome.driver", "D:\\Eclipse_Workspace\\BayerRiversand\\Drivers\\chromedriver\\chromedriver.exe");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("start-maximized");
		
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/guru99home/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement link  = driver.findElement(By.xpath(""));
		String linkText = link.getText();
		
		System.out.println("The link is there with name " + linkText);
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("adas")));
		Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(20));
		
	}
	
	
	@Test
	public void takeScreenshot() {
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
	// Create refernce of TakesScreenshot
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	// Call method to capture screenshot
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	// Copy method  specific location here it will save all screenshot in our project home directory and
	// result.getName() will return name of test case so that screenshot name will be same
	try{
	FileHandler.copy(source, new File("./Screenshots/"+result.getName()+".png"));
	System.out.println("Screenshot taken");
	}
	catch (Exception e)
	{
	System.out.println("Exception while taking screenshot "+e.getMessage());
	} 
	}
	
	}
}
