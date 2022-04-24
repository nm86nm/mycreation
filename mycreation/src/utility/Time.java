package utility;
import java.util.Date;
import java.util.Calendar;


public class Time {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		long dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		Date date = calendar.getTime();
		String dateInString = date.toString();
		
		long systemTimeInMillis = System.currentTimeMillis();
		long calendarTimeInMillis = calendar.getTimeInMillis();	
		
		System.out.println(dateInString + " - day of year: " + dayOfYear);
		System.out.println(systemTimeInMillis + " = " + calendarTimeInMillis);
		
		calendar.setFirstDayOfWeek(Calendar.MONDAY);		
	    System.out.println("First Day Of Week: " + calendar.getFirstDayOfWeek());
	}	
}
