package controller;

import java.sql.SQLException;

import bean.AddressBean;
import bean.UserBean;
import logic.enums.Roles;
import logic.model.AbstractUser;
import logic.model.FactoryUsers;
import logic.model.Singleton;
import logic.persistence.UserDAO;

public class ControllerRegistration {
	Singleton singleton = Singleton.getInstance();
	public Boolean register(UserBean userBean) throws SQLException {
		String mail = userBean.getMail();
		String pass = userBean.getPass();
		String name = userBean.getName();
		String username = userBean.getSurname();
		AddressBean address = userBean.getAddress();
		if(UserDAO.findRegisteredUser(mail, pass) != null) {
			System.out.println("User already registered");
			return false;
		}
		
		AbstractUser user = FactoryUsers.get(0, mail, name, username, pass, "USER");
		singleton.setUser(user);
		
		if(UserDAO.insert(user)) {
			return true;
		}
		System.out.println("User not inserted in database!");
		return false;
	}
}
