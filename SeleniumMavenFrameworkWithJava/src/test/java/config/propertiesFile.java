package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class propertiesFile {
	
	public static String username;
	public static String password;
	
	WebDriver driver = null;
	//public static String username = null;
	//public static String password = null;
	
	/* Constructor */
	public propertiesFile(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/*
	public static void main(String[] args) {
		getProperties();
	}
	*/	
	public void getProperties(String text)
	{		
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
			String username = prop.getProperty("username");
			System.out.println("The user name is...."+username);
			
			String password = prop.getProperty("password");
			System.out.println("The user name is...."+password);
			
		} catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}		
	}
}	
