package bean;

public class CollectionPointBean {
	private int id;
	private String name;
	private double longitude;
	private double latitude;
	private AddressBean address;
	private int openingTime;
	private int closingTime;
	private Boolean isAvailable;
	
	
	public CollectionPointBean(int id, String name, double longitude, double latitude, AddressBean address, int openingTime,
			int closingTime, Boolean isAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.address = address;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
		this.isAvailable = isAvailable;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public int getOpeningTime() {
		return openingTime;
	}
	public void setOpeningTime(int openingTime) {
		this.openingTime = openingTime;
	}
	public int getClosingTime() {
		return closingTime;
	}
	public void setClosingTime(int closingTime) {
		this.closingTime = closingTime;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "CollectionPointBean [id=" + id + ", name=" + name + ", longitude=" + longitude + ", latitude="
				+ latitude + ", address=" + address + ", openingTime=" + openingTime + ", closingTime=" + closingTime
				+ ", isAvailable=" + isAvailable + "]";
	}
	
	
	
	
}