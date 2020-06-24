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
//import excelUtils.excelRead;

public class loginTest {
	
	private static WebDriver driver = null;
	private static String currenturl;
	private static String username = null;
	private static String password = null;
	private static String projectpath = null;
	
	public static void main(String[] args) {
		//getProperties();
		browserInitiation();
		readingFromExcel();
		login();
		logout();		
	}
	
	public static void browserInitiation()
	{
		/* Web driver instantiation */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void readingFromExcel()
	{
		/* Reading the data from file */
		
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
	}
	
	public static void login() {
		driver.get("https://login.salesforce.com/");			
		loginPageObjects loginpage = new loginPageObjects(driver);
		loginpage.username(username);
		loginpage.password(password);
		loginpage.clicklogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		currenturl = driver.getCurrentUrl();
		System.out.println("The current url is..."+currenturl);		
	}
	
	public static void logout()
	{
		driver.close();
		driver.quit();
	}
}
