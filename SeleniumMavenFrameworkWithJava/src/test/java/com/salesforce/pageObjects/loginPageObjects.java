package com.salesforce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageObjects {

	WebDriver driver;
	
	public loginPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(name = "username") WebElement uname;
	@FindBy(name = "pw") WebElement upwd;
	@FindBy(name = "Login") WebElement ulogin;
	
	public void loginToAppl(String usernameFromAppl, String passwordFromAppl)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		uname.sendKeys(usernameFromAppl);
		//password = Base64.getEncoder().encode(password);
		upwd.sendKeys(passwordFromAppl);
		ulogin.click();
	}
	
}
