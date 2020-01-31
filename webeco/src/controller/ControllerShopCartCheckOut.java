package controller;

import enums.DeliveryStatus;

import enums.MesType;
import model.AbstractUser;
import model.ActivationCode;
import model.ActivationCodeTran;
import model.Message;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import bean.ActivationCodeBean;
import bean.ProductBean;
import model.Product;
import model.ShipmentTran;
import model.Singleton;
import persistence.ActivationCodeDAO;
import persistence.MessageDAO;
import persistence.ProductDAO;
import persistence.TransactionDAO;
import persistence.UserDAO;

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
	
	public boolean addProduct(int productId, HttpSession session) throws SQLException{

		AbstractUser user = (AbstractUser) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		
		Product product = ProductDAO.selectProduct(productId);

		user.getCart().addProduct(product);
		
		return true;
	}
	
	
	public boolean deleteProduct(int productId,  HttpSession session) throws SQLException{

		AbstractUser user = (AbstractUser) session.getAttribute("user");
		if (user == null) {
			return false;
		}
		
		Product product = ProductDAO.selectProduct(productId);
		
		user.getCart().deleteProduct(product);
		//System.out.println(user.getCart().getProductList().remove(product));
		return true;
	}
	
	public ArrayList<Product> checkCart( HttpSession session) throws SQLException{
		
		AbstractUser user = (AbstractUser) session.getAttribute("user");
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
	
	
	
	public boolean buyShopCart( HttpSession session) throws SQLException{
		
		
		AbstractUser user = (AbstractUser) session.getAttribute("user");
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
	
	
	public int enabledActivationCode(ActivationCodeBean code,  HttpSession session) throws SQLException {
		
		
		AbstractUser user = (AbstractUser) session.getAttribute("user");

		ActivationCode cod = ActivationCodeDAO.select(code.getActivationCode());
		
		
		if( cod != null) {
				
			int val = cod.getGrenCoinVal();
				
		
			ActivationCodeDAO.delete(cod);
		
			user.setGreenCoin(user.getGreenCoin() + val);
		
			UserDAO.update(user);
		
			ActivationCodeTran a = new ActivationCodeTran(0, time(), code.getActivationCode(), val);
		
			TransactionDAO.insertActivationCodeTran(a, user);
		
			user.getHistory().addTransaction(a);
		
		
			Message m = new Message(0, time(), "Riscossione GreenCoin da ActivationCode", "Hai riscosso " + val + " GreenCoin da un ActivationCode! ", MesType.ACTIVATIONCODE);
		
			MessageDAO.insert(m, user);
		
			user.getBoards().addMessage(m);
			
			System.out.println(user.getGreenCoin());
			
			return val;
			
			
		}
		
		return 0;
		
	}
	
	
}