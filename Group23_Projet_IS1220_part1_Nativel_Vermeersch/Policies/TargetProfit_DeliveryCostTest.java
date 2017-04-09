package Policies;

import java.util.ArrayList;

import Food.Order;
import Main.ConfigInitiale;
import Main.Date;
import Main.MyFoodora;
import Users.Customer;
import junit.framework.TestCase;

public class TargetProfit_DeliveryCostTest extends TestCase {
/*
 * Je teste la méthode avec des arguments et je vérifie le calcul à la fin
 */
	public void testComputeProfitFigures() {
		MyFoodora system = MyFoodora.getInstance();
		ConfigInitiale.launch();
		TargetProfit_DeliveryCost t = new TargetProfit_DeliveryCost(0.1, 1, 1);
		Customer c1 =system.getCustomersList().get("nver");
		System.out.println(c1.getName());
		Order o = new Order();
		o.setPrice(10);
		o.setCustomer(c1);
		Date d = new Date(2, Date.getCurrentMonth() -1);
		
		o.setDate(d);
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(o);
		system.setCompletedOrders(orders);
		
		assertTrue(t.computeProfitFigures()[2] == 10*0.1 + 1 - 1);
	}

}
