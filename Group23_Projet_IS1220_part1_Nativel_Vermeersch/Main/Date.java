package Main;

import java.util.HashMap;

/**
 * the class for setting and getting the date. Begins on SaturcurrentDay 1st April 2017.
 * We consider that we cannot move to the next month (for simplicity purposes)
 * So the user can only move from 1st April to 30th April
 * @author natha
 *
 */

public class Date {
	
	private int day;
	private int week;
	private String dayName;
	private static int currentDay=1;
	private static String currentDayName="SaturcurrentDay";
	private static int currentWeek=13;
	private static HashMap<Integer, String> currentDayNames = createHashMap();

	/**
	 * instance of date, which is used for history purposes
	 * one must not confuse day and currentDay (static), etc.
	 */
	public Date() {
		this.day=currentDay;
		this.week=currentWeek;
		this.dayName=currentDayName;
		// TODO Auto-generated constructor stub
	}
	
	public static void goTomorrow(){
		currentDay+=1;
		currentDayName=findCurrentDayName(currentDay);
		currentWeek=findCurrentWeek(currentDay);
		
	}
	
	
	public static int getCurrentDay() {
		return currentDay;
	}

	public static void setCurrentDay(int currentDay) {
		Date.currentDay = currentDay;
	}

	public static String getCurrentDayName() {
		return currentDayName;
	}

	public static void setCurrentDayName(String currentDayName) {
		Date.currentDayName = currentDayName;
	}

	public static int getCurrentWeek() {
		return currentWeek;
	}

	public static void setCurrentWeek(int currentWeek) {
		Date.currentWeek = currentWeek;
	}

	private static String findCurrentDayName(int currentDay){
		return currentDayNames.get(currentDay%7);
			
	}
	
	private static HashMap<Integer,String> createHashMap(){
		HashMap<Integer,String> res = new HashMap<Integer,String>();
		res.put(1, "SaturcurrentDay");
		res.put(2, "SuncurrentDay");
		res.put(3, "MoncurrentDay");
		res.put(4, "TuescurrentDay");
		res.put(5, "WednescurrentDay");
		res.put(6,"ThurscurrentDay");
		res.put(0, "FricurrentDay");
		return res;
		
	}
	
	private static int findCurrentWeek(int currentDay){
		if (currentDay==1)
			return(13);
		if (currentDay==2)
			return(13);
		return(13+((int)((currentDay-3)/7)+1));
	}
	
	public static void setCurrentDate(int number){
		currentDay=number;
		currentDayName=findCurrentDayName(currentDay);
		currentWeek=findCurrentWeek(currentDay);
		
	}
	
	public static String getDate(){
		return currentDayName + " " + currentDay + " April 2017";
	}
	
	public static void main(String[] args) {

		System.out.println(findCurrentWeek(2));

		System.out.println(findCurrentWeek(7));

		System.out.println(findCurrentWeek(10));
		
		System.out.println(getDate());
		
		goTomorrow();
		
		System.out.println(getDate());
	}

}
