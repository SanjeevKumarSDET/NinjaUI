package ninja.Test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import core.framework.web.CommonUtils;
import core.framework.web.ReadData;
import core.test.TestBase;
import ninja.pom.AmazonLoginPOM;

public class AmazonLoginTest extends TestBase{
	
	AmazonLoginPOM homePage ;
	CommonUtils utils ;

	@BeforeMethod
	public void initsetUp() throws IOException {
		homePage = new AmazonLoginPOM();
		utils = new CommonUtils();
	}
	
	/**
	 * Currently the below test is enabled as false
	 * If you need to run the below test case, change enabled = true
	 * Enter your Amazon user name and password in the configuration.properties file
	 * @throws InterruptedException
	 * @throws IOException
	 */
	
	@Test(enabled=true)
	public void SignInAndValidateAccountName() throws InterruptedException, IOException {	
		utils.navigateToUrl(ReadData.fromConfig("AmazonUrl"));
		homePage.signIn().click();
		/*Enter your user name and password in the configuration.properties file*/
		homePage.enterEmail().sendKeys(ReadData.fromConfig("AmazonUsername"));
		homePage.continueBtn().click();
		homePage.password().sendKeys(ReadData.fromConfig("AmazonPassword"));
		homePage.submit().click();
		boolean isNamePresent = homePage.navAccount().getText().contains("Sanjeev");
		System.out.println(isNamePresent);
		AssertJUnit.assertEquals(isNamePresent, true);
		utils.mouseHover(homePage.navAccount());
		driver.findElement(By.xpath("//span[text()='Your Orders']")).click();
	}

	@Test(enabled=true)
	public void searchAnItem() throws InterruptedException, IOException {
		homePage = new AmazonLoginPOM();
		utils = new CommonUtils();
		utils.navigateToUrl(ReadData.fromConfig("AmazonUrl"));
		homePage.searchBar().sendKeys("One plus nord");
		homePage.searchBtn().click();
		utils.mouseHover(homePage.signIn());
		Thread.sleep(1000);
	}

	@Test(enabled=true)
	public void searchAVideoInYoutube() throws InterruptedException {
		driver.get("https://youtu.be/HzPpKLrRG7M");
		Thread.sleep(1000);
	}
	
	
}
