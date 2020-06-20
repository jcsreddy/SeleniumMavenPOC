package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumTest {
	
	public static void main(String[] args) {
		
		//WebDriver driver = new FirefoxDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\CHANDRASEKHARJANGA\\git\\SeleniumPOC\\FirstProject\\lib\\drivers\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", "\\FirstProject\\lib\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev");
		
		driver.quit();
	}

}