package tests.manageControl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

import keywords.Assertions;
import keywords.CompareArrays;
import keywords.FormatDate;
import keywords.Generals;
import keywords.QueryToFetchDbData;
import keywords.SelectDropDownValues;
import keywords.SelectProperty;
import keywords.SetCalender;
import keywords.SwitchControlTo;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DbCon;
import repository.OR_ManageControls.OR_BestAvailableRate;
import repository.OR_ManageControls.OR_ChannelManagement;
import tests.general.general;

public class TEST_BestAvailableRate extends general{
	public static String guiSystemToday=null;
    public String BAR_Output_Type = null;
	@BeforeMethod
	public void navigateToRMScreenAndSwitchToIFrame() throws Exception{
		Generals.sleepBy(2000);
		SelectProperty.selectAProperty();
	    Generals.navigateTo(OR_ChannelManagement.manageControlLink());
	    Generals.sleepBy(2000);
	    Generals.click(OR_BestAvailableRate.reputationManagementModule());
	    Generals.sleepBy(4000);
	    SwitchControlTo.switchToInnerFrame();
	    
        DbCon dbCon = new DbCon();
        ResultSet rs = dbCon.getRecords("SELECT value FROM propertysystemparameters WHERE propertyID=(select propertyID from property where shortname='"+prop.getProperty("PropertyName")+"') AND propertyparamvariable='BAR_OUTPUT_TYPE';");
        while(rs.next())
        {
     	  BAR_Output_Type = rs.getString(1);
     	  logger.info("\n BAR Output Type of the property is- "+BAR_Output_Type+"");
        }
        rs.close();
        dbCon.dropConnection();
        
	}
	
	@AfterMethod
	public void switchToDefaultContent() throws Exception{
		Generals.sleepBy(1000);
		SwitchControlTo.switchToDefaultContent();
	}
	
    @Test
	public void TestNavigationToReputationManagementScreen() throws Exception{
    logger.info("\n\nRunning Test- TestNavigationToReputationManagementScreen");	

    Assertions.assertElementIsDisplaying(OR_BestAvailableRate.reputationBARText());
    Assertions.assertElementIsDisplaying(OR_BestAvailableRate.reputationQuadrantText());
    Assertions.assertElementIsDisplaying(OR_BestAvailableRate.reputationAnalysisText());
   
    }
    
