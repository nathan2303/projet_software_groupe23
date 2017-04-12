package Fidelity;

import Users.Customer;
import Users.Restaurant;

public class BasicFidelityCard extends FidelityCard {


public BasicFidelityCard(Restaurant restaurant, Customer customer) {
		super(restaurant, customer);
		// TODO Auto-generated constructor stub
	}

	/*
 * Si le client poss�de une carte standard, la r�duction sera simplement le discount factor du restaurant
 * @see Fidelity.FidelityCard#useCard(double)
 */
	public  double useCard(double price){
		return 1;
	}
}