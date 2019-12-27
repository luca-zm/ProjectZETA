package logic.Model;

import java.util.ArrayList;

public class History {
	private ArrayList<Transaction> tranList;

	public History(ArrayList<Transaction> tranList) {
		this.tranList = tranList;
	}
    
	//Add new LEARN Transaction. ProductId and ProductName are set to default 
	public void AddLearnTran(String date, int value) {
		this.tranList.add(new Transaction (date, 0, null, value, TranType.LEARN));
	}
	
	//Add new SPEND Transaction.
	public void AddSpendTran(String date, Product product) {
		this.tranList.add(new Transaction (date, product.getId(), product.getName(), product.getPrice(), TranType.SPEND));
	}
	
	//Add new BONUS Transaction. ProductId and ProductName are set to default 
	public void AddBonusTran(String date, int value) {
		this.tranList.add(new Transaction (date, 0, null, value, TranType.BONUS));
	}
	
	
	// Needed by Graphic Observer in View
	public ArrayList<Transaction> getList(){return tranList;}
	
	public void clear() {
		tranList.clear();
	}
}
