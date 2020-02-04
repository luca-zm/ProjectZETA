package webeco.src.controller;

import java.sql.SQLException;
import laptopeco.bean.ProductBean;
import laptopeco.logic.enums.Category;
import laptopeco.logic.model.Product;
import laptopeco.logic.persistence.ProductDAO;

public class ControllerManageProduct {
	public Boolean addProduct(ProductBean productBean) throws SQLException {
		int id = productBean.getIdProductBean();
		String name = productBean.getNameProductBean();
		int price = productBean.getPriceBean();
		int discount = productBean.getDiscountPercentageBean();
		Category cat = productBean.getCategoryBean();
		String image = productBean.getImageProductBean();
		String descr = productBean.getDescriptionProductBean();
		Product p = new Product(id, name, price, discount, cat, image, descr);
		ProductDAO.insert(p);
		return true;
	}
	
	public Boolean deleteProduct(ProductBean productBean) throws SQLException {
		int id = productBean.getIdProductBean();
		ProductDAO.delete(id);
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
		Product p = new Product(id, name, price, discount, cat, image, descr);
		ProductDAO.update(p);
		return true;
	}

}
