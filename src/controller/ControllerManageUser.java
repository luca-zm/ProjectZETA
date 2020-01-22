package controller;

import java.sql.SQLException;

import bean.UserBean;
import logic.model.AbstractUser;
import logic.persistence.UserDAO;

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
