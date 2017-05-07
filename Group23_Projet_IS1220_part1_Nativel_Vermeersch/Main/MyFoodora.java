package Main;
import java.util.ArrayList;
import java.util.HashMap;

import Fidelity.BasicFidelityCard;
import Food.Order;
import Policies.DeliveryPolicy;
import Policies.ProfitPolicy;
import Users.Address;
import Users.Courier;
import Users.Customer;
import Users.Manager;
import Users.Restaurant;
import Users.User;

/**
 * the core system, it is a singleton
 * @author natha
 *
 */
public class MyFoodora {

  private double markupPercentage = 0.05;
  private double serviceFee = 7;
  private double deliveryCost = 5;
  private HashMap<String, User> usersList = new HashMap<String, User>();
  private HashMap<String, User> activatedUsersList = new HashMap<String, User>();
  private HashMap<String, Restaurant> restaurantsList = new HashMap<String, Restaurant>();
  private HashMap<String, Customer> customersList = new HashMap<String, Customer>();
  private HashMap<String, Courier> couriersList = new HashMap<String, Courier>();
  private ArrayList<Courier> onDutyCouriersList = new ArrayList<Courier>();
  private HashMap<String,Manager> managersList = new HashMap<String,Manager>();
  private ArrayList<Order> completedOrders = new ArrayList<Order>();
  private DeliveryPolicy deliveryPolicy;
  private ProfitPolicy profitPolicy;
  private User loggedOnUser = null;
  private static MyFoodora instance = null;
  private User connectedUser;
  
  
  public User getConnectedUser() {
	return connectedUser;
}

public void setConnectedUser(User connectedUser) {
	this.connectedUser = connectedUser;
}

/**
   * enables the manager to add users (they're activated by default)
   * @param u the user to be added
   */
  public void addUser(User u){
	  usersList.put(u.getUsername(),u);
	  activateUser(u);
	  if (u instanceof Courier){
		  couriersList.put(u.getUsername(),(Courier)u);
		  onDutyCouriersList.add((Courier)u);
	  }
	  if (u instanceof Restaurant){
		  restaurantsList.put(u.getUsername(),(Restaurant)u);
		  for(String c : customersList.keySet()){
			  customersList.get(c).getFidelityCardList().put((Restaurant) u, new BasicFidelityCard((Restaurant) u, customersList.get(c)));
		  }
	  }
	  if (u instanceof Customer)
		  customersList.put(u.getUsername(),(Customer)u);
	  if (u instanceof Manager)
		  managersList.put(u.getUsername(),(Manager)u);
  }
  
  /**
   * removes and deactivates a user
   * @param u
   */
  
  public void removeUser(User u){
	  usersList.remove(u);
	  deactivateUser(u);
	  if (u instanceof Courier){
		  couriersList.remove((Courier)u);
		  onDutyCouriersList.add((Courier)u);
	  }
	  if (u instanceof Restaurant)
		  restaurantsList.remove((Restaurant)u);
	  if (u instanceof Customer)
		  customersList.remove((Customer)u);
	  if (u instanceof Manager)
		  managersList.remove((Manager)u);
  }
  
  public void activateUser(User u){
	  activatedUsersList.put(u.getUsername(),u);
  }
  
  public void deactivateUser(User u){
	  activatedUsersList.remove(u.getUsername());
  }
  
  /**
   * adds an order to the history of order of the system
   * @param order
   */
  public void addOrder(Order order){
	  this.completedOrders.add(order);
  }
  
  /**
   * computes the income (ie cumulated price of orders)
   * @param start the date of start
   * @param end the date of end
   * @return order_price, not profit!
   */
  public double computeIncome(Date start, Date end){
	  double res = 0;
	  for (Order o : this.completedOrders){
		  if (o.getDate().compareTo(start)>=0 && o.getDate().compareTo(end)<=0)
			  res+=o.getPrice();
	  }
	  return res;
  }
  
  
  /**
   * computes the income over a time period divided by the customers who ordered something during this time period
   * @param start
   * @param end
   * @return
   */
    public double computeIncomePerCustomer(Date start, Date end){
	  double res = 0;
	  ArrayList<Customer> list = new ArrayList<>();
	  for (Order o : this.completedOrders){
		  if (o.getDate().compareTo(start)>=0 && o.getDate().compareTo(end)<=0){
			  res+=o.getPrice();
			  Customer c = o.getCustomer();
			  if (!list.contains(c))
				  list.add(c);
		  }
	  }
	  return res/list.size();
  }

    /**
     * returns a double[2] with the income per customer and the number of customers who ordered something over the time period
     * @param start
     * @param end
     * @return
     */
    public double[] computeIncomePerCustomerBis(Date start, Date end){
	  double res = 0;
	  double[] res2=new double[2];
	  ArrayList<Customer> list = new ArrayList<>();
	  for (Order o : this.completedOrders){
		  if (o.getDate().compareTo(start)>=0 && o.getDate().compareTo(end)<=0){
			  res+=o.getPrice();
			  Customer c = o.getCustomer();
			  if (!list.contains(c))
				  list.add(c);
		  }
	  }
	  res2[0]=res;
	  res2[1]=list.size();
	  return res2;
  }
  
