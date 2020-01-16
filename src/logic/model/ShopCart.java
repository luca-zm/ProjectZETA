package logic.model;

import java.util.ArrayList;

public class ShopCart {
	private int id;
	private ArrayList<Product> productList;
	private int totalPrice;
	
	

	public ShopCart(int id, ArrayList<Product> productList, int totalPrice) {
		super();
		this.id = id;
		this.productList = productList;
		this.totalPrice = totalPrice;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public ArrayList<Product> getProductList() {
		return productList;
	}


	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public Boolean addProduct(Product product) {
		if(product == null) {
			return false;
		}
		this.productList.add(product);
		this.totalPrice += product.getPrice();
		return true;
	}
	
	
	public Boolean deleteProduct(Product product) {
		if(this.productList.remove(product)) {
			this.totalPrice = product.getPrice();
			return true;
		}
		return false;
	}
	
	public void clear() {
		this.productList.clear();
		this.totalPrice = 0;
	}


	@Override
	public String toString() {
		return "ShopCart [id=" + id + ", productList=" + productList + ", totalPrice=" + totalPrice + "]";
	}
	
	
}
