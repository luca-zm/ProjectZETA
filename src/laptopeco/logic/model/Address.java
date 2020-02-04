package laptopeco.logic.model;

public class Address {

	private int id;
	private String addr;
	private String city;
	private String postalCode;
	private String telephone;
	private String state;
	private String zone;

	



	public Address(int id, String address, String city, String postalCode, String telephone, String state, String zone) {
		super();
		this.id = id;
		this.addr = address;
		this.city = city;
		this.postalCode = postalCode;
		this.telephone = telephone;
		this.state = state;
		this.zone = zone;
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getAddr() {
		return addr;
	}

	public void setAddr(String address) {
		this.addr = address;
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
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return telephone;
	}



	@Override
	public String toString() {
		return "Address [id=" + id + ", address=" + addr + ", city=" + city + ", postalCode=" + postalCode
				+ ", telephone=" + telephone + ", state=" + state + ", zone=" + zone + "]";
	}
	
	

	

	
	
	
	
	
}