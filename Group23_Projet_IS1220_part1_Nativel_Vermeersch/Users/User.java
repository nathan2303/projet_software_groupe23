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
	  this.Counter++;
	  this.id=Counter;
	  
  }

public User(String username, String password) {
	super();
	this.Counter++;
	this.id = Counter;
	this.username = username;
	this.password = password;
}
  
  

}