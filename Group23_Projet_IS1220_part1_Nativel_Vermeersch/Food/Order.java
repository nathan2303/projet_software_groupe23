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
	
	private Customer customer;
	private Restaurant restaurant;
	private ArrayList<Food> content;
	private Date date;
	private double price;
	private double profit;
	private Courier courier;
	private MyFoodora system = MyFoodora.getInstance();
	

	public Order() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Order(Customer customer, Restaurant restaurant, ArrayList<Food> content) {
		super();
		System.out.println("order created");
		this.customer = customer;
		this.restaurant = restaurant;
		this.content = content;
		this.date = new Date();
		this.price = computeOrderPrice(content);
		this.price = this.price * customer.getFidelityCardList().get(restaurant).useCard(this.price);
		this.profit = this.price*system.getMarkupPercentage()+system.getServiceFee()-system.getDeliveryCost();
	}
	
	/**
	 * computes the price of an order, taking into account discount factors of restaurant (through visitors pattern)
	 * @param content
	 * @return
	 */
	public double computeOrderPrice(ArrayList<Food> content){
		  double res = 0;
		  System.out.println("coucou3");
		  System.out.println("");
		  for (Food f : content){
			  System.out.println("f"+f);
			  System.out.println(f.accept(this.restaurant));
			  res+=f.accept(this.restaurant);
			  }
		  return res;
	}
	
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



	public static void main(String[] args) {
		System.out.println(Date.getCurrentDate());
	}

}
