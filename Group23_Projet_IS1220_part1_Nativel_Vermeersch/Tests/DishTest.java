package Tests;

import Food.Dish;
import Food.DishType;
import Food.MainDish;
import Users.Address;
import Users.Restaurant;
import junit.framework.TestCase;

public class DishTest extends TestCase {

	public void testAccept() {
		Dish Dish1 = new MainDish(1.0, "Spaghettis",DishType.Standard);
		Restaurant r1 = new Restaurant("Chez Charbel", "charb", "0000", new Address(4000,5000));
		
		assertTrue(Dish1.accept(r1) == 1.0);

	}

	public void testDish() {
		Dish Dish1 = new MainDish(1.0, "Spagettis",DishType.Standard);
		assertTrue(Dish1.getDishType() == DishType.Standard);
		assertTrue(Dish1.getPrice() == 1.000);
		assertTrue(Dish1.getName() == "Spagettis");
		
	}

	public void testGetDishType() {
		Dish Dish1 = new MainDish(1.0, "Spagettis",DishType.Standard);
		assertTrue(Dish1.getDishType() == DishType.Standard);
	}

	public void testSetDishType() {
		Dish Dish1 = new MainDish(1.0, "Spagettis",DishType.Standard);
		Dish1.setDishType(DishType.GlutenFree);
		assertTrue(Dish1.getDishType() == DishType.GlutenFree);
		
	}

}
