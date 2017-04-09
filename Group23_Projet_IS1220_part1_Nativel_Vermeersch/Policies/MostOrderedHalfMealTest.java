package Policies;

import java.util.ArrayList;

import Food.Dessert;
import Food.Dish;
import Food.DishType;
import Food.Food;
import Food.FullMeal;
import Food.HalfMeal;
import Food.InvalidHalfMealException;
import Food.MainDish;
import Food.Meal;
import Food.Order;
import Food.Starter;
import Main.ConfigInitiale;
import Main.MyFoodora;
import junit.framework.TestCase;

public class MostOrderedHalfMealTest extends TestCase {

	public void testSortOrders() throws InvalidHalfMealException {
		MyFoodora system = MyFoodora.getInstance();
		ConfigInitiale.launch();
		Starter s1 = new Starter(5, "saumon fumé", DishType.Standard);
		MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		Dessert d1 = new Dessert(6, "tiramisu", DishType.Vegetarian);
		Meal m1 = new FullMeal("menu classique", s1, md1, d1);
		ArrayList<Dish> l1 = new ArrayList<Dish>();
		ArrayList<Dish> l2 = new ArrayList<Dish>();
		l1.add(d1);
		l1.add(md1);
		l2.add(md1);
		l2.add(s1);
		HalfMeal h1 = new HalfMeal(l1);
		HalfMeal h2 = new HalfMeal(l2);
		ArrayList<Food> or1 = new ArrayList<Food>();
		or1.add(h1);
		ArrayList<Food> or2 = new ArrayList<Food>();
		or2.add(h2);
		
		Order o1 = new Order();
		o1.setContent(or1);
		Order o2 =new Order();
		o2.setContent(or2);
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(o1);
		orders.add(o2);
		orders.add(o1);
		MostOrderedHalfMeal mohm = new MostOrderedHalfMeal();
		mohm.sortOrders(orders);
		System.out.println("on est arriv� avant derniere ligne");
		assertTrue(mohm.sortOrders(orders).get(h1) == 2);
		
	}

}
