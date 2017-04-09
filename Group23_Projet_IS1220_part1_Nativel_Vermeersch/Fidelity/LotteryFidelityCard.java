package Fidelity;

import java.util.Random;

import Users.Customer;
import Users.Restaurant;

public class LotteryFidelityCard extends FidelityCard {

  public double probability;

public LotteryFidelityCard(double probability, Customer owner, Restaurant restaurant) {
	super();
	this.probability = probability;
	this.owner = owner;
	this.restaurant = restaurant;
}


/*
 * l'utilisation d'une carte lotterie renvoie  0 si la commande est gratuite avec une probabilité "probability", et 1 sinon
 * @see Fidelity.FidelityCard#useCard(double)
 */
public double useCard(double price){
	Random r = new Random();
	double res = r.nextDouble();
	if (res < this.probability){ return 0.0;}
	else { return 1;}
	
	
}
  

}