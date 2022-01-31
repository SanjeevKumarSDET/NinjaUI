package testNGListeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.test.TestBase;

public class ScreenshotBase extends TestBase{
	public static void failed(String screenshotName) {
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			String path = System.getProperty("user.dir");
			
			String dateVar = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			String timeVar = new SimpleDateFormat("hh:mm:ss").format(new Date());

			String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+"_"+dateVar+"_"+timeVar+".png";
			File finalDestination = new File(destination);
			FileUtils.copyFile(source, finalDestination);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
