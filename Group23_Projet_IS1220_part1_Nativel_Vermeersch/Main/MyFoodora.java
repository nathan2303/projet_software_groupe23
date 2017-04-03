import java.util.ArrayList;
import java.util.Date;

import Food.Order;
import Policies.DeliveryPolicy;
import Policies.ProfitPolicy;
import Users.Restaurant;

public class MyFoodora {

  public double markupPercentage;

  public double serviceFee;

  public ArrayList<Restaurant> restaurants;

  public ArrayList<Order> completedOrders;

  public Date currentDate;

  public DeliveryPolicy deliveryPolicy;

  public ProfitPolicy profitPolicy;
  
  public MyFoodora instance = null;
  
  private MyFoodora(){
  }
  
  public MyFoodora getInstance(){
	  if (instance == null)
		  instance = new MyFoodora();
	  return instance;
			  
  }

}