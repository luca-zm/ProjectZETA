package laptopeco.controller;

import java.sql.SQLException;
import laptopeco.bean.AddressBean;
import laptopeco.bean.UserBean;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.Address;
import laptopeco.logic.model.FactoryUsers;
import laptopeco.logic.model.Singleton;
import laptopeco.logic.persistence.AddressDAO;
import laptopeco.logic.persistence.UserDAO;

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
		
		Address addr = new Address(0, addrBean.getAddrBean(), addrBean.getCityBean(), addrBean.getPostalCodeBean(), addrBean.getTelephoneBean(), addrBean.getStateBean(),  addrBean.getZoneBean());
		AddressDAO.insert(addr);
	
		user.setAddress(addr);
		singleton.setUser(user);
		
		UserDAO.insert(user);
		return true;
	}
}
