package logic.model;

public class BonusTran extends Transaction {

	private String description; 
	private int greenCoinAdded;
	public BonusTran(int id, String date, String description, int greenCoinAdded) {
		super(id, date);
		this.description = description;
		this.greenCoinAdded = greenCoinAdded;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getGreenCoinAdded() {
		return greenCoinAdded;
	}
	public void setGreenCoinAdded(int greenCoinAdded) {
		this.greenCoinAdded = greenCoinAdded;
	}
	@Override
	public String toString() {
		return "Bonus-> Description: " + description + ", Greencoin added: " + greenCoinAdded + ", id: " + id + ", Date: "
				+ date + "\n";
	}
	
	
	
}
