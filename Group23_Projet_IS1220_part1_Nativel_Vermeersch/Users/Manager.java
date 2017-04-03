package Users;
import Main.MyFoodora;
import Policies.DeliveryPolicy;

public class Manager extends User {

	private String name;
	
	private String surname;
	

	
	public Manager(String name, String surname, String username, String password) {
		super(username, password);
		this.name = name;
		this.surname = surname;
	}
	
	public void addUser(User u){
	  }
	
	public void removeUser(User u) {
	  }
	
	public void activateUser(User u) {
	  }
	
	public void deactivateUser(User u) {
	  }
	
	public double computeProfit() {
	  return 0.0;
	  }
	
	public double computeIncome() {
	  return 0.0;
	  }
	
	public double computeIncomePerCustomer() {
	  return 0.0;
	  }
	
	public void setDeliveryPolicy(DeliveryPolicy dp) {
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

}