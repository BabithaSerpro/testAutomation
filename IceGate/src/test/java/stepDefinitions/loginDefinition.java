package stepDefinitions;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import PageObjects.LoginPage;
import Resources.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.sourceforge.tess4j.Tesseract;

public class loginDefinition extends Base{
	String url;
	private static Logger log = LogManager.getLogger(loginDefinition.class.getName());
	
	@Given("^Initialize browser$")
	public void initialize_browser() throws Throwable {
		try {
			driver = initializeDriver();
			log.info("Initialized driver");
			}
			catch(WebDriverException e) {
				throw new Exception("Cannot Initialize the WebDriver");
			}
	   
	}

	@Given("^Navigate to given url$")
	public void navigate_to_given_url() throws Throwable {
		url = getUrl();
		driver.manage().window().maximize();
		try{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		try {
		driver.get(url);
		
		}catch(WebDriverException e) {
			throw new Exception("coudn't fetch the Url");
		}
		}catch(TimeoutException Te) {
			throw new Exception("Session Timed out could'nt find the Url");
		}
	}

	@When("^user selects Document Type$")
	public void user_selects_Document_Type() throws Throwable {
		LoginPage Lp=new LoginPage(driver);
		WebElement select = Lp.getdocType();
		Select s=new Select(select);
		s.selectByVisibleText("BE");
	}

	@When("^user enters IEC or Passport number$")
	public void user_enters_IEC_or_Passport_number() throws Throwable {
	    LoginPage Lp=new LoginPage(driver);
	    Lp.getIEC().sendKeys("1234235");
	}

	@When("^user selects location$")
	public void user_selects_location() throws Throwable {
		 LoginPage Lp=new LoginPage(driver);
		 WebElement selectloc=Lp.getLocation();
		 Select loc = new Select(selectloc);
			loc.selectByVisibleText("Amritsar Rail Cargo (INASR2)");
	    
	}

	@Then("^enters captcha$")
	public void enters_captcha() throws Throwable {
		 LoginPage Lp=new LoginPage(driver);
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	      BufferedImage  fullImg = ImageIO.read(screenshot);

	      WebElement ele = Lp.getCaptchaImg();
	      // Get the location of element on the page
	      Point point = ele.getLocation();

	      // Get width and height of the element
	      int eleWidth = ele.getSize().getWidth();
	      int eleHeight = ele.getSize().getHeight();

	      // Crop the entire page screenshot to get only element screenshot
	      BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
	          eleWidth, eleHeight);
	      ImageIO.write(eleScreenshot, "png", screenshot);

	      // Copy the element screenshot to disk
	      File screenshotLocation = new File("Image/GoogleLogo_screenshot.png");
	      FileUtils.copyFile(screenshot, screenshotLocation);
	      Tesseract tesseract = new Tesseract();
			tesseract.setDatapath("tessdata");
			Thread.sleep(2000);
			String imageText=tesseract.doOCR(new File("Image/GoogleLogo_screenshot.png"));
			
			System.out.println("Image text--->"+imageText);

			Lp.getCaptchaText().sendKeys(imageText);
	}

	@Then("^clicks on submit button$")
	public void clicks_on_submit_button() throws Throwable {
		LoginPage Lp=new LoginPage(driver);
		Lp.getSubmitBtn().click();
		Thread.sleep(1000);
		driver.switchTo().alert().dismiss();
	}

	@Then("^close all browsers$")
	public void close_all_browsers() throws Throwable {
		driver.close();
	    
	}


}
