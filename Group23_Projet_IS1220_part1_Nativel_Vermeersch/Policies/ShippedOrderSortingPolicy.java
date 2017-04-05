package Policies;

import java.util.ArrayList;
import java.util.TreeMap;

import Food.Food;
import Food.Order;

public interface ShippedOrderSortingPolicy {
	
	public TreeMap<Food, Integer> sortOrders(ArrayList<Order> orders);
}