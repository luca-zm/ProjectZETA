package laptopeco.logic.model;

import java.sql.SQLException;
import java.util.List;

import logic.enums.MesType;
import logic.persistence.MessageDAO;
import logic.persistence.TransactionDAO;
import logic.persistence.UserDAO;

public class BonusMachine implements Observer{
	
	private AbstractUser user;
	private History history;
	private int greenCoinMemo;
	private int greenCoinTarget;
	private int bonus;
	public BonusMachine(AbstractUser user) throws SQLException {
		super();
		this.user = user;
		this.history = user.getHistory();
		this.history.attach(this);
		this.greenCoinTarget = 500;
		this.bonus = 100;
		this.greenCoinMemo = getHistoryPrice();
		
	}
		public String time() {
			java.util.Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			return sdf.format(dt);
		}
		
	@Override
	public void update() throws SQLException {
		int coin = getHistoryPrice();
		if(coin - greenCoinMemo >= greenCoinTarget) {
			greenCoinMemo += greenCoinTarget;
			addBonus();
		}
	}
	
	public int getHistoryPrice() throws SQLException {
		List<ActivationCodeTran> listActCodeTran = TransactionDAO.selectActivationCodeTra(user);
		int activationGreenCoin = 0;
		
		for (ActivationCodeTran actCodeTran : listActCodeTran) {
			int price = actCodeTran.getGreenCoinAdded();
			activationGreenCoin += price;
		}
		return activationGreenCoin;
	}
	
	public void addBonus() throws SQLException {
		user.setGreenCoin(user.getGreenCoin() + bonus); 
		
		BonusTran tran = new BonusTran(0, time(), "Hai collezionato 500 GreenCoin", bonus);
					
		TransactionDAO.insertBonusTran(tran, user);
					
		user.getHistory().addTransaction(tran);
										
		Message m = new Message(0,time(), "Bonus", "Hai ricevuto un bonus di " + Integer.toString(bonus), MesType.BONUS);
					
		MessageDAO.insert(m, user);
		
		UserDAO.update(user);
		
	}
	
	
	

}
