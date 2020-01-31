package model;

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
		ArrayList<Product> appoggio = new ArrayList<Product>();
		int c = 0;
		for (Product p: this.productList) {
			if(p.getId() != product.getId()){
				
				appoggio.add(p); //lista buona
			}
			else {
				if (c == 0){
					
					c = c + 1;
				}
				else {
					appoggio.add(p); //lista buona
				}
  
			}
		}
		this.productList = appoggio;
		if(c != 0) {
	     	this.totalPrice -= product.getPrice();
	     	return true;
		}
		return false;
//		if(this.productList.remove(product)) {
//			this.totalPrice -= product.getPrice();
//			return true;
//		}
//		return false;
	}
	
	public void clear() {
		this.productList.clear();
		this.totalPrice = 0;
	}


	@Override
	public String toString() {
		return "ProductList=" + productList + ", TotalPrice=" + totalPrice;
	}
	
	
}