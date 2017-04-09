package Main;

import java.util.HashMap;

/**
 * the class for setting and getting the date. Begins on Saturday 1st April 2017.
 * We consider that all months have 30 days (for the sake of simplicity)
 * @author natha
 *
 */

public class Date implements Comparable<Date> {
	
	private int day;
	private int week;
	private int month;
	private String dayName;
	private String monthName;
	private int year;
	private int nonStaticCounter;
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
	 * without arguments, the Date is the current Date at the moment you construct the instance
	 */
	public Date() {
		this.day=currentDay;
		this.week=currentWeek;
		this.dayName=currentDayName;
		this.month=currentMonth;
		this.monthName=currentMonthName;
		this.nonStaticCounter=counter;
		// TODO Auto-generated constructor stub
	}
	
	
	public Date(int day, int month){
		this.day=day;
		this.month=month;
		this.nonStaticCounter=findCounter(day, month);
		this.dayName=findCurrentDayName(nonStaticCounter);
		this.monthName=findCurrentMonthName(nonStaticCounter);
		this.week=findCurrentWeek(nonStaticCounter);
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
	/**
	 * advance of a number of days (static)
	 * @param numberOfDays
	 */
	public static void advanceInTime(int numberOfDays){
		counter+=numberOfDays;
		currentDay=findCurrentDay(counter);
		currentDayName=findCurrentDayName(counter);
		currentWeek=findCurrentWeek(counter);
		currentMonth=findCurrentMonth(counter);
		currentMonthName=findCurrentMonthName(currentMonth);
	}
	
	public int findCounter(int day, int month){
		switch (month){
		case 3 :
			return(-31+day);
		case 4 :
			return(day);
		case 5 :
			return(30+day);
		case 6 :
			return(61+day);
		case 7 :
			return(61+30+day);
		case 8 :
			return(91+31+day);
		case 9 :
			return(122+31+day);
		case 10 :
			return(153+30+day);
		case 11 :
			return(183+31+day);
		case 12 :
			return(214+30+day);
		}
		return(0);
	}
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getDayName() {
		return dayName;
	}

	public void setDayName(String dayName) {
		this.dayName = dayName;
	}

	public String getMonthName() {
		return monthName;
	}

	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Date.counter = counter;
		currentDay=findCurrentDay(counter);
		currentDayName=findCurrentDayName(counter);
		currentWeek=findCurrentWeek(counter);
		currentMonth=findCurrentMonth(counter);
		currentMonthName=findCurrentMonthName(currentMonth);
	}

	public static int getCurrentMonth() {
		return currentMonth;
	}

	public static void setCurrentMonth(int currentMonth) {
		Date.currentMonth = currentMonth;
	}

	public static String getCurrentMonthName() {
		return currentMonthName;
	}

	public static void setCurrentMonthName(String currentMonthName) {
		Date.currentMonthName = currentMonthName;
	}

	public static int getCurrentYear() {
		return currentYear;
	}

	public static void setCurrentYear(int currentYear) {
		Date.currentYear = currentYear;
	}

	public int getNonStaticCounter() {
		return nonStaticCounter;
	}

	public void setNonStaticCounter(int nonStaticCounter) {
		this.nonStaticCounter = nonStaticCounter;
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
		if (n<=0)
			return n+31;
		if (n<=30)
			return n;
		if (n<=61)
			return n-30;
		if (n<=61+30)
			return n-61;
		if (n<=91+31)
			return n-91;
		if (n<=122+31)
			return n-122;
		if (n<=153+30)
			return n-153;
		if (n<=183+31)
			return n-153;
		if (n<=214+30)
			return n-214;
		if (n<=244+31)
			return n-244;
		else{
			int x = n%30;
			return((x==0) ? 30 : x);}
	}
	

	/**
	 * converts a number (the number of days starting from 1st April 2017) into a day name
	 * @param n
	 * @return day name (Monday...)
	 */
	private static String findCurrentDayName(int n){
		if (n%7<0)
			return dayNames.get(n%7+7);
		return dayNames.get(n%7);
			
	}
	
	/**
	 * converts the day counter into a month
	 * @param n
	 * @return a month (int)
	 */
	private static int findCurrentMonth(int n){
		if (n<=0)
			return 3;
		if (n<=30)
			return 4;
		if (n<=61)
			return 5;
		if (n<=61+30)
			return 6;
		if (n<=91+31)
			return 7;
		if (n<=122+31)
			return 8;
		if (n<=153+30)
			return 9;
		if (n<=183+31)
			return 10;
		if (n<=214+30)
			return 11;
		if (n<=244+31)
			return 12;
		else
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
	
	public static void setCurrentDate(int number, int month){
		currentDay=number;
		currentDayName=findCurrentDayName(currentDay);
		currentWeek=findCurrentWeek(currentDay);
		
	}
	
	
	@Override
	public String toString() {
		return this.dayName + " " + this.day + " " + this.monthName + " 2017";
	}

	public static String getCurrentDate(){
		return currentDayName + " " + currentDay + " " + currentMonthName + " 2017";
	}
	
	public static void main(String[] args) {

		System.out.println(findCurrentWeek(2));

		System.out.println(findCurrentWeek(7));

		System.out.println(findCurrentWeek(10));
		
		System.out.println(getCurrentDate());
		
		for (int i=0;i<40;i++)
			goTomorrow();
		
		System.out.println(getCurrentDate());
		
	}
	
	public int compareTo(Date date){
		int compareQuantity = date.getNonStaticCounter();
		
		return this.nonStaticCounter - compareQuantity;
	}

}
