package laptopeco.test.model;

import static org.junit.Assert.*;


import java.sql.SQLException;

import org.junit.Test;

import laptopeco.bean.ProductBean;
import laptopeco.controller.ControllerManageProduct;
import laptopeco.logic.enums.Category;
import laptopeco.logic.model.Product;
import laptopeco.logic.persistence.ProductDAO;


//Davide Verardo Test1 ControllerManageProduct

public class testControllerManageProduct {

	ControllerManageProduct controltest = new ControllerManageProduct();
	ProductBean p2 = new ProductBean(0, "testproduct", 200, 0, Category.UTILITY, "testpath2", "test description");
	Product ptest = new Product(0, "testproduct2", 200, 0, Category.UTILITY, "testpath2", "test description");

	
	@Test
	public void testaddProduct() throws SQLException {  //tests the inclusion of a product in the DB

		controltest.addProduct(p2);
		boolean var = false;
		for ( Product p : ProductDAO.select()) { 
			  if(p.getName() == p2.getNameProductBean()) {
					  if( p.getPrice()== p2.getPriceBean()) {
						  var = true;
					  }
			  }
			  else {
				  var = false;
			  }
		}
		
			assertEquals(false, var);
		}
		
		
	@Test
	public void testdeleteProduct() throws SQLException {  //tests the elimination of a product in the DB

		controltest.deleteProduct(p2);
		boolean var = false;
		for ( Product p : ProductDAO.select()) { 
			  if(p.getName() != p2.getNameProductBean()) {
					  if( p.getPrice() != p2.getPriceBean()) {
						  var = true;
					  }
			  }
			  else {
				  var = false;
			  }
		}
		
			assertEquals(false, var);
		}
		
		
		
			
		
		
			
}
	
