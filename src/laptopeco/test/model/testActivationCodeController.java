package laptopeco.test.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import laptopeco.bean.ActivationCodeBean;
import laptopeco.bean.AddressBean;
import laptopeco.bean.UserBean;
import laptopeco.controller.ControllerLogin;
import laptopeco.controller.ControllerShopCartCheckOut;

public class testActivationCodeController {

	ControllerLogin cl = new ControllerLogin();
	AddressBean addr = new AddressBean("ttt", "ttt", "111", "111", "ttt", "ttt");
	UserBean ub = new UserBean(0, "ttt", "ttt", "ttt", "ttt", addr);
	
	int code=1111;
	int value=100;
	
	int badcode = 10008;
	
	ControllerShopCartCheckOut csc = new ControllerShopCartCheckOut();
	
	@Test
	public void testEnabledActivationCodeWithExistingCode() throws SQLException {
		cl.login(ub);
		int val = 100;
		Boolean ver = false;
		ActivationCodeBean ab = new ActivationCodeBean(code, value);

		if (val == csc.enabledActivationCode(ab)) {
			ver = true;
		}
		assertEquals(true, ver);
		
	}
	
	@Test
	public void testTryToEnableActivationCodeWithWrongData() throws SQLException {
		cl.login(ub);
		int val = 100;
		Boolean ver = false;
		ActivationCodeBean ab = new ActivationCodeBean(badcode, value);

		if (val != csc.enabledActivationCode(ab)) {
			ver = true;
		}
		assertEquals(true, ver);
		
	}
}
