package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class leadDataObjects {

	//private static WebElement element = null;
	WebDriver driver = null;
	
	/* Login page objects */
	By clickleadstab = By.xpath("//li/a[@title='Leads Tab']");
	By closedialoginleadstab = By.xpath("//a[@class='dialogClose']");
	By clicknewinleadstab = By.name("new");
	By lastname = By.name("name_lastlea2");
	By company = By.name("lea3");
	By leadstatus = By.xpath("//select[@name='lea13']/option");
	By clicksave = By.xpath("(//input[@title='Save'])[2]");
	
	
	/* Constructor */
	public leadDataObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void closedialoginleadstab()
	{
		driver.findElement(closedialoginleadstab).click();
	}
	
	public void clickleadstab()
	{
		driver.findElement(clickleadstab).click();
	}
	
	public void clicknewinleadstab()
	{
		driver.findElement(clicknewinleadstab).click();
	}
	
	public void lastname(String text)
	{
		//driver.findElement(lastname).
		driver.findElement(lastname).sendKeys(text);
	}
	
	public void company(String text)
	{
		driver.findElement(company).sendKeys(text);
	}
	
	public void leadstatus(String text)
	{
		driver.findElement(leadstatus).sendKeys(text);
	}
	
	public void clicksave()
	{
		driver.findElement(clicksave).click();
	}
	
	/*
	
	public static WebElement username(WebDriver driver) 
	{	
		element = driver.findElement(By.name("username"));
		return element;
	}
	
	public static WebElement password(WebDriver driver) 
	{	
		element = driver.findElement(By.name("pw"));
		return element;		
	}
	
	public static WebElement clicklogin(WebDriver driver) 
	{	
		element = driver.findElement(By.name("Login"));
		return element;		
	}
	*/
}
