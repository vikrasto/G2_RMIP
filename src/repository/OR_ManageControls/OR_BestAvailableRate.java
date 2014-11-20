package repository.OR_ManageControls;

import org.openqa.selenium.By;

public class OR_BestAvailableRate {
	
	public static By bestAvailableRateLink(){
		return By.linkText("Best Available Rate");
	}
	public static By bestAvailableRateSubModulesNames(int index){
		return By.xpath(".//div[@class='containerTabSet']/div["+index+"]/a");
	}
	public static By reputationManagementModule(){
		return By.linkText("Reputation Management");
	}

	public static By reputationBARText(){
		return By.xpath(".//a[text()='Reputation BAR']");
	}
	public static By reputationQuadrantText(){
		return By.xpath(".//a[text()='Reputation Quadrant']");
	}
	public static By reputationAnalysisText(){
		return By.xpath(".//a[text()='Reputation Analysis']");
	}
	public static By filterSectionFilterByText(){
		return By.xpath(".//div[@class='headerDiv']/h2");
	}
	public static By filterSectionDateText(int rowIndex){
		return By.xpath(".//table[@id='filterTable']/tbody/tr["+rowIndex+"]/td");
	}
	public static By filterSectionCompetitorsText(){
		return By.xpath("(.//td[@class='tableHeaders'])[3]");
	}
	public static By filterSectionDOWTable(int trNumber, int tdNumber){
		return By.xpath(".//table[@id='dowTable']/tbody/tr["+trNumber+"]/td["+tdNumber+"]");
	}
	public static By filterSectionStartDate(){
		return By.id("txtSDate1");
	}
	public static By filterSectionEndDate(){
		return By.id("txtEDate");
	}
	public static By filterSectionStartDateCalenderIcon(){
		return By.id("strSpan1");
	}
	public static By filterSectionEndDateCalenderIcon(){
		return By.xpath("(.//span[@id='strSpan1'])[2]");
	}
	public static By filterSectionCalenderDate(String Date){
		return By.linkText(""+Date+"");
	}
	public static By filterSectionCalenderDateMonth(){
		return By.xpath(".//div[@id='calControls']/select");
	}
	public static By filterSectionShowDatesWhereRBexceedsText(){
		return By.xpath(".//td[text()='Show dates where Reputation BAR exceeds:']");
	}
	public static By filterSectionDisplayOptionWithBarNameBarValue(int Index){
		return By.xpath(".//div[@class='floatRight']/label["+Index+"]");
	}
	public static By filterSectionDisplayOptionRadioButtons(int Index){
		return By.xpath(".//div[@class='floatRight']/input["+Index+"]");
	}
	public static By filterSectionDOWCheckboxes(int Index){
		return By.id("dow"+Index+"");
	}
	public static By filterSectionCheckedDOWValues(){
		return By.xpath(".//table[@id='dowTable']//input[@checked='checked']/following-sibling::span");
	}
	public static By filterSectionDOWValues(int Index){
		return By.xpath(".//input[@id='dow"+Index+"']/following-sibling::span");
	}
	public static By filterSectionShowDatesWithRBExceedsDropDown(){
		return By.id("barExceeds");
	}
	public static By filterSectionShowDatesWithRBExceedsDropDownOptions(int Index){
		return By.xpath(".//select[@id='barExceeds']/option["+Index+"]");
	}
	public static By filterSectionApplyButton(){
		return By.id("applyBtn");
	}
	public static By filterSectionClearButton(){
		return By.id("resetBtn");
	}
	public static By tableSectionColumnNames(int Count){
		return By.xpath(".//tr[@role='rowheader']/th["+Count+"]");
	}
	public static By tableSectionColumnNameAfterBarDecision(int Index){
		return By.xpath(".//th[text()='BAR Decision']/following-sibling::th["+Index+"]");
	}
	public static By tableSectionBottomColumnNames(int Count){
		return By.xpath("(.//tr[@role='rowheader'])[2]/th["+Count+"]");
	}
	public static By expandAllButton(){
		return By.className("expandCollapseAll");
	}
	public static By startdateTextBox(){
		return By.id("txtSDate1");
	}
	public static By enddateTextBox(){
		return By.id("txtEDate");
	}
	public static By filterSectionCompetitorsList(int Index){
		return By.xpath(".//ul[@class='chzn-choices']/li["+Index+"]");
	}
	public static By filterSectionCompetitorsBox(){
		return By.className("chzn-choices");
	}
	public static By competitorName(String CompetitorName){
		return By.xpath(".//li[text()='"+CompetitorName+"']");
	}
	public static By competitorsDropDownOpenedAfterClick(){
		return By.className("chzn-results");
	}
	public static By competitorsDropDownValuesOpenedAfterClick(int Index){
		return By.xpath(".//ul[@class='chzn-results']/li["+Index+"]");
	}
	public static By competitorsDropDownOpenedAfterClickListElements(){
		return By.xpath(".//ul[@class='chzn-results']/li");
	}
	public static By competitorsCloseAllLink(){
		return By.xpath(".//span[text()='All']/following-sibling::a");
	}
	public static By reputationManagementDescriptionText(){
		return By.id("reputationBARDetailsDesc");
	}
	public static By tableDataDOWValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_dayOfWeek'])["+RowIndex+"]");
	}
	public static By tableDataDOWValue(){
		return By.xpath(".//td[@aria-describedby='treegrid_dayOfWeek']");
	}
	public static By tableDataRows(){
		return By.xpath(".//table[@id='treegrid']/tbody/tr[@role='row']");
	}
	public static By tableDataDateValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_date'])["+RowIndex+"]");
	}
	public static By tableDataEntireTable(int RowIndex, String ariaDescribedByValue){
		return By.xpath(".//table[@id='treegrid' and @aria-labelledby='gbox_treegrid']/tbody/tr[@id='"+RowIndex+"']/td[@aria-describedby='"+ariaDescribedByValue+"']");
	}
	public static By tableDataRoomsSold(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_roomsSold'])["+RowIndex+"]");
	}
	public static By tableDataOccupanyForecast(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_occupancyForecast'])["+RowIndex+"]");
	}
	public static By tableDataLOSvalue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_los'])["+RowIndex+"]");
	}
	public static By tableDataOccupanyForecastPercentage(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_occupancyForecastPercentTotal'])["+RowIndex+"]");
	}
	public static By tableDataLRVValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_lrv'])["+RowIndex+"]");
	}
	public static By tableDataSystemBARValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_system'])["+RowIndex+"]");
	}
	public static By tableDataSpecialEventValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_specialEventsTYList'])["+RowIndex+"]");
	}
	public static By tableDataWebBARValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_web'])["+RowIndex+"]");
	}
	public static By tableDataUserBARValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_user'])["+RowIndex+"]");
	}
	public static By tableDataRoomsSoldLYTDValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_roomsSoldLYTD'])["+RowIndex+"]");
	}
	public static By tableDataReputationBARValue(int RowIndex){
		return By.xpath("(.//td[@aria-describedby='treegrid_reputation'])["+RowIndex+"]");
	}
	public static By tableDataExpandCollapseImage(){
		return By.xpath(".//span[@class='expandCollapseSprites collapseIcon']");
	}
	public static By reputationBARDetailsText(){
		return By.id("reputationBARDetails");
	}
	public static By notDataAvailableText(){
		return By.id("dataNotAvailable");
	}

	
//	Competitors Object Repository starts here
	public static By competitorsLink(){
        return By.linkText("Competitors");
    }
	public static By competitorsReputationCompetitorHotelNameColumn(){
		return By.xpath(".//th[text()='Reputation Competitor Hotel Name']");
	}
	public static By competitorsReputationCompetitorHotelNameColumnValues(){
		return By.name("rracomp");
	}
	public static By competitorsHotelName(){
		return By.name("webCompetitorHotel");
	}
	public static By competitorsReputationCompetitorHotelNameColumnIndividualValues(int Index){
		return By.xpath(".//select[@id='rracomp_"+Index+"']");
	}
	
	public static By competitorsHotelNameIndividualValues(int Index){
		return By.xpath("(.//input[@name='webCompetitorHotel'])["+Index+"]");
	}
}
