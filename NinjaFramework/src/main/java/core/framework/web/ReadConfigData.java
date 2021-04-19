package core.framework.web;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData extends WebBase{
	public static Properties prop;
	public static  FileInputStream fis;
	
	public static String config(String text) throws IOException {
		prop = new Properties();
		String deviceOS = System.getProperty("os.name");
        System.out.println("Opening in "+deviceOS);
		/*For windows machine*/
		//fis = new FileInputStream(System.getProperty("user.dir")+"\\Configs\\configuration.properties"); 
		
		/**For Mac */
		if(deviceOS.contains("Mac OS X")){
		fis = new FileInputStream(System.getProperty("user.dir")+"//Configs//configuration.properties");
		}
		prop.load(fis);
		String output=prop.getProperty(text);
		return output;	
	}
}
