package Main;
import java.util.ArrayList;

import Food.Order;
import Policies.DeliveryPolicy;
import Policies.FastestDelivery;
import Policies.ProfitPolicy;
import Policies.TargetProfit_DeliveryCost;
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

  public double markupPercentage = 0.05;
  public double serviceFee = 5;
  public ArrayList<User> usersList = new ArrayList<User>();
  public ArrayList<User> activatedUsersList = new ArrayList<User>();
  public ArrayList<Restaurant> restaurantsList = new ArrayList<Restaurant>();
  public ArrayList<Customer> customersList = new ArrayList<Customer>();
  public ArrayList<Courier> couriersList = new ArrayList<Courier>();
  public ArrayList<Courier> onDutyCouriersList = new ArrayList<Courier>();
  public ArrayList<Manager> managersList = new ArrayList<Manager>();
  public ArrayList<Order> completedOrders = new ArrayList<Order>();
  public DeliveryPolicy deliveryPolicy = new FastestDelivery();
  public ProfitPolicy profitPolicy = new TargetProfit_DeliveryCost();
  public static MyFoodora instance = null;
  
  
  /**
   * enables the manager to add users (they're activated by default)
   * @param u the user to be added
   */
  public void addUser(User u){
	  usersList.add(u);
	  activateUser(u);
	  if (u instanceof Courier){
		  couriersList.add((Courier)u);
		  onDutyCouriersList.add((Courier)u);
	  }
	  if (u instanceof Restaurant)
		  restaurantsList.add((Restaurant)u);
	  if (u instanceof Customer)
		  customersList.add((Customer)u);
	  if (u instanceof Manager)
		  managersList.add((Manager)u);
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
	  activatedUsersList.add(u);
  }
  
  public void deactivateUser(User u){
	  activatedUsersList.remove(u);
  }
  
  public void addOrder(Order order){
	  this.completedOrders.add(order);
  }
  
  private MyFoodora(){
  }
  
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
	
	public void setProfitPolicy(ProfitPolicy profitPolicy) {
		this.profitPolicy = profitPolicy;
	}

	public ArrayList<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(ArrayList<User> usersList) {
		this.usersList = usersList;
	}

	public ArrayList<User> getActivatedUsersList() {
		return activatedUsersList;
	}

	public void setActivatedUsersList(ArrayList<User> activatedUsersList) {
		this.activatedUsersList = activatedUsersList;
	}

	public ArrayList<Restaurant> getRestaurantsList() {
		return restaurantsList;
	}

	public void setRestaurantsList(ArrayList<Restaurant> restaurantsList) {
		this.restaurantsList = restaurantsList;
	}

	public ArrayList<Customer> getCustomersList() {
		return customersList;
	}

	public void setCustomersList(ArrayList<Customer> customersList) {
		this.customersList = customersList;
	}

	public ArrayList<Courier> getCouriersList() {
		return couriersList;
	}

	public void setCouriersList(ArrayList<Courier> couriersList) {
		this.couriersList = couriersList;
	}

	public ArrayList<Courier> getOnDutyCouriersList() {
		return onDutyCouriersList;
	}

	public void setOnDutyCouriersList(ArrayList<Courier> onDutyCouriersList) {
		this.onDutyCouriersList = onDutyCouriersList;
	}

	public ArrayList<Manager> getManagersList() {
		return managersList;
	}

	public void setManagersList(ArrayList<Manager> managersList) {
		this.managersList = managersList;
	}
	
	
  
  

}