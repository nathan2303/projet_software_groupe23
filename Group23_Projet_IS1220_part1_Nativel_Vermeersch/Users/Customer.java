package Users;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Fidelity.BasicFidelityCard;
import Fidelity.FidelityCard;
import Fidelity.LotteryFidelityCard;
import Fidelity.PointFidelityCard;
import Food.Food;
import Food.Order;
import Main.Date;

public class Customer extends User implements Observer {

  private Address address;

  private String emailAddress;

  private String phoneNumber;

  private String name;

  private String surname;
  
  private Date birthday;
  
  private ArrayList<Order> ordersList = new ArrayList<Order>();
  
  private HashMap<Restaurant,FidelityCard> fidelityCardList;
  
  private LinkedList<String> inbox = new LinkedList<String>();
  
  private Random rand = new Random();

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
		List <Restaurant> list = new ArrayList<Restaurant>(system.getRestaurantsList().values());
		for (Restaurant mapKey: list){
			this.getFidelityCardList().put(mapKey,  new BasicFidelityCard(mapKey,this));
		}
		this.birthday = new Date(rand.nextInt(30)+1,rand.nextInt(12)+1);
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String name, String surname, String username, String password, Address address, String emailAddress, String phoneNumber, Date birthday) {
		super(username, password);
		this.address = address;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.name = name;
		this.surname = surname;
		this.setFidelityCardList(new HashMap<Restaurant, FidelityCard>());
		List <Restaurant> list = new ArrayList<Restaurant>(system.getRestaurantsList().values());
		for (Restaurant mapKey: list){
			this.getFidelityCardList().put(mapKey,  new BasicFidelityCard(mapKey,this));
		}
		this.birthday = birthday;
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String surname, String username, String password) {
		super(username, password);

		this.name = name;
		this.surname = surname;
		this.setFidelityCardList(new HashMap<Restaurant, FidelityCard>());
		List <Restaurant> list = new ArrayList<Restaurant>(system.getRestaurantsList().values());
		for (Restaurant mapKey: list){
			this.getFidelityCardList().put(mapKey,  new BasicFidelityCard(mapKey,this));
		}
		this.birthday = new Date(rand.nextInt(30)+1,rand.nextInt(12)+1);
		// TODO Auto-generated constructor stub
	
		this.address = new Address(Math.rint(Math.random()*5000)/100,Math.rint(Math.random()*5000)/1000);
		this.phoneNumber = "06" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		this.emailAddress = this.surname.toLowerCase()+ "." + this.name.toLowerCase() + "@live.com";
	}
	
	public Customer(String name, String surname, String username, String password, Date birthday) {
		super(username, password);

		this.name = name;
		this.surname = surname;
		this.setFidelityCardList(new HashMap<Restaurant, FidelityCard>());
		List <Restaurant> list = new ArrayList<Restaurant>(system.getRestaurantsList().values());
		for (Restaurant mapKey: list){
			this.getFidelityCardList().put(mapKey,  new BasicFidelityCard(mapKey,this));
		}
		this.birthday = birthday;
	
		this.address = new Address(Math.rint(Math.random()*5000)/100,Math.rint(Math.random()*5000)/1000);
		this.phoneNumber = "06" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10);
		this.emailAddress = this.surname.toLowerCase()+ "." + this.name.toLowerCase() + "@live.com";
	}
	
	
	public void order(ArrayList<Food> content, Restaurant r) {
		Order order = new Order(this, r, content);
		Courier c = order.findCourier();
		if (c==null)
			System.out.println("MyFoodora could not find any available courier to ship your order. Please try again later.");
		else{
			System.out.println("Your order has been processed. You will soon receive your meals thanks to your devoted courier: "+ c + " (" + c.getPhoneNumber() +").");
			System.out.println("Here is a quick recap of your order. Have a nice meal with Foodora!");
			System.out.println(order);
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
		ArrayList<Restaurant> list = new ArrayList<Restaurant>(system.getRestaurantsList().values());
		for (Restaurant r : list)
			this.registerNotifications(r);
		System.out.println("[SYSTEM] " + this.surname + " " + this.name + " has been successfully registered for all notifications.");
	}
	
	public void unregisterAllNotifications(){
		ArrayList<Restaurant> list = new ArrayList<Restaurant>(system.getRestaurantsList().values());
		for (Restaurant r : list)
			this.unregisterNotifications(r);
		System.out.println("[SYSTEM] " + this.surname + " " + this.name + " has been successfully unregistered for all notifications.");
	}
	
	public void update(Restaurant r) {
		  System.out.println("[SYSTEM] " + "Customer " + this.surname + " "+ this.name + " has received the promotional offer from the restaurant " + r.getName());
		  inbox.add("\n-----------------------------\nMessage received on " + new Date() +" from the restaurant " + r + ".\n"+r.getGenericDiscountFactor() + " discount for the all the meals!\n"+r.getSpecialDiscountFactor() + " discount for the meals of the week!\n"+"The new meals of the week: " + r.getMealsOfTheWeek().toString()+"\n-----------------------------\n");
		 
	  }
	
	public void updateBirthday(Restaurant r){
		System.out.println("[SYSTEM] " + "Customer "+this+" has received an offer for his/her birthday from "+r+"!");
		inbox.add("\n-----------------------------\n"+"Message received on " + new Date() +" from the restaurant " + r + ".\n"+"Happy birthday dear "+this.surname + " "+ this.name +"! We would be very happy to see you at our table today...\n"+r.getGenericDiscountFactor() + " discount for the all the meals!\n"+r.getSpecialDiscountFactor() + " discount for the meals of the week!\n"+"The new meals of the week: " + r.getMealsOfTheWeek().toString()+"\n-----------------------------\n");
		 
	}
	
	public LinkedList<String> getInbox() {
		return inbox;
	}

	public void setInbox(LinkedList<String> inbox) {
		this.inbox = inbox;
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
	/**
	 * creates a PointFidelityCard with 0 point. Warning: if there was already a fidelity card, the previous one will be deleted!
	 * @param restaurant
	 */
	public void registerPointFidelityCard(Restaurant restaurant){
		PointFidelityCard card = new PointFidelityCard(restaurant, this);
		this.getFidelityCardList().put(restaurant, card);
		System.out.println("[SYSTEM] " + "Customer "+this+" has been successfully registered for a point fidelity card with restaurant "+restaurant+"."); 
		
	}
	
	/*
	 * crée une carte de fidélité lotterie dans le restaurant en argument. Attention si le client possède déjà une carte de fidélité celle-ci est effacée
	 */
	public void registerLotteryFidelityCard(Restaurant restaurant){
		LotteryFidelityCard card = new  LotteryFidelityCard(restaurant, this);
		this.getFidelityCardList().put(restaurant, card);
		System.out.println("[SYSTEM] " + "Customer "+this+" has been successfully registered for a lottery fidelity card with restaurant "+restaurant+"."); 
		
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
		System.out.println("[SYSTEM] " + "Customer "+this+" has been successfully unregistered for fidelity cards with restaurant "+r+"."); 
		
	}
	
	
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String toString(){
		return this.surname + " " + this.name;
	}
	
}