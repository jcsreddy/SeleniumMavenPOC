package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginPage {

	private static WebElement element = null;
	
	public static WebElement username(WebDriver driver) {	

		element = driver.findElement(By.name("username"));
		return element;

	}
	
	public static WebElement password(WebDriver driver) {	
		
		element = driver.findElement(By.name("pw"));
		return element;
		
	}
	
	public static WebElement clicklogin(WebDriver driver) {	

		element = driver.findElement(By.name("Login"));
		return element;
		
	}

}
