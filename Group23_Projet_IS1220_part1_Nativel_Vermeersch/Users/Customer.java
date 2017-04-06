package Users;
import java.util.ArrayList;

import Food.Food;
import Food.Order;

public class Customer extends User implements Observer {

  private Address address;

  private String emailAddress;

  private String phoneNumber;

  private String name;

  private String surname;
  
  private ArrayList<Order> ordersList = new ArrayList<Order>();
  
  

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String surname, String username, String password, Address address, String emailAddress, String phoneNumber) {
		super(username, password);
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.surname = surname;
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public void order(ArrayList<Food> content, Restaurant r) {
		Order order = new Order(this, r, content);
		Courier c = order.findCourier();
		if (c==null)
			System.out.println("MyFoodora could not find any available courier to ship your order. Please try again later.");
		else{
			System.out.println("Your order has been processed. You will soon receive your meals.");
			r.addOrder(order);
			this.addOrder(order);
			system.addOrder(order);
			c.completeOrder(order);
			//c.setPosition(this.getAddress());
		}
		
	  }
	
	
	public void addOrder(Order order){
		ordersList.add(order);
	}
	
	public void registerNotifications(Restaurant r) {
		r.registerObserver(this);
	  }
	
	public void unregisterNotifications(Restaurant r) {
		r.removeObserver(this);
	  }
	
	public void registerAllNotifications(){
		ArrayList<Restaurant> list = (ArrayList<Restaurant>)system.getRestaurantsList().values();
		for (Restaurant r : list)
			this.registerNotifications(r);
	}
	
	public void unregisterAllNotifications(){
		ArrayList<Restaurant> list = (ArrayList<Restaurant>)system.getRestaurantsList().values();
		for (Restaurant r : list)
			this.unregisterNotifications(r);
	}
	
	public void update(Restaurant r) {
		  System.out.println("Customer " + name + "has received the promotional offer from " + r.getName());
		  System.out.println(r.getSpecialDiscountFactor() + " discount for the meals of the week!");
	  }
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
	
	public ArrayList<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(ArrayList<Order> ordersList) {
		this.ordersList = ordersList;
	}

	public static void main(String[] args) {
		
	}

}