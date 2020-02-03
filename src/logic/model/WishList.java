package logic.model;

import java.util.List;

public class WishList {
	private List<Product> list;


	public WishList(List<Product> list) {
		this.list = list;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
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
