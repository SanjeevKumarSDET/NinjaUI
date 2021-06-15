package core.framework.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonUtils extends WebBase {

	public CommonUtils() {
		PageFactory.initElements(driver, this);
	}
	
	public static void waitForElement(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	

	public WebElement mouseHover(WebElement locator) {
		Actions actions = new Actions(driver);
		actions.moveToElement(locator).perform();
		return locator;
	}
	
	public void clickOnElement(WebElement locator) {
		try {
			if(locator.isDisplayed()){
				locator.click();
			}else {
				System.out.print(locator+" not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void enterText(WebElement locator,String text) {
		try {
			if(locator.isDisplayed()){
				locator.sendKeys(text);
			}else {
				System.out.print(locator+" not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToUrl(String url){
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Boolean isElementPresent(WebElement locator) {
		waitForElement(locator);
		Boolean visible=true;
			if(locator.isDisplayed()){
				Assert.assertTrue(true);
				System.out.println(locator+"found!!");
				return visible;
			}else {
				System.out.print(locator+" not found");	
				Assert.fail();
				return false;
			}
	}
}
