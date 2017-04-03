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
		Order order = new Order();
		
		
	  }
	
	public void registerNotifications(Restaurant r) {
		r.registerObserver(this);
	  }
	
	public void unregisterNotifications(Restaurant r) {
		r.removeObserver(this);
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

}