package core.framework.web;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebBase {
	public static WebDriver driver;
	public static Properties prop;

	public static void initializeDriver() throws IOException {
		String browsername = ReadConfigData.config("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
	}

	
	public static void getDetailsDevice(){
		// Printing Name of the system property
        System.out.println("user.dir: "+System.getProperty("user.dir"));
  
        // Fetches the property set with 'home' key
        System.out.println("home: "+System.getProperty("home"));
        // Resulting in Null as no property is present
  
        // Printing 'name of Operating System'
        System.out.println("os.name: "+System.getProperty("os.name"));
  
        // Printing 'JAVA Runtime version'
        System.out.println("version: "+System.getProperty("java.runtime.version" ));
  
        // Printing 'name' property
        System.out.println("name: "+System.getProperty("name" ));
        // Resulting in Null as no property is present
	}

	
	public void quitdriver() {
		driver.quit();
	}
}
