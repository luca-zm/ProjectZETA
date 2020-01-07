package logic.model;

import static logic.enums.Roles.GUEST;

import logic.enums.Roles;

public class Guest extends AbstractUser{
	


    public Guest(String mail, String name, String username, String pass) {
		super(mail, name, username, pass, Roles.GUEST);
	}

	@Override
    public Roles getType() {
        return GUEST;
    }

	@Override
	public String toString() {
		return "Guest [name=" + name + ", username=" + username + ", pass=" + pass + ", mail=" + mail + "]";
	}

	public void setValid(boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	


	
	
    
}