    @Test
    public void TestReputationManagementFilterSection() throws Exception{
	    logger.info("\n\nRunning Test- TestReputationManagementFilterSection");	

	    System.out.println("khfdskjhfkj"+Generals.getText(OR_BestAvailableRate.startdateTextBox()));
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionFilterByText(), "Filter By");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDateText(1), "Start Date:");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDateText(2), "End Date:");
	    
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionCompetitorsText(), "Competitors:");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionCompetitorsList(1), "All");
	    
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDOWTable(1, 1), "DOW:");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDOWTable(1, 2), "Sun");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDOWTable(1, 3), "Thu");
	    
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDOWTable(2, 2), "Mon");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDOWTable(2, 3), "Fri");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDOWTable(3, 2), "Tue");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDOWTable(3, 3), "Sat");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDOWTable(4, 2), "Wed");
	    
	    Assertions.assertElementIsDisplaying(OR_BestAvailableRate.filterSectionShowDatesWhereRBexceedsText());
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDisplayOptionWithBarNameBarValue(1), "Display Option:");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDisplayOptionWithBarNameBarValue(2), "BAR Name");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionDisplayOptionWithBarNameBarValue(3), "BAR Value");
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(1));
	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));

	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(1));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(2));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(3));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(4));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(5));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(6));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(7));
	    Assertions.verifyElementTextEquals(SelectDropDownValues.getTextOfSelectedValue(OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDown()), "--Select--");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDownOptions(2), "System BAR");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDownOptions(3), "Web BAR");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDownOptions(4), "User BAR");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDownOptions(5), "All");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionApplyButton(), "Apply");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionClearButton(), "Clear");
	}
    @Test
    public void TestReputationManagementTableDataColumnSection() throws Exception{
        logger.info("\n\nRunning Test- TestReputationManagementTableDataColumnSection");	
        
        if(BAR_Output_Type.equals("BAR_BY_DAY") || BAR_Output_Type.equals("BAR_FOR_ALL_LOS"))
        {
        	logger.info("\n LOS column should NOT be displayed as BAR Output Type is "+BAR_Output_Type+"");
        	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(1), "DOW");
		    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(2), "Date");
		    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(3), "Special Event");
		    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(4), "LRV");
		    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(5), "Occupancy Forecast");
		    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(6), "Occupancy Forecast %");
		    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(7), "Rooms Sold");
		    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(8), "Rooms Sold LYTD");
		    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(9), "BAR Decision");
        }
        
        else{
        	logger.info("\n LOS column should be displayed as BAR Output Type is "+BAR_Output_Type+"");
        	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(1), "DOW");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(2), "Date");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(3), "LOS");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(4), "Special Event");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(5), "LRV");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(6), "Occupancy Forecast");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(7), "Occupancy Forecast %");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(8), "Rooms Sold");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(9), "Rooms Sold LYTD");
    	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(10), "BAR Decision");
        }
        
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionBottomColumnNames(1), "System");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionBottomColumnNames(2), "Web");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionBottomColumnNames(3), "Reputation");
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionBottomColumnNames(4), "User");
	    
    }

    @Test
    public void TestClearButtonUncheckDOWCheckbox() throws Exception{
    	logger.info("\n\nRunning Test- TestClearButtonUncheckDOWCheckbox");	
    	
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(1));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(2));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(3));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(4));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(5));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(6));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(7));
    	
    	Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(1));
 	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(2));
 	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(3));
 	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(4));
 	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(5));
 	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(6));
 	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(7));
    	
    	Generals.click(OR_BestAvailableRate.filterSectionClearButton());
    	
    	Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(1));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(2));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(3));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(4));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(5));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(6));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDOWCheckboxes(7));
	    
	 }
    
    @Test
    public void TestClearButtonCheckBarValueCheckbox(){
    	logger.info("\n\nRunning Test- TestClearButtonCheckBarValueCheckbox");	
    	
    	Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(1));
	    
	    Generals.click(OR_BestAvailableRate.filterSectionClearButton());
	    Assertions.verifyElementIsSelected(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(1));
	    Assertions.verifyElementIsNOTSelected(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
    }
    
    @Test
    public void TestClearButtonSelectValueFromShowDatesWhereReputationBARExceeds(){
    	logger.info("\n\nRunning Test- TestClearButtonSelectValueFromShowDatesWhereReputationBARExceeds");	
    	SelectDropDownValues.selecyByVisibleText("System BAR", OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDown());
    	Assertions.verifyElementTextEquals(SelectDropDownValues.getTextOfSelectedValue(OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDown()), "System BAR");
	    Generals.click(OR_BestAvailableRate.filterSectionClearButton());
	    Assertions.verifyElementTextEquals(SelectDropDownValues.getTextOfSelectedValue(OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDown()), "--Select--");
    }
    @Test
    public void TestClearButtonSelectCompetitors() throws Exception{
    	logger.info("\n\nRunning Test- TestClearButtonSelectCompetitors");	
    	Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionCompetitorsList(1), "All");
    	Generals.click(OR_BestAvailableRate.filterSectionCompetitorsBox());
    	Generals.click(OR_BestAvailableRate.competitorName(prop.getProperty("RM_CompetitorName1")));
    	Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionCompetitorsList(2), prop.getProperty("RM_CompetitorName1"));
        Generals.click(OR_BestAvailableRate.filterSectionClearButton());
    	Assertions.assertPresentTextNOTEquals(OR_BestAvailableRate.filterSectionCompetitorsList(2), prop.getProperty("RM_CompetitorName1"));
    	Assertions.assertPresentTextEquals(OR_BestAvailableRate.filterSectionCompetitorsList(1), "All");
  }
    
    @Test
    public void TestClearButtonSelectStartAndEndDate() throws Exception{
    	logger.info("\n\nRunning Test- TestClearButtonSelectStartAndEndDate");	
        String DefaultStartDate	= Generals.getTextValue(OR_BestAvailableRate.startdateTextBox());
        String DefaultEndDate = Generals.getTextValue(OR_BestAvailableRate.enddateTextBox());
        Generals.sleepBy(1000);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
	    Generals.sleepBy(1000);
	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
	    Generals.click(OR_BestAvailableRate.filterSectionClearButton());
	    Assertions.assertPresentTextValueEquals(OR_BestAvailableRate.startdateTextBox(), DefaultStartDate);
    	Assertions.assertPresentTextValueEquals(OR_BestAvailableRate.enddateTextBox(), DefaultEndDate);
  }
    @Test
    public void TestReputationManagementCompetitorsList() throws Exception{
    	logger.info("\n\nRunning Test- TestReputationManagementCompetitorsList");	
    	Generals.click(OR_BestAvailableRate.filterSectionCompetitorsBox());
     	Generals.sleepBy(1000);
     	int totalNumbersOfCompetitorsInRMscreen = Generals.getSizeOfElements(OR_BestAvailableRate.competitorsDropDownOpenedAfterClickListElements()) - 1;
     	String AllCompetitorNameInRMscreen = "";
     	for(int i=1;i<=totalNumbersOfCompetitorsInRMscreen;i++)
     	{
     	    AllCompetitorNameInRMscreen = AllCompetitorNameInRMscreen.concat(Generals.getText(OR_BestAvailableRate.competitorsDropDownValuesOpenedAfterClick(i+1))+",");
     	}
        String[] CompetitorNameInRMscreen =	AllCompetitorNameInRMscreen.split(",");	
        Arrays.sort(CompetitorNameInRMscreen);
        
    	SwitchControlTo.switchToDefaultContent();
     	Generals.click(OR_BestAvailableRate.competitorsLink());
     	SwitchControlTo.switchToInnerFrame();
    	Generals.waitByVisiblilityOfElement(Generals.element(OR_BestAvailableRate.competitorsReputationCompetitorHotelNameColumn()));
    	
        int TotalDataRowsInCompetitorsTab =	Generals.getSizeOfElements(OR_BestAvailableRate.competitorsHotelName());
     	
     	int TotalHotelNamesSelected=0;
     	String HotelNameInCompetitorsScreen = "";
     	
     	for(int i=1;i<=TotalDataRowsInCompetitorsTab;i++)
     	{
     		if(!SelectDropDownValues.getTextOfSelectedValue(OR_BestAvailableRate.competitorsReputationCompetitorHotelNameColumnIndividualValues(i)).equals("- Select -")){	
            HotelNameInCompetitorsScreen = HotelNameInCompetitorsScreen.concat(Generals.getTextValue(OR_BestAvailableRate.competitorsHotelNameIndividualValues(i))+",");
            TotalHotelNamesSelected++;
     		}
        }
     	Assertions.verifyIfIntValuesAreEqual(TotalHotelNamesSelected, totalNumbersOfCompetitorsInRMscreen);
        String[] CompetitorNameInCompetitorsTab =	HotelNameInCompetitorsScreen.split(",");
        Arrays.sort(CompetitorNameInCompetitorsTab);
        
        CompareArrays.compareStringArrays(CompetitorNameInCompetitorsTab, CompetitorNameInRMscreen);
 	 }
    
    @Test
     public void TestColumnNameAfterSelectingAllInCompetitorsTextBox() throws Exception{
    	logger.info("\n\nRunning Test- TestColumnNameAfterSelectingAllInCompetitorsTextBox");	
      	Generals.click(OR_BestAvailableRate.filterSectionCompetitorsBox());
       	Generals.sleepBy(1000);
       	int totalNumbersOfCompetitorsInRMscreen = Generals.getSizeOfElements(OR_BestAvailableRate.competitorsDropDownOpenedAfterClickListElements()) - 1;
       	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());
       try{
       	for(int i=1;i<=totalNumbersOfCompetitorsInRMscreen;i++)
       	{
       		  Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableSectionColumnNames(9+i)));
              Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNames(9+i), Generals.getText(OR_BestAvailableRate.competitorsDropDownValuesOpenedAfterClick(i+1)));
        }
       }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
               }
    }
    
    @Test
    public void TestColumnNameAfterSelectingAComeptitorInCompetitorsTextBox() throws Exception{
    	logger.info("\n\nRunning Test- TestColumnNameAfterSelectingAComeptitorInCompetitorsTextBox");	
    	Generals.click(OR_BestAvailableRate.competitorsCloseAllLink());
    	Generals.click(OR_BestAvailableRate.filterSectionCompetitorsBox());
      	Generals.sleepBy(1000);
      	Generals.click(OR_BestAvailableRate.competitorName(prop.getProperty("RM_CompetitorName1")));
      	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());
      try{	
      	Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableSectionColumnNameAfterBarDecision(1)));
	    Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNameAfterBarDecision(1), prop.getProperty("RM_CompetitorName1"));

	    int totalNumbersOfCompetitorsInRMscreen = Generals.getSizeOfElements(OR_BestAvailableRate.competitorsDropDownOpenedAfterClickListElements()) - 1;
     	String OtherCompetitorNameInRMscreen = null;
     	for(int i=1;i<=totalNumbersOfCompetitorsInRMscreen;i++)
     	{
     	    if(!Generals.getText(OR_BestAvailableRate.competitorsDropDownValuesOpenedAfterClick(i+1)).equals(prop.getProperty("RM_CompetitorName1"))){
     		OtherCompetitorNameInRMscreen = Generals.getText(OR_BestAvailableRate.competitorsDropDownValuesOpenedAfterClick(i+1));
     	    }
     	}
        Assertions.verifyElementIsNOTPresent(By.xpath(".//div[text()='"+OtherCompetitorNameInRMscreen+"']")); 
	 
     }catch(NoSuchElementException e){
		logger.info("\nNo data is present after setting this criteria");
		Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
         }
    }
    
    @Test
    public void TestColumnNameAfterSelectingTwoComeptitorsInCompetitorsTextBox() throws Exception{
    	logger.info("\n\nRunning Test- TestColumnNameAfterSelectingTwoComeptitorsInCompetitorsTextBox");
    	Generals.click(OR_BestAvailableRate.competitorsCloseAllLink());
    	Generals.click(OR_BestAvailableRate.filterSectionCompetitorsBox());
      	Generals.sleepBy(1000);
      	Generals.click(OR_BestAvailableRate.competitorName(prop.getProperty("RM_CompetitorName1")));
      	
       	Generals.click(OR_BestAvailableRate.filterSectionCompetitorsBox());
      	Generals.sleepBy(1000);
      	Generals.click(OR_BestAvailableRate.competitorName(prop.getProperty("RM_CompetitorName2")));

      	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());
     try{
      	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNameAfterBarDecision(1), prop.getProperty("RM_CompetitorName1"), prop.getProperty("RM_CompetitorName2"));
      	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableSectionColumnNameAfterBarDecision(2), prop.getProperty("RM_CompetitorName1"), prop.getProperty("RM_CompetitorName2"));

      	Assertions.assertElementIsDisplaying(By.xpath(".//div[text()='"+prop.getProperty("RM_CompetitorName1")+"']"));
      	Assertions.assertElementIsDisplaying(By.xpath(".//div[text()='"+prop.getProperty("RM_CompetitorName2")+"']"));
      	
		int totalNumbersOfCompetitorsInRMscreen = Generals.getSizeOfElements(OR_BestAvailableRate.competitorsDropDownOpenedAfterClickListElements()) - 1;
     	String OtherCompetitorNameInRMscreen = null;
     	for(int i=1;i<=totalNumbersOfCompetitorsInRMscreen;i++)
     	{
     	    if(!Generals.getText(OR_BestAvailableRate.competitorsDropDownValuesOpenedAfterClick(i+1)).equals(prop.getProperty("RM_CompetitorName1")) &&
     	       !Generals.getText(OR_BestAvailableRate.competitorsDropDownValuesOpenedAfterClick(i+1)).equals(prop.getProperty("RM_CompetitorName2")))
     	     {
     		   OtherCompetitorNameInRMscreen = Generals.getText(OR_BestAvailableRate.competitorsDropDownValuesOpenedAfterClick(i+1));
     	     }
     	    
     	}
        Assertions.verifyElementIsNOTPresent(By.xpath(".//div[text()='"+OtherCompetitorNameInRMscreen+"']"));
     }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
             }
	 }
    
    @Test
    public void TestReputationManagementDescriptionText() throws Exception{
    	logger.info("\n\nRunning Test- TestReputationManagementDescriptionText");
        Assertions.assertPresentTextEquals(OR_BestAvailableRate.reputationManagementDescriptionText(), 	"This table shows the Reputation BAR and the supporting information in order to validate your BAR decisions and evaluate opportunities to drive rate based on competitor rates and reviews.");
    }
