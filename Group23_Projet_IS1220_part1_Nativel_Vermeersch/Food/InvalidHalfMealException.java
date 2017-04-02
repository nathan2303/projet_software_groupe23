package Food;

public class InvalidHalfMealException extends Exception {

	public InvalidHalfMealException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidHalfMealException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidHalfMealException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidHalfMealException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidHalfMealException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public String getMessage(){
		return("A half meal must contain either one starter and one main-dish, or one main dish and one dessert.");
	}

}
