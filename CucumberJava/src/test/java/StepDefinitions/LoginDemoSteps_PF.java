package StepDefinitions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagefactory.HomePage_PF;
import pagefactory.LoginPage_PF;


public class LoginDemoSteps_PF {
	
	// class variables
	WebDriver driver;
	LoginPage_PF login;
	HomePage_PF homePage;
	
	// hooks
	@Before
	public void browserSetup() {
		
		Duration duration = Duration.ofSeconds(10);
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project Path is:"+projectPath);
		
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");
				
		driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(duration);
		
	}
	
	@After
	public void browserTeardown() {
		driver.close();
		driver.quit();
	}
	

	
	@Given("user is on login page")
	public void user_is_on_login_page() {

		driver.navigate().to("https://example.testproject.io/web/");
	}
	
	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) throws InterruptedException  {
		
		login = new LoginPage_PF(driver);
		
		
		login.enterUsername(username);
		login.enterPassword(password);
		
		Thread.sleep(2000);
	}
	
	@And("user clicks on login")
	public void user_clicks_on_login() throws InterruptedException {
		
		homePage = new HomePage_PF(driver);
		login.clickOnLogin();
		
		Thread.sleep(2000);
	}

	@Then("user is navigated to the home page")
	public void user_is_navigated_to_the_home_page() {
		System.out.println("Inside Step - User navigates to search results");
		
		homePage.checkLogoutIdDisplayed();
		
	}

}
