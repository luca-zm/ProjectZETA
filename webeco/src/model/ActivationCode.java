package model;

public class ActivationCode {
	
	private int activationCode;
	private int greenCoinVal;
	
	
	public ActivationCode(int activationCode, int grenCoinVal) {
		super();
		this.activationCode = activationCode;
		this.greenCoinVal = grenCoinVal;
	}


	public int getActivationCode() {
		return activationCode;
	}


	public void setActivationCode(int activationCode) {
		this.activationCode = activationCode;
	}


	public int getGrenCoinVal() {
		return greenCoinVal;
	}


	public void setGrenCoinVal(int grenCoinVal) {
		this.greenCoinVal = grenCoinVal;
	}


	@Override
	public String toString() {
		return "ActivationCode: " + activationCode + ", Greencoin value: " + greenCoinVal;
	}
	
	
	
	
	

}
