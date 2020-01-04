package logic.model;

import static logic.enums.Roles.ADMIN;
import logic.enums.Roles;
public class Admin extends AbstractUser {

    public Admin(String name, String username, String mail, String pass)  {
    	super(name, username, mail, pass, Roles.ADMIN);
    }

    @Override
	public Roles getType() {
		return ADMIN;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", username=" + username + ", pass=" + pass + ", mail=" + mail + ", getType()="
				+ getType() + "]";
	}   
    
}


