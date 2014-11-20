package repository;

import org.openqa.selenium.By;

public class OR_General {
    public static By userName(){
    	return By.name("userName");
    }

	public static By passWord() {
        return By.name("password"); 
	}

	public static By loginButton() {
		return By.linkText("Login");
	}
	
	public static By logoutButton() {
		return By.linkText("Logout");
	}
	
	public static By selectAPropertyDropDown() {
		return By.xpath(".//span[text()='Search a new view or property']");
	}
	public static By selectPropertyFromDropdown(String propertyName) {
		return By.xpath(".//li[text()='"+propertyName+"']");
	}
	public static By calenderDateForDate1(String Date){
		return By.linkText(""+Date+"");
	}
	public static By calenderDate(int Date){
		return By.xpath(".//div[@id='calDays']//a[text()='1']/../following-sibling::div["+Date+"-1]/a");
	}
	public static By calenderMonthForwardImage(){
		return By.xpath(".//img[contains(@src,'cal-mon-fwd')]");
	}
	public static By calenderMonthBackImage(){
		return By.xpath(".//img[contains(@src,'cal-mon-back')]");
	}
	public static By calenderYearForwardImage(){
		return By.xpath(".//img[contains(@src,'cal-year-fwd')]");
	}
	public static By calenderYearBackImage(){
		return By.xpath(".//img[contains(@src,'cal-year-back')]");
	}
	public static By calenderDateMonth(){
		return By.xpath(".//div[@id='calControls']/select");
	}
}
