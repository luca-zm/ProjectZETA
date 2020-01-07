package logic.model;

import java.util.ArrayList;


import logic.enums.Roles;


public abstract class AbstractUser {
	protected String name;
	protected String username;
	protected String pass;
	protected String mail;
	private Roles type;


	public AbstractUser(String mail, String name, String username, String pass,  Roles type) {
		this.name = name;
		this.username = username;
		this.pass = pass;
		this.mail = mail;
		this.type = type;
	} 
	
	public abstract Roles getType();
	
	public void setType(Roles type) {
        this.type = type;
    }
	
	
	 public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
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


	public void update(Guest toUpdate) {
	        this.name = toUpdate.getName();
	        this.username = toUpdate.getUsername();
	        this.pass = toUpdate.getPass();
	        this.mail = toUpdate.getMail();
	    }
	
	
	
}
