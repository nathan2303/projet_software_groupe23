package Policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import Food.Food;
import Food.HalfMeal;
import Food.Order;

public class MostOrderedHalfMeal implements ShippedOrderSortingPolicy {
	
	
	
	
	public MostOrderedHalfMeal() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public HashMap<Food, Integer> sortOrders(ArrayList<Order> orders){
		HashMap<Food,Integer> res = new HashMap<>();
		for (Order o : orders){
			ArrayList<Food> list = o.getContent();
			
			for (Food food : list){
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
}