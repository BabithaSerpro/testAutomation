package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
;

public class LoginPage {

	public static WebDriver driver;
	
	By docType=By.xpath("//select[@id='docType']");
	By iec=By.xpath("//input[@id='multiChallanAction_iec']");
	By location=By.xpath("//select[@id='location']");
	By captchaImg=By.xpath("//img[@id='capimg']");
	By captchaText=By.xpath("//input[@id='captchaResp']");
	By SubmitBtn=By.xpath("//div[@class='button']/a[@class='page_button']");
	public LoginPage(WebDriver driver) {
		LoginPage.driver=driver;
		
	}
	
	public WebElement getdocType() {
		return driver.findElement(docType);
	}
	

	public WebElement getIEC() {
		return driver.findElement(iec);
	}

	public WebElement getLocation() {
		return driver.findElement(location);
		
	}
	public WebElement getCaptchaImg() {
		return driver.findElement(captchaImg);
		
	}
	public WebElement getCaptchaText() {
		return driver.findElement(captchaText);
		
	}
	public WebElement getSubmitBtn() {
		return driver.findElement(SubmitBtn);
	}
}
