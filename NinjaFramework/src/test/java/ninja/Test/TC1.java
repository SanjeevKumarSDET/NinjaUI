package ninja.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import core.framework.web.CommonUtils;
import core.framework.web.ReadConfigData;
import core.framework.web.WebBase;
import ninja.pages.HomePage;

public class TC1 extends WebBase{
	HomePage homePage ;
	CommonUtils utils ;

	@BeforeMethod
	public void setUp() throws IOException {
		initializeDriver();
		homePage = new HomePage();
		utils = new CommonUtils();
	}
	
	/**
	 * Currently the below test is enabled as false
	 * If you need to run the below test case, change enabled = true
	 * Enter your Amazon user name and password in the configuration.properties file
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(enabled=false)
	public void SignInAndValidateAccountName() throws InterruptedException, IOException {	
		homePage.sigIn().click();
		/*Enter your user name and password in the configuration.properties file*/
		homePage.enterEmail().sendKeys(ReadConfigData.config("username"));
		homePage.continueBtn().click();
		homePage.password().sendKeys(ReadConfigData.config("password"));
		homePage.submit().click();
		boolean isNamePresent = homePage.navAccount().getText().contains("Sanjeev");
		System.out.println(isNamePresent);
		Assert.assertEquals(isNamePresent, true);
		utils.mouseHover(homePage.navAccount());
		driver.findElement(By.xpath("//span[text()='Your Orders']")).click();
	}

	@Test(enabled=true)
	public void searchAnItem(){
		homePage.searchBar().sendKeys("One plus nord");
		homePage.searchBtn().click();
	}
	
}
