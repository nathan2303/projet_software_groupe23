package Policies;

import java.util.ArrayList;
import java.util.HashMap;

import Food.Food;
import Food.HalfMeal;
import Food.Order;
import Main.ConfigInitiale;
import Main.MyFoodora;
import Users.Restaurant;

public class MostOrderedHalfMeal implements ShippedOrderSortingPolicy {
	
	private MyFoodora system = MyFoodora.getInstance();
	
	
	
	public MostOrderedHalfMeal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * returns a hashmap with the items associated to the number of times they have been ordered
	 */
	@Override
	public HashMap<Food, Integer> sortOrders(ArrayList<Order> orders){
		HashMap<Food,Integer> res = new HashMap<>();
		for (Order o : orders){
			ArrayList<Food> list = o.getContent();
			for (Food food : list){
				System.out.println(res);
				System.out.println(food);
				if (food instanceof HalfMeal){
					if (res.containsKey(food)){
						res.put(food, res.get(food) + 1);
					}
					else
						res.put(food, 1);
				}
			}			
		}
		return res;
	}

	public static void main(String[] args) {
		ConfigInitiale.launch();
		MyFoodora system = MyFoodora.getInstance();
		Restaurant r = system.getRestaurantsList().get("delice");
		r.sortOrders(new MostOrderedItem());
		
	}
}