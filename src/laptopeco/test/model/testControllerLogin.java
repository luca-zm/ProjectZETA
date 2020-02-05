package laptopeco.test.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import laptopeco.bean.AddressBean;
import laptopeco.bean.UserBean;
import laptopeco.controller.ControllerLogin;
import laptopeco.logic.model.Singleton;

//Luca Zammariello
public class testControllerLogin{
	ControllerLogin cl = new ControllerLogin();
	AddressBean addr = new AddressBean("ttt", "ttt", "111", "111", "ttt", "ttt");
	UserBean ub = new UserBean(0, "ttt", "ttt", "ttt", "ttt", addr);
	Singleton sg = Singleton.getInstance();
	
	String mail = "ttt";
	String passcorrect = "ttt";
	
	String passwrong = "njnjnjnj";

	
	@Test
	public void testLoginOnCorrectData() throws SQLException {
		
		cl.login(ub);
		
		Boolean ver = false;
		if (sg.getUser().getMail().equals(mail)) {
			if (sg.getUser().getPass().equals(passcorrect)) {
				ver = true;
			}
		}
		assertEquals(true, ver);	
	}
	
	@Test
	public void testLoginOnWrongData() throws SQLException {
		
		cl.login(ub);

		Boolean ver = false;
		if (sg.getUser().getMail().equals(mail)) {
			if (sg.getUser().getPass().equals(passwrong)) {
				ver = true;
			}
		}
		assertEquals(false, ver);
	}
}