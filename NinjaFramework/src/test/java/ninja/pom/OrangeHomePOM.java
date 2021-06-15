package ninja.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import core.framework.web.WebBase;

public class OrangeHomePOM extends WebBase{
	public OrangeHomePOM(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='branding']/a/img[@alt='OrangeHRM']")
	private static WebElement brandImage;
	
	@FindBy(id="Subscriber_link")
	private static WebElement admin;
	
	
	public static WebElement brandImage() {
		return brandImage;
	}
	
	public static WebElement admin() {
		return admin;
	}
}
