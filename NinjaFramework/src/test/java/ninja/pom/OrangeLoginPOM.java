package ninja.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.framework.web.WebBase;

public class OrangeLoginPOM extends WebBase{
	public OrangeLoginPOM(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")
	private static WebElement userName;
	
	@FindBy(id="txtPassword")
	private static WebElement password;
	
	@FindBy(id="btnLogin")
	private static WebElement loginBtn;
	
	public WebElement userName() {
		return userName;
	}
	
	public static WebElement password() {
		return password;
	}
	
	public static WebElement loginBtn() {
		return loginBtn;
	}
}
