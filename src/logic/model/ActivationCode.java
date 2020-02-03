package logic.model;

public class ActivationCode {
	
	private int actCode;
	private int greenCoinVal;
	
	
	public ActivationCode(int activationCode, int grenCoinVal) {
		super();
		this.actCode = activationCode;
		this.greenCoinVal = grenCoinVal;
	}


	public int getActCode() {
		return actCode;
	}


	public void setActCode(int activationCode) {
		this.actCode = activationCode;
	}


	public int getGrenCoinVal() {
		return greenCoinVal;
	}


	public void setGrenCoinVal(int grenCoinVal) {
		this.greenCoinVal = grenCoinVal;
	}


	@Override
	public String toString() {
		return "ActivationCode: " + actCode + ", Greencoin value: " + greenCoinVal;
	}
	
	
	
	
	

}
