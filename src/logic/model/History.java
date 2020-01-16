package logic.model;

import java.util.ArrayList;

public class History {
	private int id;
	private ArrayList<Transaction> tranList;
	
	public History(int id, ArrayList<Transaction> tranList) {
		super();
		this.id = id;
		this.tranList = tranList;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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
		return "History [id=" + id + ", tranList=" + tranList + "]";
	}

	
}
