package core.framework.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData extends WebBase{
	public static Properties prop;
	
	public static String config(String text) throws IOException {
		prop = new Properties();
		/*For windows machine*/
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Configs\\configuration.properties"); 
		
		/**For Mac */
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//Configs//configuration.properties");
		prop.load(fis);
		String output=prop.getProperty(text);
		return output;	
	}
}
