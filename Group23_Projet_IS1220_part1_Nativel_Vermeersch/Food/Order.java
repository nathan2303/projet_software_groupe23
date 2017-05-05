package Food;

import java.util.ArrayList;

import Main.Date;
import Main.MyFoodora;
import Users.Courier;
import Users.Customer;
import Users.Restaurant;

/**
 * 
 * @author natha
 *
 */

public class Order {
	
	private int id;
	private static int counter = 0;
	
	private Customer customer;
	private Restaurant restaurant;
	private ArrayList<Food> content;
	private Date date;
	private double price;
	private double profit;
	private Courier courier;
	private MyFoodora system = MyFoodora.getInstance();
	

	public Order() {
		counter++;
		this.id=counter;
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Order(Customer customer, Restaurant restaurant, ArrayList<Food> content) {
		super();
		this.customer = customer;
		this.restaurant = restaurant;
		this.content = content;
		this.date = new Date();
		this.price = Math.rint(computeOrderPrice(content)*100)/100;
		this.profit = this.price*system.getMarkupPercentage()+system.getServiceFee()-system.getDeliveryCost();
		counter++;
		this.id=counter;
	}
	
	/**
	 * computes the price of an order, taking into account discount factors of restaurant (through visitors pattern)
	 * as well as the existing fidelity card
	 * @param content
	 * @return
	 */
	public double computeOrderPrice(ArrayList<Food> content){
		  double res = 0;
		  for (Food f : content){
			  res+=f.accept(this.restaurant);
			  }
		  double fidelityDiscount = this.customer.getFidelityCardList().get(this.restaurant).useCard(res);
		  return res*(fidelityDiscount);
	}
	
	/**
	 * finds the courier according to the current delivery policy
	 * @return a courier or null if there is no available courier
	 */
	public Courier findCourier(){
		Courier res = system.getDeliveryPolicy().findCourier(this);
		this.courier = res;
		return(res);
	}
	
	



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	public Restaurant getRestaurant() {
		return restaurant;
	}



	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}



	public ArrayList<Food> getContent() {
		return content;
	}



	public void setContent(ArrayList<Food> content) {
		this.content = content;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Courier getCourier() {
		return courier;
	}



	public void setCourier(Courier courier) {
		this.courier = courier;
	}



	public MyFoodora getSystem() {
		return system;
	}



	public void setSystem(MyFoodora system) {
		this.system = system;
	}
	
	public String toString(){
		return "\n***** Order no. " + this.id + " *****\nCustomer: " + this.customer + "\nRestaurant: " + this.restaurant + "\nDate: " + this.date + "\nContent: " + this.content + "\nPrice: " + this.price + "€\n****************\n";
	}
	
	



	public double getProfit() {
		return profit;
	}



	public void setProfit(double profit) {
		this.profit = profit;
	}



	public static void main(String[] args) {
		System.out.println(Date.getCurrentDate());
	}

}
