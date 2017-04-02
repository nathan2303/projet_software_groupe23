package Users;
import Food.Dish;
import Food.Meal;
import Food.Order;
import java.util.ArrayList;
import Users.Observable;

public class Restaurant extends User implements Visitor, Observable {

  private Address address;

  private ArrayList<Dish> dishes = new ArrayList<Dish>();

  private ArrayList<Meal> meals = new ArrayList<Meal>();

  private double genericDiscountFactor = 0.05;

  private double specialDiscountFactor = 0.1;

  private ArrayList<Order> shippedOrders = new ArrayList<Order>();

  private String name;

  private ArrayList<Meal> mealsOfTheWeek = new ArrayList<Meal>();
  
  private ArrayList<Observer> registeredCustomersForNotifications = new ArrayList<Observer>();
  
  
  public Restaurant(){
	  super();
  }
  
  

  public Restaurant(String name, String username, String password, Address address) {
	super(username, password);
	this.name = name;
	this.address = address;
	// TODO Auto-generated constructor stub
}

public void addDish(Dish d) {
  }

  public void removeDish(Dish d) {
  }

  public void createMeal() {
  }

  public void removeMeal() {
  }

  public void sortShippedOrders() {
  }

  public double visit(Dish d) {
	  return d.getPrice();
  }

  public double visit(Meal m) {
	  if (mealsOfTheWeek.contains(m))
		  return m.getPrice()*specialDiscountFactor;
	  return m.getPrice()*genericDiscountFactor;
  }
  
  public void registerObserver(Observer o){
	  registeredCustomersForNotifications.add(o);
	  
  }
  
  public void removeObserver(Observer o){
	  registeredCustomersForNotifications.remove(o);
	  
  }
  
  public void notifyObservers(){
	  for (Observer o : registeredCustomersForNotifications)
		  o.update(this);
	  
	  
  }
  
  
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public ArrayList<Dish> getDishes() {
		return dishes;
	}
	
	public void addDish(ArrayList<Dish> dishes) {
		this.dishes = dishes;
	}
	public void removeDish(ArrayList<Dish> dishes) {
		this.dishes = dishes;
	}
	
	public ArrayList<Meal> getMeals() {
		return meals;
	}
	
	public void addMeal(ArrayList<Meal> meals) {
		this.meals = meals;
	}
	
	public void removeMeal(ArrayList<Meal> meals) {
		this.meals = meals;
	}
	
	public double getGenericDiscountFactor() {
		return genericDiscountFactor;
	}
	
	public void setGenericDiscountFactor(double genericDiscountFactor) {
		this.genericDiscountFactor = genericDiscountFactor;
	}
	
	public double getSpecialDiscountFactor() {
		return specialDiscountFactor;
	}
	
	public void setSpecialDiscountFactor(double specialDiscountFactor) {
		this.specialDiscountFactor = specialDiscountFactor;
	}
	
	public ArrayList<Order> getShippedOrders() {
		return shippedOrders;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Meal> getMealsOfTheWeek() {
		return mealsOfTheWeek;
	}
	
	public void setMealsOfTheWeek(ArrayList<Meal> mealsOfTheDay) {
		this.mealsOfTheWeek = mealsOfTheDay;
	}

public static void main(String[] args) {
	  Restaurant r1 = new Restaurant();
	  Restaurant r2 = new Restaurant();
	  
	  System.out.println(r1.id);
	  System.out.println(r2.id);
}

}