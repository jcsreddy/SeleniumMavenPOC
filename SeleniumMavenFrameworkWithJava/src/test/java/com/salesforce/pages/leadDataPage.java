package com.salesforce.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class leadDataPage {

	static WebElement element = null;
	static WebDriver driver = null;
	
	/* Login page objects */
	static By clickleadstab = By.xpath("//li/a[@title='Leads Tab']");
	By closedialoginleadstab = By.xpath("//a[@class='dialogClose']");
	By clicknewinleadstab = By.name("new");
	By lastname = By.name("name_lastlea2");
	By company = By.name("lea3");
	By leadstatus = By.xpath("//select[@name='lea13']/option");
	By clicksave = By.xpath("(//input[@title='Save'])[2]");
	
	
	/* Constructor */
	public leadDataPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void closedialoginleadstab()
	{
		driver.findElement(closedialoginleadstab).click();
	}
	

	
	public void clickleadstab()
	{
		//driver.findElement(clickleadstab).isEnabled();
		driver.findElement(clickleadstab).click();
	}
	
	public void clicknewinleadstab()
	{
		driver.findElement(clicknewinleadstab).click();
	}
	
	public void lastname(String text)
	{
		driver.findElement(lastname).click();
		driver.findElement(lastname).sendKeys(text);
	}
	
	public void company(String text)
	{
		driver.findElement(company).click();
		driver.findElement(company).sendKeys(text);
	}
	
	public void leadstatus(String text)
	{
		//driver.findElement(leadstatus).click();
		driver.findElement(leadstatus).sendKeys(text);
	}
	
	public void clicksave()
	{
		driver.findElement(clicksave).click();
	}
}
