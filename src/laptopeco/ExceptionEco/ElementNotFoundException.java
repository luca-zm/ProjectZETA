package laptopeco.ExceptionEco;

public class ElementNotFoundException extends Exception{
	//Stefano Costanzo

	private static final long serialVersionUID = 1L;

	public ElementNotFoundException() {
		super("Element not Found !");
	}

	@Override
	public String toString() {
		return getMessage();
	}
}

