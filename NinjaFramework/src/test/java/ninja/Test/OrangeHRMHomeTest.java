package ninja.Test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import core.framework.web.CommonUtils;
import core.framework.web.ReadData;
import core.test.ExtentReport;
import core.test.TestBase;
import ninja.Pages.OrangeHomePage;
import ninja.pom.OrangeHomePOM;
import ninja.pom.OrangeLoginPOM;

public class OrangeHRMHomeTest extends TestBase{
	OrangeLoginPOM orangeHRMLogin;
	CommonUtils utils;
	ExtentReport report;
	
	@BeforeMethod
	public void initSetup(){
		orangeHRMLogin = new OrangeLoginPOM();
		utils = new CommonUtils();
		report = new ExtentReport();
	}
	
	@Test
	public void checkBrandImage() throws IOException, Exception{
		utils.navigateToUrl(ReadData.fromConfig("OrangeHRMUrl"));
	    System.out.println("user.dir: "+System.getProperty("user.dir"));
	    utils.isElementPresent(OrangeLoginPOM.password());
	    utils.enterText(orangeHRMLogin.userName(), ReadData.fromConfig("OrangeHRMUser"));
	    utils.enterText(OrangeLoginPOM.password(), ReadData.fromConfig("OrangeHRMPassword"));
	    utils.clickOnElement(OrangeLoginPOM.loginBtn());
	    Thread.sleep(10000);
	    utils.isElementPresent(OrangeHomePOM.admin());

	}
}

