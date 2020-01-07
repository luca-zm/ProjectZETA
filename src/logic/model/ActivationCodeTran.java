package logic.model;

public class ActivationCodeTran extends Transaction{
	private String activationCode;
	private int greenCoinAdded;
	public ActivationCodeTran(int id, String date, String activationCode, int greenCoinAdded) {
		super(id, date);
		this.activationCode = activationCode;
		this.greenCoinAdded = greenCoinAdded;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
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
		return "ActivationCodeTran [activationCode=" + activationCode + ", greenCoinAdded=" + greenCoinAdded + ", id="
				+ id + ", date=" + date + "]";
	}
	
	
}
