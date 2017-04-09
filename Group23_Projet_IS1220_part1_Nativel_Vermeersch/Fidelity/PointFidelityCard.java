package Fidelity;

import Users.Customer;
import Users.Restaurant;

public class PointFidelityCard extends FidelityCard {

  public double cumulatedSpending = 0;

  public int points = 0;
  


  public PointFidelityCard(Restaurant restaurant, Customer customer) {
	super(restaurant, customer);
	// TODO Auto-generated constructor stub
}



/**
   * gives the number of points accumulated
   * @param price
   */
public void gainPoints(double price){
	this.points += (int)(price/10);
	this.cumulatedSpending += price;
	}
	
/**
 * returns the multiplying factor (1 or 0.9 in this case)
 */
@Override
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



public double getCumulatedSpending() {
	return cumulatedSpending;
}



public void setCumulatedSpending(double cumulatedSpending) {
	this.cumulatedSpending = cumulatedSpending;
}



public int getPoints() {
	return points;
}



public void setPoints(int points) {
	this.points = points;
}
	

}
