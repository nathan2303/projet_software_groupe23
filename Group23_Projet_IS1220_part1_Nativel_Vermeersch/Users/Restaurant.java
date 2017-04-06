package Users;
import java.util.ArrayList;
import java.util.TreeMap;

import Food.Dish;
import Food.Food;
import Food.Meal;
import Food.Order;
import Policies.ShippedOrderSortingPolicy;

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
  
  private double totalProfit;
  
  public Restaurant(){
	  super();
  }
  
  

  public Restaurant(String name, String username, String password, Address address) {
	super(username, password);
	this.name = name;
	this.address = address;
	this.totalProfit = 0.0;
	
	// TODO Auto-generated constructor stub
}

public void addDish(Dish d) {
	this.dishes.add(d);
  }

  public void removeDish(Dish d) {
	  this.dishes.remove(d);
  }

  public void addMeal(Meal m) {
	  this.meals.add(m);	  
  }

  public void removeMeal(Meal m) {
	  this.meals.add(m);
  }

  public void sortShippedOrders() {
  }
  
  public void addOrder(Order order){
	  this.shippedOrders.add(order);
	  this.totalProfit += order.getPrice();
  }
  
  
// visitors pattern, computation of price with discount
  public double visit(Dish d) {
	  return d.getPrice();
  }
  
  /**
   * visitor pattern
   * @param m the meal
   * @return price of the meal with discount
   */
  public double visit(Meal m) {
	  if (mealsOfTheWeek.contains(m))
		  return m.getPrice()*(1-specialDiscountFactor);
	  return m.getPrice()*(1-genericDiscountFactor);
  }
  
  public void registerObserver(Observer o){
	  if (!registeredCustomersForNotifications.contains(o))
		  registeredCustomersForNotifications.add(o);
	  
  }
  
  public void removeObserver(Observer o){
	  if (registeredCustomersForNotifications.contains(o))
		  registeredCustomersForNotifications.remove(o);
	  
  }
  
  public void notifyObservers(){
	  for (Observer o : registeredCustomersForNotifications)
		  o.update(this);
	  
	  
  }
  
  	public TreeMap<Food,Integer> sortOrders(ShippedOrderSortingPolicy sosp){
  		return sosp.sortOrders(this.shippedOrders);
  		
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
		this.notifyObservers();
	}
	
	public double getSpecialDiscountFactor() {
		return specialDiscountFactor;
	}
	
	public void setSpecialDiscountFactor(double specialDiscountFactor) {
		this.specialDiscountFactor = specialDiscountFactor;
		this.notifyObservers();
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
public double getTotalProfit(){
	return this.totalProfit;
}


}
