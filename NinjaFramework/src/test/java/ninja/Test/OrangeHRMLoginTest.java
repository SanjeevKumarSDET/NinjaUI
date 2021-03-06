package ninja.Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.framework.web.CommonUtils;
import core.framework.web.ReadData;
import core.test.ExtentReport;
import core.test.TestBase;
import ninja.pom.OrangeLoginPOM;

public class OrangeHRMLoginTest extends TestBase{
	static OrangeLoginPOM orangeHRMLogin;
	static CommonUtils utils;
	ExtentReport report;

	@BeforeMethod
	public void initSetup(){
		orangeHRMLogin = new OrangeLoginPOM();
		utils = new CommonUtils();
		report = new ExtentReport();
	}

@Test
	public static void loginToOrangeHRM() throws IOException{
		utils.navigateToUrl(ReadData.fromConfig("OrangeHRMUrl"));
	    System.out.println("user.dir: "+System.getProperty("user.dir"));
	    utils.enterText(orangeHRMLogin.userName(), ReadData.fromConfig("OrangeHRMUser"));
	    utils.enterText(OrangeLoginPOM.password(), ReadData.fromConfig("OrangeHRMPassword"));
	    utils.clickOnElement(OrangeLoginPOM.loginBtn());
	}	
	
	
}
