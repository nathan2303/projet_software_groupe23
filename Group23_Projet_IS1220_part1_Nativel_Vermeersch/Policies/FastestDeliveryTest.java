package Policies;

import java.util.ArrayList;

import Food.Dish;
import Food.Food;
import Food.Order;
import Main.ConfigInitiale;
import Main.MyFoodora;
import Users.Address;
import Users.Courier;
import Users.Customer;
import Users.Restaurant;
import junit.framework.TestCase;

public class FastestDeliveryTest extends TestCase {
/*
 * Le courier larbin2 est plus proche du restaurant il doit donc être choisi par la policy
 */
	public void testFindCourier() {
		ConfigInitiale.launch();
		MyFoodora system =MyFoodora.getInstance();
		Restaurant r1 = system.getRestaurantsList().get("charb");
		Customer c1 = system.getCustomersList().get("nver");
		Courier larbin2 = new Courier("jean","dupont","jpont","password", new Address(10,10),"phone");
		system.addUser(larbin2);
		ArrayList<Food> list  = new ArrayList<Food>();
		for( Dish d: r1.getDishes()){ list.add(d);}
		Order o = new Order(c1, r1, list);
		FastestDelivery f = new FastestDelivery();
		
		assertTrue(f.findCourier(o) == larbin2);
	}

}
