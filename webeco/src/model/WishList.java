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
		this.list.remove(product);
		
	}
	
	public void clear() {
		this.list.clear();
	}
}
