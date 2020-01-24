package controller;

import logic.enums.DeliveryStatus;

import logic.enums.MesType;
import logic.model.AbstractUser;
import logic.model.ActivationCode;
import logic.model.ActivationCodeTran;
import logic.model.Message;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.ActivationCodeBean;
import bean.ProductBean;
import logic.model.Product;
import logic.model.ShipmentTran;
import logic.model.Singleton;
import logic.persistence.ActivationCodeDAO;
import logic.persistence.MessageDAO;
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
	
	java.util.Date dt = new java.util.Date();

	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	String currentTime = sdf.format(dt);
	
	
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
	
	public ArrayList<Product> checkCart() throws SQLException{
		
		AbstractUser user = singleton.getUser();
		if (user == null) {
			return null;
		}
		
		ArrayList<Product> list = new ArrayList<Product>();
		for( Product product : user.getCart().getProductList()) {
			
			
			Product prod = ProductDAO.selectProduct(product.getId());
			if ( !prod.isAvailability()) {
				
				list.add(product);
				user.getCart().deleteProduct(product);
			}
				
		}
		return list;
		
	}
	
	
	
	public boolean buyShopCart() throws SQLException{
		
		
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
			
			TransactionDAO.insertShipment(s, user);
			
			user.getHistory().addTransaction(s);
			
			
			Message m = new Message(0,currentTime, "Acquisto prodotto", "Hai acquistato " + product.getName() + " al modico prezzo di " + product.getPrice(), MesType.PRODUCT);
			
			MessageDAO.insert(m, user);
			
			user.getBoards().addMessage(m);
			
			
		}
		
		user.getCart().clear();
		
	
		return true;
		
	}
	
	
	public int enabledActivationCode(ActivationCodeBean code) throws SQLException {
		
		
		AbstractUser user = singleton.getUser();

		ActivationCode cod = ActivationCodeDAO.select(code.getActivationCode());
		
		
		if( cod != null) {
				
			int val = cod.getGrenCoinVal();
				
		
			ActivationCodeDAO.delete(cod);
		
			user.setGreenCoin(user.getGreenCoin() + val);
		
			UserDAO.update(user);
		
			ActivationCodeTran a = new ActivationCodeTran(0, currentTime, code.getActivationCode(), val);
		
			TransactionDAO.insertActivationCodeTran(a, user);
		
			user.getHistory().addTransaction(a);
		
		
			Message m = new Message(0,currentTime, "Riscossione GreenCoin da ActivationCode", "Hai riscosso " + val + " GreenCoin da un ActivationCode! ", MesType.ACTIVATIONCODE);
		
			MessageDAO.insert(m, user);
		
			user.getBoards().addMessage(m);
			
			return val;
			
			
		}
		
		return 0;
		
	}
	
	
}		


	
	
	




