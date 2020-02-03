package controller;

import java.sql.SQLException;
import bean.ProductBean;
import logic.enums.Category;
import logic.model.Product;
import logic.persistence.ProductDAO;

public class ControllerManageProduct {
	public Boolean addProduct(ProductBean productBean) throws SQLException {
		int id = productBean.getIdProductBean();
		String name = productBean.getNameProductBean();
		int price = productBean.getPriceBean();
		int discount = productBean.getDiscountPercentageBean();
		Category cat = productBean.getCategoryBean();
		String image = productBean.getImageProductBean();
		String descr = productBean.getDescriptionProductBean();
		Boolean avail = productBean.isAvailabilityBean();
		Product p = new Product(id, name, price, discount, cat, image, descr, avail);
		ProductDAO.insert(p);
		return true;
	}
	
	public Boolean deleteProduct(ProductBean productBean) throws SQLException {
		int id = productBean.getIdProductBean();
		ProductDAO.delete(id);
		return true;
	}
	
	
	public Boolean setProductAvailability(ProductBean productBean, Boolean av) throws SQLException {
		int id = productBean.getIdProductBean();
		String name = productBean.getNameProductBean();
		int price = productBean.getPriceBean();
		int discount = productBean.getDiscountPercentageBean();
		Category cat = productBean.getCategoryBean();
		String image = productBean.getImageProductBean();
		String descr = productBean.getDescriptionProductBean();
		Product p = new Product(id, name, price, discount, cat, image, descr, av);
		ProductDAO.update(p);
		return true;
	}
	
	public Boolean updateProduct(ProductBean productBean) throws SQLException {
		int id = productBean.getIdProductBean();
		String name = productBean.getNameProductBean();
		int price = productBean.getPriceBean();
		int discount = productBean.getDiscountPercentageBean();
		Category cat = productBean.getCategoryBean();
		String image = productBean.getImageProductBean();
		String descr = productBean.getDescriptionProductBean();
		Boolean avail = productBean.isAvailabilityBean();
		Product p = new Product(id, name, price, discount, cat, image, descr, avail);
		ProductDAO.update(p);
		return true;
	}

}
