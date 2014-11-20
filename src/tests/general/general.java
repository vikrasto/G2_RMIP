package tests.general;

import java.io.FileNotFoundException;
import keywords.Generals;
import keywords.SwitchControlTo;
import org.openqa.selenium.By;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import data.OpenBrowser;
import repository.OR_TopMenu;
import repository.OR_General;

public class general extends OpenBrowser{

    @BeforeSuite
	public static void loginIntoG2() throws FileNotFoundException {
       OpenBrowser.openBrowser();
       
	   try {
		in = general.class.getClassLoader().getResourceAsStream("data/data.properties");
	    prop.load(in);
       } catch (Exception e) {
           e.printStackTrace();
       }
	   logger.info("Application under test is - "+prop.getProperty("ApplicationURL")+"");
       driver.get(prop.getProperty("ApplicationURL"));
       
       if(browserName.equals("internet explorer")){
    	   driver.navigate().to("javascript:document.getElementById('overridelink').click();");   
       }
       
       String userName = prop.getProperty("UserID");
       String passWord = prop.getProperty("Password");
       
       Generals.clearText(OR_General.userName());
       Generals.enterText(OR_General.userName(), userName);
       Generals.clearText(OR_General.passWord());
       Generals.enterText(OR_General.passWord(), passWord);
       Generals.click(OR_General.loginButton());

       SwitchControlTo.switchToInnerFrame();
       logger.info("Closing the Alert Box InnerFrame window opened after login");
       driver.findElement(By.linkText("close")).click();
       
       Generals.waitByVisiblilityOfElement(driver.findElement(OR_TopMenu.welcomeText()));
    }
    
    @AfterSuite
    public static void closeApplication(){
    	Generals.click(OR_General.logoutButton());
    	logger.info("Closing Test Session. Quitting driver and closing the browser");
    	driver.quit();
    }
}
