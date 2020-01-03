package logic.Model;

public class Transaction {
	private String date;
	private int productId;
	private String productName;
	private int value;
	private TranType type;
	
	//Normal Constructor
	public Transaction(String date, int productId, String productName, int value, TranType type) {
		this.date = date;
		this.productId = productId;
		this.productName = productName;
		this.value = value;
		this.type = type;
	}
		

	public String getDate() {
		return date;
	}

	public int getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public int getValue() {
		return value;
	}

	public TranType getType() {
		return type;
	}


	@Override
	public String toString() {
		return "Transaction [date=" + date + ", productId=" + productId + ", productName=" + productName + ", value="
				+ value + "]";
	}
	
	

}
