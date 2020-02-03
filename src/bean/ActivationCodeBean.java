package bean;

public class ActivationCodeBean {
	
	private int activationCodeBean;
	private int greenCoinVal;
	
	
	public ActivationCodeBean(int activationCode, int grenCoinVal) {
		super();
		this.activationCodeBean = activationCode;
		this.greenCoinVal = grenCoinVal;
	}


	public int getActivationCodeBean() {
		return activationCodeBean;
	}


	public void setActivationCodeBean(int activationCode) {
		this.activationCodeBean = activationCode;
	}


	public int getGrenCoinVal() {
		return greenCoinVal;
	}


	public void setGrenCoinVal(int grenCoinVal) {
		this.greenCoinVal = grenCoinVal;
	}


	@Override
	public String toString() {
		return "ActivationCode [activationCode=" + activationCodeBean + ", grenCoinVal=" + greenCoinVal + "]";
	}
	
	
	
	
	

}
