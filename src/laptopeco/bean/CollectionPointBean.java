package bean;

public class CollectionPointBean {
	private int idCollPointBean;
	private String nameCollPointBean;
	private String addressCollPointBean;
	private int openingTimeBean;
	private int closingTimeBean;
	
	
	public CollectionPointBean(int id, String name,  String address, int openingTime,
			int closingTime) {
		super();
		this.idCollPointBean = id;
		this.nameCollPointBean = name;
		this.addressCollPointBean = address;
		this.openingTimeBean = openingTime;
		this.closingTimeBean = closingTime;
	}
	public int getIdCollPointBean() {
		return idCollPointBean;
	}
	public void setIdCollPointBean(int id) {
		this.idCollPointBean = id;
	}
	public String getNameCollPointBean() {
		return nameCollPointBean;
	}
	public void setNameCollPointBean(String name) {
		this.nameCollPointBean = name;
	}
	public String getAddressCollPointBean() {
		return addressCollPointBean;
	}
	public void setAddressCollPointBean(String address) {
		this.addressCollPointBean = address;
	}
	public int getOpeningTimeBean() {
		return openingTimeBean;
	}
	public void setOpeningTimeBean(int openingTime) {
		this.openingTimeBean = openingTime;
	}
	public int getClosingTimeBean() {
		return closingTimeBean;
	}
	public void setClosingTimeBean(int closingTime) {
		this.closingTimeBean = closingTime;
	}
	@Override
	public String toString() {
		return "CollectionPointBean [id=" + idCollPointBean + ", name=" + nameCollPointBean + ", address=" + addressCollPointBean + ", openingTime="
				+ openingTimeBean + ", closingTime=" + closingTimeBean + "]";
	}

	
	
	
	
	
	
}
