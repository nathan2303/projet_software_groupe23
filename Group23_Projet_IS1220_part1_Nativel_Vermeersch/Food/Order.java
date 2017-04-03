package Food;

import java.util.ArrayList;

import Main.Date;
import Users.Customer;
import Users.Restaurant;

public class Order {
	
	private Customer customer;
	private Restaurant restaurant;
	private ArrayList<Dish> content;
	private Date date;

	public Order() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Order(Customer customer, Restaurant restaurant, ArrayList<Dish> content, Date date) {
		super();
		this.customer = customer;
		this.restaurant = restaurant;
		this.content = content;
		this.date = new Date();
	}



	public static void main(String[] args) {
		System.out.println(Date.getDate());
	}

}