  public double computeTotalIncomePerCustomer(){
	  double res = 0;
	  ArrayList<Customer> list = new ArrayList<>();
	  for (Order o : this.completedOrders){
		  res+=o.getPrice();
		  Customer c = o.getCustomer();
		  if (!list.contains(c))
			  list.add(c);
	  }
	  return res/list.size();
  }
  
  /**
   * computes the total income, ie the sum of the prices of all the orders ever completed
   * @return
   */
  public double computeTotalIncome(){
	  double res = 0;
	  for (Order o : this.completedOrders){
		  res+=o.getPrice();
	  }
	  return res;
  }
  
  public double computeLastMonthIncome(){
	  int currentMonth = Date.getCurrentMonth();
	  double res = this.computeIncome(new Date(1,currentMonth-1), new Date(30, currentMonth-1));
	  return res;
  }
  
  public double[] computeLastMonthIncomePerCustomerBis(){
	  int currentMonth = Date.getCurrentMonth();
	  double[] res = this.computeIncomePerCustomerBis(new Date(1,currentMonth-1), new Date(30, currentMonth-1));
	  return res;
  }
  
  /**
   * computes the profit for a period of time, according to the followinf formula:
   * profit = order_price * markup + service_fee - delivery_cost
   * @param start
   * @param end
   * @return
   */
  public double computeProfit(Date start, Date end){
	  double res = 0;
	  for (Order o : this.completedOrders){
		  if (o.getDate().compareTo(start)>=0 && o.getDate().compareTo(end)<=0)
			  res+=o.getPrice()*this.markupPercentage+this.serviceFee-this.deliveryCost;
	  }
	  return res;
  }
  
  public double computeTotalProfit(){
	  double res = 0;
	  for (Order o : this.completedOrders){
		  res+=o.getPrice()*this.markupPercentage+this.serviceFee-this.deliveryCost;
	  }
	  return res;
  }
  
  private MyFoodora(){
  }
  
  /**
   * singleton pattern method
   * @return
   */
  public static MyFoodora getInstance(){
	  if (instance == null)
		  instance = new MyFoodora();
	  return instance;
  }

	public double getMarkupPercentage(){
		return markupPercentage;
	}

	public void setMarkupPercentage(double markupPercentage) {
		this.markupPercentage = markupPercentage;
	}
	
	public double getServiceFee() {
		return serviceFee;
	}
	
	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}
	
	public ArrayList<Order> getCompletedOrders() {
		return completedOrders;
	}
	
	public void setCompletedOrders(ArrayList<Order> completedOrders) {
		this.completedOrders = completedOrders;
	}
	
	public DeliveryPolicy getDeliveryPolicy() {
		return deliveryPolicy;
	}
	
	public void setDeliveryPolicy(DeliveryPolicy deliveryPolicy) {
		this.deliveryPolicy = deliveryPolicy;
	}
	
	public ProfitPolicy getProfitPolicy() {
		return profitPolicy;
	}
	
	/**
	 * this method sets the profit policy but also updates the profit figures (markup etc)
	 * @param profitPolicy
	 */
	public void setProfitPolicy(ProfitPolicy profitPolicy) {
		this.profitPolicy = profitPolicy;
		double[] list = this.profitPolicy.computeProfitFigures();
		this.markupPercentage = list[0];
		this.serviceFee = list[1];
		this.deliveryCost = list[2];
	}


	
	
	public HashMap<String, User> getUsersList() {
		return usersList;
	}

	public void setUsersList(HashMap<String, User> usersList) {
		this.usersList = usersList;
	}

	public HashMap<String, User> getActivatedUsersList() {
		return activatedUsersList;
	}

	public void setActivatedUsersList(HashMap<String, User> activatedUsersList) {
		this.activatedUsersList = activatedUsersList;
	}

	public HashMap<String, Restaurant> getRestaurantsList() {
		return restaurantsList;
	}

	public void setRestaurantsList(HashMap<String, Restaurant> restaurantsList) {
		this.restaurantsList = restaurantsList;
	}

	public HashMap<String, Customer> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(HashMap<String, Customer> customersList) {
		this.customersList = customersList;
	}

	public HashMap<String, Courier> getCouriersList() {
		return couriersList;
	}

	public void setCouriersList(HashMap<String, Courier> couriersList) {
		this.couriersList = couriersList;
	}

	public ArrayList<Courier> getOnDutyCouriersList() {
		return onDutyCouriersList;
	}

	public void setOnDutyCouriersList(ArrayList<Courier> onDutyCouriersList) {
		this.onDutyCouriersList = onDutyCouriersList;
	}

	public HashMap<String, Manager> getManagersList() {
		return managersList;
	}

	public void setManagersList(HashMap<String, Manager> managersList) {
		this.managersList = managersList;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public User getLoggedOnUser() {
		return loggedOnUser;
	}

	public void setLoggedOnUser(User loggedOnUser) {
		this.loggedOnUser = loggedOnUser;
	}

	public static void main(String[] args) {
		MyFoodora system = MyFoodora.getInstance();
		Customer c1 = new Customer("Nathan", "Vermeersch", "nver", "1234", new Address(0, 0), "nv@gmail.com", "0000");
		system.addUser(c1);
		System.out.println(system.getActivatedUsersList());
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		System.out.println(list);

	}
  
  

}