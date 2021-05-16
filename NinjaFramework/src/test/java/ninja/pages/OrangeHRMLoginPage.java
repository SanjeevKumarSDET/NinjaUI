package ninja.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.framework.web.WebBase;

public class OrangeHRMLoginPage extends WebBase{
	public OrangeHRMLoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement userName;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement loginBtn;
	
	public WebElement userName() {
		return userName;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement loginBtn() {
		return loginBtn;
	}
}
