package keywords;

import repository.OR_General;
import repository.OR_TopMenu;
import tests.general.general;

public class SelectProperty extends general{
   public static void selectAProperty() throws Exception{
	   
	   logger.info("Seleting property- "+prop.getProperty("PropertyName")+" from the Select A Property dropdown");
	   Generals.click(OR_General.selectAPropertyDropDown());
       Generals.sleepBy(1000);
	   Generals.click(OR_General.selectPropertyFromDropdown(prop.getProperty("PropertyName")));
       Generals.waitByVisiblilityOfElement(driver.findElement(OR_TopMenu.propertyName()));
	}
}
