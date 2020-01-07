package logic.model;

import java.util.ArrayList;

public class History {
	private ArrayList<Transaction> tranList;

	public History(ArrayList<Transaction> tranList) {
		this.tranList = tranList;
	}
	
	//Default constructor create an empty list
	public History() {
		this.tranList = new ArrayList<Transaction>();
	}


	public void addTransaction(Transaction tran)
	{
		tranList.add(tran);
	}

	
	// Needed by Graphic Observer in View
	public ArrayList<Transaction> getList(){return tranList;}
	
	public void clear() {
		tranList.clear();
	}

	@Override
	public String toString() {
		return "History [tranList=" + tranList + "]";
	}
	
	
}
