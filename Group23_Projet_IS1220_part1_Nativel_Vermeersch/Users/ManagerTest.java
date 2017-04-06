package Users;

import Main.ConfigInitiale;
import Main.Date;
import Main.MyFoodora;
import junit.framework.TestCase;
import Policies.TargetProfit_Markup;
public class ManagerTest extends TestCase {

	public void testAddUser() {
		ConfigInitiale.launch();
		Customer c1 = new Customer("Nathanou", "Vermeerschou", "nverou", "1234", new Address(0, 0), "nv@gmail.com", "0000");
		MyFoodora system = MyFoodora.getInstance();
		system.managersList.get("michou").addUser(c1);
		assertTrue(system.customersList.containsKey("nverou"));
	}

	public void testComputeProfit() {
		ConfigInitiale.launch();
		MyFoodora system = MyFoodora.getInstance();
		Manager manager = system.managersList.get("michou");
		Date d1 = new Date(1,1);
		Date d2 = new Date(1,2);
		assertTrue(manager.computeProfit(d1,d2) == 0);
		
	}

	public void testComputeTotalProfit() {
		ConfigInitiale.launch();
		MyFoodora system = MyFoodora.getInstance();
		Manager manager = system.managersList.get("michou");
		assertTrue(manager.computeTotalProfit() != 0);
	}
/*
 * it must return 0 while there is no order in this period item
 */
	public void testComputeIncome() {
		ConfigInitiale.launch();
		MyFoodora system = MyFoodora.getInstance();
		Manager manager = system.managersList.get("michou");
		Date d1 = new Date(1,1);
		Date d2 = new Date(1,2);
		assertTrue(manager.computeIncome(d1, d2) == 0);
	}
/*
 * It must be different of zero while there is an order in the system
 */
	public void testComputeTotalIncome() {
		ConfigInitiale.launch();
		MyFoodora system = MyFoodora.getInstance();
		Manager manager = system.managersList.get("michou");
		assertTrue(manager.computeTotalIncome() !=0);
	}

	public void testComputeIncomePerCustomer() {
		ConfigInitiale.launch();
		MyFoodora system = MyFoodora.getInstance();
		Manager manager = system.managersList.get("michou");
		Date d1 = new Date(1,1);
		Date d2 = new Date(1,2);
		assertTrue(manager.computeIncomePerCustomer(d1, d2) == 0);
	}

	public void testSetProfitPolicy() {
		ConfigInitiale.launch();
		MyFoodora system = MyFoodora.getInstance();
		Manager manager = system.managersList.get("michou");
		manager.setProfitPolicy(new TargetProfit_Markup(1.0, 1.0, 1.0));
		assertTrue(system.getProfitPolicy().getClass()==TargetProfit_Markup.class);
	}

	public void testDetermineMostLessSellingRestaurant() {
		fail("Not yet implemented");
	}

	public void testDetermineMoreLessActiveCourier() {
		fail("Not yet implemented");
	}

}
