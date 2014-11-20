package tests.manageControl;

import keywords.Assertions;
import keywords.Generals;
import keywords.SelectProperty;

import org.testng.annotations.Test;

import repository.OR_ManageControls.OR_ChannelManagement;
import tests.general.general;


public class TEST_ChannelManagement extends general{
	
    @Test
	public void TestNavigationToChannelManagement() throws Exception{
    logger.info("\n\nRunning Test- TestNavigationToChannelManagement");	
    SelectProperty.selectAProperty();
    
    Generals.navigateTo(OR_ChannelManagement.manageControlLink());
    Generals.waitByVisiblilityOfElement(driver.findElement(OR_ChannelManagement.channelManagementLink()));
    Generals.navigateTo(OR_ChannelManagement.channelManagementLink());
    Assertions.assertPresentTextEquals(OR_ChannelManagement.channelManagementText(), "Channel Management");
    }
    
    @Test
	public void TestChannelManagementScreen_ColumnNames() throws Exception{
    logger.info("\n\nRunning Test- TestChannelManagementScreen_ColumnNames");	
    SelectProperty.selectAProperty();	
    Generals.navigateTo(OR_ChannelManagement.manageControlLink());
    Generals.waitByVisiblilityOfElement(driver.findElement(OR_ChannelManagement.channelManagementLink()));
    Generals.navigateTo(OR_ChannelManagement.channelManagementLink());
    
    Assertions.assertPresentTextEquals(OR_ChannelManagement.channelManagementColumnNames(2), "Channel");
    Assertions.assertPresentTextEquals(OR_ChannelManagement.channelManagementColumnNames(3), "Channel Cost");
    Assertions.assertPresentTextEquals(OR_ChannelManagement.channelManagementColumnNames(4), "Active");
    Assertions.assertPresentTextEquals(OR_ChannelManagement.channelManagementColumnNames(5), "Room Types and Rates");
    
    Generals.sleepBy(1000);
	}
}