// Need to check the requirement now.    
    @Test
    public void TestExpandAndCollapseAllFuntionalists() throws Exception{
       logger.info("\n\nRunning Test- TestExpandAndCollapseAllFuntionalists");

   	   if(BAR_Output_Type.equals("BAR_BOTH") || BAR_Output_Type.equals("BAR_BY_LOS")){
   		logger.info("\n Expand All link should be displayed as BAR Output Type is "+BAR_Output_Type+"");
   		Assertions.assertPresentTextEquals(OR_BestAvailableRate.expandAllButton(), "Expand All");
    	Generals.sleepBy(1000);
        Generals.click(OR_BestAvailableRate.expandAllButton());
        Assertions.assertPresentTextEquals(OR_BestAvailableRate.expandAllButton(), "Collapse All");
        Generals.click(OR_BestAvailableRate.expandAllButton());
        Assertions.assertPresentTextEquals(OR_BestAvailableRate.expandAllButton(), "Expand All");   
   	   }
   	   else if(BAR_Output_Type.equals("BAR_BY_DAY") || BAR_Output_Type.equals("BAR_FOR_ALL_LOS")){
   		logger.info("\n Expand All link should NOT be displayed as BAR Output Type is "+BAR_Output_Type+"");
   		Assertions.verifyElementIsNOTPresent(OR_BestAvailableRate.expandAllButton());   
   	   }
    }
    
    public static void setStartAndEndDateAndClickOnApply() throws Exception{
    	logger.info("\n\n SetStartAndEndDate in Reputation BAR screen and ClickOnApply");	
    	Generals.sleepBy(1000);
        guiSystemToday=Generals.getTextValue(OR_BestAvailableRate.filterSectionStartDate());
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
 	    Generals.sleepBy(1000);
 	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
    	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
	    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
    }
    @Test
    public void TestRoomSoldData() throws Exception{
    	logger.info("\n\nRunning Test- TestRoomSoldData");	
    	setStartAndEndDateAndClickOnApply();
    	
	    String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd");
        DbCon dbCon = new DbCon();
	    ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getRoomsSold(prop.getProperty("PropertyName"), StartDate, EndDate));
    try{    
 	    if(BAR_Output_Type.equals("BAR_BY_DAY")){
 	    	while(resultSet.next()){
 	    		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataRoomsSold(resultSet.getRow())));
 	        	String roomSold = resultSet.getString(1);
 	        	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataRoomsSold(resultSet.getRow()), roomSold);
 	        }
        }
 	    else if(BAR_Output_Type.equals("BAR_BOTH")){
 	    	int count=1;
	    	while(resultSet.next()){
	    		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataDateValue(count)));
	    		String roomSold = resultSet.getString(1);
	    		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataRoomsSold(count), roomSold);
	    		Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<=7;i++){
            		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataOccupanyForecast(count+i), roomSold);
            	}
	    		count=count+8;
 	        }
 	    }
    }
    catch(NoSuchElementException e){
		logger.info("\nNo data is present after setting this criteria");
		Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
            }
    resultSet.close();
	dbCon.dropConnection();  
  }
    
    @Test
    public void TestDateAndDOWData() throws Exception{
    	logger.info("\n\nRunning Test- TestDateAndDOWData");
	    setStartAndEndDateAndClickOnApply();
	 try{   
	    String StartDate = Generals.getTextValue(OR_BestAvailableRate.startdateTextBox());
 	    String EndDate = Generals.getTextValue(OR_BestAvailableRate.enddateTextBox());
 	    
 	    if(BAR_Output_Type.equals("BAR_BY_DAY")){
 	    	long NumberOfRows = Generals.getDaysDifference(Generals.getDateFormatFromUserPreferences(), StartDate, EndDate);
 	        for(int i=1;i<=NumberOfRows;i++){
 	    	Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataDateValue(i)));
 	        String dateValue = Generals.incrementDate(Generals.getDateFormatFromUserPreferences(), StartDate, i-1);
 	        String dowValue = Generals.getDOWValue(Generals.getDateFormatFromUserPreferences(), dateValue);
 	    	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataDateValue(i), dateValue);
 	    	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataDOWValue(i), dowValue);
 	    	}
 	    }
 	    else if(BAR_Output_Type.equals("BAR_BOTH")){
 	    	long NumberOfRows = (Generals.getDaysDifference(Generals.getDateFormatFromUserPreferences(), StartDate, EndDate))*8;
 	        int count = 0;
  	        for(int i=1;i<=NumberOfRows;i=i+8){
  	    	Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataDateValue(i)));
  	        String dateValue = Generals.incrementDate(Generals.getDateFormatFromUserPreferences(), StartDate, count++);
  	        String dowValue = Generals.getDOWValue(Generals.getDateFormatFromUserPreferences(), dateValue);
  	    	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataEntireTable(i,"treegrid_date"), dateValue);
  	    	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataEntireTable(i,"treegrid_dayOfWeek"), dowValue);
  	    	}
 	    }
	 }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
   }
    @Test
    public void TestOccupancyForecastData() throws Exception{
    	logger.info("\n\nRunning Test- TestOccupancyForecastData");
    	setStartAndEndDateAndClickOnApply();
	    String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getOccupancyForecast(prop.getProperty("PropertyName"), StartDate, EndDate));
     try{	
 	    if(BAR_Output_Type.equals("BAR_BY_DAY")){
 	    	while(resultSet.next()){
 	    		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataOccupanyForecast(resultSet.getRow())));
 	        	String occupancyForecast = resultSet.getString(1);
 	        	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataOccupanyForecast(resultSet.getRow()), occupancyForecast);
 	        }
        }
 	    else if(BAR_Output_Type.equals("BAR_BOTH")){
 	    	int count=1;
 	    	
    		while(resultSet.next()){
    			Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataOccupanyForecast(count)));
	        	String occupancyForecast = resultSet.getString(1);
	        	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataOccupanyForecast(count), occupancyForecast);
            	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<=7;i++){
            		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataOccupanyForecast(count+i), occupancyForecast);
            	}
            count=count+8;
	        }
 	    }
    }catch(NoSuchElementException e){
		logger.info("\nNo data is present after setting this criteria");
		Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
         }
     resultSet.close();
     dbCon.dropConnection(); 
    }
    
    @Test
    public void TestLOSData() throws Exception{
    	logger.info("\n\nRunning Test- TestLOSData");
    	setStartAndEndDateAndClickOnApply();
	 	String StartDate = Generals.getTextValue(OR_BestAvailableRate.startdateTextBox());
 	    String EndDate = Generals.getTextValue(OR_BestAvailableRate.enddateTextBox());
   	    String[] los = {"1","2","3","4","5","6","7","8"};
     	
 	    long rowsCount = Generals.getDaysDifference(Generals.getDateFormatFromUserPreferences(), StartDate, EndDate);
 	   try{  
		for(int i=0;i<rowsCount;i++){
 		    Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
 		    if(BAR_Output_Type.equals("BAR_BOTH")){
        		for(int j=1;j<=los.length;j++){ 
        			Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataLOSvalue(i*los.length+j)));
        			Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataLOSvalue(i*los.length+j), los[j-1]);
	         	     }
	       	      }
           else{
         	  logger.info("BAR Output Type is- "+BAR_Output_Type+". LOS Column didn't display for the selected property");
               }
			}
    }catch(NoSuchElementException e){
		logger.info("\nNo data is present after setting this criteria");
		Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
         }
    }
    
    @Test
    public void TestOccupancyForecastPercentageData() throws Exception{
    	logger.info("\n\nRunning Test- TestOccupancyForecastPercentageData");
    	setStartAndEndDateAndClickOnApply();
	    String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getOccupancyForecastPercentage(prop.getProperty("PropertyName"), StartDate, EndDate));
      try{ 	
    	if(BAR_Output_Type.equals("BAR_BY_DAY")){
 	    	while(resultSet.next()){
 	    		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataOccupanyForecastPercentage(resultSet.getRow())));
 	        	String occupancyForecastPercentage = resultSet.getString(4);
 	            String occupancyForecastPercentageUptoTwoDecimal =  Generals.convertStringDoubleValueToTwoDecimalPlaces(occupancyForecastPercentage);
 	            Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataOccupanyForecastPercentage(resultSet.getRow()), occupancyForecastPercentageUptoTwoDecimal+"%");
 	        }
        }
 	    else if(BAR_Output_Type.equals("BAR_BOTH")){
 	    	int count=1;
 	    	while(resultSet.next()){
 				Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataOccupanyForecastPercentage(count)));
	        	String occupancyForecastPercentage = resultSet.getString(4);
	            String occupancyForecastPercentageUptoTwoDecimal =  Generals.convertStringDoubleValueToTwoDecimalPlaces(occupancyForecastPercentage);
	            Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataOccupanyForecastPercentage(count), occupancyForecastPercentageUptoTwoDecimal+"%");
            	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<=7;i++){
            		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataOccupanyForecast(count+i), occupancyForecastPercentageUptoTwoDecimal+"%");
            	}
            count=count+8;
	        }
        }
	  }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
  	 resultSet.close();
     dbCon.dropConnection();  
    }
    
    @Test
    public void TestLRVData() throws Exception{
    	logger.info("\n\nRunning Test- TestLRVData");
    	setStartAndEndDateAndClickOnApply();
        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
    	
    	try{    	
        	if(BAR_Output_Type.equals("BAR_BY_DAY")){
        		while(resultSet.next()){
            		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataLRVValue(resultSet.getRow())));
                	String lrvValue = resultSet.getString("LRV_1");
                	String lrvValueUptoTwoDecimals =  Generals.convertStringDoubleValueToTwoDecimalPlaces(lrvValue);
                	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataLRVValue(resultSet.getRow()), lrvValueUptoTwoDecimals);
                }
            	}
            else if(BAR_Output_Type.equals("BAR_BOTH")){
            	int count=1;
            	while(resultSet.next()){
            		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataLRVValue(count)));
            		String[] lrvValueUptoTwoDecimals= {Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("LRV_1")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("LRV_2")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("LRV_3")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("LRV_4")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("LRV_5")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("LRV_6")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("LRV_7")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("LRV_8"))};
                	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
                	for(int i=0;i<lrvValueUptoTwoDecimals.length;i++){
                		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataLRVValue(count+i), lrvValueUptoTwoDecimals[i]);
                	}count=count+8;
                 }
                }
    	  }catch(NoSuchElementException e){
    			logger.info("\nNo data is present after setting this criteria");
    			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
    	         }

    resultSet.close();
    dbCon.dropConnection(); 
  }
    
   @Test
    public void TestSystemBARDataWhenBARNameIsSelected() throws Exception{
    	logger.info("\n\nRunning Test- TestSystemBARDecisionDataWhenBARNameIsSelected");
    	setStartAndEndDateAndClickOnApply();

        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
 try{   	
    if(BAR_Output_Type.equals("BAR_BY_DAY")){
    	while(resultSet.next()){
    		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataSystemBARValue(resultSet.getRow())));
        	String systemBARName = resultSet.getString("systemBarDecision_1");
        	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSystemBARValue(resultSet.getRow()), systemBARName);
          }
    	}
    else if(BAR_Output_Type.equals("BAR_BOTH")){
    	int count=1;
    	while(resultSet.next()){
    		    Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataSystemBARValue(count)));
	        	String[] systemBARnames= {resultSet.getString("systemBarDecision_1"),resultSet.getString("systemBarDecision_2"),resultSet.getString("systemBarDecision_3"),resultSet.getString("systemBarDecision_4"),resultSet.getString("systemBarDecision_5"),resultSet.getString("systemBarDecision_6"),resultSet.getString("systemBarDecision_7"),resultSet.getString("systemBarDecision_8")};
	        	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<systemBARnames.length;i++){
            		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSystemBARValue(count+i), systemBARnames[i]);
            	}
             count=count+8;
	        }
      }
	 }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
  resultSet.close();
  dbCon.dropConnection();
    }

    @Test
    public void TestWebBARDataWhenBARNameIsSelected() throws Exception{
    	logger.info("\n\nRunning Test- TestWebBARDecisionDataWhenBARNameIsSelected");
    	setStartAndEndDateAndClickOnApply();
	
        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
   try{   	
    	int count=1;
		if(BAR_Output_Type.equals("BAR_BY_DAY")){
        	Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataWebBARValue(resultSet.getRow())));
        	String webBARName = resultSet.getString("webBarDecision_1");
            if(webBARName.equals("-19")){
           	 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataWebBARValue(resultSet.getRow()), "---6---"); 
            }
            else{
           	 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataWebBARValue(resultSet.getRow()), webBARName);
            }
        }
		else if(BAR_Output_Type.equals("BAR_BOTH")){
            while(resultSet.next()){
        		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataWebBARValue(count)));
            	String[] webBARNames= {resultSet.getString("webBarDecision_1"),resultSet.getString("webBarDecision_2"),resultSet.getString("webBarDecision_3"),resultSet.getString("webBarDecision_4"),resultSet.getString("webBarDecision_5"),resultSet.getString("webBarDecision_6"),resultSet.getString("webBarDecision_7"),resultSet.getString("webBarDecision_8")};
            	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<webBARNames.length;i++){
                       if(webBARNames[i].equals("-19")){
                      	 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataWebBARValue(count+i), "---6---"); 
                       }
                       else{
                    	   Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataWebBARValue(count+i), webBARNames[i]);
                       }
            	}count=count+8;
            }
        }
	  }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
   resultSet.close();
   dbCon.dropConnection();  
	 }
    @Test
    public void TestUserBARDataWhenBARNameIsSelected() throws Exception{
    	logger.info("\n\nRunning Test- TestUserBARDecisionDataWhenBARNameIsSelected");
    	setStartAndEndDateAndClickOnApply();
        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
  	try{    	
        if(BAR_Output_Type.equals("BAR_BY_DAY")){
        	while(resultSet.next()){
        		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataUserBARValue(resultSet.getRow())));
            	String userBARName = resultSet.getString("finalBar_1");
            	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataUserBARValue(resultSet.getRow()), userBARName);
            }
        	}
        else if(BAR_Output_Type.equals("BAR_BOTH")){
        	int count=1;
        	while(resultSet.next()){
        		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataUserBARValue(count)));
        		String[] userBARnames= {resultSet.getString("finalBar_1"),resultSet.getString("finalBar_2"),resultSet.getString("finalBar_3"),resultSet.getString("finalBar_4"),resultSet.getString("finalBar_5"),resultSet.getString("finalBar_6"),resultSet.getString("finalBar_7"),resultSet.getString("finalBar_8")};
            	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<userBARnames.length;i++){
            		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataUserBARValue(count+i), userBARnames[i]);
            	}count=count+8;
             }
            }
	  }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
    resultSet.close();
    dbCon.dropConnection(); 
    }
    @Test
    public void TestUserBARDataWhenBARValueIsSelected() throws Exception{
    	logger.info("\n\nRunning Test- TestUserBARDecisionDataWhenBARValueIsSelected");
    	Generals.sleepBy(1000);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
 	    Generals.sleepBy(1000);
 	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
 	    Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
    	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
	    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));

        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
  	 try{    	
        if(BAR_Output_Type.equals("BAR_BY_DAY")){
        	while(resultSet.next()){
        		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataUserBARValue(resultSet.getRow())));
            	String userBARValue = resultSet.getString("finalbarvalue_1");
            	String userBARValueUptoTwoDecimals =  Generals.convertStringDoubleValueToTwoDecimalPlaces(userBARValue);
            	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataUserBARValue(resultSet.getRow()), userBARValueUptoTwoDecimals);
            }
        	}
        else if(BAR_Output_Type.equals("BAR_BOTH")){
        	int count=1;
        	while(resultSet.next()){
        		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataUserBARValue(count)));
        		String[] userBARvaluesUptoTwoDecimals= {Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("finalbarvalue_1")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("finalbarvalue_2")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("finalbarvalue_3")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("finalbarvalue_4")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("finalbarvalue_5")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("finalbarvalue_6")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("finalbarvalue_7")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("finalbarvalue_8"))};
            	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<userBARvaluesUptoTwoDecimals.length;i++){
            		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataUserBARValue(count+i), userBARvaluesUptoTwoDecimals[i]);
            	}count=count+8;
             }
            }
	  }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
     resultSet.close();
     dbCon.dropConnection();  
	 }
    
    @Test
    public void TestSystemBARDataWhenBARValueIsSelected() throws Exception{
    	logger.info("\n\nRunning Test- TestSystemBARDecisionDataWhenBARValueIsSelected");
    	Generals.sleepBy(1000);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
 	    Generals.sleepBy(1000);
 	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
 	    Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
    	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
	    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
	
        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
   try{    	
    	if(BAR_Output_Type.equals("BAR_BY_DAY")){
    		while(resultSet.next()){
        		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataSystemBARValue(resultSet.getRow())));
            	String systemBARValue = resultSet.getString("systembarvalue_1");
            	String systemBARValueUptoTwoDecimals =  Generals.convertStringDoubleValueToTwoDecimalPlaces(systemBARValue);
            	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSystemBARValue(resultSet.getRow()), systemBARValueUptoTwoDecimals);
            }
        	}
        else if(BAR_Output_Type.equals("BAR_BOTH")){
        	int count=1;
        	while(resultSet.next()){
        		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataSystemBARValue(count)));
        		String[] systemBARvaluesUptoTwoDecimals= {Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("systembarvalue_1")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("systembarvalue_2")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("systembarvalue_3")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("systembarvalue_4")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("systembarvalue_5")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("systembarvalue_6")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("systembarvalue_7")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("systembarvalue_8"))};
            	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<systemBARvaluesUptoTwoDecimals.length;i++){
            		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSystemBARValue(count+i), systemBARvaluesUptoTwoDecimals[i]);
            	}count=count+8;
             }
            }
	  }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
   resultSet.close();
   dbCon.dropConnection();  
    }
    
    @Test
    public void TestWebBARDataWhenBARValueIsSelected() throws Exception{
    	logger.info("\n\nRunning Test- TestWebBARDecisionDataWhenBARValueIsSelected");
    	Generals.sleepBy(1000);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
 	    Generals.sleepBy(1000);
 	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
 	    Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
    	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
	    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));

        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
    
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
   try{      	
       if(BAR_Output_Type.equals("BAR_BY_DAY")){
    	   while(resultSet.next()){
       		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataWebBARValue(resultSet.getRow())));
           	      try{
                	 String webBARValue = resultSet.getString("webbarvalue_1");
       	             String webBARValueUptoTwoDecimals =  Generals.convertStringDoubleValueToTwoDecimalPlaces(webBARValue);
         	         Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataWebBARValue(resultSet.getRow()), webBARValueUptoTwoDecimals);
                  }catch(NullPointerException e){
	       	         logger.info("\nWeb BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"'. --6-- is displaying in GUI for this arrival date.");
	       	         Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataWebBARValue(resultSet.getRow()), "---6---");
            }
    	   }
    	  }
       
       else if(BAR_Output_Type.equals("BAR_BOTH")){
          	int count=1;
          	while(resultSet.next()){
           		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataWebBARValue(count)));
          		Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage()); 
          		try{
                   	String[] webBARvaluesUptoTwoDecimals= {Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("webbarvalue_1")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("webbarvalue_2")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("webbarvalue_3")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("webbarvalue_4")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("webbarvalue_5")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("webbarvalue_6")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("webbarvalue_7")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("webbarvalue_8"))};
                  	for(int i=0;i<webBARvaluesUptoTwoDecimals.length;i++){
                   	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataWebBARValue(count+i), webBARvaluesUptoTwoDecimals[i]);
                  	}
          		}catch(NullPointerException e){
          		  for(int i=0;i<8;i++){
	       	          logger.info("\nWeb BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"'. --6-- is displaying in GUI for this arrival date.");
	       	          Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataWebBARValue(count+i), "---6---");
        	     }
              }count=count+8;
            }
         }
	  }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
     resultSet.close();
     dbCon.dropConnection();  
  }
    
    @Test
    public void TestReputationBARDataWhenBARValueIsSelected() throws Exception{
    	logger.info("\n\nRunning Test- TestWebBARDecisionDataWhenBARValueIsSelected");
    	Generals.sleepBy(1000);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
 	    Generals.sleepBy(1000);
 	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
 	    Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
    	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
	    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
  
        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
   
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
     try{      	
       if(BAR_Output_Type.equals("BAR_BY_DAY")){
    	   while(resultSet.next()){
       		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataReputationBARValue(resultSet.getRow())));
           	      try{
                	 String webBARValue = resultSet.getString("reputationBarValue_1");
       	             String reputationBARValueUptoTwoDecimals =  Generals.convertStringDoubleValueToTwoDecimalPlaces(webBARValue);
         	         Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataReputationBARValue(resultSet.getRow()), reputationBARValueUptoTwoDecimals);
                  }catch(NullPointerException e){
	       	         logger.info("\nWeb BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"'. - is displaying in GUI for this arrival date.");
	       	         Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataReputationBARValue(resultSet.getRow()), "-");
            }
    	   }
    	  }
      else if(BAR_Output_Type.equals("BAR_BOTH")){
       	int count=1;
       	while(resultSet.next()){
       		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataReputationBARValue(count)));
       		Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage()); 
       		try{
       			String[] reputationBARValueUptoTwoDecimals= {Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("reputationBarvalue_1")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("reputationBarvalue_2")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("reputationBarvalue_3")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("reputationBarvalue_4")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("reputationBarvalue_5")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("reputationBarvalue_6")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("reputationBarvalue_7")),Generals.convertStringDoubleValueToTwoDecimalPlaces(resultSet.getString("reputationBarvalue_8"))};
               	for(int i=0;i<reputationBARValueUptoTwoDecimals.length;i++){
                	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataReputationBARValue(count+i), reputationBARValueUptoTwoDecimals[i]);
               	}
       		}catch(NullPointerException e){
       		  for(int i=0;i<8;i++){
       			 logger.info("\nReputation BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"'. - is displaying in GUI for this arrival date.");	
       			 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataReputationBARValue(count+i), "-");
     	     }
           }count=count+8;
         }
      }
	 }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
    resultSet.close();
    dbCon.dropConnection();  
  }
