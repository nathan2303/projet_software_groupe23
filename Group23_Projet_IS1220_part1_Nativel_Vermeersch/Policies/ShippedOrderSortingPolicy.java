package Policies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import Food.Food;
import Food.Order;

public interface ShippedOrderSortingPolicy {
	
	public HashMap<Food, Integer> sortOrders(ArrayList<Order> orders);
	
	
	/**
	 * returns the sorted ArrayList of orders
	 * @param orders
	 * @return
	 */
	public default ArrayList<Food> sortOrders2(ArrayList<Order> orders){
		HashMap<Food,Integer> res = this.sortOrders(orders);
		ArrayList<Food> res2 = new ArrayList<Food>(res.keySet());
		Collections.sort(res2, new Comparator<Food>(){
			public int compare(Food f1, Food f2){
				return res.get(f1)-res.get(f2);
			}
			});
		return res2;
	}
}