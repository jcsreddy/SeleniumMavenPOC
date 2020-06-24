package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import pageObjects.loginPageObjects;
import config.propertiesFile;

public class loginTest_backup {
	
	private static WebDriver driver = null;
	private static String currenturl;
	private static String username = null;
	private static String password = null;
	
	public static void main(String[] args) {
		//getProperties();
		login();
		
	}
/*	
	public static String getProperties()
	{
		System.out.println("Inside the properties file");
		try {
			Properties prop = new Properties();
			String projectpath = System.getProperty("user.dir");
			System.out.println(projectpath);
			InputStream input = new FileInputStream(projectpath+"/src/test/java/config/config.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String username1 = prop.getProperty("username");
			System.out.println(username1);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		System.out.println("Moving out of the properties file");
		System.out.println("The username is ..."+username);
		return username;

	}
*/	
	public static void login() {
		
		/* Reading the data from file */
		/*
		System.out.println("Inside the properties file");
		try 
		{
			Properties prop = new Properties();
			String projectpath = System.getProperty("user.dir");
			System.out.println(projectpath);
			InputStream input = new FileInputStream(projectpath+"/src/test/java/config/config.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			System.out.println("The username and password are..."+username+"and"+password);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		System.out.println("Moving out of the properties file");
		System.out.println("The username and password are..."+username+"and"+password);
		*/
		
		/* Web driver instantiation */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		driver.manage().window().maximize();
		
		loginPageObjects loginpage = new loginPageObjects(driver);
		propertiesFile prop = new propertiesFile(driver);
		
		
		//loginpage.username("jcsreddy@gmail.com");
		//loginpage.username(username);
		loginpage.username(username);
		loginpage.password(password);
		loginpage.clicklogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		currenturl = driver.getCurrentUrl();
		System.out.println("The current url is..."+currenturl);
		driver.close();
		
		/*
		loginPageObjects.username(driver).sendKeys("jcsreddy@gmail.com");
		loginPageObjects.password(driver).sendKeys("sekhar123");
		loginPageObjects.clicklogin(driver).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		currenturl = driver.getCurrentUrl();
		System.out.println("The current url is..."+currenturl);
		
		driver.close();
		
		System.out.println("The test completed successfully");
		*/
	}
}
