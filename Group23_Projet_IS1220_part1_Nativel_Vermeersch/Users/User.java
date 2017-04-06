package Users;

import Main.MyFoodora;

public abstract class User {

  public int id;

  public String username;

  public String password;
  
  private static int Counter = 0;
  
  protected MyFoodora system = MyFoodora.getInstance();
  
  
  public User(){
	  super();
	  Counter++;
	  this.id=Counter;
	  
  }

public User(String username, String password) {
	super();
	Counter++;
	this.id = Counter;
	this.username = username;
	this.password = password;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}
  


  

}