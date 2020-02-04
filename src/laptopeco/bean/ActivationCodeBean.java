package laptopeco.bean;

public class ActivationCodeBean {
	
	private int actCodeBean;
	private int greenCoinVal;
	
	
	public ActivationCodeBean(int activationCode, int grenCoinVal) {
		super();
		this.actCodeBean = activationCode;
		this.greenCoinVal = grenCoinVal;
	}


	public int getActCodeBean() {
		return actCodeBean;
	}


	public void setActCodeBean(int activationCode) {
		this.actCodeBean = activationCode;
	}


	public int getGrenCoinVal() {
		return greenCoinVal;
	}


	public void setGrenCoinVal(int grenCoinVal) {
		this.greenCoinVal = grenCoinVal;
	}


	@Override
	public String toString() {
		return "ActivationCode [activationCode=" + actCodeBean + ", grenCoinVal=" + greenCoinVal + "]";
	}
	
	
	
	
	

}
