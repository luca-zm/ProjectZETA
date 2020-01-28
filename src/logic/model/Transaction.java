package logic.model;

public class Transaction {
	protected int id;
	protected String date;
	
	
	public Transaction(int id, String date) {
		super();
		this.id = id;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "id: " + id + ", date: " + date;
	}
	
	
	
	

}
