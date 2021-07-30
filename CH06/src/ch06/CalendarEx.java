package ch06;

import java.util.Calendar;

public class CalendarEx {
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int month = now.get(Calendar.MONTH)+1;
		int day = now.get(Calendar.DAY_OF_MONTH);
		int dayOfweek = now.get(Calendar.DAY_OF_WEEK);
		
		System.out.println(year+"/"+month+"/"+day);
		System.out.println(dayOfweek);
	}
}
