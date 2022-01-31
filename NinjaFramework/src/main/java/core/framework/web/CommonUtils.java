package core.framework.web;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class CommonUtils extends WebBase {

	public CommonUtils() {
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElement(WebElement locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			System.out.println("Waits for element " + locator);
			wait.until(ExpectedConditions.visibilityOf(locator));
		} catch (Exception e) {
			System.out.println("Element not found " + locator + " , waited for 20 seconds");
		}
	}

	public void waitForElementToEnable(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void waitForElementToDisappear(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOf(locator));
	}

	public WebElement mouseHover(WebElement locator) {
		waitForElement(locator);
		Actions actions = new Actions(driver);
		actions.moveToElement(locator).perform();
		return locator;
	}

	public void clickOnElement(WebElement locator) {
		
		waitForElementToEnable(locator);
		if (locator.isEnabled()) {
			locator.click();
			System.out.println("CLICKED ON ELEMENT " + locator);
		} else if (!locator.isEnabled()) {
			waitForElementToEnable(locator);
			locator.click();
		} else if (!locator.isDisplayed())
			System.out.println(locator + "NOT FOUND ");
	}

	public void enterText(WebElement locator, String text) {
		waitForElement(locator);
		try {
			if (locator.isDisplayed()) {
				locator.sendKeys(text);
			} else {
				System.out.print(locator + " not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateToUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Boolean isElementPresent(WebElement locator) {
		Boolean visible = true;
		if (locator.isDisplayed()) {
			Assert.assertTrue(true);
			System.out.println(locator + "found!!");
			return visible;
		} else {
			System.out.print(locator + " not found");
			Assert.fail();
			return false;
		}
	}

	public void scrollUptoAnElement(WebElement locator) throws InterruptedException {
		waitForElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", locator);
		js.executeScript("window.scrollBy(0,-180)", "");
		clickOnElement(locator);
	}

	public void scrollDown(int value) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + value + ")");
	}

	public void scrollUp(int value) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-" + value + ")");
	}

	public void clickBackButton() {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			Reporter.log("Unable to go back from the Page, Exception: " + e);
		}
	}

	public void pressEnterKey() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ENTER).build().perform();
	}

	public void pressDownArrowKey() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ARROW_DOWN).build().perform();
	}

	public void pressUpArrowKey() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ARROW_UP).build().perform();
	}

	public void pressRightArrowKey() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.ARROW_RIGHT).build().perform();
	}

	public void pressBackSpace() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.BACK_SPACE).build().perform();
	}

	public void pressEndKey() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.END).build().perform();
	}
	
}
