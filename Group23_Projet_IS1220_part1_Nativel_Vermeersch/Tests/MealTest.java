package Tests;

import java.util.ArrayList;

import Food.Dessert;
import Food.Dish;
import Food.DishType;
import Food.FullMeal;
import Food.MainDish;
import Food.Meal;
import Food.Starter;
import junit.framework.TestCase;

public class MealTest extends TestCase {

	public void testMeal() {
		Starter s1 = new Starter(5, "saumon fumé", DishType.Standard);
		MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		Dessert d1 = new Dessert(6, "tiramisu", DishType.Vegetarian);
		Meal m1 = new FullMeal("menu classique", s1, md1, d1);
		assertTrue(m1.getName() == "menu classique");
		System.out.println(m1.getDishes());
		ArrayList<Dish> menutest = new ArrayList<Dish>();
		assertTrue(true);
		
		
	}

	public void testMealArrayListOfDish() {
		fail("Not yet implemented");
	}

	public void testMealStringArrayListOfDish() {
		fail("Not yet implemented");
	}

	public void testFindMealType() {
		Starter s1 = new Starter(5, "saumon fumé", DishType.Standard);
		MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		Dessert d1 = new Dessert(6, "tiramisu", DishType.Vegetarian);
		Meal m1 = new FullMeal("menu classique", s1, md1, d1);
		assertTrue(m1.findMealType(m1.getDishes()) == DishType.Standard);
	}

	public void testComputeMealPrice() {
		Starter s1 = new Starter(5, "saumon fumé", DishType.Standard);
		MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		Dessert d1 = new Dessert(6, "tiramisu", DishType.Vegetarian);
		Meal m1 = new FullMeal("menu classique", s1, md1, d1);
		assertTrue( m1.computeMealPrice(m1.getDishes()) ==21);
		
	}

}
