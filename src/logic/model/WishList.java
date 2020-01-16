package logic.model;

import java.util.ArrayList;

public class WishList {
	private int id;
	private ArrayList<Product> list;


	public WishList(int id, ArrayList<Product> list) {
		super();
		this.id = id;
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Product> getList() {
		return list;
	}

	public void setList(ArrayList<Product> list) {
		this.list = list;
	}
	
	@Override
	public String toString() {
		return "WishList [id=" + id + ", list=" + list + "]";
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
