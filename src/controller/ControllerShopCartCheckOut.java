package controller;

import logic.enums.DeliveryStatus;
import logic.enums.MesType;
import logic.model.AbstractUser;
import logic.model.Message;

import java.security.SecureRandom;
import java.sql.SQLException;

import bean.ProductBean;
import logic.model.Product;
import logic.model.ShipmentTran;
import logic.model.Singleton;
import logic.persistence.ProductDAO;
import logic.persistence.TransactionDAO;
import logic.persistence.UserDAO;

public class ControllerShopCartCheckOut {
	
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	
	Singleton singleton = Singleton.getInstance();
	
	public boolean addProduct(ProductBean p) throws SQLException{

		AbstractUser user = singleton.getUser();
		if (user == null) {
			return false;
		}
		
		Product product = ProductDAO.selectProduct(p.getId());

		user.getCart().addProduct(product);
		
		return true;
	}
	
	
	public boolean deleteProduct(ProductBean p) throws SQLException{

		AbstractUser user = singleton.getUser();
		if (user == null) {
			return false;
		}
		
		Product product = ProductDAO.selectProduct(p.getId());

		user.getCart().deleteProduct(product);
		
		return true;
	}
	
	
	
	public boolean buyShopCart() throws SQLException{
		
		
		java.util.Date dt = new java.util.Date();

		java.text.SimpleDateFormat sdf = 
		     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(dt);
		
		AbstractUser user = singleton.getUser();
		if (user == null) {
			return false;
		}
		
		if(user.getCart().getTotalPrice() > user.getGreenCoin()) {
			System.out.println("Errore, non hai abbastanza Coin");
			return false;
		}	
		
		
		user.setGreenCoin(user.getGreenCoin() - user.getCart().getTotalPrice());
		
		UserDAO.update(user);
		
		String tracknum = randomString(10);
		
		for(Product product: user.getCart().getProductList()) { //Aggiungo Transazione
			
			ShipmentTran s = new ShipmentTran(0,currentTime, tracknum, product, DeliveryStatus.SENT );
			
			user.getHistory().addTransaction(s);
			
			TransactionDAO.insertShipment(s, user);
			
			Message m = new Message(0,currentTime, "Acquisto prodotto", "Hai acquistato " + product.getName() + " al modico prezzo di " + product.getPrice(), MesType.PRODUCT);
			
			user.getBoards().addMessage(m);
		}
		
		user.getCart().clear();
		
	
		return true;
		
	}
		
}

	
	
	




