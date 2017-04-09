package Users;


import java.util.ArrayList;

import Food.Dish;
import Food.Food;
import Food.Order;
import Main.ConfigInitiale;
import Main.MyFoodora;
import junit.framework.TestCase;
public class CustomerTest extends TestCase {
/**
 * Pour tester order, je regarde si la commande est bien ajoutée au système
 */
	public void testOrder() {
		ConfigInitiale.launch();
		MyFoodora system=MyFoodora.getInstance();
		Customer c1 = system.getCustomersList().get("nver");
		//System.out.println(system.getRestaurantsList().get("charb").getDishes());
		ArrayList<Food> commande = new ArrayList<Food>() ;
		for (Dish d : system.getRestaurantsList().get("charb").getDishes()){
			commande.add(d);
			
		}
		System.out.println(commande);
		c1.order(commande,system.getRestaurantsList().get("charb"));
		boolean bool = false;
		for (Order o : system.getCompletedOrders()){
			if (o.getCustomer() == c1){
				bool = true;
				}
			}
		assertTrue(bool);
	}

	public void testAddOrder() {
		fail("Not yet implemented");
	}

	public void testUpdate() {
		ConfigInitiale.launch();
		MyFoodora system=MyFoodora.getInstance();
		Customer c1 = system.getCustomersList().get("nver");
		Restaurant r1 = system.getRestaurantsList().get("charb");
		c1.registerNotifications(r1);
		c1.update(r1);
		
		
	}

}
