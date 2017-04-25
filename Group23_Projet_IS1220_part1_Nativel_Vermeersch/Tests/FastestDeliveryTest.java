package Tests;

import java.util.ArrayList;
import java.util.HashMap;

import Food.Dish;
import Food.Food;
import Food.Order;
import Main.ConfigInitiale;
import Main.MyFoodora;
import Policies.FastestDelivery;
import Users.Address;
import Users.Courier;
import Users.Customer;
import Users.Restaurant;
import junit.framework.TestCase;

public class FastestDeliveryTest extends TestCase {
/*
 * Le courier larbin1 est plus proche du restaurant il doit donc être choisi par la policy
 */
	public void testFindCourier() {
		ConfigInitiale.launch();
		MyFoodora system =MyFoodora.getInstance();
		Restaurant r1 = new Restaurant("Chez Martin", "martin", "1234", new Address(0,0));
		Customer c1 = system.getCustomersList().get("ddescamps");
		Courier larbin1 = new Courier("jeanne","dupond","jpond","password", new Address(5,5),"phone");
		Courier larbin2 = new Courier("jean","dupont","jpont","password", new Address(10,10),"phone");
		system.addUser(larbin2);
		HashMap<String,Courier> hm = new HashMap<String, Courier>();
		hm.put(larbin1.getName(),larbin1);
		hm.put(larbin2.getName(),larbin2);
		system.setOnDutyCouriersList(new ArrayList(hm.values()));
		System.out.println(system.getCouriersList());
		ArrayList<Food> list  = new ArrayList<Food>();
		for( Dish d: r1.getDishes()){ list.add(d);}
		Order o = new Order(c1, r1, list);
		FastestDelivery f = new FastestDelivery();
		System.out.println(f.findCourier(o));
		assertTrue(f.findCourier(o) == larbin1);
	}

}

