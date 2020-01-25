package logic.model;

public class ActivationCodeTran extends Transaction{
	private int activationCode;
	private int greenCoinAdded;
	public ActivationCodeTran(int id, String date, int activationCode, int greenCoinAdded) {
		super(id, date);
		this.activationCode = activationCode;
		this.greenCoinAdded = greenCoinAdded;
	}
	public int getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(int activationCode) {
		this.activationCode = activationCode;
	}
	public int getGreenCoinAdded() {
		return greenCoinAdded;
	}
	public void setGreenCoinAdded(int greenCoinAdded) {
		this.greenCoinAdded = greenCoinAdded;
	}
	@Override
	public String toString() {
		return "ActivationCode: " + activationCode + ", Greencoin added: " + greenCoinAdded + ", Date: " + date + "\n";
	}
	
	
}
