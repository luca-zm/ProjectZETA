package controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import bean.AddressBean;
import bean.UserBean;
import logic.enums.Roles;
import logic.model.AbstractUser;
import logic.model.Address;
import logic.model.FactoryUsers;
import logic.model.Singleton;
import logic.persistence.AddressDAO;
import logic.persistence.UserDAO;

public class ControllerRegistration {
	Singleton singleton = Singleton.getInstance();
	public Boolean register(UserBean userBean) throws SQLException {
		String mail = userBean.getMail();
		String pass = userBean.getPass();
		String name = userBean.getName();
		String username = userBean.getSurname();
		AddressBean addrBean = userBean.getAddress();

		
		if(UserDAO.findRegisteredUser(mail) != null) {
			return false;
		}
		
		AbstractUser user = FactoryUsers.get(0, mail, name, username, pass, "USER");
		
		Address addr = new Address(0, addrBean.getAddress(), addrBean.getCity(), addrBean.getPostalCode(), addrBean.getTelephone(), addrBean.getState(), addrBean.getCountry(), addrBean.getZone());
		AddressDAO.insert(addr);
	
		user.setAddress(addr);
		singleton.setUser(user);
		
		UserDAO.insert(user);
		return true;
	}
}