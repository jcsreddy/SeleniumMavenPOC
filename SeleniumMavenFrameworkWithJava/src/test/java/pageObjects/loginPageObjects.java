package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPageObjects {

	//private static WebElement element = null;
	
	WebDriver driver = null;
	
	/* Login page objects */
	By username = By.name("username");
	By password = By.name("pw");
	By clicklogin = By.name("Login");
	
	/* Constructor */
	public loginPageObjects(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void username(String text)
	{
		driver.findElement(username).sendKeys(text);
	}
	
	public void password(String text)
	{
		driver.findElement(password).sendKeys(text);
	}
	
	public void clicklogin()
	{
		driver.findElement(clicklogin).click();
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
