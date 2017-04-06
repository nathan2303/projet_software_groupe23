package Users;

/**
 * simple class to model a x,y position
 * @author natha
 *
 */

public class Address {
	
	private double x;
	private double y;

	public Address() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * address class
	 * @param x : x coordinate
	 * @param y : y coordinate
	 */
	public Address(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getDistanceTo(Address address){
		return Math.sqrt(Math.pow(this.x-address.getX(),2)+Math.pow(this.y-address.getY(),2));
	}
	

	public boolean equals(Address a){
		return(this.getX() == a.getX() && this.getY() == a.getY());
		
	}
	
	
	
	

}
