package Policies;

import java.util.ArrayList;
import java.util.TreeMap;

import Food.Dish;
import Food.Food;
import Food.Order;

public class MostOrderedItem implements ShippedOrderSortingPolicy {

	public MostOrderedItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public TreeMap<Food, Integer> sortOrders(ArrayList<Order> orders){
		TreeMap<Food,Integer> res = new TreeMap<>();
		for (Order o : orders){
			ArrayList<Food> list = o.getContent();
			for (Food food : list){
				if (food instanceof Dish){
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