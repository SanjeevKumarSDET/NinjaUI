package ninja.Pages;

import org.openqa.selenium.support.PageFactory;

import core.framework.web.CommonUtils;
import core.framework.web.WebBase;
import ninja.pom.OrangeHomePOM;

public class OrangeHomePage extends WebBase{
	
	CommonUtils utils = new CommonUtils();

	public OrangeHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyAdminHeader() {
		utils.isElementPresent(OrangeHomePOM.admin());
	}
}
