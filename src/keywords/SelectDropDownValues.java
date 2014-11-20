package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import data.OpenBrowser;

public class SelectDropDownValues extends OpenBrowser{
	
  public static Select select;	
  public static Select instantiateSelect(By By){
	  select = new Select(Generals.element(By));
	  return select;
  }
  public static String getTextOfSelectedValue(By By){
	  instantiateSelect(By);
      return select.getFirstSelectedOption().getText();  
  }
  public static void selecyByVisibleText(String TextToBeSelected, By By){
	  instantiateSelect(By);
      select.selectByVisibleText(TextToBeSelected); 
  }
}
