package bean;

import logic.enums.Roles;
import logic.model.Address;
import logic.model.History;
import logic.model.NoticeBoard;
import logic.model.ShopCart;

public class UserBean {
	protected String name;
	protected String surname;
	protected String pass;
	protected String mail;
    protected AddressBean address;
	public UserBean(String name, String surname, String pass, String mail, AddressBean address) {
		super();
		this.name = name;
		this.surname = surname;
		this.pass = pass;
		this.mail = mail;
		this.address = address;
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
	@Override
	public String toString() {
		return "UserBean [name=" + name + ", surname=" + surname + ", pass=" + pass + ", mail=" + mail + ", address="
				+ address + "]";
	}
	
}
    
    
    
    