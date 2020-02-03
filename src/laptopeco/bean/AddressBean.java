package bean;

public class AddressBean {
	private String addrBean;
	private String cityBean;
	private String postalCodeBean;
	private String telephoneBean;
	private String stateBean;
	private String zoneBean;
	
	
	
	public AddressBean(String address, String city, String postalCode, String telephone, String state,
			String zone) {
		this.addrBean = address;
		this.cityBean = city;
		this.postalCodeBean = postalCode;
		this.telephoneBean = telephone;
		this.stateBean = state;
		this.zoneBean = zone;
	}
	public String getAddrBean() {
		return addrBean;
	}
	public void setAddrBean(String address) {
		this.addrBean = address;
	}
	public String getCityBean() {
		return cityBean;
	}
	public void setCityBean(String city) {
		this.cityBean = city;
	}
	public String getPostalCodeBean() {
		return postalCodeBean;
	}
	public void setPostalCodeBean(String postalCode) {
		this.postalCodeBean = postalCode;
	}
	public String getTelephoneBean() {
		return telephoneBean;
	}
	public void setTelephoneBean(String telephone) {
		this.telephoneBean = telephone;
	}
	public String getStateBean() {
		return stateBean;
	}
	public void setStateBean(String state) {
		this.stateBean = state;
	}

	
	public String getZoneBean() {
		return zoneBean;
	}
	public void setZoneBean(String zone) {
		this.zoneBean = zone;
	}
	@Override
	public String toString() {
		return "AddressBean [address=" + addrBean + ", city=" + cityBean + ", postalCode=" + postalCodeBean + ", telephone="
				+ telephoneBean + ", state=" + stateBean + ", zone=" + zoneBean + "]";
	}
	
	
	
}
