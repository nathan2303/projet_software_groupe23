package Food;
import java.util.ArrayList;

import Users.Visitor;

public abstract class Meal extends Food {
	

  protected ArrayList<Dish> dishes;

  protected DishType mealType;
  
  public Meal(){
	  
  }
  
  public Meal(ArrayList<Dish> dishes){
	  super.name = dishes.toString();
	  this.dishes=dishes;
	  super.price=computeMealPrice(this.dishes);
	  this.mealType=findMealType(this.dishes);
  }
  
  public Meal(String name, ArrayList<Dish> dishes){
	  super.name = name;
	  this.dishes=dishes;
	  super.price = computeMealPrice(this.dishes);
	  this.mealType = findMealType(this.dishes);
  }
  
  /**
   * finds the type of the meal: to be vegetarian, all dishes of a meal must be vegetarian, etc.
   * if no common specificity returns standard
   * @param dishes
   * @return the type of the meal (enum DishType)
   */
  
  protected DishType findMealType(ArrayList<Dish> dishes){
	  boolean isVegetarian = true;
	  boolean isGlutenFree = true;
	  boolean isBoth = true;
	  for (Dish dish : this.dishes){
		  DishType x = dish.getDishType();
		  if(isVegetarian == true && x!=DishType.Vegetarian){
			  isVegetarian = false;
		  }
		  if(isGlutenFree == true && x!=DishType.GlutenFree){
			  isGlutenFree = false;
		  }
		  if(isBoth == true && x!=DishType.VegetarianAndGlutenFree){
			  isBoth = false;
		  }
	  }
	  if (isVegetarian){
		  return DishType.Vegetarian;
	  }
	  if (isGlutenFree){
		  return DishType.GlutenFree;
	  }
	  if (isBoth){
		  return DishType.VegetarianAndGlutenFree;
	  }
	  if(!isVegetarian && !isGlutenFree && !isBoth){
		  return DishType.Standard;
	  }
	  return DishType.Standard;
	  
  }
  
  /**
   * 
   * @param dishes
   * @return simply the sum of the prices of the dishes contained in the meal (no reduction yet)
   */
  protected double computeMealPrice(ArrayList<Dish> dishes){
	  double res = 0;
	  for (Dish d : dishes){
		  System.out.println("loop for in computeMealPrice");
		  System.out.println("res= "+res);
		  res+=d.getPrice();
	  }
	  return res;
  }
  
  
  public double accept(Visitor v){
	  return v.visit(this);
  }
  
  
  



}