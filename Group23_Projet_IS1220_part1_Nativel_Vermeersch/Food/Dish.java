package Food;

import Users.Visitor;

/** a dish is either a starter, a main dish or a dessert
 * 
 * @author natha
 *
 */

public abstract class Dish extends Food {

  protected DishType dishType;
  

  public Dish(double price, String name, DishType dishType) {
	  super.price=price;
	  super.name=name;
	  this.dishType=dishType;

}

public DishType getDishType() {
	return dishType;
}

public void setDishType(DishType dishType) {
	this.dishType = dishType;
}

/** computes the price of the dish in the Restaurant v (according to the Visitor pattern)
   * @param v the Restaurant which has specific discount factors
   * @return the price of the dish in the Restaurant v
   */
  public double accept(Visitor v){
	  return v.visit(this);
  }
  
  public String toString(){
	  return this.name + " (" + this.dishType + ")";
  }

}