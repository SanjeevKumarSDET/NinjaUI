package core.framework.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils extends WebBase {

	WebDriver driver;
	public CommonUtils(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement waitForElement(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 5);
		return wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
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
}
