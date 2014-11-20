package keywords;

import org.openqa.selenium.By;

import data.OpenBrowser;

public class SwitchControlTo extends OpenBrowser {
  public static void switchToInnerFrame(){
	  logger.info("Switching the active window to InnerFrame");
	  driver.switchTo().frame(driver.findElement(By.id("innerFrame")));
  }
  
  public static void switchToDefaultContent(){
	  logger.info("Switching the active window to Default Content");
	  driver.switchTo().defaultContent();
  }
}
