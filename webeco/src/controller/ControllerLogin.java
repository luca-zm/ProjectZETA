package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import bean.AddressBean;
import bean.UserBean;
import model.AbstractUser;
import model.ActivationCodeTran;
import model.Address;
import model.BonusMachine;
import model.BonusTran;
import model.History;
import model.Message;
import model.NoticeBoard;
import model.Product;
import model.ShipmentTran;
import model.ShopCart;
import model.Singleton;
import model.Transaction;
import model.WishList;
import persistence.ActivationCodeDAO;
import persistence.AddressDAO;
import persistence.MessageDAO;
import persistence.ProductDAO;
import persistence.TransactionDAO;
import persistence.UserDAO;
import persistence.WishListDAO;

public class ControllerLogin {
	
	public Boolean login(UserBean userBean, HttpSession session) throws SQLException {		
		String mail = userBean.getMail();
		String pass = userBean.getPass();
		AbstractUser user = UserDAO.findRegisteredUser(mail);
		if (user == null || !user.getPass().equals(pass)) {
			return false;
		}
		
		ShopCart shopcart = new ShopCart();
		ArrayList<Product> productList = WishListDAO.select(user);
		WishList wishList = new WishList(productList);
		user.setWishList(wishList);
		
		ArrayList<ActivationCodeTran> actcodeTranList = TransactionDAO.selectActivationCodeTra(user);
		ArrayList<BonusTran> bonusTranList = TransactionDAO.selectBonusTran(user);
		ArrayList<ShipmentTran> shipmentList = TransactionDAO.selectShipment(user);
		ArrayList<Transaction> list = new ArrayList<Transaction>();
		list.addAll(actcodeTranList);
		list.addAll(bonusTranList);
		list.addAll(shipmentList);
		History history = new History(list);
		user.setHistory(history);
		
		ArrayList<Message> messageList = MessageDAO.select(user);
		NoticeBoard noticeBoard = new NoticeBoard(messageList);
		user.setBoards(noticeBoard);

		Address address = AddressDAO.select(user);
		user.setAddress(address);
		
		BonusMachine machine = new BonusMachine(user);		
		
		session.setAttribute("user", user);
		
		
		return true;
	}


}
