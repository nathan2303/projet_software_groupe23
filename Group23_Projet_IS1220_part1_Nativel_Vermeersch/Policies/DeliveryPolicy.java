package Policies;

import Food.Order;
import Users.Courier;

public interface DeliveryPolicy {
	
	public Courier findCourier(Order order);


}