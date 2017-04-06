package Food;

import junit.framework.TestCase;

import java.util.ArrayList;

import Food.FullMeal;
import Food.InvalidFullMealException;



public class InvalidFullMealExceptionTest extends TestCase {
	public void TestException(){
		Dish s1 = new Starter(5, "saumon fumé", DishType.Standard);
		MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		MainDish md2 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		ArrayList<Dish> dishes = new ArrayList<Dish>();
		dishes.add(s1);
		dishes.add(md1);
		dishes.add(md2);
		
		try {FullMeal meal = new FullMeal("menu1", dishes);}
		catch (InvalidFullMealException e) {
			
			
			assertTrue(e.getMessage().contains("A full meal must contain a starter, a main-dish and a dessert."));
		}
	}

}
