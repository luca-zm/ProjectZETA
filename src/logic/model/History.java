package logic.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

public class History {
	private ArrayList<Transaction> tranList;
	private Vector listObserver;
	
	public History(ArrayList<Transaction> tranList) {
		this.tranList = tranList;
		this.listObserver = new java.util.Vector();
	}
	
	
	// Observer Pattern
	
	public void attach(Observer observer){
		  listObserver.addElement(observer);
	}

	public void detach(Observer observer){
	  listObserver.removeElement(observer);
	}

	 public void inform() throws SQLException{
	   java.util.Enumeration enumeration = listObservers();
	   while (enumeration.hasMoreElements()) {
	     ((Observer)enumeration.nextElement()).update();
	    }
	 }
	 
	  public Enumeration listObservers(){
		 	return ((java.util.Vector) listObserver.clone()).elements();
	   }
	


	public ArrayList<Transaction> getTranList() {
		return tranList;
	}


	public void setTranList(ArrayList<Transaction> tranList) {
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
		return "History [tranList=" + tranList + "]";
	}

	
}
