package bean;

public class CollectionPointBean {
	private int id;
	private String name;
	private String address;
	private int openingTime;
	private int closingTime;
	
	
	public CollectionPointBean(int id, String name,  String address, int openingTime,
			int closingTime) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.openingTime = openingTime;
		this.closingTime = closingTime;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
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
	@Override
	public String toString() {
		return "CollectionPointBean [id=" + id + ", name=" + name + ", address=" + address + ", openingTime="
				+ openingTime + ", closingTime=" + closingTime + "]";
	}

	
	
	
	
	
	
}