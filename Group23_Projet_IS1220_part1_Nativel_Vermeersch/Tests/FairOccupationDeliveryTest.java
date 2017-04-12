package Tests;

import java.util.ArrayList;

import Food.Order;
import Main.ConfigInitiale;
import Main.MyFoodora;
import Policies.FairOccupationDelivery;
import Users.Address;
import Users.Courier;
import junit.framework.TestCase;

public class FairOccupationDeliveryTest extends TestCase {
	/*
	 * Je place deux couriers l'un a déjà fait au moins une commande (larbin 2) et l'autre non, 
	 * je vérifie que le système me renvoie bien le courier le moins occupé lorsque j'appplique la fairoccupation policy
	 * 
	 */
	public void testFindCourier() {
		ConfigInitiale.launch();
		MyFoodora system =MyFoodora.getInstance();
		Courier larbin = system.getCouriersList().get("cdubois");
		ArrayList<Order> list = new ArrayList<>();
		larbin.setDeliveredOrders(list);
		Courier larbin2 = new Courier("jean", "dupont", "jpont", "password", new Address(0,0), "ceci est un numéro");
		system.addUser(larbin2);
		Order o = new Order();
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(o);
		larbin2.setDeliveredOrders(orders);
		system.addUser(larbin2);
		FairOccupationDelivery f = new FairOccupationDelivery();
		assertTrue(f.findCourier(o) == larbin);
		

}
}
