package laptopeco.controller;

import java.sql.SQLException;

import laptopeco.bean.UserBean;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.persistence.UserDAO;

public class ControllerManageUser {
	public Boolean update(UserBean userBean) throws SQLException {
		AbstractUser user = UserDAO.findUserById(userBean.getId());
		UserDAO.insert(user);
		return true;
	}
	
	public Boolean delete(UserBean userBean) throws SQLException {
		AbstractUser user = UserDAO.findUserById(userBean.getId());
		UserDAO.update(user);
		return true;
	}

}
