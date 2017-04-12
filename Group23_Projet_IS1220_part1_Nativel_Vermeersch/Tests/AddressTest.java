package Tests;

import Users.Address;
import junit.framework.TestCase;

public class AddressTest extends TestCase {

	public void testGetDistanceTo() {
		double x = 3.0;
		double y = 4.0;
		Address address = new Address(x,y);
		Address address2 = new Address(0.0,0.0);
		assertTrue(address.getDistanceTo(address2) == 5.0);
		
	}

}
