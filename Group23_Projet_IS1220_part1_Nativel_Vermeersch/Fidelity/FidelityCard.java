package Fidelity;
import Main.MyFoodora;
import Users.Customer;
import Users.Restaurant;

public abstract class FidelityCard {

  protected Customer owner;

  protected Restaurant restaurant;
  
  protected MyFoodora system = MyFoodora.getInstance();
  
  public FidelityCard(Restaurant restaurant, Customer customer){
	  this.restaurant=restaurant;
	  this.owner = customer;
  }

  public abstract double useCard(double price);

public Customer getOwner() {
	return owner;
}

public void setOwner(Customer owner) {
	this.owner = owner;
}

public Restaurant getRestaurant() {
	return restaurant;
}

public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}
  
  
}

