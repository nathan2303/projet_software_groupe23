package Main;

import java.util.ArrayList;

import Food.Dessert;
import Food.Dish;
import Food.DishType;
import Food.Food;
import Food.FullMeal;
import Food.MainDish;
import Food.Meal;
import Food.Order;
import Food.Starter;
import Policies.FastestDelivery;
import Users.Address;
import Users.Courier;
import Users.Customer;
import Users.Manager;
import Users.Restaurant;
import Users.Manager;
public class ConfigInitiale  {
	
	
	private static MyFoodora system = MyFoodora.getInstance();
	
	public ConfigInitiale(){
		
	}
	
	
	public static void launch(){
		Courier c = new Courier("larbin","larb","AZERTY",new Address(3,2),"000");
//		system.addUser(c)
	//  system.setDeliveryPolicy(new FastestDelivery())
		Starter s1 = new Starter(5, "saumon fumé", DishType.Standard);
		MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		Dessert d1 = new Dessert(6, "tiramisu", DishType.Vegetarian);
		Meal m1 = new FullMeal("menu classique", s1, md1, d1);
		ArrayList<Dish> list = new ArrayList<Dish>();
		list.add(s1);
		list.add(md1);
		list.add(d1);
		system.setDeliveryPolicy(new FastestDelivery());
		Customer c1 = new Customer("Nathan", "Vermeersch", "nver", "1234", new Address(0, 0), "nv@gmail.com", "0000");
		Manager mana1 = new Manager("michou", "le forain", "michou", "password");
		Restaurant r1 = new Restaurant("Chez Charbel", "charb", "0000", new Address(4000,5000));
		system.addUser(c1);
		system.addUser(r1);
		system.addUser(c);
		system.addUser(mana1);;
		
		ArrayList<Food> commande = new ArrayList<Food>() ;
		for (Dish d : system.getRestaurantsList().get("charb").getDishes()){
			commande.add(d);}
		Order o = new Order(c1,r1,commande);
		system.addOrder(o);
		
		
		c1.order(commande, r1);
		r1.addDish(list);
		r1.addMeal(m1);
		
		
	}

}
