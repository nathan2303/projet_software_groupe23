package Tests;

import java.util.ArrayList;
import java.util.List;

import Food.DishType;
import Food.Food;
import Food.Starter;
import Main.ConfigInitiale;
import Main.MyFoodora;
import Users.Customer;
import Users.Restaurant;
import junit.framework.TestCase;

public class BasicFidelityCardTest extends TestCase {
	
	private MyFoodora system = MyFoodora.getInstance();
	
	/**
	 * on v�rifie que la carte ne change pas le prix initial du nem (5�)
	 */
	public void testUseCard(){
		ConfigInitiale.launch();
		Customer c1 = system.getCustomersList().get("jdegardin");
		Restaurant r1 = system.getRestaurantsList().get("asiat");
		Starter s1 = new Starter(5,"nem",DishType.Standard);
		ArrayList<Food> content = new ArrayList<>();
		content.add(s1);
		c1.order(content, r1);
		assertTrue(c1.getOrdersList().get(0).getPrice()==5);
	}

}
