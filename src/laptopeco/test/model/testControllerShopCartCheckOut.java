package laptopeco.test.model;

import static org.junit.Assert.*;


import java.sql.SQLException;

import org.junit.Test;

import laptopeco.bean.AddressBean;
import laptopeco.bean.UserBean;
import laptopeco.controller.ControllerLogin;
import laptopeco.controller.ControllerShopCartCheckOut;
import laptopeco.logic.enums.Category;
import laptopeco.logic.model.Product;
import laptopeco.logic.model.Singleton;


//Davide Verardo Test1 ControllerShopCartCheckOut

public class testControllerShopCartCheckOut {

	ControllerLogin cl = new ControllerLogin();
	ControllerShopCartCheckOut checktest = new ControllerShopCartCheckOut();
	AddressBean addr = new AddressBean("test1", "test2", "test3", "test4", "test5", "test6");
	UserBean ub = new UserBean(0, "mailtest", "nametest", "surnametest", "passtest", addr);
	Singleton sg = Singleton.getInstance();
	Product p = new Product(1, "producttest", 200, 0 , Category.UTILITY, "pathtest", "testdescription");
	
	
	
	
	@Test
	public void testBuyShopCart() throws SQLException { //Confirm the correct purchase of the shopping cart
																//by comparing current user green coin with the expected ones
		cl.login(ub);
		sg.getUser().setGreenCoin(300);
		sg.getUser().getCart().addProduct(p);
		checktest.buyShopCart();
		
		assertEquals(sg.getUser().getGreenCoin(), sg.getUser().getGreenCoin()-p.getPrice());
	}
	
	@Test
	public void testbuyShopCartNegativeCoin() throws SQLException { //Test the possibility to buy the cart not having enough green coin, 
																	//the expected result is FALSE
		
		cl.login(ub);
		sg.getUser().setGreenCoin(300);
		sg.getUser().getCart().addProduct(p);
		checktest.buyShopCart();
		
		assertEquals(checktest.buyShopCart(), false);
	}
	
}