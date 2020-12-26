package ninja.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import core.framework.web.CommonUtils;
import core.framework.web.ReadConfigData;
import core.framework.web.WebBase;
import ninja.pages.HomePage;

public class TC1 extends WebBase{
	
	
	@Test
	public void SignInAndValidateAccountName() throws InterruptedException, IOException {
		HomePage homePage = new HomePage(driver);
		CommonUtils utils = new CommonUtils(driver);
		driver.get(ReadConfigData.config("url"));
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
	
}
