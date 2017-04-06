package Users;

import Food.Order;
import Main.MyFoodora;
import junit.framework.TestCase;
import Users.User;
public class CourierTest extends TestCase {



	public void testCompleteOrder() {
		Order o = new Order();
		Customer c = new Customer("name","surname", "id", "password", new Address(0.0,0.0), "phonenumber", "laststring");
		Courier  cour = new Courier();
		o.setCustomer(c);
		o.setCourier(cour);
		cour.completeOrder(o);
		assertTrue(cour.getPosition().equals( new Address(0.0,0.0)));
		
	}

	public void TestsetOnDuty() {
		MyFoodora system = MyFoodora.getInstance();
		Courier  cour = new Courier();
		cour.setOnDuty(true);
		assertTrue(cour.isOnDuty() == true);
		assertTrue(system.getOnDutyCouriersList().contains(cour));
		
	}
	
	

}
