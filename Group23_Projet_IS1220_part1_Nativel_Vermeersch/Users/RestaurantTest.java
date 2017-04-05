package Users;

import java.util.ArrayList;

import Food.Dessert;
import Food.DishType;
import Food.FullMeal;
import Food.MainDish;
import Food.Meal;
import Food.Starter;
import junit.framework.TestCase;

public class RestaurantTest extends TestCase {

	public void testVisitMeal() {
		Restaurant r1 = new Restaurant("Chez Charbel", "charb", "0000", new Address(4000,5000));
		Starter s1 = new Starter(5, "saumon fumé", DishType.Standard);
		MainDish md1 = new MainDish(10, "pizza végétarienne", DishType.Vegetarian);
		Dessert d1 = new Dessert(6, "tiramisu", DishType.Vegetarian);
		Meal m1 = new FullMeal("menu classique", s1, md1, d1);
		r1.setGenericDiscountFactor(0.5);
		r1.setSpecialDiscountFactor(0.1);
		assertTrue(r1.visit(m1)==10.5);
		ArrayList<Meal> weekpromotion = new ArrayList<Meal>();
		weekpromotion.add(m1);
		
		r1.setMealsOfTheWeek(weekpromotion);
		System.out.println(r1.visit(m1));
	}

}
