package laptopeco.logic.model;

import java.util.ArrayList;
import java.util.List;

public class ShopCart {
	private List<Product> productList;
	private int totalPrice;
	
	public ShopCart() {
		this.productList = new ArrayList<>();
		this.totalPrice = 0;
	}
	
	public List<Product> getProductList() {
		return productList;
	}


	public void setProductList(List<Product> productList) {
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
		ArrayList<Product> appoggio = new ArrayList<>();
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
