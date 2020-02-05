package laptopeco.ExceptionEco;

//Luca Zammariello
public class NotAnIntegerException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAnIntegerException() {
		super("ActicationCode must be a number ! Try again");
	}

	@Override
	public String toString() {
		return getMessage();
	
	}
}
