package com.bayer.qa.ptactice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightCLickTest {
	
	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","D:\\Eclipse_Workspace\\BayerRiversand\\Drivers\\UpdatedChrome\\chromedriver89.exe");
		 driver= new ChromeDriver();

	//Launch the Application Under Test (AUT)
	//driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	//driver.manage().window().maximize();

	driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	driver.manage().window().maximize();
	//Double click the button to launch an alertbox
	Actions action = new Actions(driver);
	WebElement link =driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
	action.doubleClick(link).perform();
	//Switch to the alert box and click on OK button
	Alert alert = driver.switchTo().alert();
	System.out.println("Alert Text\n" +alert.getText());
	alert.accept();
	//Closing the driver instance
	//driver.quit();
	
	//Actions action = new Actions(driver);

	WebElement linkOne = driver.findElement(By.cssSelector(".context-menu-one"));
	action.contextClick(linkOne).perform();
	// Click on Edit link on the displayed menu options
	WebElement element = driver.findElement(By.cssSelector(".context-menu-icon-copy"));
	element.click();
	
	// Accept the alert displayed
	//driver.switchTo().alert().accept();
	// Closing the driver instance
	//driver.quit();
		
	}

}
