package ninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import core.framework.web.WebBase;

public class HomePage extends WebBase{

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="nav-link-accountList")
	private WebElement btnSignIn;
	
	@FindBy(id="ap_email")
	private WebElement email;
	
	@FindBy(id="continue")
	private WebElement btnContinue;
	
	@FindBy(id="ap_password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement btnSubmit;
	
	@FindBy(id="nav-link-accountList")
	private WebElement navAccount;

	@FindBy(id="twotabsearchtextbox")
	private WebElement searchBar;
	
	@FindBy(id="nav-search-submit-button")
	private WebElement searchBtn;
		
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

	public WebElement searchBar(){
		return searchBar;
	}
	
	public WebElement searchBtn(){
		return searchBtn;
	}
	
	
}
