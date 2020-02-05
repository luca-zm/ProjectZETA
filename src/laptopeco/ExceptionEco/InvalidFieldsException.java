package laptopeco.ExceptionEco;

//Davide Verardo
public class InvalidFieldsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFieldsException() {
		super("Invalid fields!");
	}

	@Override
	public String toString() {
		return getMessage();
	
	}
	

}