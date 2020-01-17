package logic.model;

import java.util.ArrayList;

public class History {
	private ArrayList<Transaction> tranList;
	
	public History(ArrayList<Transaction> tranList) {
		this.tranList = tranList;
	}

	public ArrayList<Transaction> getTranList() {
		return tranList;
	}


	public void setTranList(ArrayList<Transaction> tranList) {
		this.tranList = tranList;
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
