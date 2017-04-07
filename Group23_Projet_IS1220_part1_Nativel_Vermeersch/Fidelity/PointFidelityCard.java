package Fidelity;

import Users.Customer;
import Users.Restaurant;

public class PointFidelityCard extends FidelityCard {

  public double cumulatedSpending;

  public int points;
  
  /*
   * 
   */
  public PointFidelityCard(Restaurant restaurant, Customer customer) {
	  this.restaurant =restaurant;
	  this.owner = customer;
	  this.points = 0;
	  this.cumulatedSpending = 0;
	  
	// TODO Auto-generated constructor stub
}

public void gainPoints(double price){
	this.points += (int)(price/10);
	this.cumulatedSpending += price;
	}
	


public double useCard(double price){
	if (this.points > 100){
		this.points -= 100;
		this.gainPoints(price);
		return 1 - 0.1;
				
	}
	else{
		this.gainPoints(price);
		return 1.0;
	}
}
	

}
