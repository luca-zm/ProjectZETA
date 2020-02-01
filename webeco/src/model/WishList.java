package model;

import java.util.ArrayList;

public class WishList {
	private ArrayList<Product> list;


	public WishList(ArrayList<Product> list) {
		this.list = list;
	}

	public ArrayList<Product> getList() {
		return list;
	}

	public void setList(ArrayList<Product> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "WishList [list=" + list + "]";
	}

	public void addProduct(Product product) {
		this.list.add(product);
	}
	
	
	public void deleteProduct(Product product) {
		ArrayList<Product> appoggio = new ArrayList<Product>();
		int c = 0;
		for (Product p: this.list) {
			if(p.getId() != product.getId()){
				
				appoggio.add(p); //lista buona
			}
		}
		this.list = appoggio;
	}
		
	
	
	public void clear() {
		this.list.clear();
	}
}
