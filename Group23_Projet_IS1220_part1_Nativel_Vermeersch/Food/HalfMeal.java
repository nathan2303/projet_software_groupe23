package Food;

import java.util.ArrayList;

/** half meal
 * 
 * @author natha
 *
 */

public class HalfMeal extends Meal {
	
	/**
	 * half meal, throws InvalidHalfMealException if not a proper HalfMeal
	 * @param name
	 * @param dishes
	 * @throws InvalidHalfMealException
	 */

	public HalfMeal(String name, ArrayList<Dish> dishes) throws InvalidHalfMealException {
		super(name, dishes);
		checkHalfMeal(dishes);
		// TODO Auto-generated constructor stub
	}
	
	/** checks there are either one starter and one maindish, or one maindish and one dessert, throws Exception if not
	 * 
	 * @param dishes
	 * @throws InvalidFullMealException
	 */
	private void checkHalfMeal(ArrayList<Dish> dishes) throws InvalidHalfMealException {
		int starterCounter=0;
		int maindishCounter=0;
		int dessertCounter=0;
		for (Dish d : dishes){
			if (d instanceof Starter)
				starterCounter++;
			if (d instanceof MainDish)
				maindishCounter++;
			if (d instanceof Dessert)
				dessertCounter++;
		}
		if (!(starterCounter == 1 && maindishCounter == 1) && !(maindishCounter == 1 && dessertCounter == 1))
			throw new InvalidHalfMealException();
	}
	
	
}