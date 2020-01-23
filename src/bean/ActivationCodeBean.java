package bean;

public class ActivationCodeBean {
	
	private int activationCode;
	private int greenCoinVal;
	
	
	public ActivationCodeBean(int activationCode, int grenCoinVal) {
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
		return "ActivationCode [activationCode=" + activationCode + ", grenCoinVal=" + greenCoinVal + "]";
	}
	
	
	
	
	

}
