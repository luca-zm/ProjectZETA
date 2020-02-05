package laptopeco.test.model;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import laptopeco.bean.AddressBean;
import laptopeco.bean.UserBean;
import laptopeco.controller.ControllerLogin;
import laptopeco.controller.ControllerRegistration;
import laptopeco.logic.model.Singleton;

//Luca Zammariello
public class testControllerRegistration {

	ControllerRegistration cr = new ControllerRegistration();
	
	
	
	Singleton sg = Singleton.getInstance();
	
	String mail = "federco@";
	String pass = "ffff";
	String name = "fede";
	String surname = "picco";
	
	
	String Wrongmail = "ttt";

	@Test
	public void testRegisterDefault() throws SQLException {
		AddressBean addr = new AddressBean("via scarpa", "roma", "000112", "3333333", "italy", "talenti");
		UserBean ub = new UserBean(0, "federico@", "fede", "picco", "ffff", addr);
		
		cr.register(ub);
		
		Boolean ver = false;
		if (sg.getUser().getMail().equals(mail) && sg.getUser().getPass().equals(pass) &&
				sg.getUser().getPass().equals(name) && sg.getUser().getPass().equals(surname)) {
				ver = true;
		}
		assertEquals(true, ver);
	}
	
	@Test
	public void testRegisterWithWrongData() throws SQLException {
		AddressBean addr = new AddressBean("ttt", "ttt", "111", "111", "ttt", "ttt");
		UserBean ub = new UserBean(0, "ttt", "ttt", "ttt", "ttt", addr);
		
		cr.register(ub);
		
		Boolean ver = false;
		if (sg.getUser().getMail().equals(Wrongmail)) {
				ver = true;
		}
		assertEquals(true, ver);
	}
}
