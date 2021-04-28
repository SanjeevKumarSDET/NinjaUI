package core.test;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import core.framework.web.WebBase;

public class TestBase extends WebBase{
	
	public TestBase() {
		PageFactory.initElements(driver, this);
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		initializeDriver();	
	}
	
	@AfterMethod
	public void quit() {
		quitdriver();
	}
}
