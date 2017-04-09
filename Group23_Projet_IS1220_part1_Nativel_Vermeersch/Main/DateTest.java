package Main;

import junit.framework.TestCase;

public class DateTest extends TestCase {

	public void testGoTomorrow() {
		Date date = new Date();
		int a = date.getNonStaticCounter();
		date.goTomorrow();
		assertTrue( date.getNonStaticCounter() == a+1);
		
				
	}
	public void testCompareTo(){
	
		Date d1 = new Date(1, Date.getCurrentMonth());
		Date d2 = new Date(2,Date.getCurrentMonth());
		assertTrue(d1.compareTo(d2) < 0);
	}
	}

