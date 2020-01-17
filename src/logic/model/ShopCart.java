package logic.model;

import java.util.ArrayList;

public class ShopCart {
	private ArrayList<Product> productList;
	private int totalPrice;
	
	public ShopCart() {
		this.productList = new ArrayList<Product>();
		this.totalPrice = 0;
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
