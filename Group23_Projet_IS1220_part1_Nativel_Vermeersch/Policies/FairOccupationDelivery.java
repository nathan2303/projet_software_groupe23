package Policies;

import java.util.ArrayList;

import Food.Order;
import Main.MyFoodora;
import Users.Address;
import Users.Courier;

public class FairOccupationDelivery implements DeliveryPolicy {
	private MyFoodora system = MyFoodora.getInstance();
	
	
	
	public FairOccupationDelivery() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * finds a courier according to fair occupation delivery
	 * searches the least occupied courier
	 * @param order
	 * @return a Courier, null only if there are no on duty couriers
	 */
	public Courier findCourier(Order order){
		ArrayList<Courier> list = system.getOnDutyCouriersList();
		if (list.isEmpty())
			return null;
		Courier res = list.get(0);
		double resOccupation = res.getDeliveredOrders().size();
		for (Courier c : list){
			if (c.getDeliveredOrders().size()<resOccupation){
				if (c.decideDelivery()){
					res=c;
					resOccupation = res.getDeliveredOrders().size();
				}
			}
		}
		return res;
	}
	
}