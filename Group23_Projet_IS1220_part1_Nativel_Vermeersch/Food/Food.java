package Food;
import Users.Visitor;


public abstract class Food {

  protected double price;
  protected String name;
  
  public Food() {

}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

@Override
public boolean equals(Object obj){
	if (obj instanceof Food){
		Food obj1 = (Food) obj;
		Boolean res = this.name == obj1.name;
		return(res);
	}
	return false;

}



public abstract double accept(Visitor v);

}