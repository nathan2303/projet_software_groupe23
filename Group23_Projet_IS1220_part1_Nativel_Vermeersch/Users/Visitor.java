package Users;
import Food.Dish;
import Food.Meal;

public interface Visitor {

  public double visit(Dish d);

  public double visit(Meal m);

}