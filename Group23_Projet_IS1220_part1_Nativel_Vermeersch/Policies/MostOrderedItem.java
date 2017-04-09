package Policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import Food.Dish;
import Food.Food;
import Food.Order;

public class MostOrderedItem implements ShippedOrderSortingPolicy {

	public MostOrderedItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * Renvoie le nombre de fois que chaque plat a été commandé
	 * (je ne l'ai pas testé sachant que cette fonction est identique à mostorderedhalfmeal)
	 * @see Policies.ShippedOrderSortingPolicy#sortOrders(java.util.ArrayList)
	 */
	@Override
	public HashMap<Food, Integer> sortOrders(ArrayList<Order> orders){
		HashMap<Food,Integer> res = new HashMap<>();
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