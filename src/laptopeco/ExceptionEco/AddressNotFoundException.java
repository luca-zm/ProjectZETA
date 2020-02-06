package laptopeco.ExceptionEco;

public class AddressNotFoundException extends Exception {
	//Stefano Costanzo
	
	private static final long serialVersionUID = 1L;

	public AddressNotFoundException() {
		super("Address not found by Google Maps API !");
	}

	@Override
	public String toString() {
		return getMessage();
	}
}


