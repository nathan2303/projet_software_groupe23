package Users;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import Main.Date;
import Policies.DeliveryPolicy;
import Policies.ProfitPolicy;

public class Manager extends User {

	private String name;
	private String surname;
	
	public Manager(String name, String surname, String username, String password) {
		super(username, password);
		this.name = name;
		this.surname = surname;
	}
	public Manager() {
		// TODO Auto-generated constructor stub
	}
	public void addUser(User u){
		system.addUser(u);
	  }
	public void removeUser(User u) {
		system.removeUser(u);
	  }
	public void activateUser(User u) {
		system.activateUser(u);
	  }
	
	public void deactivateUser(User u) {
		system.deactivateUser(u);
	  }
	
	public double computeProfit(Date start, Date end) {
		return system.computeProfit(start, end);
	  }
	public double computeTotalProfit() {
		return system.computeTotalProfit();
	  }
	public double computeIncome(Date start, Date end) {
		return system.computeIncome(start, end);
	  }
	public double computeTotalIncome() {
		return system.computeTotalIncome();
	  }
	
	public double computeIncomePerCustomer(Date start, Date end) {
	  return system.computeIncomePerCustomer(start, end);
	  }
	
	public void setDeliveryPolicy(DeliveryPolicy dp) {
		system.setDeliveryPolicy(dp);
	  }
	
	/**
	 * changes the attribute in MyFoodora but also updates profit figures (markup, etc)
	 * @param pp ProfitPolicy
	 */
	public void setProfitPolicy(ProfitPolicy pp) {
		system.setProfitPolicy(pp);
	  }
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public ArrayList<Restaurant> determineMostLessSellingRestaurant(){
		String mostRes = new String();
		String lessRes = new String();
		HashMap<String,Restaurant> res = system.getRestaurantsList();
		ArrayList<Restaurant> res2 = new ArrayList<Restaurant>(res.values());
		Collections.sort(res2, new Comparator<Restaurant>(){
			public int compare(Restaurant r1, Restaurant r2){
				return (int)r1.getTotalProfit()-(int)r2.getTotalProfit();
			}
			});
		double mostSell = 0.0;
		double lessSell = system.computeTotalIncome();  // je prends cette valeur initiale car un restaurant ne peut pas vendre plus que le revenu total du système
		for (String mapKey : system.getRestaurantsList().keySet()){
			if ( system.getRestaurantsList().get(mapKey).getTotalProfit() > mostSell)
			{
				mostSell = system.getRestaurantsList().get(mapKey).getTotalProfit();
				mostRes = mapKey;
			}
			if ( system.getRestaurantsList().get(mapKey).getTotalProfit() < lessSell){
				lessSell = system.getRestaurantsList().get(mapKey).getTotalProfit();
				lessRes = mapKey;
			}
					
		}
	System.out.println("the most selling restaurant is "+mostRes+" with "+mostSell +"of sells");
	System.out.println("the least selling restaurant is "+lessRes+" with "+lessSell +" of sells");
	HashMap<Restaurant, Double> res3 = new HashMap<Restaurant,Double>();
	for(Restaurant r : res2){
		System.out.println(r+": "+r.getTotalProfit()+"€");
		
	}
	return res2;
	}
	
	public ArrayList<Courier> determineMostLessActiveCourier(){
		HashMap<String, Courier> list = system.getCouriersList();
		ArrayList<Courier> res2 = new ArrayList<Courier>(list.values());
		Collections.sort(res2, new Comparator<Courier>(){
			public int compare(Courier c1, Courier c2){
				return c1.getDeliveredOrders().size()-c2.getDeliveredOrders().size();
			}
			});
		if (list.isEmpty() == false){
			
		String maxres = new String();
		int maxresOccupation = 0;
		String minres = new String();
		int minresOccupation = system.getCompletedOrders().size();
		
		for (String c : list.keySet()){
			if (list.get(c).getDeliveredOrders().size()>maxresOccupation){
					maxres = c;
					maxresOccupation = list.get(c).getDeliveredOrders().size();
			}
			if (list.get(c).getDeliveredOrders().size() < minresOccupation){
				minres = c;
				minresOccupation = list.get(c).getDeliveredOrders().size();
			}
		}
		System.out.println("the most active courier is" + maxres + ",  with " + maxresOccupation +" courses");
		System.out.println("the least active courier is" + minres + ", with " + minresOccupation + " courses");
		}
		for(Courier c : res2){
			System.out.println(c+": "+c.getDeliveredOrders().size()+" delivered orders");
			
		}
		
		return res2;
	}
	public String toString(){
		return this.surname + " " + this.name;
	}
	
}