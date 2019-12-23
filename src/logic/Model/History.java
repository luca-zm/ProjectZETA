package logic.Model;

import java.util.ArrayList;

public class History {
	private ArrayList<Transaction> tranList;

	public History(ArrayList<Transaction> tranList) {
		this.tranList = tranList;
	}
    
	public void addTransaction(String date, int productId, String productName, int value) {
		this.tranList.add(new Transaction (date, productId, productName, value));
	}
	
	// Generate a Bonus transaction in the list
	public void addBonus(String date, int value){
		this.tranList.add(new Transaction(date, value));
	}
	
	// Needed by Graphic Observer in View
	public ArrayList<Transaction> getList(){
		return tranList;
	}
	
	public void clear() {
		tranList.clear();
	}
}
