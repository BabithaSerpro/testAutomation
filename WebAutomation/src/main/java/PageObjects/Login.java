package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	public static WebDriver driver;
	
	By loginicon=By.xpath("//div[@class='flyDownOuter']/div[@class='dropdown']/a");
	By username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By loginBtn=By.xpath("//input[@id='Login']");
	
	
	public Login(WebDriver driver) {
		Login.driver=driver;
		
	}

	public WebElement getLogin() {
		return driver.findElement(loginicon);
	}
	
	public WebElement getUsername() {
		return driver.findElement(username);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getLoginBtn() {
		return driver.findElement(loginBtn);
	}
}
