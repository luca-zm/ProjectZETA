package controller;

import java.sql.SQLException;

import bean.ProductBean;
import enums.Category;
import model.Product;
import persistence.ProductDAO;

public class ControllerManageProduct {
	public Boolean addProduct(ProductBean productBean) throws SQLException {
		int id = productBean.getId();
		String name = productBean.getName();
		int price = productBean.getPrice();
		int discount = productBean.getDiscountPercentage();
		Category cat = productBean.getCategory();
		String image = productBean.getImage();
		String descr = productBean.getDescription();
		Boolean avail = productBean.isAvailability();
		Product p = new Product(id, name, price, discount, cat, image, descr, avail);
		ProductDAO.insert(p);
		return true;
	}
	
//	public Boolean deleteProduct(ProductBean productBean) throws SQLException {
//		int id = productBean.getId();
//		ProductDAO.delete(id);
//		return true;
//	}
	
	
	public Boolean setProductAvailability(ProductBean productBean, Boolean av) throws SQLException {
		int id = productBean.getId();
		String name = productBean.getName();
		int price = productBean.getPrice();
		int discount = productBean.getDiscountPercentage();
		Category cat = productBean.getCategory();
		String image = productBean.getImage();
		String descr = productBean.getDescription();
		Product p = new Product(id, name, price, discount, cat, image, descr, av);
		ProductDAO.update(p);
		return true;
	}
	
	public Boolean updateProduct(ProductBean productBean) throws SQLException {
		int id = productBean.getId();
		String name = productBean.getName();
		int price = productBean.getPrice();
		int discount = productBean.getDiscountPercentage();
		Category cat = productBean.getCategory();
		String image = productBean.getImage();
		String descr = productBean.getDescription();
		Boolean avail = productBean.isAvailability();
		Product p = new Product(id, name, price, discount, cat, image, descr, avail);
		ProductDAO.update(p);
		return true;
	}

}
