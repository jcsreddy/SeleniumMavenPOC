package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageObjects.loginPage;

public class loginTest {
	
	private static WebDriver driver = null;
	private static String currenturl;
	
	public static void main(String[] args) {
		
		login();
		
	}
	
	public static void login() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		loginPage.username(driver).sendKeys("jcsreddy@gmail.com");
		loginPage.password(driver).sendKeys("sekhar123");
		loginPage.clicklogin(driver).click();
		
		try {
			driver.manage().window().wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currenturl = driver.getCurrentUrl();
		System.out.println("The current url is..."+currenturl);
		
		driver.close();
	}
}
