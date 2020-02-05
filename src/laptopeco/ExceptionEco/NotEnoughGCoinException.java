package laptopeco.ExceptionEco;

//Luca Zammariello
public class NotEnoughGCoinException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotEnoughGCoinException() {
		super("Not enough greencoin!");
	}

	@Override
	public String toString() {
		return getMessage();
	
	}
}
