package logic.model;

import java.sql.SQLException;
import java.util.ArrayList;

import logic.persistence.TransactionDAO;

public class BonusMachine implements Observer{
	
	private AbstractUser user;
	private History history;
	private int greenCoinMemo;
	private int greenCoinTarget;
	private int bonus;

	public BonusMachine(AbstractUser user) {
		super();
		this.user = user;
		this.history = user.getHistory();
		this.history.attach(this);
		this.greenCoinMemo = 0;
		this.greenCoinTarget = 500;
		this.bonus = 100;
	}

	@Override
	public void update() throws SQLException {
		ArrayList<ActivationCodeTran> listActCodeTran = TransactionDAO.selectActivationCodeTra(user);
		ArrayList<BonusTran> listbonusTran = TransactionDAO.selectBonusTran(user);
		ArrayList<ShipmentTran> listShipmentTran = TransactionDAO.selectShipment(user);
		
		int shipmentGreenCoin = 0; 
		int activationGreenCoin = 0;
		
//		for (ShipmentTran shipmentTran : listShipmentTran) {
//			int price = shipmentTran.getProduct().getPrice();
//			shipmentGreenCoin += price;
//		}
//		if(shipmentGreenCoin - greenCoinMemo > greenCoinTarget) {
//			addBonus();
//			greenCoinMemo = greenCoinTarget;
//		}
		
		
		for (ActivationCodeTran actCodeTran : listActCodeTran) {
			int price = actCodeTran.getGreenCoinAdded();
			activationGreenCoin += price;
		}
		if(activationGreenCoin - greenCoinMemo > greenCoinTarget) {
			addBonus();
			greenCoinMemo = greenCoinTarget;
		}
	}
	
	public void addBonus() {
		System.out.println("Ho aggiunto greenCoin");
	}
	
	
	

}
