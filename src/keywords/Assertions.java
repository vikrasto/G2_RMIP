package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import tests.general.general;
import static org.testng.Assert.*;

public class Assertions extends general{
   public static void assertPresentTextEquals(By By, String expectedText){
	   logger.info("Validating Text Present in element located- "+By+" \nExpected text to be present in this element is- "+expectedText+"");
	    assertTrue(Generals.getText(By).trim().equals(expectedText),
			   " "+expectedText+" is NOT displaying in the screen. "
			   		+ "Actual text present is- "+Generals.getText(By).trim()+" ");
   }
   public static void assertPresentTextNOTEquals(By By, String unExpectedText){
	   logger.info("Validating Text Present in element located- "+By+" \nUnExpected text which should NOT be present in this element is- "+unExpectedText+"");
	    assertTrue(!Generals.getText(By).trim().equals(unExpectedText),
			   " "+unExpectedText+" is displaying in the screen.");
  }
   public static void assertPresentTextNOTEquals(By By, String unExpectedText1,String unExpectedText2){
	   logger.info("Validating Text Present in element located- "+By+" \nUnExpected text which should NOT be present in this element is- "+unExpectedText1+" and "+unExpectedText2+"");
	    assertTrue(!Generals.getText(By).trim().equals(unExpectedText1) && !Generals.getText(By).trim().equals(unExpectedText2),
			   " "+unExpectedText1+" is displaying in the screen.");
  }
   public static void assertPresentTextNOTEquals(By By, String unExpectedText1,String unExpectedText2,String unExpectedText3){
	   logger.info("Validating Text Present in element located- "+By+" \nUnExpected text which should NOT be present in this element is- "+unExpectedText1+" and "+unExpectedText2+" and "+unExpectedText3+"");
	    assertTrue(!Generals.getText(By).trim().equals(unExpectedText1) && !Generals.getText(By).trim().equals(unExpectedText2) &&!Generals.getText(By).trim().equals(unExpectedText3),
			   " "+unExpectedText1+" is displaying in the screen.");
  }
   public static void assertPresentTextNOTEquals(By By, String unExpectedText1,String unExpectedText2,String unExpectedText3, String unExpectedText4){
	   logger.info("Validating Text Present in element located- "+By+" \nUnExpected text which should NOT be present in this element is- "+unExpectedText1+" and "+unExpectedText2+" and "+unExpectedText3+" and "+unExpectedText4+"");
	    assertTrue(!Generals.getText(By).trim().equals(unExpectedText1),
			   " "+unExpectedText1+" is displaying in the screen.");
  }
   public static void assertPresentTextValueEquals(By By, String expectedText){
	   logger.info("Validating Text Present in element located- "+By+" \nExpected text to be present in this element is- "+expectedText+"");
	    assertTrue(Generals.getTextValue(By).trim().equals(expectedText),
			   " "+expectedText+" is NOT displaying in the screen. "
			   		+ "Actual text present is- "+Generals.getTextValue(By).trim()+" ");
   }
   
   public static void assertPresentTextEquals(By By, String ExpectedText1, String ExpectedText2){
	   logger.info("Validating Text Present in element located- "+By+" \nExpected text to be present in this element is- "+ExpectedText1+" or "+ExpectedText2+"");
	    assertTrue(Generals.getText(By).trim().equals(ExpectedText1) || Generals.getText(By).trim().equals(ExpectedText2),
			   " "+ExpectedText1+" or "+ExpectedText2+" is NOT displaying in the screen. "
			   		+ "Actual text present is- "+Generals.getText(By).trim()+" ");
   }
   
   public static void assertPresentTextEquals(By By, String ExpectedText1, String ExpectedText2, String ExpectedText3){
	   logger.info("Validating Text Present in element located- "+By+" \nExpected text to be present in this element is- "+ExpectedText1+" or "+ExpectedText2+"");
	    assertTrue(Generals.getText(By).trim().equals(ExpectedText1) || Generals.getText(By).trim().equals(ExpectedText2) ||Generals.getText(By).trim().equals(ExpectedText3),
			   " "+ExpectedText1+" or "+ExpectedText2+" or "+ExpectedText3+" is NOT displaying in the screen. "
			   		+ "Actual text present is- "+Generals.getText(By).trim()+" ");
   }
   
   public static void assertPresentTextEquals(By By, String ExpectedText1, String ExpectedText2, String ExpectedText3, String ExpectedText4){
	   logger.info("Validating Text Present in element located- "+By+" \nExpected text to be present in this element is- "+ExpectedText1+" or "+ExpectedText2+"");
	    assertTrue(Generals.getText(By).trim().equals(ExpectedText1) || Generals.getText(By).trim().equals(ExpectedText2) ||Generals.getText(By).trim().equals(ExpectedText3)||Generals.getText(By).trim().equals(ExpectedText4),
			   " "+ExpectedText1+" or "+ExpectedText2+" or "+ExpectedText3+" or "+ExpectedText4+" is NOT displaying in the screen. "
			   		+ "Actual text present is- "+Generals.getText(By).trim()+" ");
   }
   
   public static void assertElementIsDisplaying(By By){
	    logger.info("Validating whether element is displaying- "+By+"");
	    assertTrue(Generals.verifyElementIsDisplaying(By),"Element located by "+By+" is NOT displaying in the screen");
	}
   
   public static void verifyElementIsNOTPresent(By By){
	    logger.info("Validating whether element is present in screen or not- "+By+"");
	    
	    try{
	    	Generals.element(By);
	    }catch(NoSuchElementException e){
	        		    	
	    }
	    
  }
   
   public static void verifyElementIsSelected(By By){
	    logger.info("Validating whether element is Selected/ Checked- "+By+"");
	    assertTrue(Generals.verifyElementIsSelected(By),"Element located by "+By+" is NOT Checked/ Selected");
   }
   public static void verifyElementIsNOTSelected(By By){
	    logger.info("Validating whether element is Selected/ Checked- "+By+"");
	    assertTrue(!Generals.verifyElementIsSelected(By),"Element located by "+By+" is Checked/ Selected");
   }
   public static void verifyElementTextEquals(String ActualText, String ExpectedText){
	    logger.info("Validating whether element actual text is equal to expected text or not ");
	    assertTrue(ActualText.equals(ExpectedText), "Element's Actual Text- "+ActualText+" is NOT equal to Expected Text- "+ExpectedText+"");
   }
   public static void verifyStringValuesAreEqual(String Value1, String Value2){
	    logger.info("Validating whether element actual text is equal to expected text or not ");
	    assertTrue(Value1.trim().equals(Value2.trim()), "First String value "+Value1+" is NOT equal to Second String value "+Value2+"");
  }
   public static void verifyIfIntValuesAreEqual(int ActualValue, int ExpectedValue){
	    logger.info("Validating whether actual integer value is equal to expected integer value or not ");
	    assertTrue(ActualValue==ExpectedValue, "Element's Actual value- "+ActualValue+" is NOT equal to Expected value- "+ExpectedValue+"");
  }
   public static void verifyIfLongValuesAreEqual(long ActualValue, long ExpectedValue){
	    logger.info("Validating whether actual integer value is equal to expected integer value or not ");
	    assertTrue(ActualValue==ExpectedValue, "Element's Actual value is NOT equal to Expected value");
 }
}
