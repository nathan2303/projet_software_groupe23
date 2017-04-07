package Users;
import java.util.ArrayList;
import java.util.HashMap;

import Fidelity.BasicFidelityCard;
import Fidelity.FidelityCard;
import Fidelity.LotteryFidelityCard;
import Fidelity.PointFidelityCard;
import Food.Food;
import Food.Order;

public class Customer extends User implements Observer {

  private Address address;

  private String emailAddress;

  private String phoneNumber;

  private String name;

  private String surname;
  
  private ArrayList<Order> ordersList = new ArrayList<Order>();
  
  private HashMap<Restaurant,FidelityCard> fidelityCardList;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String surname, String username, String password, Address address, String emailAddress, String phoneNumber) {
		super(username, password);
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.surname = surname;
		this.setFidelityCardList(new HashMap<Restaurant, FidelityCard>());
		for (Restaurant mapKey: getFidelityCardList().keySet()){
			getFidelityCardList().put(mapKey,  new BasicFidelityCard(mapKey,this));
		}
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public void order(ArrayList<Food> content, Restaurant r) {
		Order order = new Order(this, r, content);
		Courier c = order.findCourier();
		if (c==null)
			System.out.println("MyFoodora could not find any available courier to ship your order. Please try again later.");
		else{
			System.out.println("Your order has been processed. You will soon receive your meals.");
			r.addOrder(order);
			this.addOrder(order);
			system.addOrder(order);
			c.completeOrder(order);
			//c.setPosition(this.getAddress());
		}
		
	  }
	
	
	public void addOrder(Order order){
		ordersList.add(order);
	}
	
	public void registerNotifications(Restaurant r) {
		r.registerObserver(this);
	  }
	
	public void unregisterNotifications(Restaurant r) {
		r.removeObserver(this);
	  }
	
	public void registerAllNotifications(){
		ArrayList<Restaurant> list = (ArrayList<Restaurant>)system.getRestaurantsList().values();
		for (Restaurant r : list)
			this.registerNotifications(r);
		System.out.println(this.surname + " " + this.name + " has been successfully registered for all notifications.");
	}
	
	public void unregisterAllNotifications(){
		ArrayList<Restaurant> list = (ArrayList<Restaurant>)system.getRestaurantsList().values();
		for (Restaurant r : list)
			this.unregisterNotifications(r);
		System.out.println(this.surname + " " + this.name + " has been successfully unregistered for all notifications.");
	}
	
	public void update(Restaurant r) {
		  System.out.println("Customer " + this.surname + " "+ this.name + "has received the promotional offer from " + r.getName());
		  System.out.println(r.getGenericDiscountFactor() + " discount for the all the meals!");
		  System.out.println(r.getSpecialDiscountFactor() + " discount for the meals of the week!");
		  System.out.println("The new meals of the week: " + r.getMealsOfTheWeek().toString());
	  }
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	
	
	
	public ArrayList<Order> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(ArrayList<Order> ordersList) {
		this.ordersList = ordersList;
	}
	/*
	 * crée une carte de fidélité à points dans le restaurant en argument. Attention: si le client possède déjà une carte de fidélité,celle ci est effacée
	 */
	public void registerPointFidelityCard(Restaurant restaurant){
		PointFidelityCard card = new PointFidelityCard(restaurant, this);
		this.getFidelityCardList().put(restaurant, card);
		
	}
	
	/*
	 * crée une carte de fidélité lotterie dans le restaurant en argument. Attention si le client possède déjà une carte de fidélité celle-ci est effacée
	 */
	public void registerLotteryFidelityCard(Restaurant restaurant, double probability){
		LotteryFidelityCard card = new  LotteryFidelityCard(probability, this, restaurant);
		this.getFidelityCardList().put(restaurant, card);
		
	}
	public static void main(String[] args) {
		
	}

	public HashMap<Restaurant,FidelityCard> getFidelityCardList() {
		return fidelityCardList;
	}

	public void setFidelityCardList(HashMap<Restaurant,FidelityCard> fidelityCardList) {
		this.fidelityCardList = fidelityCardList;
	}
	/*
	 * Losqu'on se désabonne d'un programme de fidélité la carte de fidélité du restaurant redevient basique
	 */
	public void unregisterFidelityCard(Restaurant r){
		this.fidelityCardList.put(r, new BasicFidelityCard(r,this));
		
	}
	
}