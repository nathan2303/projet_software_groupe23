package Main;

import java.util.HashMap;

/**
 * the class for setting and getting the date. Begins on Saturday 1st April 2017.
 * We consider that all months have 30 days (for the sake of simplicity)
 * @author natha
 *
 */

public class Date {
	
	private int day;
	private int week;
	private int month;
	private String dayName;
	private String monthName;
	private int year;
	private static int counter = 1;
	private static int currentDay=1;
	private static String currentDayName="Saturday";
	private static int currentWeek=13;
	private static int currentMonth=4;
	private static String currentMonthName="April";
	private static int currentYear = 2017;
	private static HashMap<Integer, String> dayNames = createHashMapDay();
	private static HashMap<Integer, String> monthNames = createHashMapMonth();

	/**
	 * instance of date, which is used for history purposes
	 * one must not confuse day and currentDay (static), etc.
	 */
	public Date() {
		this.day=currentDay;
		this.week=currentWeek;
		this.dayName=currentDayName;
		this.month=currentMonth;
		this.monthName=currentMonthName;
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * the static attributes go one day further
	 */
	
	public static void goTomorrow(){
		counter+=1;
		currentDay=findCurrentDay(counter);
		currentDayName=findCurrentDayName(counter);
		currentWeek=findCurrentWeek(counter);
		currentMonth=findCurrentMonth(counter);
		currentMonthName=findCurrentMonthName(currentMonth);
		
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
	
	/**
	 * convert the counter into a proper day of a month
	 * @param n
	 * @return day of the month
	 */
	private static int findCurrentDay(int n){
		int x = n%30;
		return((x==0) ? 30 : x);
	}
	

	/**
	 * converts a number (the number of days starting from 1st April 2017) into a day name
	 * @param n
	 * @return day name (Monday...)
	 */
	private static String findCurrentDayName(int n){
		return dayNames.get(n%7);
			
	}
	
	/**
	 * converts the day counter into a month
	 * @param n
	 * @return a month (int)
	 */
	private static int findCurrentMonth(int n){
		return((int)(n-1)/30 + 4);
	}
	
	/**
	 * converts the month number into the month name
	 * @param monthNumber
	 * @return month name (April...)
	 */
	private static String findCurrentMonthName(int monthNumber){
		return monthNames.get(monthNumber);
	}
	
		
	private static HashMap<Integer,String> createHashMapDay(){
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
	
	private static HashMap<Integer,String> createHashMapMonth(){
		HashMap<Integer,String> res = new HashMap<Integer,String>();
		res.put(1, "January");
		res.put(2, "February");
		res.put(3, "March");
		res.put(4, "April");
		res.put(5,"May");
		res.put(6, "June");
		res.put(7, "July");
		res.put(8, "August");
		res.put(9, "September");
		res.put(10, "October");
		res.put(11, "November");
		res.put(12, "December");
		return res;
		
	}
	
	
	private static int findCurrentWeek(int currentDay){
		if (currentDay==1)
			return(13);
		if (currentDay==2)
			return(13);
		return(13+((int)((currentDay-3)/7)+1));
	}
	
	public static void setCurrentDate(int day, int month){
		currentDay=number;
		currentDayName=findCurrentDayName(currentDay);
		currentWeek=findCurrentWeek(currentDay);
		
	}
	
	public static String getDate(){
		return currentDayName + " " + currentDay + " " + currentMonthName + " 2017";
	}
	
	public static void main(String[] args) {

		System.out.println(findCurrentWeek(2));

		System.out.println(findCurrentWeek(7));

		System.out.println(findCurrentWeek(10));
		
		System.out.println(getDate());
		
		for (int i=0;i<40;i++)
			goTomorrow();
		
		System.out.println(getDate());
	}

}