//    Check how Special Event data looks like for bar out put type barBoth and accordingly modify the code as modified in occupancy Forecast.
    @Test
    public void TestSpecialEventData() throws Exception{
    	logger.info("\n\nRunning Test- TestSpecialEventData");
    	setStartAndEndDateAndClickOnApply();
        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd");
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getSpecialEventsByAllDates(prop.getProperty("PropertyName"), StartDate, EndDate));
  	 try{   	
    	 if(BAR_Output_Type.equals("BAR_BY_DAY")){
 	    	while(resultSet.next()){
 	    		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataSpecialEventValue(resultSet.getRow())));
 	        	String specialEvent = resultSet.getString("SpecialEvents");
 	        	try{
 	        		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSpecialEventValue(resultSet.getRow()), specialEvent);
 	              }catch(NullPointerException e){
 	   	           logger.info("\nSpecial Event Value is null in database for the arrival date= '"+resultSet.getString("DATE")+"'. Nothing is displaying in GUI for this arrival date.");
 	   	           Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSpecialEventValue(resultSet.getRow()), "");
 	             }catch(AssertionError e){
 	            	 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSpecialEventValue(resultSet.getRow()), "");
 	             }
 	    	  }  
        }
 	    else if(BAR_Output_Type.equals("BAR_BOTH")){
 	    	int count=1;
 	    	while(resultSet.next()){
 	    		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataSpecialEventValue(resultSet.getRow())));
 	        	String specialEvent = resultSet.getString("SpecialEvents");
 	        	try{
 	        		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSpecialEventValue(count), specialEvent);
 	              }catch(NullPointerException e){
 	   	           logger.info("\nSpecial Event Value is null in database for the arrival date= '"+resultSet.getString("DATE")+"'. Nothing is displaying in GUI for this arrival date.");
 	   	           Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSpecialEventValue(count), "");
 	             }catch(AssertionError e){
 	            	 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataSpecialEventValue(count), "");
 	             }
 	        	count=count+8;
 	    	  }  
     	    }
        }catch(NoSuchElementException e){
    		logger.info("\nNo data is present after setting this criteria");
    		Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
             }
     resultSet.close();
     dbCon.dropConnection();  
	 }
    
    @Test
    public void TestRoomsSoldLYTDData() throws Exception{
    	logger.info("\n\nRunning Test- TestRoomsSoldLYTDData");
    	setStartAndEndDateAndClickOnApply();

        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd");
        String SystemTodayDate = FormatDate.changeDateFormat(Generals.getDateFormatFromUserPreferences(), guiSystemToday, "yyyy-MM-dd");
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getRoomsSoldLastYearToDate(prop.getProperty("PropertyName"), StartDate, EndDate, SystemTodayDate));
  	try{      	
    	if(BAR_Output_Type.equals("BAR_BY_DAY")){
 	    	while(resultSet.next()){
 	    		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataRoomsSoldLYTDValue(resultSet.getRow())));
 	        	String roomsSoldLYTD = resultSet.getString("LastYrSoldToDate");
 	        	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataRoomsSoldLYTDValue(resultSet.getRow()), roomsSoldLYTD);
           }
 	    }
 	    else if(BAR_Output_Type.equals("BAR_BOTH")){
 	    	int count = 1;
	    		while(resultSet.next()){
	        		Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataRoomsSoldLYTDValue(count)));
	            	String roomsSoldLYTD = resultSet.getString("LastYrSoldToDate");
	            	Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataRoomsSoldLYTDValue(count), roomsSoldLYTD);
	            	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
	            	for(int i=0;i<=7;i++){
	            		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataRoomsSoldLYTDValue(count+i), roomsSoldLYTD);
	            	}
	            count=count+8;
 	        }
	     }
     }catch(NoSuchElementException e){
    		logger.info("\nNo data is present after setting this criteria");
    		Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
             }
    resultSet.close();
    dbCon.dropConnection();  
	}
    
    @Test
    public void TestReputationBARDataWhenBARNameIsSelected() throws Exception{
    	logger.info("\n\nRunning Test- TestRoomsSoldLYTDData");
    	setStartAndEndDateAndClickOnApply();
 
        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd");
        DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
   	try{      	
    	int count=1;
		if(BAR_Output_Type.equals("BAR_BY_DAY")){
			Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataReputationBARValue(resultSet.getRow())));
        	String reputationBAR = resultSet.getString("reputationBar_1");
        	
        	  if(reputationBAR.equals("-25")){
              	 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataReputationBARValue(resultSet.getRow()), "-"); 
               }
               else{
            	   Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataReputationBARValue(resultSet.getRow()), reputationBAR);
               }
        }
		else if(BAR_Output_Type.equals("BAR_BOTH")){
            while(resultSet.next()){
            	
            	Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataReputationBARValue(count)));
            	String[] reputationBARNames= {resultSet.getString("reputationBar_1"),resultSet.getString("reputationBar_2"),resultSet.getString("reputationBar_3"),resultSet.getString("reputationBar_4"),resultSet.getString("reputationBar_5"),resultSet.getString("reputationBar_6"),resultSet.getString("reputationBar_7"),resultSet.getString("reputationBar_8")};
            	Generals.click(OR_BestAvailableRate.tableDataExpandCollapseImage());
            	for(int i=0;i<reputationBARNames.length;i++){
                    if(reputationBARNames[i].equals("-25")){
                     	 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataReputationBARValue(count+i), "-"); 
                    }
                    else{
                 	   Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataReputationBARValue(count+i), reputationBARNames[i]);
                    }
         	}count=count+8;
           }
		}
	 }catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
	         }
    resultSet.close();
    dbCon.dropConnection();
    }
    
    @Test
    public void TestDefaultEndDateIsAlwaysStartDatePlus30Days() throws Exception{
    	logger.info("\n\nRunning Test- TestDefaultEndDateIsAlwaysStartDatePlus30Days");
    	Generals.sleepBy(1000);
        String StartDate=Generals.getTextValue(OR_BestAvailableRate.filterSectionStartDate());
        String EndDate=Generals.getTextValue(OR_BestAvailableRate.filterSectionEndDate());
        Assertions.verifyIfLongValuesAreEqual(Generals.getDaysDifference(Generals.getDateFormatFromUserPreferences(), StartDate, EndDate),30);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
        String ChangedStartDate=Generals.getTextValue(OR_BestAvailableRate.filterSectionStartDate());
        String ChangedEndDate=Generals.getTextValue(OR_BestAvailableRate.filterSectionEndDate());
        Assertions.verifyIfLongValuesAreEqual(Generals.getDaysDifference(Generals.getDateFormatFromUserPreferences(), ChangedStartDate, ChangedEndDate),30);
    }
    
    @Test
    public void TestTableDataCountAfterUncheckingFewDOWsInFilterBySection_CheckSunMonTue() throws Exception{
    	logger.info("\n\nRunning Test- TestTableDataCountAfterUncheckingFewDOWsInFilterBySection_CheckSunMonTue");
    	Generals.sleepBy(1000);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
 	    Generals.sleepBy(1000);
 	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
        String StartDate = Generals.getTextValue(OR_BestAvailableRate.startdateTextBox());
 	    String EndDate = Generals.getTextValue(OR_BestAvailableRate.enddateTextBox());
    	long daysDifference = Generals.getDaysDifference(Generals.getDateFormatFromUserPreferences(), StartDate, EndDate);
    	int numberOfRows=0;
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(4));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(5));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(6));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(7));
    	
	    Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
	    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
    try{	
    	for(int i=1;i<=daysDifference+1;i++){
    		String dateValue = Generals.incrementDate(Generals.getDateFormatFromUserPreferences(), StartDate, i-1);
    		String dowValue = Generals.getDOWValue(Generals.getDateFormatFromUserPreferences(), dateValue);
    		if(dowValue.equals("Sun")||dowValue.equals("Mon")||dowValue.equals("Tue")){
    			numberOfRows=numberOfRows+1;
    		}
    	}
    	Assertions.verifyIfIntValuesAreEqual(Generals.getSizeOfElements(OR_BestAvailableRate.tableDataRows())-1, numberOfRows);
    	for(int i=1;i<=numberOfRows;i++){
    		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataDOWValue(i), "Sun", "Mon", "Tue");
    		Assertions.assertPresentTextNOTEquals(OR_BestAvailableRate.tableDataDOWValue(i), "Web","Thu","Fri","Sat" );
    	}
     }catch(NoSuchElementException e){
		logger.info("\nNo data is present after setting this criteria");
		Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
         }
    }
    
    @Test
    public void TestTableDataCountAfterUncheckingFewDOWsInFilterBySection_CheckWedThuFriSat() throws Exception{
    	logger.info("\n\nRunning Test- TestTableDataCountAfterUncheckingFewDOWsInFilterBySection_CheckWedThuFriSat");
    	Generals.sleepBy(1000);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
 	    Generals.sleepBy(1000);
 	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
        String StartDate = Generals.getTextValue(OR_BestAvailableRate.startdateTextBox());
 	    String EndDate = Generals.getTextValue(OR_BestAvailableRate.enddateTextBox());
    	long daysDifference = Generals.getDaysDifference(Generals.getDateFormatFromUserPreferences(), StartDate, EndDate);
    	int numberOfRows=0;
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(1));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(2));
    	Generals.click(OR_BestAvailableRate.filterSectionDOWCheckboxes(3));
	    Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
	    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
    try{	
    	for(int i=1;i<=daysDifference+1;i++){
    		String dateValue = Generals.incrementDate(Generals.getDateFormatFromUserPreferences(), StartDate, i-1);
    		String dowValue = Generals.getDOWValue(Generals.getDateFormatFromUserPreferences(), dateValue);
    		if(dowValue.equals("Wed")||dowValue.equals("Thu")||dowValue.equals("Fri")||dowValue.equals("Sat")){
    			numberOfRows++;
    		}
    	}
    	Assertions.verifyIfIntValuesAreEqual(Generals.getSizeOfElements(OR_BestAvailableRate.tableDataRows())-1, numberOfRows);
      	for(int i=1;i<=numberOfRows;i++){
    		Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataDOWValue(i), "Wed","Thu","Fri","Sat");
    		Assertions.assertPresentTextNOTEquals(OR_BestAvailableRate.tableDataDOWValue(i), "Sun","Mon","Tue");
    	}
     }catch(NoSuchElementException e){
		logger.info("\nNo data is present after setting this criteria");
		Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
         }
     }
    
    @Test
    public void TestTableDataWhenShowDatesWhereReputationBarExceedsSystemBar() throws Exception {
    	logger.info("\n\nRunning Test- TestTableDataWhenShowDatesWhereReputationBarExceedsSystemBar");
    	Generals.sleepBy(1000);
        SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
 	    Generals.sleepBy(1000);
 	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
 	    Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
 	    SelectDropDownValues.selecyByVisibleText("System BAR", OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDown());
    	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
	    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
	    
        String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
        String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
        
    	DbCon dbCon = new DbCon();
    	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
   		ArrayList<String> dates = new ArrayList<String>();
        int count=0;
    	 try{
    			while(resultSet.next()){
                   try{
    	             	 String reputationBARValue = resultSet.getString("reputationBarValue_1");
    	               	 String systemBARValue= resultSet.getString("systembarvalue_1");
    	               	 int reputationBARValueInInt = Integer.parseInt(reputationBARValue);
    	               	 int systemBARValueInInt = Integer.parseInt(systemBARValue);
    	               	 if(reputationBARValueInInt>systemBARValueInInt){
                       		count =count+1;
                       		String arrivalDates= resultSet.getString("arrivaldate");
                       		dates.add(arrivalDates);
                       	 }
    	     	Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataReputationBARValue(count)));
                       }
    	              catch(NullPointerException e){
    	       	         logger.info("\nReputation BAR or System BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"");
                      }
                      catch(NumberFormatException e){
  	       	            logger.info("\nReputation BAR or System BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"");
                    }
                 }
	                Assertions.verifyIfIntValuesAreEqual(Generals.getSizeOfElements(OR_BestAvailableRate.tableDataRows())-1, count);
	        	     for(int i=0;i<dates.size();i++){
	        	     String date = FormatDate.changeDateFormat("yyyy-MM-dd", dates.get(i), Generals.getDateFormatFromUserPreferences());	 
	        		 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataDateValue(i+1), date);
	        	       }
    		}catch(NoSuchElementException e){
    			logger.info("\nNo data is present after setting this criteria");
    			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
            }
      resultSet.close();
   	  dbCon.dropConnection();
    }

