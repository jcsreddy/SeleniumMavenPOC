import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserTest {

	public static void main(String[] args) {
		
		BrowserCode();

	}
		public static void BrowserCode()
		{

			String projectPath = System.getProperty("user.dir");
			System.out.println("The project path is "+projectPath);

			//System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			//System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver\\geckodriver.exe");
			//WebDriverManager.firefoxdriver().setup();
			//WebDriver driver = new FirefoxDriver();

			driver.get("https://www.selenium.dev/");
			driver.findElement(By.xpath("//img[@class='logo logo-large']"));

			String expectedText = "BLACK LIVES MATTER";
			String actualText = driver.findElement(By.xpath("//strong[contains(text(),'BLACK LIVES MATTER')]")).getText();
			Assert.assertEquals(expectedText, actualText);
			System.out.println("Assertion Passed");

			List<WebElement> lisOfInputElements = driver.findElements(By.xpath("//input"));
			lisOfInputElements.size();

			System.out.println("Count of locators with Input are " + lisOfInputElements.size());

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String str = driver.getCurrentUrl();
			System.out.println("The current URL is :"+str);

			System.out.println("Test completed successfully");

			driver.quit();

		}
}
