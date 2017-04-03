package Main;

import java.util.HashMap;

/**
 * the class for setting and getting the date. Begins on Saturday 1st April 2017.
 * We consider that we cannot move to the next month (for simplicity purposes)
 * So the user can only move from 1st April to 30th April
 * @author natha
 *
 */

public class Date {
	
	private static int day=1;
	private static String dayName="Saturday";
	private static int week=13;
	private static HashMap<Integer, String> dayNames = createHashMap();

	public Date() {
		// TODO Auto-generated constructor stub
	}
	
	public static void goTomorrow(){
		day+=1;
		dayName=findDayName(day);
		week=findWeek(day);
		
	}
	
	
	public static int getDay() {
		return day;
	}

	public static void setDay(int day) {
		Date.day = day;
	}

	public static String getDayName() {
		return dayName;
	}

	public static void setDayName(String dayName) {
		Date.dayName = dayName;
	}

	public static int getWeek() {
		return week;
	}

	public static void setWeek(int week) {
		Date.week = week;
	}

	private static String findDayName(int day){
		return dayNames.get(day%7);
			
	}
	
	private static HashMap<Integer,String> createHashMap(){
		HashMap<Integer,String> res = new HashMap<Integer,String>();
		res.put(1, "Saturday");
		res.put(2, "Sunday");
		res.put(3, "Monday");
		res.put(4, "Tuesday");
		res.put(5, "Wednesday");
		res.put(6,"Thursday");
		res.put(0, "Friday");
		return res;
		
	}
	
	private static int findWeek(int day){
		if (day==1)
			return(13);
		if (day==2)
			return(13);
		return(13+((int)((day-3)/7)+1));
	}
	
	public static void setDate(int number){
		day=number;
		dayName=findDayName(day);
		week=findWeek(day);
		
	}
	
	public static String getDate(){
		return dayName + " " + day + " April 2017";
	}
	
	public static void main(String[] args) {

		System.out.println(findWeek(2));

		System.out.println(findWeek(7));

		System.out.println(findWeek(10));
		
		System.out.println(getDate());
		
		goTomorrow();
		
		System.out.println(getDate());
	}

}
