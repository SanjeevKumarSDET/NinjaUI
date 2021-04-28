package testNGListeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.test.TestBase;

public class ScreenshotBase extends TestBase{
	public void failed() {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			String path = System.getProperty("user.dir");
			FileUtils.copyFileToDirectory(source, new File(path+"/screenshots"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
