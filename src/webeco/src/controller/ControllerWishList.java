package webeco.src.controller;

import java.security.SecureRandom;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.Product;
import laptopeco.logic.persistence.ProductDAO;
import laptopeco.logic.persistence.WishListDAO;

public class ControllerWishList {
	
	
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	java.util.Date dt = new java.util.Date();

	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	String currentTime = sdf.format(dt);
	
	
	public boolean addProductinWishList(int productId, HttpSession session){

		AbstractUser user = (AbstractUser) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		
		Product product;
		try {
			product = ProductDAO.selectProduct(productId);
			WishListDAO.insert(user, product);
			user.getWishList().addProduct(product);
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return true;
	}
	
	
	public boolean deleteProductfromWishList(int productId, HttpSession session) throws SQLException{

		AbstractUser user = (AbstractUser) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		
		Product product = ProductDAO.selectProduct(productId);
		
		WishListDAO.delete(user, product);

		user.getWishList().deleteProduct(product);
		
		
		
		return true;
	}
	
	
	public boolean clearWishList(HttpSession session) throws SQLException {
		
		AbstractUser user = (AbstractUser) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		
		
		for( Product p : user.getWishList().getList() ) {
			
			WishListDAO.delete(user, p);
			
		}
			
		
		user.getWishList().clear();
		
		return true;
		
	}
				
				
	
				
}
