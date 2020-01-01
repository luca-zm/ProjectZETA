package logic.Model;

import java.util.ArrayList;

import logic.Model.Roles;



public abstract class AbstractUser {
	
	protected String name;
	protected String username;
	protected String pass;
	protected String mail;
	private ArrayList<Roles> roles;
	private Roles type;
	private boolean valid;
	
	public AbstractUser() {
	}

	public abstract Roles getType();
	
	public void setType(Roles type) {
        this.type = type;
    }
	
	
	public ArrayList<Roles> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Roles> roles) {
        this.roles = roles;
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
	
	public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
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
