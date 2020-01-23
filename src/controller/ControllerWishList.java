package controller;

import java.security.SecureRandom;
import java.sql.SQLException;

import bean.ProductBean;
import logic.enums.DeliveryStatus;
import logic.enums.MesType;
import logic.model.AbstractUser;
import logic.model.Message;
import logic.model.Product;
import logic.model.ShipmentTran;
import logic.model.Singleton;
import logic.model.User;
import logic.persistence.ProductDAO;
import logic.persistence.TransactionDAO;
import logic.persistence.UserDAO;
import logic.persistence.WishListDAO;

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
	
	
	Singleton singleton = Singleton.getInstance();
	
	
	public boolean addProductinWishList(ProductBean p) throws SQLException{

		AbstractUser user = singleton.getUser();
		if (user == null) {
			return false;
		}
		
		Product product = ProductDAO.selectProduct(p.getId());
		
		WishListDAO.insert(user, product);

		user.getWishList().addProduct(product);
		 
		
		
		return true;
	}
	
	
	public boolean deleteProductfromWishList(ProductBean p) throws SQLException{

		AbstractUser user = singleton.getUser();
		if (user == null) {
			return false;
		}
		
		Product product = ProductDAO.selectProduct(p.getId());
		
		WishListDAO.delete(user, product);

		user.getWishList().deleteProduct(product);
		
		
		
		return true;
	}
	
	
	public boolean clearWishList() throws SQLException {
		
		AbstractUser user = singleton.getUser();
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
