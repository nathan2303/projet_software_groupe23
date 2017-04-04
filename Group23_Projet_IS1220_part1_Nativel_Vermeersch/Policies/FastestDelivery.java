package Policies;

import java.util.ArrayList;

import Food.Order;
import Main.MyFoodora;
import Users.Address;
import Users.Courier;

public class FastestDelivery implements DeliveryPolicy {
	
	private MyFoodora system = MyFoodora.getInstance();
	
	

	/**
	 * finds a courier according to fastest delivery policy 
	 * computes the distances with the restaurant among the on duty couriers
	 * @param order
	 * @return a Courier, null only if there are no on duty couriers
	 */
	public Courier findCourier(Order order){
		ArrayList<Courier> list = system.getOnDutyCouriersList();
		Address restaurantAddress = order.getRestaurant().getAddress();
		if (list.isEmpty())
			return null;
		Courier res = list.get(0);
		Address resAddress = res.getPosition();
		double resDistance = resAddress.getDistanceTo(restaurantAddress);
		for (Courier c : list){
			if (c.getPosition().getDistanceTo(restaurantAddress)<resDistance){
				if (c.decideDelivery()){
					res=c;
					resAddress = res.getPosition();
					resDistance = resAddress.getDistanceTo(restaurantAddress);
				}
			}
		}
		return res;
		
	}
}