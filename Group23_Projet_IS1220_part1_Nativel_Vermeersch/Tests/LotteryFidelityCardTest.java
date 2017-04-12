package Tests;

import java.util.ArrayList;
import java.util.HashMap;

import Fidelity.FidelityCard;
import Fidelity.LotteryFidelityCard;
import Food.DishType;
import Food.Food;
import Food.Starter;
import Main.ConfigInitiale;
import Main.MyFoodora;
import Users.Customer;
import Users.Restaurant;
import junit.framework.TestCase;

public class LotteryFidelityCardTest extends TestCase {
	private MyFoodora system = MyFoodora.getInstance();
	
	/**
	 * on vérifie que si la probabilité de la lottery card est fixée à 1, alors le client a bien 100% de chance d'avoir son repas gratuit
	 */
	public void testUseCard(){
		ConfigInitiale.launch();
		Customer c1 = system.getCustomersList().get("jdegardin");
		Restaurant r1 = system.getRestaurantsList().get("asiat");
		LotteryFidelityCard fc = new LotteryFidelityCard(r1, c1);
		fc.setProbability(1);
		HashMap<Restaurant,FidelityCard> hm = new HashMap<>();
		hm.put(r1, fc);
		c1.setFidelityCardList(hm);
		Starter s1 = new Starter(5,"nem",DishType.Standard);
		ArrayList<Food> content = new ArrayList<>();
		content.add(s1);
		c1.order(content, r1);
		c1.order(content, r1);
		assertTrue(c1.getOrdersList().get(1).getPrice()==0);
	}
}
