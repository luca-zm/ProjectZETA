package bean;

public class AddressBean {
	private String address;
	private String city;
	private String postalCode;
	private String telephone;
	private String state;
	private String zone;
	
	
	
	public AddressBean(String address, String city, String postalCode, String telephone, String state,
			String zone) {
		this.address = address;
		this.city = city;
		this.postalCode = postalCode;
		this.telephone = telephone;
		this.state = state;

		this.zone = zone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	@Override
	public String toString() {
		return "AddressBean [address=" + address + ", city=" + city + ", postalCode=" + postalCode + ", telephone="
				+ telephone + ", state=" + state + ", zone=" + zone + "]";
	}
	
	
	
}
