package ninja.Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.framework.web.CommonUtils;
import core.framework.web.ReadConfigData;
import core.test.TestBase;
import ninja.pages.OrangeHRMLoginPage;

public class OrangeHRMLoginTest extends TestBase{
	OrangeHRMLoginPage orangeHRMLogin;
	CommonUtils utils;
	
	@BeforeMethod
	public void initSetup(){
		orangeHRMLogin = new OrangeHRMLoginPage();
		utils = new CommonUtils();
	}
	
	@Test
	public void loginToOrangeHRM() throws IOException{
		utils.navigateToUrl(ReadConfigData.config("OrangeHRMUrl"));
		orangeHRMLogin.userName().sendKeys("Admin");
		orangeHRMLogin.password().sendKeys("admin123");
		orangeHRMLogin.loginBtn().click();
	}
}
