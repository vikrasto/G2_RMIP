package repository.OR_ManageControls;

import org.openqa.selenium.By;

public class OR_ChannelManagement {
	public static By manageControlLink(){
		return By.linkText("Manage Controls");
	}
	
	public static By channelManagementLink(){
		return By.linkText("Channel Management");
    }
	
	public static By channelManagementText(){
		return By.xpath(".//form[@name='Channels']/div[2]/h2");
    }
	public static By channelManagementColumnNames(int Index){
		return By.xpath(".//*[@id='table_ChannelsList']/thead/tr/th["+Index+"]");
    }
}
