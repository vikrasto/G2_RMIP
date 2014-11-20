package tests.general;

import keywords.Assertions;
import keywords.SelectProperty;

import org.testng.annotations.Test;

import repository.OR_TopMenu;

public class TEST_SelectProperty extends general{

    @Test
    public void TestSelectPropertyFromDropdown() throws Exception{
       logger.info("\n\nRunning Test- TestSelectPropertyFromDropdown");	
       SelectProperty.selectAProperty();
       Assertions.assertPresentTextEquals(OR_TopMenu.propertyName(), prop.getProperty("PropertyName"));
      }
}
