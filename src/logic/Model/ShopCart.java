package logic.Model;

import java.util.ArrayList;

public class ShopCart {
	private ArrayList<Product> productList;
	private int totalPrice;
	
	public ShopCart(ArrayList<Product> productList, int totalPrice) {
		this.productList = productList;
		this.totalPrice = totalPrice;
	}
	
	public ArrayList<Product> getProductList() {return productList;}

	public int getTotalPrice() {return totalPrice;}



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
			this.totalPrice -= product.getPrice();
			return true;
		}
		return false;
	}
	
	public void clear() {
		this.productList.clear();
		this.totalPrice = 0;
	}
}
