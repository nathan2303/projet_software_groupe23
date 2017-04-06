package Main;

import java.util.ArrayList;

import Food.Dessert;
import Food.DishType;
import Food.Food;
import Food.FullMeal;
import Food.MainDish;
import Food.Meal;
import Food.Starter;
import Users.Address;
import Users.Courier;
import Users.Customer;
import Users.Restaurant;
import Users.User;

public class ConfigInitiale  {
	
	
	private static MyFoodora system = MyFoodora.getInstance();
	
	public ConfigInitiale(){
		
	}
	
	
	public static void launch(){
		Courier c = new Courier("larbin","Monsieur","larb","AZERTY",new Address(3,2),"000");
//		system.addUser(c)
	//  system.setDeliveryPolicy(new FastestDelivery())
		Starter s1 = new Starter(5, "saumon fumé", DishType.Standard);
		MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		Dessert d1 = new Dessert(6, "tiramisu", DishType.Vegetarian);
		Meal m1 = new FullMeal("menu classique", s1, md1, d1);
		ArrayList<Food> list = new ArrayList<>();
//		list.add(m1)
		Customer c1 = new Customer("Nathan", "Vermeersch", "nver", "1234", new Address(0, 0), "nv@gmail.com", "0000");
		
		Restaurant r1 = new Restaurant("Chez Charbel", "charb", "0000", new Address(4000,5000));
		system.addUser(c1);
		system.addUser(r1);
		

		
	}
	public static void main(String[] args) {
		User c1 = new Customer("Nathan", "Vermeersch", "nver", "1234", new Address(0, 0), "nv@gmail.com", "0000");
		MyFoodora system = MyFoodora.getInstance();
		system.addUser(c1);
		System.out.println(c1.getClass()==Users.Customer.class);
	}

}
