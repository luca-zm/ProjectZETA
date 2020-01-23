package bean;

import logic.enums.Roles;
import logic.model.Address;
import logic.model.History;
import logic.model.NoticeBoard;
import logic.model.ShopCart;

public class UserBean {
	protected int id;
	protected String name;
	protected String surname;
	protected String pass;
	protected String mail;
	protected int greencoin;
    protected AddressBean address;
	public UserBean(int id, String name, String surname, String pass, String mail, AddressBean address) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.pass = pass;
		this.mail = mail;
		this.address = address;
		this.greencoin = 0;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}

	
	public int getGreencoin() {
		return greencoin;
	}

	public void setGreencoin(int greencoin) {
		this.greencoin = greencoin;
	}

	@Override
	public String toString() {
		return "UserBean [id=" + id + ", name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail=" + mail
				+ ", greencoin=" + greencoin + ", address=" + address + "]";
	}

	
	
	
}
    
    
    
    