package Fidelity;

import java.util.Random;

import Users.Customer;
import Users.Restaurant;

public class LotteryFidelityCard extends FidelityCard {

  public double probability = 0.2;

public LotteryFidelityCard(Restaurant restaurant, Customer customer) {
	super(restaurant, customer);
	// TODO Auto-generated constructor stub
}

/**
 * the use of this card Lottery makes the order free with a given probability (0.2 by default)
 * @see Fidelity.FidelityCard#useCard(double)
 * @return the multiplying factor (0 or 1 in this case)
 */
public double useCard(double price){
	Random r = new Random();
	double res = r.nextDouble();
	if (res < this.probability){ return 0.0;}
	else { return 1;}
	
	
}

public double getProbability() {
	return probability;
}

public void setProbability(double probability) {
	this.probability = probability;
}
  

}