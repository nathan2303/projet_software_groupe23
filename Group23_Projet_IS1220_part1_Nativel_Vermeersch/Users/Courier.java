package Users;

public class Courier extends User {

  private boolean isOnDuty;

  private String phoneNumber;

  private Address position;

  private int counterDeliveredOrders = 0;

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
	  if(p>0.2){
		  return true;
	  }
	  return false;
  }




public boolean isOnDuty() {
	return isOnDuty;
}




public void setOnDuty(boolean isOnDuty) {
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




public int getCounterDeliveredOrders() {
	return counterDeliveredOrders;
}




public void setCounterDeliveredOrders(int counterDeliveredOrders) {
	this.counterDeliveredOrders = counterDeliveredOrders;
}

public void addDeliveredOrders (int newOrders){
	this.counterDeliveredOrders+=newOrders;
}


public static void main(String[] args) {
	Courier c = new Courier();
	System.out.println(c.getCounterDeliveredOrders());
	c.addDeliveredOrders(4);
	System.out.println(c.getCounterDeliveredOrders());
}


}