package core.framework.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils extends WebBase {

	public CommonUtils() {
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElement(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}

	public WebElement mouseHover(WebElement locator) {
		Actions actions = new Actions(driver);
		actions.moveToElement(locator).perform();
		return locator;
	}
	
	public WebElement clickOnElement(WebElement locator) {
		try {
			if(locator.isDisplayed()) {
				driver.findElement(By.id("locator")).click();
			}else {
				System.out.print("Element not found");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return locator;
	}

	public void navigateToUrl(String url){
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
