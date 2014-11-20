package keywords;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate{
	
  public static String changeDateFormat(String CurrentDateFormat, String DateToBeFormatted, String ExpectedDateFormat) throws Exception{
	  
	SimpleDateFormat formatter = new SimpleDateFormat(CurrentDateFormat);
  	String dateInString = DateToBeFormatted;
   
  	Date date = formatter.parse(dateInString);
    String FormattedDate = new SimpleDateFormat(ExpectedDateFormat).format(date);
    return FormattedDate;
  }
  
  public static Date changeDateFormat_ReturnTypeDate(String CurrentDateFormat, String DateToBeFormatted, String ExpectedDateFormat) throws Exception{
	  
	SimpleDateFormat formatter = new SimpleDateFormat(CurrentDateFormat);
  	String dateInString = DateToBeFormatted;
   
  	Date date = formatter.parse(dateInString);
    return date;
  }
  
  public static Date changeFromStringToDate(String DateFormat, String StringDateToBeConvertedToDate) throws Exception{
	  
	SimpleDateFormat formatter = new SimpleDateFormat(DateFormat);
  	String dateInString = StringDateToBeConvertedToDate;
   
  	Date date = formatter.parse(dateInString);
    return date;
  }
  
//  public static String IncrementDate(String DateFormat, String StringDateToIncrement, int IncrementBy) throws Exception{
//	  
//    SimpleDateFormat sdf = new SimpleDateFormat(DateFormat);
//    Calendar c = Calendar.getInstance();
//    c.setTime(sdf.parse(StringDateToIncrement));
//    c.add(Calendar.DATE, IncrementBy);
//    StringDateToIncrement = sdf.format(c.getTime());
//    return StringDateToIncrement;
//  }
  
  
}
