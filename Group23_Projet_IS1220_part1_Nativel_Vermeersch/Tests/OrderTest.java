package Tests;

import java.util.ArrayList;

import Main.ConfigInitiale;
import Main.MyFoodora;
import Users.Address;
import Users.Courier;
import Users.Customer;
import Users.Restaurant;
import junit.framework.TestCase;
import Food.Dish;
import Food.Food;
import Food.Order;
public class OrderTest extends TestCase {


	


	/*
	 * test si la fonctionne renvoie bien un double
	 */
	public void testComputeOrderPrice() {
		ConfigInitiale.launch();
		MyFoodora system=MyFoodora.getInstance();
		Restaurant r1 = system.getRestaurantsList().get("charb");
		ArrayList<Food> list  = new ArrayList<Food>();
		Order o = new Order();
		o.setRestaurant(r1);
		for( Dish d: r1.getDishes()){ list.add(d);}
		System.out.println( o.computeOrderPrice(list));
		
	}
	/*
	 * teste si la fonction renvoie bien le seul courier existant larbin
	 */
	public void testFindCourier() {
		ConfigInitiale.launch();
		MyFoodora system=MyFoodora.getInstance();
		Order o = new Order();
		Restaurant r1 = system.getRestaurantsList().get("charb");
		Customer c1 = system.getCustomersList().get("nver");
		o.setRestaurant(r1);
		o.setCustomer(c1);
	
		
		assertTrue(o.findCourier().getName() == "larbin");
	}

}
