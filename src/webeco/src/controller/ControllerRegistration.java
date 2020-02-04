package webeco.src.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import laptopeco.bean.AddressBean;
import laptopeco.bean.UserBean;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.Address;
import laptopeco.logic.model.FactoryUsers;
import laptopeco.logic.model.Singleton;
import laptopeco.logic.persistence.AddressDAO;
import laptopeco.logic.persistence.UserDAO;

public class ControllerRegistration {
	public Boolean register(UserBean userBean, HttpSession session) throws SQLException {
		String mail = userBean.getMail();
		String pass = userBean.getPass();
		String name = userBean.getName();
		String surname = userBean.getSurname();
		AddressBean addrBean = userBean.getAddress();

		
		if(UserDAO.findRegisteredUser(mail) != null) {
			return false;
		}
		
		AbstractUser user = FactoryUsers.get(0, mail, name, surname, pass, "USER");
		
		Address addr = new Address(0, addrBean.getAddrBean(), addrBean.getCityBean(), addrBean.getPostalCodeBean(), addrBean.getTelephoneBean(), addrBean.getStateBean(),  addrBean.getZoneBean());
		AddressDAO.insert(addr);
	
		user.setAddress(addr);
		
		UserDAO.insert(user);
		return true;
	}
}
