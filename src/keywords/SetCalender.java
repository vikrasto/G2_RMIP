package keywords;

import java.util.Date;
import org.openqa.selenium.By;
import repository.OR_General;
import tests.general.general;

public class SetCalender extends general{
	
   @SuppressWarnings("deprecation")
   public static void setCalender(By CalenderIcon, By DateInputField, String SetDateFromPropertiesFile) throws Exception{
	   String DatePresentInGUIFilter = Generals.getTextValue(DateInputField);
	   Generals.click(CalenderIcon);

	   String InputDateMonthAndYear = prop.getProperty(""+SetDateFromPropertiesFile+"");
	   String[] InputData = InputDateMonthAndYear.split(" ");
       String InputDateInString = InputData[0];
       int InputDate = Integer.valueOf(InputDateInString);
       
        Date FormattedDateFromPropertiesFile = FormatDate.changeDateFormat_ReturnTypeDate("dd MMM yyyy", prop.getProperty(""+SetDateFromPropertiesFile+""), "dd/MM/yy");
        Date FormattedDatePresentInGUIFilter = FormatDate.changeDateFormat_ReturnTypeDate(Generals.getDateFormatFromUserPreferences(), DatePresentInGUIFilter, "dd/MM/yy");

		int DiffInYear = FormattedDateFromPropertiesFile.getYear() - FormattedDatePresentInGUIFilter.getYear();
		int DiffInMonth = FormattedDateFromPropertiesFile.getMonth() - FormattedDatePresentInGUIFilter.getMonth();
//		int DiffInDays = FormattedDateFromPropertiesFile.getDate() - FormattedDatePresentInGUIFilter.getDate();
		

		
  if(!(InputDate==1))
	 {
		  
		  
	 if(DiffInYear==0)
	   {
		   if(DiffInMonth==0)
		      {
			   Generals.click(OR_General.calenderDate(InputDate));  
		      }
		   else if(DiffInMonth>0)
		     {
			   for(int i=1;i<=DiffInMonth;i++)
			   {
			      Generals.click(OR_General.calenderMonthForwardImage());
			   }
				  Generals.click(OR_General.calenderDate(InputDate));
		     }
		   else if(DiffInMonth<0)
		     {
			   DiffInMonth = -DiffInMonth;
			   for(int i=1;i<=DiffInMonth;i++)
			   {
			      Generals.click(OR_General.calenderMonthBackImage());
			   }
				  Generals.click(OR_General.calenderDate(InputDate));
		     }
		   
	   }
	   
	  if(DiffInYear>0)
	  {
		  for(int i=1;i<=DiffInYear;i++)
		  {
			  Generals.click(OR_General.calenderYearForwardImage());
		  }
		  
		   if(DiffInMonth==0)
		      {
			   Generals.click(OR_General.calenderDate(InputDate));  
		      }
		   else if(DiffInMonth>0)
		     {
			   for(int i=1;i<=DiffInMonth;i++)
			   {
			      Generals.click(OR_General.calenderMonthForwardImage());
			      Generals.sleepBy(1000);
			   }
				  Generals.click(OR_General.calenderDate(InputDate));
		     }
		   else if(DiffInMonth<0)
		     { 
			   DiffInMonth = -DiffInMonth;
			   for(int i=1;i<=DiffInMonth;i++)
			   {
			      Generals.click(OR_General.calenderMonthBackImage());
			   }
				  Generals.click(OR_General.calenderDate(InputDate));
		     }
	  }
	   
	  if(DiffInYear<0)
	  {
		  DiffInYear = -DiffInYear;
		  for(int i=1;i<=DiffInYear;i++)
		  {
			  Generals.click(OR_General.calenderYearBackImage());
		  }
		  
		   if(DiffInMonth==0)
		      {
			   Generals.click(OR_General.calenderDate(InputDate));  
		      }
		   else if(DiffInMonth>0)
		     {
			   for(int i=1;i<=DiffInMonth;i++)
			   {
			      Generals.click(OR_General.calenderMonthForwardImage());
			   }
				  Generals.click(OR_General.calenderDate(InputDate));
		     }
		   else if(DiffInMonth<0)
		     {
			   DiffInMonth = -DiffInMonth;
			   for(int i=1;i<=DiffInMonth;i++)
			   {
			      Generals.click(OR_General.calenderMonthBackImage());
			   }
				  Generals.click(OR_General.calenderDate(InputDate));
		     }
	  }
	  
	  
   } 
 
 
  if(InputDate==1)
	  {
		  
		  
		  if(DiffInYear==0)
		   {
			   if(DiffInMonth==0)
			      {
				   Generals.click(OR_General.calenderDateForDate1(InputDateInString));  
			      }
			   else if(DiffInMonth>0)
			     {
				   for(int i=1;i<=DiffInMonth;i++)
				   {
				      Generals.click(OR_General.calenderMonthForwardImage());
				   }
					  Generals.click(OR_General.calenderDateForDate1(InputDateInString));
			     }
			   else if(DiffInMonth<0)
			     {
				   DiffInMonth = -DiffInMonth;
				   for(int i=1;i<=DiffInMonth;i++)
				   {
				      Generals.click(OR_General.calenderMonthBackImage());
				   }
					  Generals.click(OR_General.calenderDateForDate1(InputDateInString));
			     }
			   
		   }
		   
		  if(DiffInYear>0)
		  {
			  for(int i=1;i<=DiffInYear;i++)
			  {
				  Generals.click(OR_General.calenderYearForwardImage());
			  }
			  
			   if(DiffInMonth==0)
			      {
				   Generals.click(OR_General.calenderDateForDate1(InputDateInString));  
			      }
			   else if(DiffInMonth>0)
			     {
				   for(int i=1;i<=DiffInMonth;i++)
				   {
				      Generals.click(OR_General.calenderMonthForwardImage());
				      Generals.sleepBy(1000);
				   }
					  Generals.click(OR_General.calenderDateForDate1(InputDateInString));
			     }
			   else if(DiffInMonth<0)
			     {
				   DiffInMonth = -DiffInMonth;
				   for(int i=1;i<=DiffInMonth;i++)
				   {
				      Generals.click(OR_General.calenderMonthBackImage());
				   }
					  Generals.click(OR_General.calenderDateForDate1(InputDateInString));
			     }
		  }
		   
		  if(DiffInYear<0)
		  {
			  DiffInYear = -DiffInYear;
			  for(int i=1;i<=DiffInYear;i++)
			  {
				  Generals.click(OR_General.calenderYearBackImage());
			  }
			  
			   if(DiffInMonth==0)
			      {
				   Generals.click(OR_General.calenderDateForDate1(InputDateInString));  
			      }
			   else if(DiffInMonth>0)
			     {
				   for(int i=1;i<=DiffInMonth;i++)
				   {
				      Generals.click(OR_General.calenderMonthForwardImage());
				   }
					  Generals.click(OR_General.calenderDateForDate1(InputDateInString));
			     }
			   else if(DiffInMonth<0)
			     {
				   DiffInMonth = - DiffInMonth;
				   for(int i=1;i<=DiffInMonth;i++)
				   {
				      Generals.click(OR_General.calenderMonthBackImage());
				   }
					  Generals.click(OR_General.calenderDateForDate1(InputDateInString));
			     }
		  }  
		  
	  }
   }
}
