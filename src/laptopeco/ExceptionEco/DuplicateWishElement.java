package laptopeco.ExceptionEco;

//Davide Verardo
public class DuplicateWishElement extends Exception {

	private static final long serialVersionUID = 1L;

	public DuplicateWishElement() {
		super("Product is already in your wishlist");
	}

	@Override
	public String toString() {
		return getMessage();

	
	}

}