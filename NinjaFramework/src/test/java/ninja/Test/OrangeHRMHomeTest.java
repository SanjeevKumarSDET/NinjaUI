package ninja.Test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import core.framework.web.CommonUtils;
import core.framework.web.ReadData;
import core.test.TestBase;
import ninja.pom.OrangeHomePOM;
import ninja.pom.OrangeLoginPOM;

public class OrangeHRMHomeTest extends TestBase{
	OrangeLoginPOM orangeHRMLogin;
	CommonUtils utils;
	ExtentReports report;
	
	@BeforeMethod
	public void initSetup(){
		orangeHRMLogin = new OrangeLoginPOM();
		utils = new CommonUtils();
		report = new ExtentReports("");
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

