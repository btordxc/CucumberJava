package pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF {
	
	// Create a WebDriver reference variable. 
	WebDriver driver;
	
	// Declare a constructor and pass WebDriver reference as an input parameter. 
	public LoginPage_PF(WebDriver driver) {
		
		this.driver = driver;
		
		// Call initElements() method by using PageFactory reference and pass driver and this as parameters. 
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Locate all elements using locators in the home page
		@FindBy(how = How.ID, using="name")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(id="login")
	WebElement btn_login;
	
	// Declare methods to perform operations on the elements.
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void clickOnLogin() {
		btn_login.click();
	}
}
