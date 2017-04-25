package Users;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import Fidelity.BasicFidelityCard;
import Food.Dish;
import Food.Food;
import Food.Meal;
import Food.Order;
import Main.Date;
import Policies.ShippedOrderSortingPolicy;

public class Restaurant extends User implements Visitor, Observable {

  private Address address;

  private ArrayList<Dish> dishes = new ArrayList<Dish>();

  private ArrayList<Meal> meals = new ArrayList<Meal>();
  
  private HashMap<String,Food> items = new HashMap<String,Food>();

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
		ArrayList<Customer> list = new ArrayList<Customer>(this.system.getCustomersList().values());
		if (!list.isEmpty()){
			for (Customer c : list){
				if (!c.getFidelityCardList().containsKey(this))
					c.getFidelityCardList().put(this, new BasicFidelityCard(this, c));	
			}
		}
	  }
		
		// TODO Auto-generated constructor stub
	  public Restaurant(String name, String username, String password) {
			super(username, password);
			this.name = name;
			this.totalProfit = 0.0;
			ArrayList<Customer> list = new ArrayList<Customer>(this.system.getCustomersList().values());
			if (!list.isEmpty()){
				for (Customer c : list){
					if (!c.getFidelityCardList().containsKey(this))
						c.getFidelityCardList().put(this, new BasicFidelityCard(this, c));	
				}
			}
			this.address = new Address(Math.rint(Math.random()*5000)/100,Math.rint(Math.random()*5000)/1000);
		}

public void addDish(Dish d) {
	this.dishes.add(d);
	this.items.put(d.getName(), d);
  }

  public void removeDish(Dish d) {
	  this.dishes.remove(d);
	  this.items.remove(d.getName());
  }

  public void addMeal(Meal m) {
	  this.meals.add(m);	
	  this.items.put(m.getName(), m);
  }

  public void removeMeal(Meal m) {
	  this.meals.add(m);
	  this.items.remove(m.getName());
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
  
  public void updateChangeDate(){
	  for (Observer o : this.registeredCustomersForNotifications){
		  Customer c = (Customer)o;
		  if (c.getBirthday().compareTo(new Date())==0)
			  c.updateBirthday(this);
		  
	  }
  }
  
  public void notifyObservers(){
	  for (Observer o : registeredCustomersForNotifications)
		  o.update(this);
	  
	  
  }
  
  	public HashMap<Food,Integer> sortOrders(ShippedOrderSortingPolicy sosp){
  		System.out.println("Sorted items (from the least to the most): " + sosp.sortOrders2(this.shippedOrders));

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
	
	public void removeDish(ArrayList<Dish> dishes) {
		this.dishes = dishes;
	}
	
	public ArrayList<Meal> getMeals() {
		return meals;
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
	public void addMealOfTheWeek(Meal m) {
		this.mealsOfTheWeek.add(m);
		this.notifyObservers();
	}
	public void removeMealOfTheWeek(Meal m) {
		this.mealsOfTheWeek.remove(m);
		this.notifyObservers();
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


public HashMap<String, Food> getItems() {
	return items;
}



public void setItems(HashMap<String, Food> items) {
	this.items = items;
}



public String toString(){
	return this.name;
}

}
