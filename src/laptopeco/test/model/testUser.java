/**package test.model;

import static org.junit.Assert.*;


import org.junit.Test;
import logic.model.History;
import logic.model.NoticeBoard;
import logic.model.ShopCart;
import logic.model.User;

public class testUser {


	ShopCart cart = new ShopCart();
	History history = new History();
	NoticeBoard board = new NoticeBoard();
	User user = new User("name", "username", "pass", "mail", 0, cart, history, board);
	
	@Test
	public void testAddGreenCoinOnDefault() {
		int n = 20;
		user.addGreenCoin(n);
		assertEquals(n, user.getGreenCoin());
	}
	
	@Test
	public void testAddGreenCoinOnNegative() {
		int n = -100;
		user.addGreenCoin(n);
		assertEquals(n, user.getGreenCoin());
	}
	
	@Test
	public void testAddGreenCoinOnMaximum() {
		int n = 3000;
		user.addGreenCoin(n);
		assertEquals(n, user.getGreenCoin());
	}

}
**/