package Fidelity;

import java.util.ArrayList;

import Food.DishType;
import Food.Food;
import Food.Starter;
import Main.ConfigInitiale;
import Main.MyFoodora;
import Users.Customer;
import Users.Restaurant;
import junit.framework.TestCase;

public class PointFidelityCardTest extends TestCase {
	private MyFoodora system = MyFoodora.getInstance();
	
	public void testUseCard(){
		ConfigInitiale.launch();
		Customer c1 = system.getCustomersList().get("jdegardin");

		Restaurant r1 = system.getRestaurantsList().get("asiat");
		c1.registerPointFidelityCard(r1);
		Starter s1 = new Starter(1010,"nem",DishType.Standard);
		ArrayList<Food> content = new ArrayList<>();
		content.add(s1);
		c1.order(content, r1);
		c1.order(content, r1);
		assertTrue(c1.getOrdersList().get(1).getPrice()==909);
	}
}
