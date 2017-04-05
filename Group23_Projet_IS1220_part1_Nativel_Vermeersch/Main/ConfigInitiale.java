package Main;

import java.util.ArrayList;

import Food.Dessert;
import Food.Dish;
import Food.DishType;
import Food.Food;
import Food.FullMeal;
import Food.MainDish;
import Food.Meal;
import Food.Starter;
import Policies.FastestDelivery;
import Users.Address;
import Users.Courier;
import Users.Customer;
import Users.Restaurant;

public class ConfigInitiale  {
	MyFoodora system = MyFoodora.getInstance();
	Courier c = new Courier("larbin","larb","AZERTY",new Address(3,2),"000");
//	system.addUser(c)
//  system.setDeliveryPolicy(new FastestDelivery())
	Starter s1 = new Starter(5, "saumon fumé", DishType.Standard);
	MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
	Dessert d1 = new Dessert(6, "tiramisu", DishType.Vegetarian);
	Meal m1 = new FullMeal("menu classique", s1, md1, d1);
	ArrayList<Food> list = new ArrayList<>();
//	list.add(m1)
	Customer c1 = new Customer("Nathan", "Vermeersch", "nver", "1234", new Address(0, 0), "nv@gmail.com", "0000");
	
	Restaurant r1 = new Restaurant("Chez Charbel", "charb", "0000", new Address(4000,5000));

}
