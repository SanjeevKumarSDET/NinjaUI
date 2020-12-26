package ninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav-link-accountList")
	WebElement btnSignIn;
	
	@FindBy(id="ap_email")
	WebElement email;
	
	@FindBy(id="continue")
	WebElement btnContinue;
	
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement btnSubmit;
	
	@FindBy(id="nav-link-accountList")
	WebElement navAccount;
		
	public WebElement sigIn() {
		return btnSignIn;
	}
	
	public WebElement enterEmail() {
		return email;
	}
	
	public WebElement continueBtn() {
		return btnContinue;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement submit() {
		return btnSubmit;
	}
	
	public WebElement navAccount() {
		return navAccount;
	}
	
	
	
}
