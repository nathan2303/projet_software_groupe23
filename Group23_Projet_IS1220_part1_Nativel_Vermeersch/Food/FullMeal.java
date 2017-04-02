package Food;

import java.util.ArrayList;

import sun.security.krb5.internal.crypto.Des;

public class FullMeal extends Meal {

	/**
	 * full meal, throws {@link InvalidFullMealException} if not a proper full meal
	 * @param name
	 * @param dishes
	 * @throws InvalidFullMealException
	 */
	public FullMeal(String name, ArrayList<Dish> dishes) throws InvalidFullMealException{
		super(name, dishes);
		checkFullMeal(dishes);
		// TODO Auto-generated constructor stub
	}
	
	/** checks there are one starter, one maindish and one dessert, throws Exception if not
	 * 
	 * @param dishes
	 * @throws InvalidFullMealException
	 */
	private void checkFullMeal(ArrayList<Dish> dishes) throws InvalidFullMealException {
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
		if (starterCounter != 1 || maindishCounter != 1 || dessertCounter != 1 )
			throw new InvalidFullMealException();
	}
	
}