@Test
public void TestTableDataWhenShowDatesWhereReputationBarExceedsWebBar() throws Exception {
	logger.info("\n\nRunning Test- TestTableDataWhenShowDatesWhereReputationBarExceedsWebBar");
	Generals.sleepBy(1000);
    SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
	    Generals.sleepBy(1000);
	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
	    Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
	    SelectDropDownValues.selecyByVisibleText("System BAR", OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDown());
	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
    
    String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
    String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
    
	DbCon dbCon = new DbCon();
	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
		ArrayList<String> dates = new ArrayList<String>();
    int count=0;
	 try{
			while(resultSet.next()){
               try{
	             	 String reputationBARValue = resultSet.getString("reputationBarValue_1");
	               	 String webBARValue= resultSet.getString("webbarvalue_1");
	               	 int reputationBARValueInInt = Integer.parseInt(reputationBARValue);
	               	 int webBARValueInInt = Integer.parseInt(webBARValue);
	               	 if(reputationBARValueInInt>webBARValueInInt){
                   		count =count+1;
                   		String arrivalDates= resultSet.getString("arrivaldate");
                   		dates.add(arrivalDates);
                   	 }
	     	        Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataReputationBARValue(count)));
                   }
	              catch(NullPointerException e){
	       	         logger.info("\nReputation BAR or Web BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"");
                  }
                  catch(NumberFormatException e){
	       	            logger.info("\nReputation BAR or Web BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"");
                }
             }
                Assertions.verifyIfIntValuesAreEqual(Generals.getSizeOfElements(OR_BestAvailableRate.tableDataRows())-1, count);
        	     for(int i=0;i<dates.size();i++){
        	     String date = FormatDate.changeDateFormat("yyyy-MM-dd", dates.get(i), Generals.getDateFormatFromUserPreferences());	 
        		 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataDateValue(i+1), date);
        	       }
		}catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
           }
      resultSet.close();
	  dbCon.dropConnection();
 }

