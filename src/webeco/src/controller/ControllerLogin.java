package webeco.src.controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import laptopeco.bean.UserBean;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.ActivationCodeTran;
import laptopeco.logic.model.Address;
import laptopeco.logic.model.BonusMachine;
import laptopeco.logic.model.BonusTran;
import laptopeco.logic.model.History;
import laptopeco.logic.model.Message;
import laptopeco.logic.model.NoticeBoard;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.ShipmentTran;
import laptopeco.logic.model.Singleton;
import laptopeco.logic.model.Transaction;
import laptopeco.logic.model.WishList;
import laptopeco.logic.persistence.AddressDAO;
import laptopeco.logic.persistence.MessageDAO;
import laptopeco.logic.persistence.TransactionDAO;
import laptopeco.logic.persistence.UserDAO;
import laptopeco.logic.persistence.WishListDAO;

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


