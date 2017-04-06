package Users;
import Main.Date;
import Main.MyFoodora;
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
	
	public void determineMostLessSellingRestaurant(){
		String mostRes;
		String lessRes;
		double mostSell = 0.0;
		double lessSell = system.computeTotalIncome();  // je prends cette valeur initiale car un restaurant ne peut pas vendre plus que le revenu total du système
		for (String mapKey : system.restaurantsList.keySet()){
			if ( system.restaurantsList.get(mapKey).getTotalProfit() > mostSell)
			{
				mostSell = system.restaurantsList.get(mapKey).getTotalProfit();
				mostRes = mapKey;
			}
			if ( system.restaurantsList.get(mapKey).getTotalProfit() < lessSell){
				lessSell = system.restaurantsList.get(mapKey).getTotalProfit();
				lessRes = mapKey;
			}
					
				}
		}

}