package controller;

import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import bean.AddressBean;
import bean.UserBean;
import enums.Roles;
import model.AbstractUser;
import model.Address;
import model.FactoryUsers;
import model.Singleton;
import persistence.AddressDAO;
import persistence.UserDAO;

public class ControllerRegistration {
	Singleton singleton = Singleton.getInstance();
	public Boolean register(UserBean userBean) throws SQLException {
		String mail = userBean.getMail();
		String pass = userBean.getPass();
		String name = userBean.getName();
		String surname = userBean.getSurname();
		AddressBean addrBean = userBean.getAddress();

		
		if(UserDAO.findRegisteredUser(mail) != null) {
			return false;
		}
		
		AbstractUser user = FactoryUsers.get(0, mail, name, surname, pass, "USER");
		
		Address addr = new Address(0, addrBean.getAddress(), addrBean.getCity(), addrBean.getPostalCode(), addrBean.getTelephone(), addrBean.getState(), addrBean.getZone());
		AddressDAO.insert(addr);
	
		user.setAddress(addr);

		
		UserDAO.insert(user);
		return true;
	}
}