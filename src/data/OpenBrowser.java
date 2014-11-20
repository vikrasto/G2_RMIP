package data;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import tests.general.general;

public class OpenBrowser {
	
   public static Properties prop = new Properties();
   public static InputStream in = null;
	
   public static Logger logger = Logger.getLogger(general.class);
   
   public static WebDriver driver;
   public static String browserName;
   public static void openBrowser(){
	   System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriverServers\\SeleniumChromeDriver_32.exe");
	   driver = new ChromeDriver();
//	   System.setProperty("webdriver.ie.driver", "C:\\SeleniumDriverServers\\IEDriverServer_32.exe");
//	   driver = new InternetExplorerDriver();
	   Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	   browserName = cap.getBrowserName().toLowerCase();
	   logger.info("\n\nStarting a new test suite run. Opened Browser- "+browserName+"\n");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.manage().window().maximize();

   }
}
