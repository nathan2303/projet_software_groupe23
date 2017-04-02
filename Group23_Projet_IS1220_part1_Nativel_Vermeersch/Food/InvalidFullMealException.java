package Food;

public class InvalidFullMealException extends Exception {

	
	public InvalidFullMealException() {
		// TODO Auto-generated constructor stub
		
	}

	public InvalidFullMealException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidFullMealException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public InvalidFullMealException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public InvalidFullMealException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		try{
			throw new InvalidFullMealException("wrong");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public String getMessage(){
		return("A full meal must contain a starter, a main-dish and a dessert.");
	}

}