@Test
public void TestTableDataWhenShowDatesWhereReputationBarExceedsUserBar() throws Exception {
	logger.info("\n\nRunning Test- TestTableDataWhenShowDatesWhereReputationBarExceedsUserBar");
	Generals.sleepBy(1000);
    SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
	    Generals.sleepBy(1000);
	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
	    Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
	    SelectDropDownValues.selecyByVisibleText("System BAR", OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDown());
	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
    
    String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
    String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
    
	DbCon dbCon = new DbCon();
	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
		ArrayList<String> dates = new ArrayList<String>();
    int count=0;
	 try{
			while(resultSet.next()){
               try{
	             	 String reputationBARValue = resultSet.getString("reputationBarValue_1");
	               	 String userBARValue= resultSet.getString("finalbarvalue_1");
	               	 int reputationBARValueInInt = Integer.parseInt(reputationBARValue);
	               	 int userBARValueInInt = Integer.parseInt(userBARValue);
	               	 if(reputationBARValueInInt>userBARValueInInt){
                   		count =count+1;
                   		String arrivalDates= resultSet.getString("arrivaldate");
                   		dates.add(arrivalDates);
                   	 }
	     	        Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataReputationBARValue(count)));
                   }
	              catch(NullPointerException e){
	       	         logger.info("\nReputation BAR or User BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"");
                  }
                  catch(NumberFormatException e){
	       	            logger.info("\nReputation BAR or User BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"");
                }
             }
                Assertions.verifyIfIntValuesAreEqual(Generals.getSizeOfElements(OR_BestAvailableRate.tableDataRows())-1, count);
        	     for(int i=0;i<dates.size();i++){
        	     String date = FormatDate.changeDateFormat("yyyy-MM-dd", dates.get(i), Generals.getDateFormatFromUserPreferences());	 
        		 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataDateValue(i+1), date);
        	       }
		}catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
   }
      resultSet.close();
	  dbCon.dropConnection();
 }

