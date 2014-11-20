package keywords;

import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import data.DbCon;
import data.OpenBrowser;

public class Generals extends OpenBrowser {
	
    public static WebElement element(By By){
    	return driver.findElement(By);
    }
    public static List<WebElement> elements(By By){
    	return driver.findElements(By);
    }
	
    public static void waitByVisiblilityOfElement(WebElement element){
		logger.info("Waiting for the visibility of element- "+element+"");
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public static void waitByVisiblilityOfElementLocatedBy(By By){
		logger.info("Waiting for the visibility of element located By- "+By+"");
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By));
    }
    public static void waitByPresenceOfElementLocatedBy(By By){
		logger.info("Waiting for the presence of element located By- "+By+"");
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By));
    }
    public static void waitByInvisibilityOfElementLocatedBy(By By){
		logger.info("Waiting for the invisibility of element located By- "+By+"");
    	WebDriverWait wait = new WebDriverWait(driver,30);
    	wait.until(ExpectedConditions.invisibilityOfElementLocated(By));
    }
    
    public static void sleepBy(long TimeInMilliSeconds) throws Exception{
       logger.info("Thread is sleeping by- "+TimeInMilliSeconds+" Milli Seconds");	
       Thread.sleep(TimeInMilliSeconds);
    }

	public static void clearText(By By){
		logger.info("Clearing Text present in the element located- "+By+"");
		driver.findElement(By).clear();
	}
	public static void click(By By) {
		logger.info("Clicking on the element located-"+By+"");
		driver.findElement(By).click();
	}
	
    public static void enterText(By By,String text){
        logger.info("Entering Text "+text+" in the element located-"+By+"");	
  	    driver.findElement(By).sendKeys(text);
    }

    public static String getText(By By){
        logger.info("Getting Text from the element located-"+By+"");
  	    return driver.findElement(By).getText();
    }
    public static String getTextValue(By By){
        logger.info("Getting Text value from the element located-"+By+"");
  	    return driver.findElement(By).getAttribute("value");
    }
    
    public static void navigateTo(By By){
    	logger.info("Navigating to the element located-"+By+"");
    	driver.findElement(By).click();
    }
    
    public static boolean verifyElementIsDisplaying(By By){
    	return driver.findElement(By).isDisplayed();
    }
    public static boolean verifyElementIsSelected(By By){
    	return driver.findElement(By).isSelected();
    }
    public static int getSizeOfElements(By By){
    	return driver.findElements(By).size();
    }
    public static void makeVisible(WebElement webelement)
	{
		try{
		Coordinates coordinate = ((Locatable)webelement).getCoordinates(); 
		coordinate.inViewPort();
		//coordinate.onScreen();
		}
		catch(Exception e)
		{
			if(browserName.equals("chrome")){
				Actions actions = new Actions(driver);
				actions.sendKeys(Keys.DOWN);
				actions.build().perform();}
		}
	}
    public static String getDateFormatFromUserPreferences() throws Exception{
	  String dateFormat=null;
      DbCon dbCon = new DbCon();
  	  ResultSet resultSet = dbCon.getRecords("SELECT dateFormat FROM userpreferences a INNER JOIN users b ON a.userID WHERE a.userID=b.userID AND b.shortname='"+prop.getProperty("UserID")+"'");
  	  
  	while(resultSet.next()){
    	 dateFormat = resultSet.getString(1);
  	}
  	  resultSet.close();
  	  dbCon.dropConnection();
	  return dateFormat;
    }
    
    public static long getDaysDifference(String DateFormat, String StartDate, String EndDate) throws Exception{
        Date startDateInDateFormat = FormatDate.changeFromStringToDate(DateFormat,StartDate);
 	    Date endDateInDateFormat = FormatDate.changeFromStringToDate(DateFormat,EndDate);
        long DiffInTime = endDateInDateFormat.getTime() - startDateInDateFormat.getTime();
        return TimeUnit.DAYS.convert(DiffInTime, TimeUnit.MILLISECONDS);
    }
    
    public static String getDOWValue(String DateFormat, String getDOWValueOfThisDate) throws Exception{
    	String dowValue = FormatDate.changeDateFormat(DateFormat, getDOWValueOfThisDate, "EE");
    	return dowValue;
    }
    
    public static String incrementDate(String DateFormat, String StringDateToIncrement, int IncrementBy) throws Exception{
  	    SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(StringDateToIncrement));
        c.add(Calendar.DATE, IncrementBy);
        StringDateToIncrement = sdf.format(c.getTime());
        return StringDateToIncrement;
      }
    
    public static String convertStringDoubleValueToTwoDecimalPlaces(String StringNumber) throws Exception{
    	double number = Double.parseDouble(StringNumber);
        DecimalFormat df = new DecimalFormat("0.00");
        String numberUptoTwoDecimal = df.format(number);
        return numberUptoTwoDecimal;
      }
}
