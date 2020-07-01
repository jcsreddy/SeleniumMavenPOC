package com.salesforce.testcases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.salesforce.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import config.propertiesFile;
//import excelUtils.excelRead;

public class loginTest_Backup_24June {
	
	private static WebDriver driver = null;
	private static String currenturl;
	private static String username = null;
	private static String password = null;
	private static String projectpath = null;
	
	public static void main(String[] args) {
		//getProperties();
		login();
		
	}

	public static void login() {
		
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
		System.out.println("The username and password are..."+username+" and "+password);
		
		
		/* Web driver instantiation */
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		driver.manage().window().maximize();
		
		LoginPage loginpage = new LoginPage(driver);
		//propertiesFile prop = new propertiesFile(driver);
		
		//String projectpath = System.getProperty("user.dir");
		//excelRead er = new excelRead(projectpath+"/excelUtils/LoginData.xlsx", "sheet1");
		
		//loginpage.username("jcsreddy@gmail.com");
		//loginpage.username(username);
		//username = propertiesFile.username;
		//password = propertiesFile.password;
		System.out.println("The username and password are.."+username+"and"+password);
		loginpage.username(username);
		loginpage.password(password);
		loginpage.clicklogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		currenturl = driver.getCurrentUrl();
		System.out.println("The current url is..."+currenturl);
		driver.close();
	}
}
