package webeco.src.controller;

import laptopeco.logic.enums.DeliveryStatus;


import laptopeco.logic.enums.MesType;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.ActivationCode;
import laptopeco.logic.model.ActivationCodeTran;
import laptopeco.logic.model.Message;
import java.security.SecureRandom;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import laptopeco.bean.ActivationCodeBean;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.ShipmentTran;
import laptopeco.logic.persistence.ActivationCodeDAO;
import laptopeco.logic.persistence.MessageDAO;
import laptopeco.logic.persistence.ProductDAO;
import laptopeco.logic.persistence.TransactionDAO;
import laptopeco.logic.persistence.UserDAO;

public class ControllerShopCartCheckOut {
	
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	public String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
	public String time() {
	   java.util.Date dt = new java.util.Date();

	   java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	   return sdf.format(dt);
	}
	
	public boolean addProduct(int productId, HttpSession session){

		AbstractUser user = (AbstractUser) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		
		Product product;
		try {
			product = ProductDAO.selectProduct(productId);
			user.getCart().addProduct(product);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return true;
	}
	
	
	public boolean deleteProduct(int productId, HttpSession session){

		AbstractUser user = (AbstractUser) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		
		Product product;
		try {
			product = ProductDAO.selectProduct(productId);
			user.getCart().deleteProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return true;
	}
	
	
	public boolean buyShopCart(HttpSession session) throws SQLException{
		
		
		AbstractUser user = (AbstractUser) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		
		
		if(user.getCart().getTotalPrice() > user.getGreenCoin()) {
			return false;
		}	
		
		
		user.setGreenCoin(user.getGreenCoin() - user.getCart().getTotalPrice());
		
		UserDAO.update(user);
		
		String tracknum = randomString(10);
		
		for(Product product: user.getCart().getProductList()) { //Aggiungo Transazione
			
			ShipmentTran s = new ShipmentTran(0,time(), tracknum, product, DeliveryStatus.SENT );
			
			TransactionDAO.insertShipment(s, user);
			
			user.getHistory().addTransaction(s);
			
			
			Message m = new Message(0,time(), "Acquisto prodotto", "Hai acquistato " + product.getName() + " al modico prezzo di " + product.getPrice(), MesType.PRODUCT);
			
			MessageDAO.insert(m, user);
			
			user.getBoards().addMessage(m);
			
			
		}
		
		user.getCart().clear();
		
	
		return true;
		
	}
	
	
	public int enabledActivationCode(ActivationCodeBean code, HttpSession session) throws SQLException {
		
		
		AbstractUser user = (AbstractUser) session.getAttribute("user");

		ActivationCode cod = ActivationCodeDAO.select(code.getActCodeBean());
		
		
		if( cod != null) {
				
			int val = cod.getGrenCoinVal();
				
		
			ActivationCodeDAO.delete(cod);
		
			user.setGreenCoin(user.getGreenCoin() + val);
		
			UserDAO.update(user);
		
			ActivationCodeTran a = new ActivationCodeTran(0, time(), code.getActCodeBean(), val);
		
			TransactionDAO.insertActivationCodeTran(a, user);
		
			user.getHistory().addTransaction(a);
		
		
			Message m = new Message(0, time(), "Riscossione GreenCoin da ActivationCode", "Hai riscosso " + val + " GreenCoin da un ActivationCode! ", MesType.ACTIVATIONCODE);
		
			MessageDAO.insert(m, user);
		
			user.getBoards().addMessage(m);
						
			return val;
			
			
		}
		
		return 0;
		
	}
	
	
}