package stepDefinitions;



import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

import PageObjects.Login;
import Resources.Base;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginDefinition extends Base{
	
	String url;
	private static Logger log = LogManager.getLogger(LoginDefinition.class.getName());
	
	
	@Given("^Initialize browser with chrome$")
	public void initialize_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
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
	    // Write code here that turns the phrase above into concrete actions
		url = getUrl();
		driver.manage().window().maximize();
		try{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		try {
		driver.get(url);
		String eTitle = "CRM Software: Cloud Computing Solutions For Every Business - Salesforce IN";
		String aTitle = "" ;
		aTitle = driver.getTitle();
		System.out.println("Title="+aTitle);
		
		//compare the actual title with the expected title
		if (aTitle.equalsIgnoreCase(eTitle)) {
			log.info("Landed on FreePay App");
		} else {
			log.error("Didnot fetch the Freepay App");
		}
		}catch(WebDriverException e) {
			throw new Exception("coudn't fetch the Url");
		}
		}catch(TimeoutException Te) {
			throw new Exception("Session Timed out could'nt find the Url");
		}
	}

	@Given("^user clicks on login icon$")
	public void user_clicks_on_login_icon() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		try {
			Login loginPage=new Login(driver);
			loginPage.getLogin().click();
			log.info("User clicked on login url");
		}
		
		catch(ElementNotVisibleException e) {
			throw new Exception("Login url not visible!!");
		}
		catch(ElementNotInteractableException e) {
			throw new Exception("Login icon not interactable.");
		}
		catch(NoSuchElementException e) {
			//System.out.println("No Such Element found");
			throw new Exception("No Such Element found- to click!!");
		}
	}

	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\" and clicked on login button$")
	public void user_enters_and_and_clicked_on_login_button(String username, String password) throws Throwable {
		Login loginPage=new Login(driver);
		try {
			loginPage.getUsername().sendKeys(username);
			log.info("User enters Username");
			}
			catch(ElementNotVisibleException e) {
				throw new Exception("Username field not Visible!!");
			}
			catch(ElementNotInteractableException e) {
				throw new Exception("couldnot pass username into the text box!! Text box not interactable.");
			}
			catch(NoSuchElementException e) {
				//System.out.println("No Such Element found");
				throw new Exception("No Such Element found - for entering username!!");
			}
		
		try {
			loginPage.getPassword().sendKeys(password);
			log.info("User enters password");
			}
			catch(ElementNotVisibleException e) {
				throw new Exception("password field not Visible!!");
			}
			catch(ElementNotInteractableException e) {
				throw new Exception("couldnot pass password into the text box!! Text box not interactable.");
			}
			catch(NoSuchElementException e) {
				//System.out.println("No Such Element found");
				throw new Exception("No Such Element found - for entering password!!");
			}
		if(loginPage.getLoginBtn().isEnabled()) {
			log.info("Login button found and clicked");
			}else {
				log.error("Login button not found");
			}
			try {
				loginPage.getLoginBtn().click();
			}
			catch(ElementNotVisibleException e) {
				throw new Exception("Login button not Visible!!");
			}
			catch(ElementNotInteractableException e) {
				throw new Exception("Login button is not interactable!!");
			}
			catch(NoSuchElementException e) {
				//System.out.println("No Such Element found");
				throw new Exception("Coudn't find Login button-No Such Element found!!");
			}
	}

	@Then("^verify if user is succesfully logged in$")
	public void verify_if_user_is_succesfully_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^close all browsers$")
	public void close_all_browsers() throws Throwable {
		Thread.sleep(2000);
		try {
		driver.close();
		log.info("Browser closed successfully");
		}
		catch(WebDriverException e) {
			throw new Exception("Cannot close the WebDriver");
		}
	    
	}

}
