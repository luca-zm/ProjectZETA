package laptopeco.logic.model;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class History {
	private List<Transaction> tranList;
	private ArrayList<Observer> listObserver;
	
	public History(List<Transaction> tranList) {
		this.tranList = tranList;
		this.listObserver = new ArrayList<>();
	}	
	// Observer Pattern
	
	public void attach(Observer observer){
		  listObserver.add(observer);
	}

	public void detach(Observer observer){
	  listObserver.remove(observer);
	}

	 public void inform() throws SQLException{
	   for(Observer ob: listObserver) {
		   ob.update();
	   }
	 }

	public List<Transaction> getTranList() {
		return tranList;
	}


	public void setTranList(List<Transaction> tranList) {
		this.tranList = tranList;
	}


	public void addTransaction(Transaction tran) throws SQLException
	{
		inform();
		tranList.add(tran);
	}


	
	public void clear() {
		tranList.clear();
	}
	


	@Override
	public String toString() {
		return "History:tranList: " + tranList;
	}

	
}
