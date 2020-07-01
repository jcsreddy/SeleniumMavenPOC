package com.salesforce.testcases;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.pages.leadDataPage;
import com.salesforce.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import config.readLoginData;
import excelUtils.ExcelDataProvider;

public class loginTest {
	
	private static WebDriver driver = null;
	private static String currenturl;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	private static String projectpath = null;
	private static String lastname = null;
	private static String company = null;
	private static String leadstatus = null;
	
	public static void main(String[] args) {
		//getProperties();
		browserInitiation();
		readingLoginDataFromCSV();
		login();
		readingLeadDataFromCSV();
		leadCreation();
		logout();		
	}
	
	public static void browserInitiation()
	{
		/* Web driver instantiation */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static void readingLoginDataFromCSV()
	{
		/* Reading the data from csv file */
		
		System.out.println("Inside the properties file");
		try 
		{
			Properties prop = new Properties();
			String projectpath = System.getProperty("user.dir");
			System.out.println(projectpath);
			InputStream input = new FileInputStream(projectpath+"/src/test/java/config/logindata.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			//decodedpwd = prop.getProperty(key)
			password = prop.getProperty("password");
			System.out.println("The username and password are..."+username+"and"+password);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		System.out.println("Moving out of the login properties file");
	}
	
	public static void login() {
		driver.get(url);			
		LoginPage loginpage = new LoginPage(driver);
		loginpage.username(username);
		loginpage.password(password);
		loginpage.clicklogin();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		currenturl = driver.getCurrentUrl();
		System.out.println("The current url is..."+currenturl);		
	}
	
	public static void readingLeadDataFromCSV()
	{
		/* Reading the data from csv file */
		
		System.out.println("Inside the properties file");
		try 
		{
			Properties prop = new Properties();
			String projectpath = System.getProperty("user.dir");
			System.out.println(projectpath);
			InputStream input = new FileInputStream(projectpath+"/src/test/java/config/leaddata.properties");
			try {
				prop.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			
			lastname = prop.getProperty("lastname");
			company = prop.getProperty("company");
			leadstatus = prop.getProperty("leadstatus");
			System.out.println("The last, company and lead status are..."+lastname+" and "+company);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		System.out.println("Moving out of the lead properties file");
	}
	
	public static void leadCreation() {
		System.out.println("We are in the leads section...");
		leadDataPage ldpo = new leadDataPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*
		WebDriverWait wait = new WebDriverWait(driver,120);	
		wait.until(ExpectedConditions.elementIfVisible(ldpo.clickleadstabisdisplayed()));
		*/
		ldpo.clickleadstab();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ldpo.closedialoginleadstab();
		ldpo.clicknewinleadstab();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("The last name is..."+lastname);
		ldpo.lastname(lastname);
		ldpo.company(company);
		System.out.println("The lead status is..."+leadstatus);
		//ldpo.leadstatus(leadstatus);
		ldpo.clicksave();
	}
	public static void logout()
	{
		driver.close();
		driver.quit();
	}
}
