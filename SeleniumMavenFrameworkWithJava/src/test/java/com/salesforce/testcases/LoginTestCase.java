package com.salesforce.testcases;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.salesforce.pageObjects.loginPageObjects;
import com.salesforce.pages.BaseClass;

public class LoginTestCase extends BaseClass {
	
	WebDriver driver;
	
	@Test
	public void loginApplication()
	{		
		loginPageObjects loginPage = PageFactory.initElements(driver, loginPageObjects.class);
		loginPage.loginToAppl("jcsreddy@gmail.com", "sekhar123");
	}
	

}
