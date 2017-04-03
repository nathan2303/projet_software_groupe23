package Main;
import java.util.ArrayList;
import java.util.Date;

import Food.Order;
import Policies.DeliveryPolicy;
import Policies.ProfitPolicy;
import Users.Restaurant;

/**
 * the core system, it is a singleton
 * @author natha
 *
 */
public class MyFoodora {

  public double markupPercentage;

  public double serviceFee;

  public ArrayList<Restaurant> restaurants;

  public ArrayList<Order> completedOrders;
  

  public Date currentDate;

  public DeliveryPolicy deliveryPolicy;

  public ProfitPolicy profitPolicy;
  
  public static MyFoodora instance = null;
  
  private MyFoodora(){
  }
  
  public static MyFoodora getInstance(){
	  if (instance == null)
		  instance = new MyFoodora();
	  return instance;
			  
  }

}