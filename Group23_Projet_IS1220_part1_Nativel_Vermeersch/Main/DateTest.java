package Main;

import junit.framework.TestCase;

public class DateTest extends TestCase {

	public void testGoTomorrow() {
		Date date = new Date();
		int a = date.getNonStaticCounter();
		date.goTomorrow();
		
		
				
		assertTrue(a + 1 == date.getNonStaticCounter());
	}

	public void testAdvanceInTime() {
		fail("Not yet implemented");
	}

	public void testGetCurrentDay() {
		fail("Not yet implemented");
	}

	public void testGetCurrentDayName() {
		fail("Not yet implemented");
	}

	public void testGetCurrentDate() {
		fail("Not yet implemented");
	}

	public void testMain() {
		fail("Not yet implemented");
	}

}
