package testNGListeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import core.test.TestBase;

@Listeners(CustomListener.class)
public class ScreenshotTest extends TestBase{

	@Test
	public void takeScreenshotTest() {
		System.out.println("SCREEN SHOT TEST ##############");
		Assert.assertEquals(false, true);
	}
}
