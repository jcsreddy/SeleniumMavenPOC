import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {
	
	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("The project path is "+projectPath);
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		
		//System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.selenium.dev/");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str = driver.getCurrentUrl();
		System.out.println("The current URL is :"+str);
		
		//driver.quit();
		
	}

}
