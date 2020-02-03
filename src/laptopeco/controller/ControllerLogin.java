package controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import bean.UserBean;
import logic.model.AbstractUser;
import logic.model.ActivationCodeTran;
import logic.model.Address;
import logic.model.BonusMachine;
import logic.model.BonusTran;
import logic.model.History;
import logic.model.Message;
import logic.model.NoticeBoard;
import logic.model.Product;
import logic.model.ShipmentTran;
import logic.model.Singleton;
import logic.model.Transaction;
import logic.model.WishList;
import logic.persistence.AddressDAO;
import logic.persistence.MessageDAO;
import logic.persistence.TransactionDAO;
import logic.persistence.UserDAO;
import logic.persistence.WishListDAO;

public class ControllerLogin {
	Singleton singleton = Singleton.getInstance();
	
	public Boolean login(UserBean userBean) throws SQLException {
		
		String mail = userBean.getMail();
		String pass = userBean.getPass();
		AbstractUser user = UserDAO.findRegisteredUser(mail);
		if (user == null || !user.getPass().equals(pass)) {
			return false;
		}
		List<Product> productList = WishListDAO.select(user);
		WishList wishList = new WishList(productList);
		user.setWishList(wishList);
		
		List<ActivationCodeTran> actcodeTranList = TransactionDAO.selectActivationCodeTra(user);
		List<BonusTran> bonusTranList = TransactionDAO.selectBonusTran(user);
		List<ShipmentTran> shipmentList = TransactionDAO.selectShipment(user);
		ArrayList<Transaction> list = new ArrayList<>();
		list.addAll(actcodeTranList);
		list.addAll(bonusTranList);
		list.addAll(shipmentList);
		History history = new History(list);
		user.setHistory(history);
		
		List<Message> messageList = MessageDAO.select(user);
		NoticeBoard noticeBoard = new NoticeBoard(messageList);
		user.setBoards(noticeBoard);

		Address address = AddressDAO.select(user);
		user.setAddress(address);		
		BonusMachine machine = new BonusMachine(user);
		machine.getClass();
		singleton.setUser(user);	
		return true;
	}
	
	public AbstractUser giveUserForRole(UserBean u) throws SQLException {		
		return UserDAO.findRegisteredUser(u.getMail());
	}
	
}


