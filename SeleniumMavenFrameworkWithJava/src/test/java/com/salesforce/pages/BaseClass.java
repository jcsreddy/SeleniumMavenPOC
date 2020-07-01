package com.salesforce.pages;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import com.salesforce.utility.BrowserFactory;

public class BaseClass {
	
	public WebDriver driver;

	@BeforeClass
	public void setup()
	{
		driver = BrowserFactory.startApplication(driver, "chrome", "https://login.salesforce.com/");
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
}
