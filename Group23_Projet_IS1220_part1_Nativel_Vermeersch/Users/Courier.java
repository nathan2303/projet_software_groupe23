package Users;

import java.util.ArrayList;

import Food.Order;

public class Courier extends User {

  private boolean isOnDuty;

  private String phoneNumber;

  private Address position;

  private ArrayList<Order> deliveredOrders = new ArrayList<Order>();

  private String name;

  private String surname;

  public Courier() {
	super();
	// TODO Auto-generated constructor stub
}

	public Courier(String name, String username, String password, Address position, String phoneNumber) {
		super(username, password);
		this.phoneNumber = phoneNumber;
		this.position = position;
		
		// TODO Auto-generated constructor stub
	}



/**
 * the courier decides whether he accepts the delivery
 * @return true with probability 0.8, false otherwise
 */
	public boolean decideDelivery() {
		  double p = Math.random();
		  if(p>0.05){
			  return true;
		  }
		  return false;
	  }
	
	public void completeOrder(Order order){
		this.deliveredOrders.add(order);
		this.setPosition(order.getCustomer().getAddress());
		
	}



public boolean isOnDuty() {
	return isOnDuty;
}




public void setOnDuty(boolean isOnDuty) {
	if (this.isOnDuty!=isOnDuty){
		if (isOnDuty)
			system.getOnDutyCouriersList().add(this);
		else
			system.getOnDutyCouriersList().remove(this);
	}
	this.isOnDuty = isOnDuty;
	
		
}





public String getPhoneNumber() {
	return phoneNumber;
}




public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}




public Address getPosition() {
	return position;
}




public void setPosition(Address position) {
	this.position = position;
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




public ArrayList<Order> getDeliveredOrders() {
	return deliveredOrders;
}

public void setDeliveredOrders(ArrayList<Order> deliveredOrders) {
	this.deliveredOrders = deliveredOrders;
}


public void addDeliveredOrders (Order order){
	this.deliveredOrders.add(order);
}


public static void main(String[] args) {
	Courier c = new Courier();
	System.out.println(c.getDeliveredOrders());
	Order order1 = new Order();
	Order order2 = new Order();
	c.addDeliveredOrders(order1);
	c.addDeliveredOrders(order2);
	System.out.println(c.getDeliveredOrders());
	System.out.println(c.position);
}


}