

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Demo {

	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver", "src/main/java/webDrivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://epayment.icegate.gov.in/epayment/locationAction.action;jsessionid=735071314649540CB5F7891BDAD30FBF");
		Select s = new Select(driver.findElement(By.xpath("//select[@id='docType']")));
		s.selectByVisibleText("BE");
		String docType = driver.findElement(By.xpath("//select[@id='docType']")).getText();
		//System.out.println("DocType-->" + docType);

		driver.findElement(By.xpath("//input[@id='multiChallanAction_iec']")).sendKeys("12344556");
		Select loc = new Select(driver.findElement(By.xpath("//select[@id='location']")));
		loc.selectByVisibleText("Amritsar Rail Cargo (INASR2)");
		WebElement captcha=driver.findElement(By.xpath("//img[@id='capimg']"));
		File src=((TakesScreenshot)(captcha)).getScreenshotAs(OutputType.FILE);
	}
}
