package repository;

import org.openqa.selenium.By;

public class OR_TopMenu {
   public static By welcomeText(){
	   return By.xpath(".//div[text()='Welcome: ']");
   }
   
   public static By propertyName(){
	   return By.xpath(".//div[@id='headerNew']//h1");
   }
}
