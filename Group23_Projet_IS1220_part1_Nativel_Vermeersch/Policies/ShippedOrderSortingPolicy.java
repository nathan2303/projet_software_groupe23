package Policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import Food.Food;
import Food.Order;

public interface ShippedOrderSortingPolicy {
	
	public HashMap<Food, Integer> sortOrders(ArrayList<Order> orders);
}