@Test
public void TestTableDataWhenShowDatesWhereReputationBarExceedsAll() throws Exception {
	logger.info("\n\nRunning Test- TestTableDataWhenShowDatesWhereReputationBarExceedsUserBar");
	Generals.sleepBy(1000);
    SetCalender.setCalender(OR_BestAvailableRate.filterSectionStartDateCalenderIcon(), OR_BestAvailableRate.startdateTextBox(), "RM_StartDate");
	    Generals.sleepBy(1000);
	    SetCalender.setCalender(OR_BestAvailableRate.filterSectionEndDateCalenderIcon(), OR_BestAvailableRate.enddateTextBox(), "RM_EndDate");
	    Generals.click(OR_BestAvailableRate.filterSectionDisplayOptionRadioButtons(2));
	    SelectDropDownValues.selecyByVisibleText("System BAR", OR_BestAvailableRate.filterSectionShowDatesWithRBExceedsDropDown());
	Generals.click(OR_BestAvailableRate.filterSectionApplyButton());	   	    
    Generals.waitByInvisibilityOfElementLocatedBy(By.id("dvLoading"));
    
    String StartDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_StartDate"), "yyyy-MM-dd");    	
    String EndDate = FormatDate.changeDateFormat("dd MMM yyyy", prop.getProperty("RM_EndDate"), "yyyy-MM-dd"); 
    
	DbCon dbCon = new DbCon();
	ResultSet resultSet = dbCon.getRecords(QueryToFetchDbData.getLRVoverbookingAndBARValues(prop.getProperty("PropertyName"), StartDate, EndDate));
		ArrayList<String> dates = new ArrayList<String>();
    int count=0;
	 try{
			while(resultSet.next()){
               try{
	             	 String reputationBARValue = resultSet.getString("reputationBarValue_1");
	               	 String userBARValue= resultSet.getString("finalbarvalue_1");
	               	 String webBARValue= resultSet.getString("webbarvalue_1");
	               	 String systemBARValue= resultSet.getString("systembarvalue_1");
	               	 int reputationBARValueInInt = Integer.parseInt(reputationBARValue);
	               	 int userBARValueInInt = Integer.parseInt(userBARValue);
	               	 int webBARValueInInt = Integer.parseInt(webBARValue);
	               	 int systemBARValueInInt = Integer.parseInt(systemBARValue);
	               	 if(reputationBARValueInInt>userBARValueInInt && reputationBARValueInInt>webBARValueInInt && reputationBARValueInInt>systemBARValueInInt){
                   		count =count+1;
                   		String arrivalDates= resultSet.getString("arrivaldate");
                   		dates.add(arrivalDates);
                   	 }
	     	        Generals.makeVisible(Generals.element(OR_BestAvailableRate.tableDataReputationBARValue(count)));
                   }
	              catch(NullPointerException e){
	       	         logger.info("\nReputation BAR or User BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"");
                  }
                  catch(NumberFormatException e){
	       	            logger.info("\nReputation BAR or User BAR Value is null in database for the arrival date= '"+resultSet.getString("arrivaldate")+"");
                }
             }
                Assertions.verifyIfIntValuesAreEqual(Generals.getSizeOfElements(OR_BestAvailableRate.tableDataRows())-1, count);
        	     for(int i=0;i<dates.size();i++){
        	     String date = FormatDate.changeDateFormat("yyyy-MM-dd", dates.get(i), Generals.getDateFormatFromUserPreferences());	 
        		 Assertions.assertPresentTextEquals(OR_BestAvailableRate.tableDataDateValue(i+1), date);
        	       }
		}catch(NoSuchElementException e){
			logger.info("\nNo data is present after setting this criteria");
			Assertions.assertElementIsDisplaying(OR_BestAvailableRate.notDataAvailableText());
                }
      resultSet.close();
	  dbCon.dropConnection();
 }
}
  
 



