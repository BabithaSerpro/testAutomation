package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static WebDriver driver;

	public Properties prop;
	public String getUrl(){
		String url=prop.getProperty("url");
		return url;
	}
	public WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"src/main/java/resources/Data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/webDrivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/main/java/webDrivers/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "src/main/java/webDrivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
}
