package laptopeco.test.model;

import static org.junit.Assert.assertEquals;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import laptopeco.logic.model.AbstractUser;
import laptopeco.logic.model.ActivationCodeTran;
import laptopeco.logic.model.BonusMachine;
import laptopeco.logic.model.BonusTran;
import laptopeco.logic.model.FactoryUsers;
import laptopeco.logic.model.History;
import laptopeco.logic.model.Message;
import laptopeco.logic.model.NoticeBoard;
import laptopeco.logic.model.Transaction;
import laptopeco.logic.persistence.AddressDAO;
import laptopeco.logic.persistence.MessageDAO;
import laptopeco.logic.persistence.TransactionDAO;
import laptopeco.logic.persistence.UserDAO;

public class TestBonusMachine {
	//Stefano Costanzo
	
    private ActivationCodeTran tran1;
    private ActivationCodeTran tran2;
    private ActivationCodeTran tran3;
    private ActivationCodeTran tran4;
    int coin1 = 1200;
	int coin2 = 200;
	int coin3 = 4000;
	int coin4 = 700;
	int addr = 3;
    private History history;
    private BonusMachine machine;
    private AbstractUser user;
	
	//initialize parameter for testing
	private void init() throws SQLException {
		
		user = FactoryUsers.get(3, "rrr", "rrr", "rrr", "rrr", "USER");
		//Setting the user with empty history
		history = new History(new ArrayList<Transaction>());
		user.setHistory(history);
		user.setBoards(new NoticeBoard(new ArrayList<Message>()));

		
		//Bonus machine with default user
		machine = new BonusMachine(user);
		

		
		//current date 
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf =  new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	
		String time = sdf.format(dt);
		
	    tran1 = new ActivationCodeTran(0, time, 100, coin1);
	    tran2 = new ActivationCodeTran(0, time, 200, coin2);
	    tran3 = new ActivationCodeTran(0, time, 300, coin3);
	    tran3 = new ActivationCodeTran(0, time, 400, coin4);
	}
	
	@Test
	public void testUpdateOnDefault() throws SQLException {
		init();
		user.setAddress(AddressDAO.findAddressById(addr));
		
		//Bonus Machine is an Observer of user's history
		TransactionDAO.insertActivationCodeTran(tran1, user);
		history.addTransaction(tran1);
		user.setGreenCoin(user.getGreenCoin() + coin1);

		
		//With a Activation Code Transaction of 1200 coin the machine 
		//gives 200 more coins to user
		// final user green coin will be 1400
		int expectedCoin = 1400;
		System.out.println(user);
		int userCoin = user.getGreenCoin();
      
		assertEquals(expectedCoin, userCoin);
		
	}
	
	@Test
	public void testUpdateWithoutBonus() throws SQLException {
		init();
		user.setAddress(AddressDAO.findAddressById(addr));
		
		//Bonus Machine is an Observer of user's history
		TransactionDAO.insertActivationCodeTran(tran2, user);
		history.addTransaction(tran2);
		user.setGreenCoin(user.getGreenCoin() + coin2);

		
//		With a Activation Code Transaction of 200 coin the machine 
//		doesn't touch user's greencoin
//	    final user green coin will be 200
		
		int expectedCoin = 200;
		System.out.println(user);
		int userCoin = user.getGreenCoin();
        
		assertEquals(expectedCoin, userCoin);
		
	}
	
	

}

    