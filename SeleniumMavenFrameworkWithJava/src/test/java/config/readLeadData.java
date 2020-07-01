package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class readLeadData {
	
	public static String lastname;
	public static String company;
	public static String leadstatus;
	WebDriver driver = null;
	
	/* Constructor */
	public readLeadData(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void getProperties(String text)
	{		
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
			String lastname = prop.getProperty("lastname");
			System.out.println("The last name is...."+lastname);
			
			String company = prop.getProperty("company");
			System.out.println("The company is...."+company);
			
			String leadstatus = prop.getProperty("leadstatus");
			System.out.println("The lead status is...."+leadstatus);
			
		} catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}		
	}
}	
